package class2relationalImperative.rules

import atl.research.class_.Attribute
import atl.research.class_.DataType
import atl.research.relational_.Column
import atl.research.relational_.Table
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.util.EcoreUtil

class SingleAttribute2Column extends Elem2Elem {
	
	new(Resource src, Resource trgt, Resource corr) {
		super(src, trgt, corr)
	}
	
	override sourceToTarget() {
		sourceModel.allContents.filter(typeof(Attribute)).filter[att | !att.multiValued].forEach[ attribute |
			val corr = attribute.getOrCreateCorrModelElement("SingleAttribute2Column")
			var targetObj = corr.getOrCreateTargetElem(targetPackage.column)
			if (targetObj instanceof Table)
				EcoreUtil.delete(targetObj)
			val target = corr.getOrCreateTargetElem(targetPackage.column) as Column
			if (attribute.type instanceof DataType) {
				target.name = attribute.name
				target.type = DataType2Type.getType(attribute.type as DataType)
			}
			else {
				target.name = attribute.name + "Id"
				target.type = DataType2Type.getType(sourceModel.contents.filter(typeof(DataType)).findFirst[name == "Integer"])
			}
		]
	}
	
}