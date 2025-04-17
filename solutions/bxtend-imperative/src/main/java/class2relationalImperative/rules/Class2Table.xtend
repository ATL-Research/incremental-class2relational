package class2relationalImperative.rules

import org.eclipse.emf.ecore.resource.Resource

import atl.research.class_.Class
import atl.research.relational_.Table
import atl.research.class_.Attribute
import atl.research.relational_.Column
import atl.research.class_.DataType

// Setup
class Class2Table extends Elem2Elem {

	new(Resource src, Resource trgt, Resource corr) {
		// Setup
		super(src, trgt, corr)
	}

	// Transformation
	override sourceToTarget() {
		// Model Traversal
		sourceModel.contents.filter(typeof(Class)).forEach[ clz |
			// Tracing
			val corr = clz.getOrCreateCorrModelElement("Class2Table")
			// Transformation
			val targetTable = corr.getOrCreateTargetElem(targetPackage.table) as Table
			// CHANGE_PROPAGATION
			targetTable.name = clz.name
			// Transformation
			if (targetTable.col.size == 0) { // if targetTable has been newly created, create objectId column
				// Transformation
				val colId = targetFactory.createColumn => [
					// Transformation
					name = "objectId"
					// Transformation
					type = DataType2Type.getType(sourceModel.contents.filter(typeof(DataType)).findFirst[name == "Integer"])
				]			
				// Transformation
				targetTable.col += colId
				// Transformation
				targetTable.key += colId
			} // end initial creation of targetTable
			// Transformation
			for (Attribute a : clz.attr) { // iterate over class attributes and transform them
				// Transformation
				if (!a.multiValued) {
					// Transformation
					targetTable.col += elementsToCorr.get(a).targetElement as Column // establish link between table and column
				}
			}
			// Transformation
			targetModel.contents += targetTable
		]
	}
}