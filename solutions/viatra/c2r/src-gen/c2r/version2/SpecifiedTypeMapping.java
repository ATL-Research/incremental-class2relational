/**
 * Generated from platform:/resource/c2r/src/c2r/version2/queries2.vql
 */
package c2r.version2;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.emf.types.EDataTypeInSlotsKey;
import org.eclipse.viatra.query.runtime.emf.types.EStructuralFeatureInstancesKey;
import org.eclipse.viatra.query.runtime.matchers.backend.QueryEvaluationHint;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Inequality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.ConstantValue;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameterDirection;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PVisibility;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuple;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuples;
import org.eclipse.viatra.query.runtime.util.ViatraQueryLoggingUtil;
import relational_.Column;
import relational_.Type;

/**
 * A pattern-specific query specification that can instantiate Matcher in a type-safe way.
 * 
 * <p>Original source:
 *         <code><pre>
 *         Type is specified
 *           	(a) objectId column has Integer type (for classes)
 *           	(b) source model specified a type for the column
 *          
 *         pattern specifiedTypeMapping(column: Column, type: Type){
 *         	Column.name(column,"objectId");
 *         	Type.name(type,"Integer");
 *         } or {
 *         	find traceMapping(attr,_,index,column); //Traverse in reverse direction
 *         	index != 1; // single valued attribute (0), or value column (2)
 *         	Attribute.type(attr,stype);
 *         	DataType.name(stype,typename);
 *         	Type.name(type,typename);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class SpecifiedTypeMapping extends BaseGeneratedEMFQuerySpecification<SpecifiedTypeMapping.Matcher> {
  /**
   * Pattern-specific match representation of the c2r.version2.specifiedTypeMapping pattern,
   * to be used in conjunction with {@link Matcher}.
   * 
   * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
   * Each instance is a (possibly partial) substitution of pattern parameters,
   * usable to represent a match of the pattern in the result of a query,
   * or to specify the bound (fixed) input parameters when issuing a query.
   * 
   * @see Matcher
   * 
   */
  public static abstract class Match extends BasePatternMatch {
    private Column fColumn;

    private Type fType;

    private static List<String> parameterNames = makeImmutableList("column", "type");

    private Match(final Column pColumn, final Type pType) {
      this.fColumn = pColumn;
      this.fType = pType;
    }

    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "column": return this.fColumn;
          case "type": return this.fType;
          default: return null;
      }
    }

    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fColumn;
          case 1: return this.fType;
          default: return null;
      }
    }

    public Column getColumn() {
      return this.fColumn;
    }

    public Type getType() {
      return this.fType;
    }

    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("column".equals(parameterName) ) {
          this.fColumn = (Column) newValue;
          return true;
      }
      if ("type".equals(parameterName) ) {
          this.fType = (Type) newValue;
          return true;
      }
      return false;
    }

    public void setColumn(final Column pColumn) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fColumn = pColumn;
    }

    public void setType(final Type pType) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fType = pType;
    }

    @Override
    public String patternName() {
      return "c2r.version2.specifiedTypeMapping";
    }

    @Override
    public List<String> parameterNames() {
      return SpecifiedTypeMapping.Match.parameterNames;
    }

    @Override
    public Object[] toArray() {
      return new Object[]{fColumn, fType};
    }

    @Override
    public SpecifiedTypeMapping.Match toImmutable() {
      return isMutable() ? newMatch(fColumn, fType) : this;
    }

    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"column\"=" + prettyPrintValue(fColumn) + ", ");
      result.append("\"type\"=" + prettyPrintValue(fType));
      return result.toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(fColumn, fType);
    }

    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof SpecifiedTypeMapping.Match)) {
          SpecifiedTypeMapping.Match other = (SpecifiedTypeMapping.Match) obj;
          return Objects.equals(fColumn, other.fColumn) && Objects.equals(fType, other.fType);
      } else {
          // this should be infrequent
          if (!(obj instanceof IPatternMatch)) {
              return false;
          }
          IPatternMatch otherSig  = (IPatternMatch) obj;
          return Objects.equals(specification(), otherSig.specification()) && Arrays.deepEquals(toArray(), otherSig.toArray());
      }
    }

    @Override
    public SpecifiedTypeMapping specification() {
      return SpecifiedTypeMapping.instance();
    }

    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static SpecifiedTypeMapping.Match newEmptyMatch() {
      return new Mutable(null, null);
    }

    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pColumn the fixed value of pattern parameter column, or null if not bound.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static SpecifiedTypeMapping.Match newMutableMatch(final Column pColumn, final Type pType) {
      return new Mutable(pColumn, pType);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pColumn the fixed value of pattern parameter column, or null if not bound.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static SpecifiedTypeMapping.Match newMatch(final Column pColumn, final Type pType) {
      return new Immutable(pColumn, pType);
    }

    private static final class Mutable extends SpecifiedTypeMapping.Match {
      Mutable(final Column pColumn, final Type pType) {
        super(pColumn, pType);
      }

      @Override
      public boolean isMutable() {
        return true;
      }
    }

    private static final class Immutable extends SpecifiedTypeMapping.Match {
      Immutable(final Column pColumn, final Type pType) {
        super(pColumn, pType);
      }

      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }

  /**
   * Generated pattern matcher API of the c2r.version2.specifiedTypeMapping pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * Type is specified
   *   	(a) objectId column has Integer type (for classes)
   *   	(b) source model specified a type for the column
   *  
   * pattern specifiedTypeMapping(column: Column, type: Type){
   * 	Column.name(column,"objectId");
   * 	Type.name(type,"Integer");
   * } or {
   * 	find traceMapping(attr,_,index,column); //Traverse in reverse direction
   * 	index != 1; // single valued attribute (0), or value column (2)
   * 	Attribute.type(attr,stype);
   * 	DataType.name(stype,typename);
   * 	Type.name(type,typename);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see SpecifiedTypeMapping
   * 
   */
  public static class Matcher extends BaseMatcher<SpecifiedTypeMapping.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static SpecifiedTypeMapping.Matcher on(final ViatraQueryEngine engine) {
      // check if matcher already exists
      Matcher matcher = engine.getExistingMatcher(querySpecification());
      if (matcher == null) {
          matcher = (Matcher)engine.getMatcher(querySpecification());
      }
      return matcher;
    }

    /**
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * @return an initialized matcher
     * @noreference This method is for internal matcher initialization by the framework, do not call it manually.
     * 
     */
    public static SpecifiedTypeMapping.Matcher create() {
      return new Matcher();
    }

    private static final int POSITION_COLUMN = 0;

    private static final int POSITION_TYPE = 1;

    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(SpecifiedTypeMapping.Matcher.class);

    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    private Matcher() {
      super(querySpecification());
    }

    /**
     * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pColumn the fixed value of pattern parameter column, or null if not bound.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<SpecifiedTypeMapping.Match> getAllMatches(final Column pColumn, final Type pType) {
      return rawStreamAllMatches(new Object[]{pColumn, pType}).collect(Collectors.toSet());
    }

    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pColumn the fixed value of pattern parameter column, or null if not bound.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<SpecifiedTypeMapping.Match> streamAllMatches(final Column pColumn, final Type pType) {
      return rawStreamAllMatches(new Object[]{pColumn, pType});
    }

    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pColumn the fixed value of pattern parameter column, or null if not bound.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<SpecifiedTypeMapping.Match> getOneArbitraryMatch(final Column pColumn, final Type pType) {
      return rawGetOneArbitraryMatch(new Object[]{pColumn, pType});
    }

    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pColumn the fixed value of pattern parameter column, or null if not bound.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final Column pColumn, final Type pType) {
      return rawHasMatch(new Object[]{pColumn, pType});
    }

    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pColumn the fixed value of pattern parameter column, or null if not bound.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final Column pColumn, final Type pType) {
      return rawCountMatches(new Object[]{pColumn, pType});
    }

    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pColumn the fixed value of pattern parameter column, or null if not bound.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final Column pColumn, final Type pType, final Consumer<? super SpecifiedTypeMapping.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pColumn, pType}, processor);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pColumn the fixed value of pattern parameter column, or null if not bound.
     * @param pType the fixed value of pattern parameter type, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public SpecifiedTypeMapping.Match newMatch(final Column pColumn, final Type pType) {
      return SpecifiedTypeMapping.Match.newMatch(pColumn, pType);
    }

    /**
     * Retrieve the set of values that occur in matches for column.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Column> rawStreamAllValuesOfcolumn(final Object[] parameters) {
      return rawStreamAllValues(POSITION_COLUMN, parameters).map(Column.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for column.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Column> getAllValuesOfcolumn() {
      return rawStreamAllValuesOfcolumn(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for column.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Column> streamAllValuesOfcolumn() {
      return rawStreamAllValuesOfcolumn(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for column.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Column> streamAllValuesOfcolumn(final SpecifiedTypeMapping.Match partialMatch) {
      return rawStreamAllValuesOfcolumn(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for column.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Column> streamAllValuesOfcolumn(final Type pType) {
      return rawStreamAllValuesOfcolumn(new Object[]{null, pType});
    }

    /**
     * Retrieve the set of values that occur in matches for column.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Column> getAllValuesOfcolumn(final SpecifiedTypeMapping.Match partialMatch) {
      return rawStreamAllValuesOfcolumn(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for column.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Column> getAllValuesOfcolumn(final Type pType) {
      return rawStreamAllValuesOfcolumn(new Object[]{null, pType}).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for type.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Type> rawStreamAllValuesOftype(final Object[] parameters) {
      return rawStreamAllValues(POSITION_TYPE, parameters).map(Type.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for type.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Type> getAllValuesOftype() {
      return rawStreamAllValuesOftype(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for type.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Type> streamAllValuesOftype() {
      return rawStreamAllValuesOftype(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for type.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Type> streamAllValuesOftype(final SpecifiedTypeMapping.Match partialMatch) {
      return rawStreamAllValuesOftype(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for type.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Type> streamAllValuesOftype(final Column pColumn) {
      return rawStreamAllValuesOftype(new Object[]{pColumn, null});
    }

    /**
     * Retrieve the set of values that occur in matches for type.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Type> getAllValuesOftype(final SpecifiedTypeMapping.Match partialMatch) {
      return rawStreamAllValuesOftype(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for type.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Type> getAllValuesOftype(final Column pColumn) {
      return rawStreamAllValuesOftype(new Object[]{pColumn, null}).collect(Collectors.toSet());
    }

    @Override
    protected SpecifiedTypeMapping.Match tupleToMatch(final Tuple t) {
      try {
          return SpecifiedTypeMapping.Match.newMatch((Column) t.get(POSITION_COLUMN), (Type) t.get(POSITION_TYPE));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }

    @Override
    protected SpecifiedTypeMapping.Match arrayToMatch(final Object[] match) {
      try {
          return SpecifiedTypeMapping.Match.newMatch((Column) match[POSITION_COLUMN], (Type) match[POSITION_TYPE]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }

    @Override
    protected SpecifiedTypeMapping.Match arrayToMatchMutable(final Object[] match) {
      try {
          return SpecifiedTypeMapping.Match.newMutableMatch((Column) match[POSITION_COLUMN], (Type) match[POSITION_TYPE]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }

    /**
     * @return the singleton instance of the query specification of this pattern
     * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
     * 
     */
    public static IQuerySpecification<SpecifiedTypeMapping.Matcher> querySpecification() {
      return SpecifiedTypeMapping.instance();
    }
  }

  private SpecifiedTypeMapping() {
    super(GeneratedPQuery.INSTANCE);
  }

  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static SpecifiedTypeMapping instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }

  @Override
  protected SpecifiedTypeMapping.Matcher instantiate(final ViatraQueryEngine engine) {
    return SpecifiedTypeMapping.Matcher.on(engine);
  }

  @Override
  public SpecifiedTypeMapping.Matcher instantiate() {
    return SpecifiedTypeMapping.Matcher.create();
  }

  @Override
  public SpecifiedTypeMapping.Match newEmptyMatch() {
    return SpecifiedTypeMapping.Match.newEmptyMatch();
  }

  @Override
  public SpecifiedTypeMapping.Match newMatch(final Object... parameters) {
    return SpecifiedTypeMapping.Match.newMatch((relational_.Column) parameters[0], (relational_.Type) parameters[1]);
  }

  /**
   * Inner class allowing the singleton instance of {@link SpecifiedTypeMapping} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link SpecifiedTypeMapping#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final SpecifiedTypeMapping INSTANCE = new SpecifiedTypeMapping();

    /**
     * Statically initializes the query specification <b>after</b> the field {@link #INSTANCE} is assigned.
     * This initialization order is required to support indirect recursion.
     * 
     * <p> The static initializer is defined using a helper field to work around limitations of the code generator.
     * 
     */
    private static final Object STATIC_INITIALIZER = ensureInitialized();

    public static Object ensureInitialized() {
      INSTANCE.ensureInitializedInternal();
      return null;
    }
  }

  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private static final SpecifiedTypeMapping.GeneratedPQuery INSTANCE = new GeneratedPQuery();

    private final PParameter parameter_column = new PParameter("column", "relational_.Column", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("Relational", "Column")), PParameterDirection.INOUT);

    private final PParameter parameter_type = new PParameter("type", "relational_.Type", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("Relational", "Type")), PParameterDirection.INOUT);

    private final List<PParameter> parameters = Arrays.asList(parameter_column, parameter_type);

    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }

    @Override
    public String getFullyQualifiedName() {
      return "c2r.version2.specifiedTypeMapping";
    }

    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("column","type");
    }

    @Override
    public List<PParameter> getParameters() {
      return parameters;
    }

    @Override
    public Set<PBody> doGetContainedBodies() {
      setEvaluationHints(new QueryEvaluationHint(null, QueryEvaluationHint.BackendRequirement.UNSPECIFIED));
      Set<PBody> bodies = new LinkedHashSet<>();
      {
          PBody body = new PBody(this);
          PVariable var_column = body.getOrCreateVariableByName("column");
          PVariable var_type = body.getOrCreateVariableByName("type");
          new TypeConstraint(body, Tuples.flatTupleOf(var_column), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Relational", "Column")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_type), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Relational", "Type")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_column, parameter_column),
             new ExportedParameter(body, var_type, parameter_type)
          ));
          // 	Column.name(column,"objectId")
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new ConstantValue(body, var__virtual_0_, "objectId");
          new TypeConstraint(body, Tuples.flatTupleOf(var_column), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Relational", "Column")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_column, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("Relational", "Named", "name")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EString")));
          new Equality(body, var__virtual_1_, var__virtual_0_);
          // 	Type.name(type,"Integer")
          PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
          new ConstantValue(body, var__virtual_2_, "Integer");
          new TypeConstraint(body, Tuples.flatTupleOf(var_type), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Relational", "Type")));
          PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_type, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("Relational", "Named", "name")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_3_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EString")));
          new Equality(body, var__virtual_3_, var__virtual_2_);
          bodies.add(body);
      }
      {
          PBody body = new PBody(this);
          PVariable var_column = body.getOrCreateVariableByName("column");
          PVariable var_type = body.getOrCreateVariableByName("type");
          PVariable var_attr = body.getOrCreateVariableByName("attr");
          PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
          PVariable var_index = body.getOrCreateVariableByName("index");
          PVariable var_stype = body.getOrCreateVariableByName("stype");
          PVariable var_typename = body.getOrCreateVariableByName("typename");
          new TypeConstraint(body, Tuples.flatTupleOf(var_column), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Relational", "Column")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_type), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Relational", "Type")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_column, parameter_column),
             new ExportedParameter(body, var_type, parameter_type)
          ));
          // 	find traceMapping(attr,_,index,column)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_attr, var___0_, var_index, var_column), TraceMapping.instance().getInternalQueryRepresentation());
          //  //Traverse in reverse direction	index != 1
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new ConstantValue(body, var__virtual_0_, 1);
          new Inequality(body, var_index, var__virtual_0_);
          //  // single valued attribute (0), or value column (2)	Attribute.type(attr,stype)
          new TypeConstraint(body, Tuples.flatTupleOf(var_attr), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Class", "Attribute")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_attr, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("Class", "Attribute", "type")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Class", "Classifier")));
          new Equality(body, var__virtual_1_, var_stype);
          // 	DataType.name(stype,typename)
          new TypeConstraint(body, Tuples.flatTupleOf(var_stype), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Class", "DataType")));
          PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_stype, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("Class", "NamedElt", "name")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_2_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EString")));
          new Equality(body, var__virtual_2_, var_typename);
          // 	Type.name(type,typename)
          new TypeConstraint(body, Tuples.flatTupleOf(var_type), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Relational", "Type")));
          PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_type, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("Relational", "Named", "name")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_3_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EString")));
          new Equality(body, var__virtual_3_, var_typename);
          bodies.add(body);
      }
      return bodies;
    }
  }

  private static int evaluateExpression_2_1() {
    return 1;
  }
}
