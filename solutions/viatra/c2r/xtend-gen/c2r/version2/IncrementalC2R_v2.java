package c2r.version2;

import Trace.TraceEntry;
import Trace.TraceFactory;
import Trace.TracePackage;
import c2r.version2.FromAttribute2Column;
import c2r.version2.FromAttribute2Table;
import c2r.version2.FromClass;
import c2r.version2.FromDataType;
import c2r.version2.MakeInteger;
import c2r.version2.NamedMap;
import c2r.version2.SourcelessTrace;
import c2r.version2.TraceMapping;
import c2r.version2.TypeMapping;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.emf.EMFScope;
import org.eclipse.viatra.transformation.evm.specific.Lifecycles;
import org.eclipse.viatra.transformation.evm.specific.crud.CRUDActivationStateEnum;
import org.eclipse.viatra.transformation.evm.specific.resolver.InvertedDisappearancePriorityConflictResolver;
import org.eclipse.viatra.transformation.runtime.emf.modelmanipulation.IModelManipulations;
import org.eclipse.viatra.transformation.runtime.emf.modelmanipulation.SimpleModelManipulations;
import org.eclipse.viatra.transformation.runtime.emf.rules.eventdriven.EventDrivenTransformationRule;
import org.eclipse.viatra.transformation.runtime.emf.rules.eventdriven.EventDrivenTransformationRuleFactory;
import org.eclipse.viatra.transformation.runtime.emf.transformation.eventdriven.EventDrivenTransformation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import relational_.Column;
import relational_.Named;
import relational_.Relational_Factory;
import relational_.Table;
import relational_.Type;

@SuppressWarnings("all")
public class IncrementalC2R_v2 {
  @Extension
  private Relational_Factory _relational_Factory = Relational_Factory.eINSTANCE;

  /**
   * Transformation-related extensions
   */
  @Extension
  private EventDrivenTransformation transformation;

  /**
   * Transformation rule-related extensions
   */
  @Extension
  private EventDrivenTransformationRuleFactory _eventDrivenTransformationRuleFactory = new EventDrivenTransformationRuleFactory();

  @Extension
  private IModelManipulations manipulation;

  protected ViatraQueryEngine engine;

  protected Resource target;

  protected Resource trace;

  public IncrementalC2R_v2(final ResourceSet set, final Resource target) {
    TracePackage.eINSTANCE.getClass();
    this.target = target;
    this.trace = set.createResource(URI.createFileURI("Trace.tmp.xmi"));
    EMFScope _eMFScope = new EMFScope(set);
    this.engine = ViatraQueryEngine.on(_eMFScope);
    this.intType = this._relational_Factory.createType();
    this.intType.setName("Integer");
    this.createTransformation();
  }

  private final Type intType;

