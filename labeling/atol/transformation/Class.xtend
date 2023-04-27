package atol.example.transformation

import fr.eseo.aof.xtend.utils.AOFAccessors
import atl.research.class_.Class_Package

import static fr.eseo.atol.gen.MetamodelUtils.*

@AOFAccessors(Class_Package)
class Class {
	//public val __multiValued = boolOneDefault[_multiValued]
	public val __multiValued = boolOneDefault[
		_multiValued.collect[
			it ?: false
		]
	]
/*
	public val __y = oneDefault(0)[_y]
*/
}
