package de.tbuchmann.ttc.rules;

import de.tbuchmann.ttc.trafo.Class2Relational
import atl.research.class_.Attribute
import atl.research.class_.Classifier
import atl.research.class_.DataType

class SingleClassAttribute2ColumnImpl extends SingleClassAttribute2Column {	
	// Setup
	new(Class2Relational trafo) {
		// Setup
		super(trafo)
	}
	
	// Model Traversal 
	override protected filterAtt(Attribute att) {		
		// Model Traversal
		!(att.multiValued) && !(att.type instanceof DataType)// && (att.type !== null) does not work, because this 
		// would result in attributes without a correspondence element and consequently the transformation
		// will yield an exception in Class2Table when attribute.getCorr is called on EACH attribute
	}
	
	// Transformation 
	override protected colNameFrom(String attName, Classifier attType) {
		// Transformation
		new Type4colName(attName + "Id")
	}
	
	// Transformation 
	override protected colTypeFrom(String attName, Classifier attType) {
		// Transformation
		new Type4colType(Utils.getType(findIntegerDatatype()))
	}
	
	// Helper 
	def findIntegerDatatype() {
		// Model Traversal
		val datatype = sourceModel.contents.filter(typeof(DataType)).findFirst[name == "Integer"]
		// Helper
		datatype
	}
	
}