  private void createTransformation() {
    SimpleModelManipulations _simpleModelManipulations = new SimpleModelManipulations(this.engine);
    this.manipulation = _simpleModelManipulations;
    EventDrivenTransformationRule <SourcelessTrace.Match, SourcelessTrace.Matcher> _createCleanupRule = this.createCleanupRule();
    EventDrivenTransformationRule <MakeInteger.Match, MakeInteger.Matcher> _createMakeIntegerRule = this.createMakeIntegerRule();
    EventDrivenTransformationRule <FromDataType.Match, FromDataType.Matcher> _createDataTypeMappingRule = this.createDataTypeMappingRule();
    EventDrivenTransformationRule <FromClass.Match, FromClass.Matcher> _createClassMappingRule = this.createClassMappingRule();
    EventDrivenTransformationRule <FromAttribute2Column.Match, FromAttribute2Column.Matcher> _createAttribute2ColumnMappingRule = this.createAttribute2ColumnMappingRule();
    EventDrivenTransformationRule <FromAttribute2Table.Match, FromAttribute2Table.Matcher> _createAttribute2TableMappingRule = this.createAttribute2TableMappingRule();
    EventDrivenTransformationRule <NamedMap.Match, NamedMap.Matcher> _createNameChangeRule = this.createNameChangeRule();
    EventDrivenTransformationRule <TypeMapping.Match, TypeMapping.Matcher> _createTypeChangeRule = this.createTypeChangeRule();
    final List <EventDrivenTransformationRule<?, ?>> rules = Collections.<EventDrivenTransformationRule <?, ?>>unmodifiableList(CollectionLiterals.<EventDrivenTransformationRule <?, ?>>newArrayList(_createCleanupRule, _createMakeIntegerRule, _createDataTypeMappingRule, _createClassMappingRule, _createAttribute2ColumnMappingRule, _createAttribute2TableMappingRule, _createNameChangeRule, _createTypeChangeRule));
    final InvertedDisappearancePriorityConflictResolver fixedPriorityResolver = new InvertedDisappearancePriorityConflictResolver();
    final Procedure2 <EventDrivenTransformationRule<?, ?>, Integer> _function = (EventDrivenTransformationRule <?, ?> rule, Integer index) -> {
      fixedPriorityResolver.setPriority(rule.getRuleSpecification(), ((index).intValue() + 1));
    };
    IterableExtensions.<EventDrivenTransformationRule <?, ?>>forEach(rules, _function);
    final Function2 <EventDrivenTransformation.EventDrivenTransformationBuilder, EventDrivenTransformationRule <?, ?>, EventDrivenTransformation.EventDrivenTransformationBuilder> _function_1 = (EventDrivenTransformation.EventDrivenTransformationBuilder builder, EventDrivenTransformationRule <?, ?> rule) -> {
      return builder.addRule(rule);
    };
    this.transformation = IterableExtensions.<EventDrivenTransformationRule <?, ?>, EventDrivenTransformation.EventDrivenTransformationBuilder>fold(rules, 
      EventDrivenTransformation.forEngine(this.engine).setConflictResolver(fixedPriorityResolver), _function_1).build();
    this.transformation.getExecutionSchema().startUnscheduledExecution();
  }

