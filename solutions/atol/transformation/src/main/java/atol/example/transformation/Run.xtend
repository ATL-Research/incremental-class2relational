package atol.example.transformation


import atl.research.AbstractDriver
import atl.research.class_.Class
import atl.research.class_.DataType
import io.github.atlresearch.emfmodelfuzzer.SimpleEMFModelFuzzer
import org.eclipse.emf.ecore.EObject


class Run extends AbstractDriver {
	var Class2Relational transformation

	static def void main(String[] args) {
		val solution = new Run()

		solution.init
		if (solution.batchMode) {
			solution.applyChange
			solution.applyTransformation
		}
		else {
			solution.applyTransformation
			solution.applyChange
		}
        solution.saveTarget
    }

	new() {
		// initialize transformation
        this.transformation = new Class2Relational()

		// other initialization code
	}

	override void applyTransformation() {
		for(EObject e : source.contents) {
			if(e instanceof Class) {
				val res = this.transformation.Class2Table(e)._out
				target.contents.add(res)
			}
			else if (e instanceof DataType) {
				val res = this.transformation.DataType2Type(e)._out
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
