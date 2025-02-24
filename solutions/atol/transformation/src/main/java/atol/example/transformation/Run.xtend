package atol.example.transformation


import atl.research.AbstractDriver
import atl.research.class_.Class
import atl.research.class_.DataType
import fr.eseo.aof.extensions.AOFExtensions
import io.github.atlresearch.emfmodelfuzzer.SimpleEMFModelFuzzer
import org.eclipse.emf.ecore.EObject
import org.eclipse.papyrus.aof.core.impl.utils.DefaultObserver

// Setup
class Run extends AbstractDriver implements AOFExtensions {
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
	// Setup 6
        this.transformation = new Class2Relational()

		// other initialization code
	}

	// Setup 3
	override void applyTransformation() {
		// Setup 45
		val res = source.<EObject>allContents(null).collect[ e |
			val r = switch (e) {
				Class: this.transformation.Class2Table(e)._out
				DataType: this.transformation.DataType2Type(e)._out
			}
			r as EObject
		].select[ e | e !== null ]
		// Setup 50
		res.addObserver(new DefaultObserver <EObject> {
			override added(int index, EObject element) {
				target.contents.add(element)
			}
			override moved(int newIndex, int oldIndex, EObject element) {
				// no impact
			}
			override removed(int index, EObject element) {
				target.contents.remove(element)
			}
			override replaced(int index, EObject newElement, EObject oldElement) {
				removed(index, oldElement)
				added(index, newElement)
			}
		})
		// Setup 10
		res.forEach[ e |
			target.contents.add(e)
		]
	}

	def fuzzerExample() {
		val fuzzer = new SimpleEMFModelFuzzer(source, /* seed */ 3, /* log to console */ true)
		// perform some random changes
		for(var i = 1 ; i < 1000 ; i++) {
			fuzzer.performOneChange
		}
	}
}
