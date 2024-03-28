package class2relationalImperative.rules

import org.eclipse.emf.ecore.resource.Resource
import atl.research.class_.DataType
import atl.research.relational_.Type
import java.util.Map
import java.util.HashMap
import atl.research.class_.Classifier

class DataType2Type extends Elem2Elem {
	static Map<DataType, Type> typeMap = new HashMap<DataType, Type>()
		
	new(Resource src, Resource trgt, Resource corr) {
		super(src, trgt, corr)
	}
	
	override sourceToTarget() {
		sourceModel.allContents.filter(typeof(DataType)).forEach[ datatype |
			val corrDT = datatype.getOrCreateCorrModelElement("DataType2Type")
			val targetElem = corrDT.getOrCreateTargetElem(targetPackage.type) as Type => [
				name = datatype.name
			]
			targetModel.contents += targetElem
			typeMap.put(datatype, targetElem)
		]		
	}
	
	public def static getType(DataType t) {
		return typeMap.get(t)
	}
	
}