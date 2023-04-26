package atol.example.transformation


import atl.research.AbstractDriver
import atl.research.class_.Class
import io.github.atlresearch.emfmodelfuzzer.SimpleEMFModelFuzzer
import org.eclipse.emf.ecore.EObject


class Run extends AbstractDriver {
	val Class2Relational transformation

	static def void main(String[] args) {
		new Run()
    }

	new() throws Exception {
		// call AbstractDriver constructor to initialize source, changes and target
		super()

		// initialize transformation
        transformation = new Class2Relational()

		// other initialization code
	}

	override void applyTransformation() {
		for(EObject e : source.contents) {
			if(e instanceof Class) {
				val res = transformation.Class2Table(e)._out
				target.contents.add(res)
			}
		}
	}

	def fuzzerExample() {
		val fuzzer = new SimpleEMFModelFuzzer(source, /* seed */ 3, /* log to console */ true)
		// perform some random changes
		for(var i = 1 ; i < 1000 ; i++) {
			fuzzer.performOneChange
		}
	}
}
