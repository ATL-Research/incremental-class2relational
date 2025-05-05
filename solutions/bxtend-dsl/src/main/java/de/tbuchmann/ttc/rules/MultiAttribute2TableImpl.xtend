package de.tbuchmann.ttc.rules;

import de.tbuchmann.ttc.trafo.Class2Relational
import atl.research.class_.Attribute
import atl.research.class_.Class
import atl.research.class_.Classifier
import atl.research.relational_.Relational_Factory
import atl.research.class_.DataType

// Generated
class MultiAttribute2TableImpl extends MultiAttribute2Table {	
	new(Class2Relational trafo) {
		// Generated
		super(trafo)
	}

	// Generated
	override protected filterAtt(Attribute att) {	
		// Model Traversal 
		(att.multiValued) && !(att.type instanceof Class)
	}

	// Generated
	override protected tblNameFrom(String attName, Class owner) {
		// Transformation
		var tblName = (owner !== null && owner.name !== null && owner.name !== "")? owner.name : "" 	
		// Transformation		
		new Type4tblName(tblName + "_" + attName)
	}

	// Generated
	override protected colFrom(String attName, Classifier type, Class owner) {
		// Transformation 
		val colList = newArrayList
		// Transformation 
		val columnName = (owner === null || owner.name === null || owner.name === "")? "Id" : owner.name.toFirstLower + "Id"
		// Transformation 
		val idCol = Relational_Factory.eINSTANCE.createColumn() => [name = columnName
			// Transformation 
			type = Utils.getType(findIntegerDatatype())
		]
		// Transformation 
		val valCol = Relational_Factory.eINSTANCE.createColumn() => [name = attName
			// Transformation 
			type = Utils.getType(type)
		]
		// Transformation 
		colList += idCol
		// Transformation 
		colList += valCol
		// Transformation 
		return new Type4col(colList)
	}

	// Helper 
	def findIntegerDatatype() {
		// Helper 
		val datatype = sourceModel.contents.filter(typeof(DataType)).findFirst[name == "Integer"]
		// Helper 
		datatype
	}

}
