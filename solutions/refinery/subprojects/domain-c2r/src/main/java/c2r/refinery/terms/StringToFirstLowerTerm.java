package c2r.refinery.terms;

import org.eclipse.xtext.xbase.lib.StringExtensions;
import tools.refinery.store.query.substitution.Substitution;
import tools.refinery.store.query.term.AbstractTerm;
import tools.refinery.store.query.term.AnyDataVariable;
import tools.refinery.store.query.term.Term;
import tools.refinery.store.query.valuation.Valuation;

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