  public EventDrivenTransformationRule <SourcelessTrace.Match, SourcelessTrace.Matcher> createCleanupRule() {
    final Consumer <SourcelessTrace.Match> _function = (SourcelessTrace.Match it) -> {
      try {
        TraceEntry _trace = it.getTrace();
        String _plus = ("sourcelessTrace[create]: " + _trace);
        InputOutput.<String>println(_plus);
        this.manipulation.remove(it.getTrace());
        this.manipulation.remove(it.getNamed());
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    };
    return this._eventDrivenTransformationRuleFactory.<SourcelessTrace.Match, SourcelessTrace.Matcher>createRule(SourcelessTrace.Matcher.querySpecification()).action(CRUDActivationStateEnum.CREATED, _function).addLifeCycle(Lifecycles.getDefault(true, true)).build();
  }

  public EventDrivenTransformationRule <NamedMap.Match, NamedMap.Matcher> createNameChangeRule() {
    final Consumer <NamedMap.Match> _function = (NamedMap.Match it) -> {
      String _name = it.getNamed().getName();
      String _plus = ("nameRule[set]: " + _name);
      String _plus_1 = (_plus + " <--- ");
      String _name_1 = it.getName();
      String _plus_2 = (_plus_1 + _name_1);
      InputOutput.<String>println(_plus_2);
      Named _named = it.getNamed();
      _named.setName(it.getName());
    };
    final Consumer <NamedMap.Match> _function_1 = (NamedMap.Match it) -> {
      String _name = it.getNamed().getName();
      String _plus = ("nameRule[unset]: " + _name);
      String _plus_1 = (_plus + " <--- null");
      InputOutput.<String>println(_plus_1);
      Named _named = it.getNamed();
      _named.setName(null);
    };
    return this._eventDrivenTransformationRuleFactory.<NamedMap.Match, NamedMap.Matcher>createRule(NamedMap.Matcher.querySpecification()).action(CRUDActivationStateEnum.CREATED, _function).action(CRUDActivationStateEnum.DELETED, _function_1).addLifeCycle(Lifecycles.getDefault(true, true)).build();
  }

  public EventDrivenTransformationRule <TypeMapping.Match, TypeMapping.Matcher> createTypeChangeRule() {
    final Consumer <TypeMapping.Match> _function = (TypeMapping.Match it) -> {
      String _name = it.getColumn().getName();
      String _plus = ("typeRule[set]: " + _name);
      String _plus_1 = (_plus + " <--- ");
      String _name_1 = it.getType().getName();
      String _plus_2 = (_plus_1 + _name_1);
      InputOutput.<String>println(_plus_2);
      Column _column = it.getColumn();
      _column.setType(it.getType());
    };
    return this._eventDrivenTransformationRuleFactory.<TypeMapping.Match, TypeMapping.Matcher>createRule(TypeMapping.Matcher.querySpecification()).action(CRUDActivationStateEnum.CREATED, _function).addLifeCycle(Lifecycles.getDefault(true, true)).build();
  }

  public EventDrivenTransformationRule <MakeInteger.Match, MakeInteger.Matcher> createMakeIntegerRule() {
    final Consumer <MakeInteger.Match> _function = (MakeInteger.Match it) -> {
      InputOutput.<String>println("makeIntRule[create]");
      this.target.getContents().add(this.intType);
    };
    final Consumer <MakeInteger.Match> _function_1 = (MakeInteger.Match it) -> {
      InputOutput.<String>println("makeIntRule[remove]");
      this.target.getContents().remove(this.intType);
    };
    return this._eventDrivenTransformationRuleFactory.<MakeInteger.Match, MakeInteger.Matcher>createRule(MakeInteger.Matcher.querySpecification()).action(CRUDActivationStateEnum.CREATED, _function).action(CRUDActivationStateEnum.DELETED, _function_1).addLifeCycle(Lifecycles.getDefault(true, true)).build();
  }

  public EventDrivenTransformationRule <FromDataType.Match, FromDataType.Matcher> createDataTypeMappingRule() {
    final Consumer <FromDataType.Match> _function = (FromDataType.Match it) -> {
      String _name = it.getDtype().getName();
      String _plus = ("fromDataTypeRule[create] " + _name);
      InputOutput.<String>println(_plus);
      final Type type = this._relational_Factory.createType();
      this.makeTrace(it.getDtype(), type, 0);
      this.target.getContents().add(type);
    };
    return this._eventDrivenTransformationRuleFactory.<FromDataType.Match, FromDataType.Matcher>createRule(FromDataType.Matcher.querySpecification()).action(CRUDActivationStateEnum.CREATED, _function).addLifeCycle(Lifecycles.getDefault(true, true)).build();
  }

  public EventDrivenTransformationRule <FromClass.Match, FromClass.Matcher> createClassMappingRule() {
    final Consumer <FromClass.Match> _function = (FromClass.Match it) -> {
      String _name = it.getNamed().getName();
      String _plus = ("FromClassRule[create] " + _name);
      InputOutput.<String>println(_plus);
      final Table table = this._relational_Factory.createTable();
      final Column idcolumn = this._relational_Factory.createColumn();
      this.makeTrace(it.getNamed(), idcolumn, 1);
      this.makeTrace(it.getNamed(), table, 0);
      this.addColumnToTable(table, idcolumn);
      table.getKey().add(idcolumn);
      this.target.getContents().add(table);
    };
    return this._eventDrivenTransformationRuleFactory.<FromClass.Match, FromClass.Matcher>createRule(FromClass.Matcher.querySpecification()).action(CRUDActivationStateEnum.CREATED, _function).addLifeCycle(Lifecycles.getDefault(true, true)).build();
  }

  public EventDrivenTransformationRule <FromAttribute2Table.Match, FromAttribute2Table.Matcher> createAttribute2TableMappingRule() {
    final Consumer <FromAttribute2Table.Match> _function = (FromAttribute2Table.Match it) -> {
      String _name = it.getNamed().getName();
      String _plus = ("fromAttribute2TableRule[create] " + _name);
      InputOutput.<String>println(_plus);
      final Table table = this._relational_Factory.createTable();
      final Column idcolumn = this._relational_Factory.createColumn();
      final Column valuecolumn = this._relational_Factory.createColumn();
      this.makeTrace(it.getNamed(), idcolumn, 1);
      this.makeTrace(it.getNamed(), valuecolumn, 2);
      this.makeTrace(it.getNamed(), table, 0);
      this.addColumnToTable(table, idcolumn);
      this.addColumnToTable(table, valuecolumn);
      this.target.getContents().add(table);
    };
    final Consumer <FromAttribute2Table.Match> _function_1 = (FromAttribute2Table.Match it) -> {
      String _name = it.getNamed().getName();
      String _plus = ("fromAttribute2TableRule[remove] " + _name);
      InputOutput.<String>println(_plus);
      this.removeTraceQueryImages(it.getNamed());
    };
    return this._eventDrivenTransformationRuleFactory.<FromAttribute2Table.Match, FromAttribute2Table.Matcher>createRule(FromAttribute2Table.Matcher.querySpecification()).action(CRUDActivationStateEnum.CREATED, _function).action(CRUDActivationStateEnum.DELETED, _function_1).addLifeCycle(Lifecycles.getDefault(true, true)).build();
  }

  public EventDrivenTransformationRule <FromAttribute2Column.Match, FromAttribute2Column.Matcher> createAttribute2ColumnMappingRule() {
    final Consumer <FromAttribute2Column.Match> _function = (FromAttribute2Column.Match it) -> {
      String _name = it.getNamed().getName();
      String _plus = ("fromAttribute2ColumnRule[create] " + _name);
      InputOutput.<String>println(_plus);
      final Column column = this._relational_Factory.createColumn();
      this.makeTrace(it.getNamed(), column, 0);
      final Function1 <TraceMapping.Match, Boolean> _function_1 = (TraceMapping.Match it_1) -> {
        EObject _target = it_1.getTarget();
        return Boolean.valueOf((_target instanceof Table));
      };
      EObject _target = IterableExtensions.<TraceMapping.Match>findFirst(this.traceQueryImage(it.getNamed().getOwner()), _function_1).getTarget();
      final Table table = ((Table) _target);
      this.addColumnToTable(table, column);
    };
    final Consumer <FromAttribute2Column.Match> _function_1 = (FromAttribute2Column.Match it) -> {
      String _name = it.getNamed().getName();
      String _plus = ("fromAttribute2ColumnRule[remove] " + _name);
      InputOutput.<String>println(_plus);
      this.removeTraceQueryImages(it.getNamed());
    };
    return this._eventDrivenTransformationRuleFactory.<FromAttribute2Column.Match, FromAttribute2Column.Matcher>createRule(FromAttribute2Column.Matcher.querySpecification()).action(CRUDActivationStateEnum.CREATED, _function).action(CRUDActivationStateEnum.DELETED, _function_1).addLifeCycle(Lifecycles.getDefault(true, true)).build();
  }

  public Collection <TraceMapping.Match> traceQueryImage(final EObject source) {
    final TraceMapping.Matcher matcher = TraceMapping.Matcher.on(this.engine);
    return matcher.getAllMatches(matcher.newMatch(source, null, null, null));
  }

  public void removeTraceQueryImages(final EObject source) {
    final Consumer <TraceMapping.Match> _function = (TraceMapping.Match match) -> {
      try {
        this.manipulation.remove(match.getTarget());
        this.manipulation.remove(match.getTrace());
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    };
    this.traceQueryImage(source).forEach(_function);
  }

  public boolean makeTrace(final EObject source, final EObject target, final int index) {
    boolean _xblockexpression = false;
    {
      final TraceEntry traceEntry = TraceFactory.eINSTANCE.createTraceEntry();
      traceEntry.setSource(source);
      traceEntry.setTarget(target);
      traceEntry.setIndex(index);
      _xblockexpression = this.trace.getContents().add(traceEntry);
    }
    return _xblockexpression;
  }

  public void addColumnToTable(final Table table, final Column column) {
    table.getCol().add(column);
    column.setOwner(table);
  }
}
