package c2r.refinery.terms;

import org.eclipse.xtext.xbase.lib.StringExtensions;
import tools.refinery.logic.substitution.Substitution;
import tools.refinery.logic.term.AbstractTerm;
import tools.refinery.logic.term.AnyDataVariable;
import tools.refinery.logic.term.Term;
import tools.refinery.logic.valuation.Valuation;

import java.util.Set;

public class StringToFirstLowerTerm extends AbstractTerm<String> {
	private final Term<String> term;
	public StringToFirstLowerTerm(Term<String> arg){
		super(String.class);
		term = arg;
	}
	@Override
	public Set<AnyDataVariable> getInputVariables() {
		return term.getInputVariables();
	}

	@Override
	public String evaluate(Valuation valuation) {
		return StringExtensions.toFirstLower(term.evaluate(valuation));
	}

	@Override
	public Term<String> substitute(Substitution substitution) {
		return null;
	}
}
