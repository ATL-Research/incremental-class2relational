package class2relationalImperative.rules

import org.eclipse.emf.ecore.resource.Resource
import atl.research.class_.DataType
import atl.research.relational_.Type
import java.util.Map
import java.util.HashMap
import atl.research.class_.Classifier

// Setup
class DataType2Type extends Elem2Elem {
	// Helper
	static Map <DataType, Type> typeMap = new HashMap <DataType, Type>()

	// Setup
	new(Resource src, Resource trgt, Resource corr) {
		// Setup
		super(src, trgt, corr)
	}

	// Transformation
	override sourceToTarget() {
		// Model Traversal
		sourceModel.allContents.filter(typeof(DataType)).forEach[ datatype |
			// Tracing
			val corrDT = datatype.getOrCreateCorrModelElement("DataType2Type")
			// Transformation
			val targetElem = corrDT.getOrCreateTargetElem(targetPackage.type) as Type => [
				// CHANGE_PROPAGATION
				name = datatype.name
			]
			// Transformation
			targetModel.contents += targetElem
			// Tracing
			typeMap.put(datatype, targetElem)
		]		
	}

	// Helper
	public def static getType(DataType t) {
		// Helper
		return typeMap.get(t)
	}

}