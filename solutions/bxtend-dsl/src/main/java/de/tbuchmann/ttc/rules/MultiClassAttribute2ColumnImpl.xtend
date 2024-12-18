package de.tbuchmann.ttc.rules;

import de.tbuchmann.ttc.trafo.Class2Relational
import atl.research.relational_.Column
import atl.research.class_.Attribute
import atl.research.class_.Class
import atl.research.class_.Classifier
import atl.research.class_.DataType

// Setup
class MultiClassAttribute2ColumnImpl extends MultiClassAttribute2Column {	
	new(Class2Relational trafo) {
		// Setup
		super(trafo)
	}

	// Transformation 
	override protected onIdCreation(Column id) {
		// Transformation 
		id.type = Utils.getType(findIntegerDatatype())
		// Transformation 
		id.corr.target().t.col += id
	}

	// Transformation 
	override protected onFkCreation(Column fk) {
		// Transformation 
		fk.type = Utils.getType(findIntegerDatatype())
		// Transformation 
		fk.corr.target().t.col += fk
	}

	// Model_Traversal 
	override protected filterAtt(Attribute att) {		
		// Model_Traversal
		(att.multiValued) && (att.type instanceof Class)
	}

	// Transformation 
	override protected tNameFrom(String attName, Class owner, Classifier attType) {
		// Transformation 
		var tblName = (owner !== null && owner.name !== null && owner.name !== "")? owner.name : "" 
		// Transformation 
		new Type4tName(tblName + "_" + attName)
	}

	// Transformation 
	override protected idNameFrom(String attName, Class attOwner) {
		// Transformation 
		var name = (attOwner === null || attOwner.name === null || attOwner.name === "")? "Id" : attOwner.name.toFirstLower + "Id"
		// Transformation 
		new Type4idName(name)
	}

	// Transformation 
	override protected fkNameFrom(String attName, Class attOwner) {
		// Transformation 
		new Type4fkName(attName + "Id")
	}

	// Helper 
	def findIntegerDatatype() {
		// Model Traversal
		val datatype = sourceModel.contents.filter(typeof(DataType)).findFirst[name == "Integer"]
		// Helper
		datatype
	}	
}
