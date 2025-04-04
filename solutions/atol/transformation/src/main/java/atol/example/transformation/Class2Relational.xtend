package atol.example.transformation


import fr.eseo.atol.gen.ATOLGen
import fr.eseo.atol.gen.ATOLGen.Metamodel
import org.eclipse.papyrus.aof.core.IBox

@ATOLGen(transformation="src/main/resources/Class2Relational.atl", metamodels=#[
	@Metamodel(name="Class", impl=Class),
	@Metamodel(name="Relational", impl=Relational)
])
class Class2Relational {
	// Helper
	def firstToLower(IBox <String> it) {
		it.collect[toFirstLower]
	}
}
