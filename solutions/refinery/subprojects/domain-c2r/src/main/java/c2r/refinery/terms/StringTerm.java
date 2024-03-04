package c2r.refinery.terms;

import tools.refinery.store.query.substitution.Substitution;
import tools.refinery.store.query.term.AbstractTerm;
import tools.refinery.store.query.term.AnyDataVariable;
import tools.refinery.store.query.term.DataVariable;
import tools.refinery.store.query.term.Term;
import tools.refinery.store.query.valuation.Valuation;

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
