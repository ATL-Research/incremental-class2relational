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

// Generated
class Class2TableImpl extends Class2Table {	
	new(Class2Relational trafo) {
		// Generated
		super(trafo)
	}

	// Generated 
	override protected onTblCreation(Table tbl) {
		// Transformation 
		var key = Relational_Factory.eINSTANCE.createColumn => [name = "objectId"]
		// Transformation 
		key.type = Utils.getType(findIntegerDatatype())
		// Transformation 
		tbl.col.add(0, key)
		// Transformation 
		tbl.key += key
	}

	// Generated
	override protected colFrom(List <Column> attSinCol, List <Column> attSinCol_2, List <Table> attMulTbl,
		Table parent
	) {		
		// Helper 	
		val toDelete = newArrayList
		// Helper 	
		for (Column c : parent.col) {
			// Helper 	
			if (c.name !== "objectId" && c.corr !== null) {
				// Helper 	
				if (c.corr.source.size !== 0) {
					// Tracing 
					var obj = unwrap(c.corr.source.get(0) as SingleElem) as Attribute
					// Transformation
					if (obj.owner === null || obj.type === null)
						toDelete += c
				}
			}
		}

		// Helper 
		val columnsList = newArrayList
		// Helper 
		if (!parent.col.empty) {
			// Helper 
			var key = parent.col.get(0)
			// Helper 
			columnsList += key	
		}
		// Helper 
		val allColumns = newArrayList		
		// Helper 
		allColumns.addAll(attSinCol)
		// Helper 
		allColumns.addAll(attSinCol_2)

		// Transformation 	
		for (Column c : allColumns) {
			// Tracing 
			var obj = unwrap(c.corr.source.get(0) as SingleElem) as Attribute
			// Transformation
			if (obj.type !== null && obj.owner !== null) {
				// Transformation
				columnsList += c	
			}
			else {
				// Transformation
				toDelete += c				
			}
		}
		// Transformation 
		spareElems.addAll(toDelete)

		// Transformation 
		val tblToDelete = newArrayList
		// Transformation 
		for (Table t : attMulTbl) {
			// Tracing 
			var obj = unwrap(t.corr.source.get(0) as SingleElem) as Attribute
			// Transformation
			if (obj.type === null)
				// Transformation 
				tblToDelete += t
		}
		// Transformation 
		EcoreUtil.deleteAll(tblToDelete, true)

		// Transformation 	
		new Type4col(columnsList)
	}

	// Helper 
	def findIntegerDatatype() {
		// Helper 
		val datatype = sourceModel.contents.filter(typeof(DataType)).findFirst[name == "Integer"]
		// Helper 
		datatype
	}	

}
