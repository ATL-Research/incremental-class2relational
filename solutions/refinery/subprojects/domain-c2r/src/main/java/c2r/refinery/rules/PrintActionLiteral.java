package c2r.refinery.rules;

import tools.refinery.store.dse.transition.actions.AbstractActionLiteral;
import tools.refinery.store.dse.transition.actions.BoundActionLiteral;
import tools.refinery.store.model.Model;
import tools.refinery.store.query.term.NodeVariable;
import tools.refinery.store.tuple.Tuple;

import javax.swing.plaf.synth.SynthSpinnerUI;
import java.util.Arrays;
import java.util.List;

public class PrintActionLiteral extends AbstractActionLiteral {
	private List<NodeVariable> parameters;
	private final String message;
	public PrintActionLiteral(String message, NodeVariable... datatype) {
		super();
		this.parameters = Arrays.stream(datatype).toList();
		this.message = message;
	}

	@Override
	public List<NodeVariable> getInputVariables() {
		return parameters;
	}

	@Override
	public List<NodeVariable> getOutputVariables() {
		return List.of();
	}

	@Override
	public BoundActionLiteral bindToModel(Model model) {
		return tuple -> {
			System.out.println("Action called with message=\""+message+"\"");
			parameters.forEach(node -> {
				System.out.println("\t"+node.toString()+", "+tuple);
			});
			return Tuple.of();
		};
	}
}
