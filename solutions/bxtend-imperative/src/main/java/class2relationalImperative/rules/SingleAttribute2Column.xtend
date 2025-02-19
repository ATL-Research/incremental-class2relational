package class2relationalImperative.rules

import atl.research.class_.Attribute
import atl.research.class_.DataType
import atl.research.relational_.Column
import atl.research.relational_.Table
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.util.EcoreUtil

// Setup
class SingleAttribute2Column extends Elem2Elem {
	new(Resource src, Resource trgt, Resource corr) {
		// Setup
		super(src, trgt, corr)
	}

	// Transformation
	override sourceToTarget() {
		// Model_Traversal
		sourceModel.allContents.filter(typeof(Attribute)).filter[att | !att.multiValued].forEach[ attribute |
			// Transformation
			val corr = attribute.getOrCreateCorrModelElement("SingleAttribute2Column")
			// Transformation
			var targetObj = corr.getOrCreateTargetElem(targetPackage.column)
			// Transformation
			if (targetObj instanceof Table)
				// Transformation
				EcoreUtil.delete(targetObj)
			// Transformation
			val target = corr.getOrCreateTargetElem(targetPackage.column) as Column
			// Transformation
			if (attribute.type instanceof DataType) {
				// Transformation
				target.name = attribute.name
				// Transformation
				target.type = DataType2Type.getType(attribute.type as DataType)
			}
			// Transformation
			else {
				// Transformation
				target.name = attribute.name + "Id"
				// Transformation
				target.type = DataType2Type.getType(sourceModel.contents.filter(typeof(DataType)).findFirst[name == "Integer"])
			}
		]
	}	
}