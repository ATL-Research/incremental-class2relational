package c2r.refinery;

import tools.refinery.store.model.Interpretation;
import tools.refinery.store.model.Model;
import tools.refinery.store.model.ModelStoreBuilder;
import tools.refinery.store.query.view.FunctionView;
import tools.refinery.store.query.view.KeyOnlyView;
import tools.refinery.store.representation.Symbol;

import java.security.Key;

public class Trace2Domain {
	public static final Symbol<Integer> trace_trace = Symbol.of("trace2",2,Integer.class,null);
	public static final FunctionView<Integer> traceFunctionView = new FunctionView<>(trace_trace);
	public static final KeyOnlyView<Integer> traceKeyView = new KeyOnlyView<>(trace_trace);
	public static void build(ModelStoreBuilder builder){
		builder.symbols(trace_trace);
	}
}
