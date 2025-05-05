package de.tbuchmann.ttc.rules;

import de.tbuchmann.ttc.trafo.Class2Relational
import atl.research.class_.Attribute

// Generated
class SingleAttribute2ColumnImpl extends SingleAttribute2Column {	
	new(Class2Relational trafo) {
		// Generated
		super(trafo)
	}

	// Generated 
	override protected filterAtt(Attribute att) {	
		// Model_Traversal
		!(att.multiValued) && !(att.type instanceof atl.research.class_.Class) && (att.type !== null)
	}

}
