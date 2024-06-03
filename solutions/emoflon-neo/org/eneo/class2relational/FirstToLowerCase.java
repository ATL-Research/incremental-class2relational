// Setup 2
package org.eneo.class2relational;

//Setup 2
import org.emoflon.neo.engine.modules.attributeConstraints.NeoAttributeConstraint;
//Setup 2
import org.emoflon.neo.engine.modules.attributeConstraints.NeoAttributeConstraintVariable;

//Setup 5
public class FirstToLowerCase extends NeoAttributeConstraint {

	@Override
	// Setup 3
	public void solve() {
		// Setup 5
		if (variables.size() != 2)
			// Setup 4
			throw new RuntimeException("The CSP -ToLowerCase- needs exactly two variables");

		// Setup 5
		NeoAttributeConstraintVariable word = variables.get(0);
		// Setup 5
		NeoAttributeConstraintVariable lowerCase = variables.get(1);

		// Setup 5
		String bindingStates = getBindingStates(word, lowerCase);

		// Tracing 4
		if (bindingStates.equals("BB")) {
			// Tracing 9
			setSatisfied(firstToLower(word.getValue().toString()).equals(lowerCase.getValue().toString()));
		}
		
		// Transformation 5
		else if (bindingStates.equals("BF")) {
			// Transformation 6
			lowerCase.bindToValue(firstToLower(word.getValue().toString()));
			// Setup 2
			setSatisfied(true);
		// Setup 1 
		} else {
			// Setup 6
			throw new UnsupportedOperationException(
					"This case in the constraint has not been implemented yet: " + bindingStates);
		}
	}

	// Setup 5
	private String firstToLower(String s) {
		// Transformation 11
		return s.toLowerCase().charAt(0) + s.substring(1, s.length());
	}
}
