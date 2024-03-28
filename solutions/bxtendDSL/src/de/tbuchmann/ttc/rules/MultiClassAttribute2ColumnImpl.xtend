package de.tbuchmann.ttc.rules;

import de.tbuchmann.ttc.trafo.Class2Relational
import atl.research.relational_.Column
import atl.research.class_.Attribute
import atl.research.class_.Class
import atl.research.class_.Classifier
import atl.research.class_.DataType

class MultiClassAttribute2ColumnImpl extends MultiClassAttribute2Column {	
	new(Class2Relational trafo) {
		super(trafo)
	}
	
	// Transformation 
	override protected onIdCreation(Column id) {
		id.type = Utils.getType(findIntegerDatatype())
		id.corr.target().t.col += id
	}
	
	// Transformation 
	override protected onFkCreation(Column fk) {
		fk.type = Utils.getType(findIntegerDatatype())
		fk.corr.target().t.col += fk
	}
	
	// Model Traversal 
	override protected filterAtt(Attribute att) {		
		(att.isMultiValued) && (att.type instanceof Class)
	}
	
	// Transformation 
	override protected tNameFrom(String attName, Class owner, Classifier attType) {
		var tblName = (owner !== null && owner.name !== null && owner.name !== "")? owner.name : "Table" 
		new Type4tName(tblName + "_" + attName)
	}
	
	// Transformation 
	override protected idNameFrom(String attName, Class attOwner) {
		var name = (attOwner === null || attOwner.name === null || attOwner.name === "")? "tableId" : attOwner.name.toFirstLower + "Id"
		
		new Type4idName(name)
	}
	
	// Transformation 
	override protected fkNameFrom(String attName, Class attOwner) {
		new Type4fkName(attName + "Id")
	}
	
	// Helper 
	def findIntegerDatatype() {
		// Model Traversal 10
		val datatype = sourceModel.contents.filter(typeof(DataType)).findFirst[name == "Integer"]
		datatype
	}	
	
}
