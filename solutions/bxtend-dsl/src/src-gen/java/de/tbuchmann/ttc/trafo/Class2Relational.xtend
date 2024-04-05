package de.tbuchmann.ttc.trafo

import java.util.ArrayList
import java.util.HashMap
import java.util.List
import org.eclipse.emf.ecore.resource.Resource
import de.tbuchmann.ttc.rules.Elem2Elem
import de.tbuchmann.ttc.rules.DataType2Type
import de.tbuchmann.ttc.rules.SingleAttribute2ColumnImpl
import de.tbuchmann.ttc.rules.MultiAttribute2TableImpl
import de.tbuchmann.ttc.rules.SingleClassAttribute2ColumnImpl
import de.tbuchmann.ttc.rules.MultiClassAttribute2ColumnImpl
import de.tbuchmann.ttc.rules.Class2TableImpl

class Class2Relational extends AbstractClass2Relational {
	static val options = #{}
	
	val configuration = new HashMap<String, Object>()
	
	new() {
		super()
	}
	new(Resource source, Resource target, Resource correspondence) {
		super(source, target, correspondence)
	}
	
	override Object getOption(String option) {
		if (!options.contains(option)) {
			throw new IllegalArgumentException("Invalid option '" + option + "'! Valid options are " + options + ".")
		}
		return configuration.get(option)
	}
	override void setOption(String option, Object value) {
		if (!options.contains(option)) {
			throw new IllegalArgumentException("Invalid option '" + option + "'! Valid options are " + options + ".")
		}
		configuration.put(option, value)
	}
	
	override protected List<Elem2Elem> createRules() {
		var result = new ArrayList<Elem2Elem>()
		result += new DataType2Type(this)
		result += new SingleAttribute2ColumnImpl(this)
		result += new MultiAttribute2TableImpl(this)
		result += new SingleClassAttribute2ColumnImpl(this)
		result += new MultiClassAttribute2ColumnImpl(this)
		result += new Class2TableImpl(this)
		return result
	}
}
