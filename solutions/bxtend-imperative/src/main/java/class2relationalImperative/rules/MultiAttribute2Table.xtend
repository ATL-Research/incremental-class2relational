package class2relationalImperative.rules

import org.eclipse.emf.ecore.resource.Resource
import atl.research.class_.Attribute
import atl.research.relational_.Table
import atl.research.class_.DataType
import atl.research.relational_.Column
import org.eclipse.emf.ecore.util.EcoreUtil

class MultiAttribute2Table extends Elem2Elem {
	// Setup
	new(Resource src, Resource trgt, Resource corr) {
		// Setup
		super(src, trgt, corr)
	}
	
	// Transformation
	override sourceToTarget() {
		// Model Traversal
		sourceModel.allContents.filter(typeof(Attribute)).filter[att | att.multiValued].forEach[ attribute |
			// Tracing
			val corr = attribute.getOrCreateCorrModelElement("MultiAttribute2Table")
			// Transformation
			val targetObject = corr.getOrCreateTargetElem(targetPackage.table)			
			// Transformation
			if (targetObject instanceof Column)
				// Transformation
				EcoreUtil.delete(targetObject)
			// Transformation
			var targetTable = corr.getOrCreateTargetElem(targetPackage.table) as Table
			// Transformation
			var owner  = attribute.eContainer as atl.research.class_.Class
			// Transformation
			targetTable.name = (owner !== null && owner.name !== null && owner.name !== "")? owner.name : "Table" 
			// Transformation
			targetTable.name = targetTable.name + "_" + attribute.name
			// Transformation
			var idCol = targetFactory.createColumn() => [
				// Transformation
				type = DataType2Type.getType(sourceModel.contents.filter(typeof(DataType)).findFirst[name == "Integer"])
			]
			// Transformation
			idCol.name = (owner === null || owner.name === null || owner.name === "")? "tableId" : owner.name.toFirstLower + "Id"
			
			// Transformation
			if (attribute.type instanceof DataType) {															
				// Transformation
				if (targetTable.col.size == 0) {
					// Transformation
					val valCol = targetFactory.createColumn() => [name = attribute.name
						// Transformation
						type = DataType2Type.getType(attribute.type as DataType)
					]
					// Transformation
					targetTable.col += idCol				
					// Transformation
					targetTable.col += valCol				
				}
				// Transformation
				else {
					// Transformation
					idCol = targetTable.col.get(0)
					// Transformation
					idCol.name = (owner === null || owner.name === null || owner.name === "")? "tableId" : owner.name.toFirstLower + "Id"
				}
			}
			// Transformation
			else {
				// Transformation
				if (targetTable.col.size == 0) {
					// Transformation
					val fkCol = targetFactory.createColumn() => [ name = attribute.name.toFirstLower + "Id"
						// Transformation
						type = DataType2Type.getType(sourceModel.contents.filter(typeof(DataType)).findFirst[name == "Integer"])
					]
					// Transformation
					targetTable.col += idCol
					// Transformation
					targetTable.col += fkCol
				} 
				// Transformation
				else {
					// Transformation
					idCol = targetTable.col.get(0)
					// Transformation
					idCol.name = (owner === null || owner.name === null || owner.name === "")? "tableId" : owner.name.toFirstLower + "Id"
				}
			}
			// Transformation
			targetModel.contents += targetTable
		]
	}
	
}