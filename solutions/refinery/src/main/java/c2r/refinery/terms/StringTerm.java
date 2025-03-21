package c2r.refinery.terms;

import tools.refinery.logic.substitution.Substitution;
import tools.refinery.logic.term.AbstractTerm;
import tools.refinery.logic.term.AnyDataVariable;
import tools.refinery.logic.term.DataVariable;
import tools.refinery.logic.term.Term;
import tools.refinery.logic.valuation.Valuation;

import java.util.Set;
import java.util.stream.Stream;

public class StringTerm extends AbstractTerm<String> {
	private final String format;
	private final DataVariable<?>[] vars;
	public StringTerm(String format, DataVariable<?>... vars){
		super(String.class);
		this.format = format;
		this.vars = vars;
	}
	@Override
	public Set<AnyDataVariable> getInputVariables() {
		return Set.of(vars);
	}

	@Override
	public String evaluate(Valuation valuation) {
		var values = Stream.of(vars).map(valuation::getValue).toArray();
		return String.format(format, values);
	}

	@Override
	public Term<String> substitute(Substitution substitution) {
		return null;
	}
}
