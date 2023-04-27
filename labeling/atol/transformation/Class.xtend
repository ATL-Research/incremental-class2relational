package atol.example.transformation

import fr.eseo.aof.xtend.utils.AOFAccessors
import atl.research.class_.Class_Package

import static fr.eseo.atol.gen.MetamodelUtils.*

//Setup 2
@AOFAccessors(Class_Package)
class Class {
	//Helper 10
	public val __multiValued = boolOneDefault[
		_multiValued.collect[
			it ?: false
		]
	]
}
