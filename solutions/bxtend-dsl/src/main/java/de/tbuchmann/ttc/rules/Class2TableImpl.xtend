package de.tbuchmann.ttc.rules;

import atl.research.class_.Attribute
import atl.research.class_.DataType
import atl.research.relational_.Column
import atl.research.relational_.Table
import de.tbuchmann.ttc.corrmodel.SingleElem
import de.tbuchmann.ttc.trafo.Class2Relational
import java.util.List
import org.eclipse.emf.ecore.util.EcoreUtil
import atl.research.relational_.Relational_Factory

class Class2TableImpl extends Class2Table {	
	new(Class2Relational trafo) {
		super(trafo)
	}
	
	// Transformation 
	override protected onTblCreation(Table tbl) {
		var key = Relational_Factory.eINSTANCE.createColumn => [name = "objectId"]
		key.type = Utils.getType(findIntegerDatatype())
		tbl.col.add(0, key)
		tbl.key += key
	}
	
	// Transformation 
	override protected colFrom(List<Column> attSinCol, List<Column> attSinCol_2, List<Table> attMulTbl,
		Table parent
	) {
		/*
		 * How to handle columns whose corresponding attribute has owner set to null
		 * the problem with the benchmark is that the opposite direction class.attribute is still valid
		 * and thus the attribute is transformed into a column
		 * however, the column never gets assigned to a table
		 * Problem: attribute should be deleted rather than setting the EOpposite of the containment reference to null
		 * because this results in an invalid EMF-model
		 */
		// Helper 	
		val toDelete = newArrayList
		for (Column c : parent.col) {
			if (c.name !== "objectId" && c.corr !== null) {
				if (c.corr.source.size !== 0) {
					// Tracing 
					var obj = unwrap(c.corr.source.get(0) as SingleElem) as Attribute
					// Transformation 6
					if (obj.owner === null || obj.type === null)
						toDelete += c
				}
			}
		}
		
		// Helper 
		val columnsList = newArrayList
		// Helper 
		if (!parent.col.empty) {
			var key = parent.col.get(0)
			columnsList += key	
		}
		val allColumns = newArrayList		
		allColumns.addAll(attSinCol)
		allColumns.addAll(attSinCol_2)
		
		// Transformation 	
		for (Column c : allColumns) {
			// Tracing 
			var obj = unwrap(c.corr.source.get(0) as SingleElem) as Attribute
			// Transformation 14
			if (obj.type !== null && obj.owner !== null) {
				columnsList += c	
			}
			else {
				toDelete += c				
			}
		}
		// Transformation 
		spareElems.addAll(toDelete)
		
		// delete Tables that are created from attributes with null-Type
		// Transformation 
		val tblToDelete = newArrayList
		for (Table t : attMulTbl) {
			// Tracing 
			var obj = unwrap(t.corr.source.get(0) as SingleElem) as Attribute
			// Transformation 6
			if (obj.type === null)
				tblToDelete += t
		}
		EcoreUtil.deleteAll(tblToDelete, true)
		
		// Transformation 	
		new Type4col(columnsList)
	}
	
	// Helper 
	def findIntegerDatatype() {
		val datatype = sourceModel.contents.filter(typeof(DataType)).findFirst[name == "Integer"]
		datatype
	}	
	
}
