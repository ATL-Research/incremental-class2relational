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

// Setup
class IncrementalC2R_v2 {
	// Setup
	extension Relational_Factory = Relational_Factory.eINSTANCE

	// Helper
	extension EventDrivenTransformation transformation

	// Helper
	extension EventDrivenTransformationRuleFactory = new EventDrivenTransformationRuleFactory
	
	// Helper
	extension IModelManipulations manipulation

	// Helper
	protected ViatraQueryEngine engine
	
	// Setup
	protected Resource target
	// Setup
	protected Resource trace
	// Setup
	new(ResourceSet set, Resource target) {
		// TRACING
		TracePackage.eINSTANCE.class
		// Setup
		this.target = target
		// TRACING
		this.trace = set.createResource(URI.createFileURI("Trace.tmp.xmi"))
		// Setup
		engine = ViatraQueryEngine.on(new EMFScope(set));
		// Transformation
		intType = createType()
		// Transformation
		intType.name = "Integer"
		// Setup
		createTransformation
	}
	// Helper
	val Type intType

	// Setup
	private def createTransformation() {
		// Setup
		this.manipulation = new SimpleModelManipulations(engine)
		
		// Helper
		val List <EventDrivenTransformationRule<?, ?>> rules = #[
			// Setup
			createCleanupRule,
			// Setup
			createMakeIntegerRule,
			// Setup
			createDataTypeMappingRule,
			// Setup
			createClassMappingRule,
			// Setup
			createAttribute2ColumnMappingRule,
			// Setup
			createAttribute2TableMappingRule,
			// Setup
			createNameChangeRule,
			// Setup
			createTypeChangeRule
		// Helper
		]
		
		// Setup
		val fixedPriorityResolver = new InvertedDisappearancePriorityConflictResolver
		// Setup
		rules.forEach[rule, index|
			// Setup 
			fixedPriorityResolver.setPriority(rule.ruleSpecification,index+1);
		// Setup
		]
		
