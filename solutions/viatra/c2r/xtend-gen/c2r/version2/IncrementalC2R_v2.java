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

  @Extension
  private EventDrivenTransformation transformation;

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
    EventDrivenTransformationRule<SourcelessTrace.Match, SourcelessTrace.Matcher> _createCleanupRule = this.createCleanupRule();
    EventDrivenTransformationRule<MakeInteger.Match, MakeInteger.Matcher> _createMakeIntegerRule = this.createMakeIntegerRule();
    EventDrivenTransformationRule<FromDataType.Match, FromDataType.Matcher> _createDataTypeMappingRule = this.createDataTypeMappingRule();
    EventDrivenTransformationRule<FromClass.Match, FromClass.Matcher> _createClassMappingRule = this.createClassMappingRule();
    EventDrivenTransformationRule<FromAttribute2Column.Match, FromAttribute2Column.Matcher> _createAttribute2ColumnMappingRule = this.createAttribute2ColumnMappingRule();
    EventDrivenTransformationRule<FromAttribute2Table.Match, FromAttribute2Table.Matcher> _createAttribute2TableMappingRule = this.createAttribute2TableMappingRule();
    EventDrivenTransformationRule<NamedMap.Match, NamedMap.Matcher> _createNameChangeRule = this.createNameChangeRule();
    EventDrivenTransformationRule<TypeMapping.Match, TypeMapping.Matcher> _createTypeChangeRule = this.createTypeChangeRule();
    final List<EventDrivenTransformationRule<?, ?>> rules = Collections.<EventDrivenTransformationRule<?, ?>>unmodifiableList(CollectionLiterals.<EventDrivenTransformationRule<?, ?>>newArrayList(_createCleanupRule, _createMakeIntegerRule, _createDataTypeMappingRule, _createClassMappingRule, _createAttribute2ColumnMappingRule, _createAttribute2TableMappingRule, _createNameChangeRule, _createTypeChangeRule));
    final InvertedDisappearancePriorityConflictResolver fixedPriorityResolver = new InvertedDisappearancePriorityConflictResolver();
    final Procedure2<EventDrivenTransformationRule<?, ?>, Integer> _function = new Procedure2<EventDrivenTransformationRule<?, ?>, Integer>() {
      public void apply(final EventDrivenTransformationRule<?, ?> rule, final Integer index) {
        fixedPriorityResolver.setPriority(rule.getRuleSpecification(), ((index).intValue() + 1));
      }
    };
    IterableExtensions.<EventDrivenTransformationRule<?, ?>>forEach(rules, _function);
    final Function2<EventDrivenTransformation.EventDrivenTransformationBuilder, EventDrivenTransformationRule<?, ?>, EventDrivenTransformation.EventDrivenTransformationBuilder> _function_1 = new Function2<EventDrivenTransformation.EventDrivenTransformationBuilder, EventDrivenTransformationRule<?, ?>, EventDrivenTransformation.EventDrivenTransformationBuilder>() {
      public EventDrivenTransformation.EventDrivenTransformationBuilder apply(final EventDrivenTransformation.EventDrivenTransformationBuilder builder, final EventDrivenTransformationRule<?, ?> rule) {
        return builder.addRule(rule);
      }
    };
    this.transformation = IterableExtensions.<EventDrivenTransformationRule<?, ?>, EventDrivenTransformation.EventDrivenTransformationBuilder>fold(rules, 
      EventDrivenTransformation.forEngine(this.engine).setConflictResolver(fixedPriorityResolver), _function_1).build();
    this.transformation.getExecutionSchema().startUnscheduledExecution();
  }

  public EventDrivenTransformationRule<SourcelessTrace.Match, SourcelessTrace.Matcher> createCleanupRule() {
    final Consumer<SourcelessTrace.Match> _function = new Consumer<SourcelessTrace.Match>() {
      public void accept(final SourcelessTrace.Match it) {
        try {
          IncrementalC2R_v2.this.manipulation.remove(it.getTrace());
          IncrementalC2R_v2.this.manipulation.remove(it.getNamed());
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      }
    };
    return this._eventDrivenTransformationRuleFactory.<SourcelessTrace.Match, SourcelessTrace.Matcher>createRule(SourcelessTrace.Matcher.querySpecification()).action(CRUDActivationStateEnum.CREATED, _function).addLifeCycle(Lifecycles.getDefault(true, true)).build();
  }

  public EventDrivenTransformationRule<NamedMap.Match, NamedMap.Matcher> createNameChangeRule() {
    final Consumer<NamedMap.Match> _function = new Consumer<NamedMap.Match>() {
      public void accept(final NamedMap.Match it) {
        Named _named = it.getNamed();
        _named.setName(it.getName());
      }
    };
    final Consumer<NamedMap.Match> _function_1 = new Consumer<NamedMap.Match>() {
      public void accept(final NamedMap.Match it) {
        Named _named = it.getNamed();
        _named.setName(null);
      }
    };
    return this._eventDrivenTransformationRuleFactory.<NamedMap.Match, NamedMap.Matcher>createRule(NamedMap.Matcher.querySpecification()).action(CRUDActivationStateEnum.CREATED, _function).action(CRUDActivationStateEnum.DELETED, _function_1).addLifeCycle(Lifecycles.getDefault(true, true)).build();
  }

  public EventDrivenTransformationRule<TypeMapping.Match, TypeMapping.Matcher> createTypeChangeRule() {
    final Consumer<TypeMapping.Match> _function = new Consumer<TypeMapping.Match>() {
      public void accept(final TypeMapping.Match it) {
        Column _column = it.getColumn();
        _column.setType(it.getType());
      }
    };
    return this._eventDrivenTransformationRuleFactory.<TypeMapping.Match, TypeMapping.Matcher>createRule(TypeMapping.Matcher.querySpecification()).action(CRUDActivationStateEnum.CREATED, _function).addLifeCycle(Lifecycles.getDefault(true, true)).build();
  }

  public EventDrivenTransformationRule<MakeInteger.Match, MakeInteger.Matcher> createMakeIntegerRule() {
    final Consumer<MakeInteger.Match> _function = new Consumer<MakeInteger.Match>() {
      public void accept(final MakeInteger.Match it) {
        IncrementalC2R_v2.this.target.getContents().add(IncrementalC2R_v2.this.intType);
      }
    };
    final Consumer<MakeInteger.Match> _function_1 = new Consumer<MakeInteger.Match>() {
      public void accept(final MakeInteger.Match it) {
        IncrementalC2R_v2.this.target.getContents().remove(IncrementalC2R_v2.this.intType);
      }
    };
    return this._eventDrivenTransformationRuleFactory.<MakeInteger.Match, MakeInteger.Matcher>createRule(MakeInteger.Matcher.querySpecification()).action(CRUDActivationStateEnum.CREATED, _function).action(CRUDActivationStateEnum.DELETED, _function_1).addLifeCycle(Lifecycles.getDefault(true, true)).build();
  }

  public EventDrivenTransformationRule<FromDataType.Match, FromDataType.Matcher> createDataTypeMappingRule() {
    final Consumer<FromDataType.Match> _function = new Consumer<FromDataType.Match>() {
      public void accept(final FromDataType.Match it) {
        final Type type = IncrementalC2R_v2.this._relational_Factory.createType();
        IncrementalC2R_v2.this.makeTrace(it.getDtype(), type, 0);
        IncrementalC2R_v2.this.target.getContents().add(type);
      }
    };
    return this._eventDrivenTransformationRuleFactory.<FromDataType.Match, FromDataType.Matcher>createRule(FromDataType.Matcher.querySpecification()).action(CRUDActivationStateEnum.CREATED, _function).addLifeCycle(Lifecycles.getDefault(true, true)).build();
  }

  public EventDrivenTransformationRule<FromClass.Match, FromClass.Matcher> createClassMappingRule() {
    final Consumer<FromClass.Match> _function = new Consumer<FromClass.Match>() {
      public void accept(final FromClass.Match it) {
        final Table table = IncrementalC2R_v2.this._relational_Factory.createTable();
        final Column idcolumn = IncrementalC2R_v2.this._relational_Factory.createColumn();
        IncrementalC2R_v2.this.makeTrace(it.getNamed(), idcolumn, 1);
        IncrementalC2R_v2.this.makeTrace(it.getNamed(), table, 0);
        IncrementalC2R_v2.this.addColumnToTable(table, idcolumn);
        table.getKey().add(idcolumn);
        IncrementalC2R_v2.this.target.getContents().add(table);
      }
    };
    return this._eventDrivenTransformationRuleFactory.<FromClass.Match, FromClass.Matcher>createRule(FromClass.Matcher.querySpecification()).action(CRUDActivationStateEnum.CREATED, _function).addLifeCycle(Lifecycles.getDefault(true, true)).build();
  }

  public EventDrivenTransformationRule<FromAttribute2Table.Match, FromAttribute2Table.Matcher> createAttribute2TableMappingRule() {
    final Consumer<FromAttribute2Table.Match> _function = new Consumer<FromAttribute2Table.Match>() {
      public void accept(final FromAttribute2Table.Match it) {
        final Table table = IncrementalC2R_v2.this._relational_Factory.createTable();
        final Column idcolumn = IncrementalC2R_v2.this._relational_Factory.createColumn();
        final Column valuecolumn = IncrementalC2R_v2.this._relational_Factory.createColumn();
        IncrementalC2R_v2.this.makeTrace(it.getNamed(), idcolumn, 1);
        IncrementalC2R_v2.this.makeTrace(it.getNamed(), valuecolumn, 2);
        IncrementalC2R_v2.this.makeTrace(it.getNamed(), table, 0);
        IncrementalC2R_v2.this.addColumnToTable(table, idcolumn);
        IncrementalC2R_v2.this.addColumnToTable(table, valuecolumn);
        IncrementalC2R_v2.this.target.getContents().add(table);
      }
    };
    final Consumer<FromAttribute2Table.Match> _function_1 = new Consumer<FromAttribute2Table.Match>() {
      public void accept(final FromAttribute2Table.Match it) {
        IncrementalC2R_v2.this.removeTraceQueryImages(it.getNamed());
      }
    };
    return this._eventDrivenTransformationRuleFactory.<FromAttribute2Table.Match, FromAttribute2Table.Matcher>createRule(FromAttribute2Table.Matcher.querySpecification()).action(CRUDActivationStateEnum.CREATED, _function).action(CRUDActivationStateEnum.DELETED, _function_1).addLifeCycle(Lifecycles.getDefault(true, true)).build();
  }

  public EventDrivenTransformationRule<FromAttribute2Column.Match, FromAttribute2Column.Matcher> createAttribute2ColumnMappingRule() {
    final Consumer<FromAttribute2Column.Match> _function = new Consumer<FromAttribute2Column.Match>() {
      public void accept(final FromAttribute2Column.Match it) {
        final Column column = IncrementalC2R_v2.this._relational_Factory.createColumn();
        IncrementalC2R_v2.this.makeTrace(it.getNamed(), column, 0);
        final Function1<TraceMapping.Match, Boolean> _function = new Function1<TraceMapping.Match, Boolean>() {
          public Boolean apply(final TraceMapping.Match it_1) {
            EObject _target = it_1.getTarget();
            return Boolean.valueOf((_target instanceof Table));
          }
        };
        EObject _target = IterableExtensions.<TraceMapping.Match>findFirst(IncrementalC2R_v2.this.traceQueryImage(it.getNamed().getOwner()), _function).getTarget();
        final Table table = ((Table) _target);
        IncrementalC2R_v2.this.addColumnToTable(table, column);
      }
    };
    final Consumer<FromAttribute2Column.Match> _function_1 = new Consumer<FromAttribute2Column.Match>() {
      public void accept(final FromAttribute2Column.Match it) {
        IncrementalC2R_v2.this.removeTraceQueryImages(it.getNamed());
      }
    };
    return this._eventDrivenTransformationRuleFactory.<FromAttribute2Column.Match, FromAttribute2Column.Matcher>createRule(FromAttribute2Column.Matcher.querySpecification()).action(CRUDActivationStateEnum.CREATED, _function).action(CRUDActivationStateEnum.DELETED, _function_1).addLifeCycle(Lifecycles.getDefault(true, true)).build();
  }

  public Collection<TraceMapping.Match> traceQueryImage(final EObject source) {
    final TraceMapping.Matcher matcher = TraceMapping.Matcher.on(this.engine);
    return matcher.getAllMatches(matcher.newMatch(source, null, null, null));
  }

  public void removeTraceQueryImages(final EObject source) {
    final Consumer<TraceMapping.Match> _function = new Consumer<TraceMapping.Match>() {
      public void accept(final TraceMapping.Match match) {
        try {
          IncrementalC2R_v2.this.manipulation.remove(match.getTarget());
          IncrementalC2R_v2.this.manipulation.remove(match.getTrace());
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
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
