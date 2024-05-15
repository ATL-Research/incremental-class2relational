package c2r.version2

import Trace.TraceFactory
import Trace.TracePackage
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import org.eclipse.viatra.query.runtime.emf.EMFScope
import org.eclipse.viatra.transformation.evm.specific.Lifecycles
import org.eclipse.viatra.transformation.evm.specific.crud.CRUDActivationStateEnum
import org.eclipse.viatra.transformation.evm.specific.resolver.InvertedDisappearancePriorityConflictResolver
import org.eclipse.viatra.transformation.runtime.emf.modelmanipulation.IModelManipulations
import org.eclipse.viatra.transformation.runtime.emf.modelmanipulation.SimpleModelManipulations
import org.eclipse.viatra.transformation.runtime.emf.rules.eventdriven.EventDrivenTransformationRuleFactory
import org.eclipse.viatra.transformation.runtime.emf.transformation.eventdriven.EventDrivenTransformation
import relational_.Column
import relational_.Relational_Factory
import relational_.Table
import relational_.Type
import c2r.version2.TraceMapping.Match
import org.eclipse.viatra.transformation.runtime.emf.rules.eventdriven.EventDrivenTransformationRule
import java.util.List

// wrapper
class IncrementalC2R_v2 {
	// setup
	extension Relational_Factory = Relational_Factory.eINSTANCE

	// helper, transformation
	extension EventDrivenTransformation transformation

	// helper, setup
	extension EventDrivenTransformationRuleFactory = new EventDrivenTransformationRuleFactory
	// setup
	extension IModelManipulations manipulation

	// setup
	protected ViatraQueryEngine engine
	// setup
	protected Resource target
	//setup
	protected Resource trace
	//setup
	new(ResourceSet set, Resource target) {
		//setup
		TracePackage.eINSTANCE.class
		// setup
		this.target = target
		// setup
		this.trace = set.createResource(URI.createFileURI("Trace.tmp.xmi"))
		// setup
		engine = ViatraQueryEngine.on(new EMFScope(set));
		// transformation
		intType = createType()
		//transformation
		intType.name = "Integer"
		// setup
		createTransformation
	}
	// helper
	val Type intType

	// setup
	private def createTransformation() {
		// setup
		this.manipulation = new SimpleModelManipulations(engine)
		
		/* List of rules, in order of priority (from most important to least */
		// transformation
		val List<EventDrivenTransformationRule<?, ?>> rules = #[
			// transformation
			createCleanupRule,
			// transformation
			createMakeIntegerRule,
			// transformation
			createDataTypeMappingRule,
			// transformation
			createClassMappingRule,
			// transformation
			createAttribute2ColumnMappingRule,
			// transformation
			createAttribute2TableMappingRule,
			// transformation
			createNameChangeRule,
			// transformation
			createTypeChangeRule
		// transformation
		]
		
		/**
		 * Set priorities for execution
		 * Lower (number) priority first
		 * disappearing rules are inverted (i.e. negative) 
		 */
		// transformation
		val fixedPriorityResolver = new InvertedDisappearancePriorityConflictResolver
		//transformation
		rules.forEach[rule, index|
			// transformation 
			fixedPriorityResolver.setPriority(rule.ruleSpecification,index+1);
		// transformation
		]
		
