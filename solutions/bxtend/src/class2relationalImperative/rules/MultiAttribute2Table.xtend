package class2relationalImperative.rules

import org.eclipse.emf.ecore.resource.Resource
import atl.research.class_.Attribute
import atl.research.relational_.Table
import atl.research.class_.DataType
import atl.research.relational_.Column
import org.eclipse.emf.ecore.util.EcoreUtil

class MultiAttribute2Table extends Elem2Elem {
	
	new(Resource src, Resource trgt, Resource corr) {
		super(src, trgt, corr)
	}
	
	override sourceToTarget() {
		sourceModel.allContents.filter(typeof(Attribute)).filter[att | att.isMultiValued].forEach[ attribute |
			val corr = attribute.getOrCreateCorrModelElement("MultiAttribute2Table")
			val targetObject = corr.getOrCreateTargetElem(targetPackage.table)
			// handle incremental case... att could have been singlevalued -> existing Target Object is a column
			if (targetObject instanceof Column)
				EcoreUtil.delete(targetObject)
			var targetTable = corr.getOrCreateTargetElem(targetPackage.table) as Table
			var owner  = attribute.eContainer as atl.research.class_.Class
			
			targetTable.name = (owner !== null && owner.name !== null && owner.name !== "")? owner.name : "Table" 
			targetTable.name = targetTable.name + "_" + attribute.name
			
			var idCol = targetFactory.createColumn() => [
				type = DataType2Type.getType(sourceModel.contents.filter(typeof(DataType)).findFirst[name == "Integer"])
			]
			idCol.name = (owner === null || owner.name === null || owner.name === "")? "tableId" : owner.name.toFirstLower + "Id"
			
			if (attribute.type instanceof DataType) {															
				if (targetTable.col.size == 0) {
					val valCol = targetFactory.createColumn() => [name = attribute.name
						type = DataType2Type.getType(attribute.type as DataType)
					]
					targetTable.col += idCol				
					targetTable.col += valCol				
				}
				else {
					idCol = targetTable.col.get(0)
					idCol.name = (owner === null || owner.name === null || owner.name === "")? "tableId" : owner.name.toFirstLower + "Id"
				}
			}
			else {
				// create primary and foreign key
				if (targetTable.col.size == 0) {
					val fkCol = targetFactory.createColumn() => [ name = attribute.name.toFirstLower + "Id"
						type = DataType2Type.getType(sourceModel.contents.filter(typeof(DataType)).findFirst[name == "Integer"])
					]
					targetTable.col += idCol
					targetTable.col += fkCol
				} else {
					idCol = targetTable.col.get(0)
					idCol.name = (owner === null || owner.name === null || owner.name === "")? "tableId" : owner.name.toFirstLower + "Id"
				}
			}
			targetModel.contents += targetTable
		]
	}
	
}