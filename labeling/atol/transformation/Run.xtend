package atol.example.transformation


import atl.research.AbstractDriver
import atl.research.class_.Class
import atl.research.class_.DataType
import io.github.atlresearch.emfmodelfuzzer.SimpleEMFModelFuzzer
import org.eclipse.emf.ecore.EObject


class Run extends AbstractDriver {
	//Setup 3
	var Class2Relational transformation

	//Setup 6
	static def void main(String[] args) {
		//Setup 4
		val solution = new Run()

		//Setup 3
		solution.init
		//Setup 2
		if (isBatchMode) {
			//Setup 2
			solution.applyChange
			//Setup 2
			solution.applyTransformation
		}
		//Setup 1
		else {
			//Incrementality 2
			solution.applyTransformation
			//Incrementality 2
			solution.applyChange
		}
	//Setup 3
        solution.saveTarget
    }

	//Setup 1
	new() {
	//Setup 6
        this.transformation = new Class2Relational()

		// other initialization code
	}

	//Traversal 3
	override void applyTransformation() {
		//Traversal 6
		for(EObject e : source.contents) {
			//Traversal 4
			if(e instanceof Class) {
				//Transformation 11
				val res = this.transformation.Class2Table(e)._out
				//Incrementality 6
				target.contents.add(res)
			}
			//Traversal 5
			else if (e instanceof DataType) {
				/Transformation 11
				val res = this.transformation.DataType2Type(e)._out
				//Incrementality 6
				target.contents.add(res)
			}
		}
	}

	//Setup 2
	def fuzzerExample() {
		//Setup 8
		val fuzzer = new SimpleEMFModelFuzzer(source, /* seed */ 3, /* log to console */ true)
		
		//Setup 10
		for(var i = 1 ; i < 1000 ; i++) {
			//Setup 2
			fuzzer.performOneChange
		}
	}
}