		/* Initialize event-driven transformation */
		// transformation
		transformation = rules.fold(
			// transformation
			EventDrivenTransformation.forEngine(engine)
			//transformation
				.setConflictResolver(fixedPriorityResolver),
				//transformation
			[builder, rule | 
				//transformation
				builder.addRule(rule)
				// transformation
			]
		//transformation
		).build
		// transformation
		transformation.executionSchema.startUnscheduledExecution
	}

	/**
	 * 
	 */
	// transformation
	def createCleanupRule() {
		// incremental change recognition
		return createRule(SourcelessTrace.Matcher.querySpecification).action(CRUDActivationStateEnum.CREATED) [
			println("sourcelessTrace[create]: " + it.trace)
			// incremental change propagation
			it.trace.remove
			// incremental change propagation
			it.named.remove
		// transformation
		].addLifeCycle(Lifecycles.getDefault(true, true)).build
	}
	// transformation
	def createNameChangeRule() {
		// incremental change recognition
		return createRule(NamedMap.Matcher.querySpecification).action(CRUDActivationStateEnum.CREATED) [
			println("nameRule[set]: " + named.name + " <--- " + name)
			// incremental change propagation
			named.name = name
		// incremental change recognition
		].action(CRUDActivationStateEnum.DELETED) [
			println("nameRule[unset]: " + named.name + " <--- null")
			// incremental change propagation
			named.name = null
		//transformation
		].addLifeCycle(Lifecycles.getDefault(true, true)).build
	}
	// transformation
	def createTypeChangeRule() {
		// incremental change recognition
		return createRule(TypeMapping.Matcher.querySpecification).action(CRUDActivationStateEnum.CREATED) [
			println("typeRule[set]: " + column.name + " <--- " + type.name)
			// incremental change propagation
			column.type = type
		// transformation
		].addLifeCycle(Lifecycles.getDefault(true, true)).build
	}
	// transformation
	def createMakeIntegerRule() {
		// incremental change recognition
		return createRule(MakeInteger.Matcher.querySpecification).action(CRUDActivationStateEnum.CREATED) [
			println("makeIntRule[create]")
			// incremental change propagation
			target.contents.add(intType)
		// incremental change recognition
		].action(CRUDActivationStateEnum.DELETED) [
			println("makeIntRule[remove]")
			// incremental change propagation
			target.contents.remove(intType)//FIXME potential error
		// transformation
		].addLifeCycle(Lifecycles.getDefault(true, true)).build
	}
	// transformation
	def createDataTypeMappingRule() {
		// incremental change recognition
		return createRule(FromDataType.Matcher.querySpecification).action(CRUDActivationStateEnum.CREATED) [
			println("fromDataTypeRule[create] " + dtype.name)
			// incremental change propagation
			val type = createType
			// trace
			makeTrace(dtype, type, 0)
			// incremental change propagation
			target.contents.add(type)
		// transformation
		].addLifeCycle(Lifecycles.getDefault(true, true)).build
	}
	// transformation
	def createClassMappingRule() {
		// incremental change recognition
		return createRule(FromClass.Matcher.querySpecification).action(CRUDActivationStateEnum.CREATED) [
			println("FromClassRule[create] " + named.name)
			// incremental change propagation
			val table = createTable
			// incremental change propagation
			val idcolumn = createColumn
			// trace
			makeTrace(named, idcolumn, 1)
			// trace
			makeTrace(named, table, 0)
			// incremental change propagation
			addColumnToTable(table, idcolumn)
			// incremental change propagation
			table.key.add(idcolumn)
			// incremental change propagation
			target.contents.add(table)
//		].action(CRUDActivationStateEnum.DELETED) [
//			println("FromClassRule[remove] " + named.name)
//			named.removeImages
		// transformation
		].addLifeCycle(Lifecycles.getDefault(true, true)).build
	}
	// transformation
	def createAttribute2TableMappingRule() {
		// incremental change recognition
		return createRule(FromAttribute2Table.Matcher.querySpecification).action(CRUDActivationStateEnum.CREATED) [
			println("fromAttribute2TableRule[create] " + named.name)
			// incremental change propagation
			val table = createTable
			// incremental change propagation
			val idcolumn = createColumn
			// incremental change propagation
			val valuecolumn = createColumn
			// trace
			makeTrace(named, idcolumn, 1)
			// trace
			makeTrace(named, valuecolumn, 2)
			// trace
			makeTrace(named, table, 0)
			// transformation
			addColumnToTable(table, idcolumn)
			// transformation
			addColumnToTable(table, valuecolumn)
			// transformation
			target.contents.add(table)
		// incremental change recognition
		].action(CRUDActivationStateEnum.DELETED) [
			println("fromAttribute2TableRule[remove] " + named.name)
			// incremental change propagation
			named.removeTraceQueryImages
		// transformation
		].addLifeCycle(Lifecycles.getDefault(true, true)).build
	}
	// transformation
	def createAttribute2ColumnMappingRule() {
		// incremental change recognition
		return createRule(FromAttribute2Column.Matcher.querySpecification).action(CRUDActivationStateEnum.CREATED) [
			println("fromAttribute2ColumnRule[create] " + named.name)
			// transformation
			val column = createColumn
			// trace
			makeTrace(named, column, 0)
			// model navigation
			val table = named.owner.traceQueryImage.findFirst[it.target instanceof Table].target as Table 
			// transformation
			addColumnToTable(table, column)
		// incremental change recognition
		].action(CRUDActivationStateEnum.DELETED) [
			println("fromAttribute2ColumnRule[remove] " + named.name)
			// incremental change propagation
			named.removeTraceQueryImages
		// transformation
		].addLifeCycle(Lifecycles.getDefault(true, true)).build
	}
	// helper
	def traceQueryImage(EObject source) {
		// helper
		val matcher = TraceMapping.Matcher.on(engine)
		// helper
		return matcher.getAllMatches(matcher.newMatch(source, null, null, null))
	}
	// helper
	def removeTraceQueryImages(EObject source) {
		// helper
		source.traceQueryImage.forEach([match | 
			// helper
			match.target.remove
			//helper
			match.trace.remove
		])
	}
	// trace, helper
	def makeTrace(EObject source, EObject target, int index) {
		// trace
		val traceEntry = TraceFactory.eINSTANCE.createTraceEntry
		//trace
		traceEntry.source = source
		// trace
		traceEntry.target = target
		//trace
		traceEntry.index = index
		// trace
		trace.contents.add(traceEntry)
	}
	// transformation
	def addColumnToTable(Table table, Column column) {
		// transformation
		table.col.add(column)
		// transformation
		column.owner = table
	}
}