		// Setup
		transformation = rules.fold(
			// Setup
			EventDrivenTransformation.forEngine(engine)
			// Setup
				.setConflictResolver(fixedPriorityResolver),
				// Setup
			[builder, rule | 
				// Setup
				builder.addRule(rule)
				// Setup
			]
		// Setup
		).build
		// Setup
		transformation.executionSchema.startUnscheduledExecution
	}
	
	// Transformation
	def createCleanupRule() {
		// CHANGE_IDENTIFICATION
		return createRule(SourcelessTrace.Matcher.querySpecification).action(CRUDActivationStateEnum.CREATED) [
			// TRACING
			it.trace.remove
			// TRANSFORMATION
			it.named.remove
		// Setup
		].addLifeCycle(Lifecycles.getDefault(true, true)).build
	}
	// transformation
	def createNameChangeRule() {
		// CHANGE_IDENTIFICATION
		return createRule(NamedMap.Matcher.querySpecification).action(CRUDActivationStateEnum.CREATED) [
			// TRANSFORMATION
			named.name = name
		// CHANGE_IDENTIFICATION
		].action(CRUDActivationStateEnum.DELETED) [
			// TRANSFORMATION
			named.name = null
		//SETUP
		].addLifeCycle(Lifecycles.getDefault(true, true)).build
	}
	// transformation ???
	def createTypeChangeRule() {
		// CHANGE_IDENTIFICATION
		return createRule(TypeMapping.Matcher.querySpecification).action(CRUDActivationStateEnum.CREATED) [
			// TRANSFORMATION
			column.type = type
		// Setup
		].addLifeCycle(Lifecycles.getDefault(true, true)).build
	}
	// transformation
	def createMakeIntegerRule() {
		// CHANGE_IDENTIFICATION
		return createRule(MakeInteger.Matcher.querySpecification).action(CRUDActivationStateEnum.CREATED) [
			// TRANSFORMATION
			target.contents.add(intType)
		// CHANGE_IDENTIFICATION
		].action(CRUDActivationStateEnum.DELETED) [
			// TRANSFORMATION
			target.contents.remove(intType)
		// Setup
		].addLifeCycle(Lifecycles.getDefault(true, true)).build
	}
	// transformation
	def createDataTypeMappingRule() {
		// CHANGE_IDENTIFICATION
		return createRule(FromDataType.Matcher.querySpecification).action(CRUDActivationStateEnum.CREATED) [
			// TRANSFORMATION
			val type = createType
			// TRACING
			makeTrace(dtype, type, 0)
			// TRANSFORMATION
			target.contents.add(type)
		// Setup
		].addLifeCycle(Lifecycles.getDefault(true, true)).build
	}
	// transformation
	def createClassMappingRule() { 
		// CHANGE_IDENTIFICATION
		return createRule(FromClass.Matcher.querySpecification).action(CRUDActivationStateEnum.CREATED) [
			// TRANSFORMATION
			val table = createTable
			// TRANSFORMATION
			val idcolumn = createColumn
			// TRACING
			makeTrace(named, idcolumn, 1)
			// TRACING
			makeTrace(named, table, 0)
			// TRANSFORMATION
			addColumnToTable(table, idcolumn)
			// TRANSFORMATION
			table.key.add(idcolumn)
			// TRANSFORMATION
			target.contents.add(table)
		// Setup
		].addLifeCycle(Lifecycles.getDefault(true, true)).build
	}
	// transformation
	def createAttribute2TableMappingRule() {
		// CHANGE_IDENTIFICATION
		return createRule(FromAttribute2Table.Matcher.querySpecification).action(CRUDActivationStateEnum.CREATED) [
			// TRANSFORMATION
			val table = createTable
			// TRANSFORMATION
			val idcolumn = createColumn
			// TRANSFORMATION
			val valuecolumn = createColumn
			// TRACING
			makeTrace(named, idcolumn, 1)
			// TRACING
			makeTrace(named, valuecolumn, 2)
			// TRACING
			makeTrace(named, table, 0)
			// TRANSFORMATION
			addColumnToTable(table, idcolumn)
			// TRANSFORMATION
			addColumnToTable(table, valuecolumn)
			// TRANSFORMATION
			target.contents.add(table)
		// CHANGE_IDENTIFICATION
		].action(CRUDActivationStateEnum.DELETED) [
			// TRANSFORMATION
			named.removeTraceQueryImages
		// Setup
		].addLifeCycle(Lifecycles.getDefault(true, true)).build
	}
	// transformation
	def createAttribute2ColumnMappingRule() {
		// CHANGE_IDENTIFICATION
		return createRule(FromAttribute2Column.Matcher.querySpecification).action(CRUDActivationStateEnum.CREATED) [
			// TRANSFORMATION
			val column = createColumn
			// TRACING
			makeTrace(named, column, 0)
			// MODEL_NAVIGATION
			val table = named.owner.traceQueryImage.findFirst[it.target instanceof Table].target as Table 
			// TRANSFORMATION
			addColumnToTable(table, column)
		// CHANGE_IDENTIFICATION
		].action(CRUDActivationStateEnum.DELETED) [
			// TRANSFORMATION
			named.removeTraceQueryImages
		// Setup
		].addLifeCycle(Lifecycles.getDefault(true, true)).build
	}
	// helper
	def traceQueryImage(EObject source) {
		// helper
		val matcher = TraceMapping.Matcher.on(engine)
		// TRACING
		return matcher.getAllMatches(matcher.newMatch(source, null, null, null))
	}
	// helper
	def removeTraceQueryImages(EObject source) {
		// TRACING
		source.traceQueryImage.forEach([match | 
			// TRACING
			match.target.remove
			//TRACING
			match.trace.remove
		])
	}
	// Helper
	def makeTrace(EObject source, EObject target, int index) {
		// TRACING
		val traceEntry = TraceFactory.eINSTANCE.createTraceEntry
		// TRACING
		traceEntry.source = source
		// TRACING
		traceEntry.target = target
		// TRACING
		traceEntry.index = index
		// TRACING
		trace.contents.add(traceEntry)
	}
	// TRANSFORMATION
	def addColumnToTable(Table table, Column column) {
		// TRANSFORMATION
		table.col.add(column)
		// TRANSFORMATION
		column.owner = table
	}
}
