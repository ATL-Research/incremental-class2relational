package org.eneo.class2relational;

import org.emoflon.neo.engine.modules.attributeConstraints.NeoAttributeConstraint;
import org.emoflon.neo.engine.modules.attributeConstraints.NeoAttributeConstraintVariable;

//Setup 
public class FirstToLowerCase extends NeoAttributeConstraint {

	@Override
	// Setup
	public void solve() {
		// Setup
		if (variables.size() != 2)
			// Setup
			throw new RuntimeException("The CSP -ToLowerCase- needs exactly two variables");

		// Setup
		NeoAttributeConstraintVariable word = variables.get(0);
		// Setup
		NeoAttributeConstraintVariable lowerCase = variables.get(1);

		// Setup
		String bindingStates = getBindingStates(word, lowerCase);

		// Tracing
		if (bindingStates.equals("BB")) {
			// Tracing
			setSatisfied(firstToLower(word.getValue().toString()).equals(lowerCase.getValue().toString()));
		}
		
		// Transformation
		else if (bindingStates.equals("BF")) {
			// Transformation
			lowerCase.bindToValue(firstToLower(word.getValue().toString()));
			// Setup
			setSatisfied(true);
		// Setup 
		} else {
			// Setup
			throw new UnsupportedOperationException(
					"This case in the constraint has not been implemented yet: " + bindingStates);
		}
	}

	// Setup
	private String firstToLower(String s) {
		// Transformation
		return s.toLowerCase().charAt(0) + s.substring(1, s.length());
	}
}
