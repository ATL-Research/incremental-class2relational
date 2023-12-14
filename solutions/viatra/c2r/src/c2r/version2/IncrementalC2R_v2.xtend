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

class IncrementalC2R_v2 {
	extension Relational_Factory = Relational_Factory.eINSTANCE

	/* Transformation-related extensions */
	extension EventDrivenTransformation transformation

	/* Transformation rule-related extensions */
	extension EventDrivenTransformationRuleFactory = new EventDrivenTransformationRuleFactory
	extension IModelManipulations manipulation

	protected ViatraQueryEngine engine
	protected Resource target
	protected Resource trace

	new(ResourceSet set, Resource target) {
		TracePackage.eINSTANCE.class

		this.target = target
		this.trace = set.createResource(URI.createFileURI("Trace.tmp.xmi"))

		engine = ViatraQueryEngine.on(new EMFScope(set));
		
		intType = createType()
		intType.name = "Integer"
		
		createTransformation
	}

	val Type intType

	private def createTransformation() {
		// Initialize model manipulation API
		this.manipulation = new SimpleModelManipulations(engine)
		
		// List of rules, in order of priority (from most important to least)
		val List<EventDrivenTransformationRule<?, ?>> rules = #[
			createCleanupRule,
			createMakeIntegerRule,
			createDataTypeMappingRule,
			createClassMappingRule,
			createAttribute2ColumnMappingRule,
			createAttribute2TableMappingRule,
			createNameChangeRule,
			createTypeChangeRule
		]
		
		/**
		 * Set priorities for execution
		 * Lower (number) priority first
		 * disappearing rules are inverted (i.e. negative) 
		 */
		val fixedPriorityResolver = new InvertedDisappearancePriorityConflictResolver
		rules.forEach[rule, index| 
			fixedPriorityResolver.setPriority(rule.ruleSpecification,index+1);
		]
		
		// Initialize event-driven transformation
		transformation = rules.fold(
			EventDrivenTransformation.forEngine(engine)
				.setConflictResolver(fixedPriorityResolver),
			[builder, rule | 
				builder.addRule(rule)
			]
		).build
		
		transformation.executionSchema.startUnscheduledExecution
	}

	/**
	 * 
	 */
	def createCleanupRule() {
		return createRule(SourcelessTrace.Matcher.querySpecification).action(CRUDActivationStateEnum.CREATED) [
			println("sourcelessTrace[create]: " + it.trace)
			it.trace.remove
			it.named.remove
		].addLifeCycle(Lifecycles.getDefault(true, true)).build
	}
	
	def createNameChangeRule() {
		return createRule(NamedMap.Matcher.querySpecification).action(CRUDActivationStateEnum.CREATED) [
			println("nameRule[set]: " + named.name + " <--- " + name)
			named.name = name
		].action(CRUDActivationStateEnum.DELETED) [
			println("nameRule[unset]: " + named.name + " <--- null")
			named.name = null
		].addLifeCycle(Lifecycles.getDefault(true, true)).build
	}

	def createTypeChangeRule() {
		return createRule(TypeMapping.Matcher.querySpecification).action(CRUDActivationStateEnum.CREATED) [
			println("typeRule[set]: " + column.name + " <--- " + type.name)
			column.type = type
		].addLifeCycle(Lifecycles.getDefault(true, true)).build
	}

	def createMakeIntegerRule() {
		return createRule(MakeInteger.Matcher.querySpecification).action(CRUDActivationStateEnum.CREATED) [
			println("makeIntRule[create]")
			target.contents.add(intType)
		].action(CRUDActivationStateEnum.DELETED) [
			println("makeIntRule[remove]")
			target.contents.remove(intType)//FIXME potential error
		].addLifeCycle(Lifecycles.getDefault(true, true)).build
	}

	def createDataTypeMappingRule() {
		return createRule(FromDataType.Matcher.querySpecification).action(CRUDActivationStateEnum.CREATED) [
			println("fromDataTypeRule[create] " + dtype.name)
			val type = createType

			makeTrace(dtype, type, 0)

			target.contents.add(type)

//		].action(CRUDActivationStateEnum.DELETED) [
//			println("fromDataTypeRule[remove] " + dtype.name)
//			dtype.removeImages
		].addLifeCycle(Lifecycles.getDefault(true, true)).build
	}

	def createClassMappingRule() {
		return createRule(FromClass.Matcher.querySpecification).action(CRUDActivationStateEnum.CREATED) [
			println("FromClassRule[create] " + named.name)
			val table = createTable
			val idcolumn = createColumn

			makeTrace(named, idcolumn, 1)
			makeTrace(named, table, 0)

			addColumnToTable(table, idcolumn)
			table.key.add(idcolumn)

			target.contents.add(table)
//		].action(CRUDActivationStateEnum.DELETED) [
//			println("FromClassRule[remove] " + named.name)
//			named.removeImages
		].addLifeCycle(Lifecycles.getDefault(true, true)).build
	}

	def createAttribute2TableMappingRule() {
		return createRule(FromAttribute2Table.Matcher.querySpecification).action(CRUDActivationStateEnum.CREATED) [
			println("fromAttribute2TableRule[create] " + named.name)
			val table = createTable
			val idcolumn = createColumn
			val valuecolumn = createColumn

			makeTrace(named, idcolumn, 1)
			makeTrace(named, valuecolumn, 2)
			makeTrace(named, table, 0)

			addColumnToTable(table, idcolumn)
			addColumnToTable(table, valuecolumn)

			target.contents.add(table)
		].action(CRUDActivationStateEnum.DELETED) [
			println("fromAttribute2TableRule[remove] " + named.name)
			named.removeTraceQueryImages
		].addLifeCycle(Lifecycles.getDefault(true, true)).build
	}

	def createAttribute2ColumnMappingRule() {
		return createRule(FromAttribute2Column.Matcher.querySpecification).action(CRUDActivationStateEnum.CREATED) [
			println("fromAttribute2ColumnRule[create] " + named.name)
			val column = createColumn

			makeTrace(named, column, 0)

			val table = named.owner.traceQueryImage.findFirst[it.target instanceof Table].target as Table 

			addColumnToTable(table, column)
		].action(CRUDActivationStateEnum.DELETED) [
			println("fromAttribute2ColumnRule[remove] " + named.name)
			named.removeTraceQueryImages
		].addLifeCycle(Lifecycles.getDefault(true, true)).build
	}
	
	def traceQueryImage(EObject source) {
		val matcher = TraceMapping.Matcher.on(engine)
		return matcher.getAllMatches(matcher.newMatch(source, null, null, null))
	}
	
	def removeTraceQueryImages(EObject source) {
		source.traceQueryImage.forEach([match | 
			match.target.remove
			match.trace.remove
		])
	}
	
	def makeTrace(EObject source, EObject target, int index) {
		val traceEntry = TraceFactory.eINSTANCE.createTraceEntry
		traceEntry.source = source
		traceEntry.target = target
		traceEntry.index = index
		trace.contents.add(traceEntry)
	}

	def addColumnToTable(Table table, Column column) {
		table.col.add(column)
		column.owner = table
	}
}
