package c2r.refinery;

import atl.research.AbstractDriver;
import c2r.refinery.random.ChangeImplementation;
import tools.refinery.store.dse.modification.ModificationAdapter;
import tools.refinery.store.dse.propagation.PropagationAdapter;
import tools.refinery.store.model.Model;
import tools.refinery.store.model.ModelStore;
import tools.refinery.store.query.ModelQueryAdapter;
import tools.refinery.store.query.interpreter.QueryInterpreterAdapter;

import java.io.IOException;

import static c2r.refinery.C2RRules.*;
import static c2r.refinery.C2RRules.setType;

public class C2RRefineryMain extends AbstractDriver {
	Model model;
	RelationalDomain relationalmodel;

	public static void main(String[] args) throws Exception {
		var solution = new C2RRefineryMain();
		solution.init();

		if (solution.isBatchMode()) {
			solution.applyChange();
			solution.applyTransformation();
		}
		else {
			solution.applyTransformation();
			solution.applyChange();
		}
		//save to file
		solution.saveTarget();
	}
	@Override
	protected void applyChange() {
		super.applyChange();
		update();
	}
	protected void update(){
		if(model!=null){
			model.getAdapter(ModelQueryAdapter.class).flushChanges();
			model.getAdapter(PropagationAdapter.class).propagate();
		}
	}
	@Override
	protected void saveTarget() throws IOException {
		relationalmodel.toResource(getTarget());
		super.saveTarget();
	}
	@Override
	protected void applyTransformation() {
		/**
		 * Setup of transformation framework
		 */
		var storebuilder = ModelStore.builder()
				.with(QueryInterpreterAdapter.builder()
						.queries(hasInteger,needInteger,
								needDataType,hasDataType,
								needClass,hasClass,
								needAttribute2Table,hasAttribute2Table,
								needAttribute2Column,hasAttribute2Column,
								specifiedType,
								typeMapping,
								nameQuery))
				.with(ModificationAdapter.builder())
				.with(PropagationAdapter.builder()
						.rules(
								//unsetType,
								removeAttribute2Table,
								removeAttribute2Column,
								//removeClass,
								//removeType,
								removeInt
								,clean
								,addInt
								,addType
								,addClass
								,addAttribute2Column
								,addAttribute2Table
								,setType
						));
		ClassDomain.build(storebuilder);
		RelationalDomain.build(storebuilder);
		Trace2Domain.build(storebuilder);

		var store = storebuilder.build();
		model = store.createEmptyModel();

		var classmodel = new ClassDomain(model, getSource());
		getSource().eAdapters().add(new ChangeImplementation(classmodel));
		relationalmodel = new RelationalDomain(model);

		//noinspection unchecked
		model.getAdapter(ModelQueryAdapter.class)
				.getResultSet(nameQuery)
				.addListener(relationalmodel.makeNameListener());

		update();
	}
}
