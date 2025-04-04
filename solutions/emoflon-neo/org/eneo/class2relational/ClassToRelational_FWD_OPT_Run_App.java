package org.eneo.class2relational;


import java.util.List;
import org.emoflon.neo.api.classtorelational.API_ClassToRelational;
import org.emoflon.neo.api.classtorelational.run.ClassToRelational_FWD_OPT_Run;
import org.emoflon.neo.api.classtorelational.tgg.API_ClassToRelational_FWD_OPT;
import org.emoflon.neo.api.classtorelational.tgg.API_ClassToRelational_GEN;
import org.emoflon.neo.cypher.models.NeoCoreBuilder;
import org.emoflon.neo.engine.modules.NeoGenerator;
import org.emoflon.neo.engine.modules.analysis.TripleRuleAnalyser;
import org.emoflon.neo.engine.modules.ilp.ILPFactory.SupportedILPSolver;
import org.emoflon.neo.engine.modules.matchreprocessors.FWD_OPTReprocessor;
import org.emoflon.neo.engine.modules.monitors.HeartBeatAndReportMonitor;
import org.emoflon.neo.engine.modules.ruleschedulers.FWD_OPTRuleScheduler;
import org.emoflon.neo.engine.modules.startup.NoOpStartup;
import org.emoflon.neo.engine.modules.terminationcondition.NoMoreMatchesTerminationCondition;
import org.emoflon.neo.engine.modules.updatepolicies.ForwardTransformationOperationalStrategy;
import org.emoflon.neo.engine.modules.valueGenerators.LoremIpsumStringValueGenerator;
import org.emoflon.neo.engine.modules.valueGenerators.ModelNameValueGenerator;

// Setup
public class ClassToRelational_FWD_OPT_Run_App extends ClassToRelational_FWD_OPT_Run {
	// Setup
	public ClassToRelational_FWD_OPT_Run_App(String srcModelName, String trgModelName) {
		// Setup
		super(srcModelName, trgModelName, SupportedILPSolver.Sat4J);
	}
	
	// Setup
	public NeoGenerator createGenerator(NeoCoreBuilder builder) {
		// Setup
		var api = new API_ClassToRelational(builder);
		// Setup
		var genAPI = new API_ClassToRelational_GEN(builder);
		// Setup
		var fwd_optAPI = new API_ClassToRelational_FWD_OPT(builder);
		// Setup
		var genRules = genAPI.getAllRulesForClassToRelational_GEN();
		// Setup
		var analyser = new TripleRuleAnalyser(new API_ClassToRelational(builder).getTripleRulesOfClassToRelational());
		// Setup
		var choiceOfFwdRules = fwd_optAPI.getAllRulesForClassToRelational_FWD_OPT();
		
		// Setup
		forwardTransformation = new ForwardTransformationOperationalStrategy(//
				solver, //
				builder, //
				genRules, //
				choiceOfFwdRules, //
				api.getConstraintsOfClassToRelational(), //
				srcModelName, //
				trgModelName//
		);
		
		// Setup
		var gen = new NeoGenerator(//
				choiceOfFwdRules, //
				new NoOpStartup(), //
				new NoMoreMatchesTerminationCondition(), //
				new FWD_OPTRuleScheduler(analyser), //
				forwardTransformation, //
				new FWD_OPTReprocessor(analyser), //
				forwardTransformation, //
				new HeartBeatAndReportMonitor(), //
				new ModelNameValueGenerator(srcModelName, trgModelName), //
				List.of(new LoremIpsumStringValueGenerator()));
		
		// Setup
		gen.getAttrConstrContainer().addCreator("firstToLowerCase", () -> new FirstToLowerCase());
		
		// Setup
		return gen;
	}
}
