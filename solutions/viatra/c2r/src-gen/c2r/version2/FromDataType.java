/**
 * Generated from platform:/resource/c2r/src/c2r/version2/queries2.vql
 */
package c2r.version2;

import class_.DataType;
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
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameterDirection;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PVisibility;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuple;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuples;
import org.eclipse.viatra.query.runtime.util.ViatraQueryLoggingUtil;

/**
 * A pattern-specific query specification that can instantiate Matcher in a type-safe way.
 * 
 * <p>Original source:
 *         <code> <pre>
 *         Other DataTypes to be mapped to Type
 *          
 *         pattern fromDataType(dtype: DataType){
 *         	DataType.name(dtype,name);
 *         	name != "Integer";
 *         }
 * </pre> </code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class FromDataType extends BaseGeneratedEMFQuerySpecification <FromDataType.Matcher> {
  /**
   * Pattern-specific match representation of the c2r.version2.fromDataType pattern,
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
    private DataType fDtype;

    private static List <String> parameterNames = makeImmutableList("dtype");

    private Match(final DataType pDtype) {
      this.fDtype = pDtype;
    }

    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "dtype": return this.fDtype;
          default: return null;
      }
    }

    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fDtype;
          default: return null;
      }
    }

    public DataType getDtype() {
      return this.fDtype;
    }

    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("dtype".equals(parameterName) ) {
          this.fDtype = (DataType) newValue;
          return true;
      }
      return false;
    }

    public void setDtype(final DataType pDtype) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fDtype = pDtype;
    }

    @Override
    public String patternName() {
      return "c2r.version2.fromDataType";
    }

    @Override
    public List <String> parameterNames() {
      return FromDataType.Match.parameterNames;
    }

    @Override
    public Object[] toArray() {
      return new Object[]{fDtype};
    }

    @Override
    public FromDataType.Match toImmutable() {
      return isMutable() ? newMatch(fDtype) : this;
    }

    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"dtype\"=" + prettyPrintValue(fDtype));
      return result.toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(fDtype);
    }

    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof FromDataType.Match)) {
          FromDataType.Match other = (FromDataType.Match) obj;
          return Objects.equals(fDtype, other.fDtype);
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
    public FromDataType specification() {
      return FromDataType.instance();
    }

    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static FromDataType.Match newEmptyMatch() {
      return new Mutable(null);
    }

    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pDtype the fixed value of pattern parameter dtype, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static FromDataType.Match newMutableMatch(final DataType pDtype) {
      return new Mutable(pDtype);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pDtype the fixed value of pattern parameter dtype, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static FromDataType.Match newMatch(final DataType pDtype) {
      return new Immutable(pDtype);
    }

    private static final class Mutable extends FromDataType.Match {
      Mutable(final DataType pDtype) {
        super(pDtype);
      }

      @Override
      public boolean isMutable() {
        return true;
      }
    }

    private static final class Immutable extends FromDataType.Match {
      Immutable(final DataType pDtype) {
        super(pDtype);
      }

      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }

  /**
   * Generated pattern matcher API of the c2r.version2.fromDataType pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code> <pre>
   * Other DataTypes to be mapped to Type
   *  
   * pattern fromDataType(dtype: DataType){
   * 	DataType.name(dtype,name);
   * 	name != "Integer";
   * }
   * </pre> </code>
   * 
   * @see Match
   * @see FromDataType
   * 
   */
  public static class Matcher extends BaseMatcher <FromDataType.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static FromDataType.Matcher on(final ViatraQueryEngine engine) {
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
    public static FromDataType.Matcher create() {
      return new Matcher();
    }

    private static final int POSITION_DTYPE = 0;

    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(FromDataType.Matcher.class);

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
     * @param pDtype the fixed value of pattern parameter dtype, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection <FromDataType.Match> getAllMatches(final DataType pDtype) {
      return rawStreamAllMatches(new Object[]{pDtype}).collect(Collectors.toSet());
    }

    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE </strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined </strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pDtype the fixed value of pattern parameter dtype, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream <FromDataType.Match> streamAllMatches(final DataType pDtype) {
      return rawStreamAllMatches(new Object[]{pDtype});
    }

    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pDtype the fixed value of pattern parameter dtype, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional <FromDataType.Match> getOneArbitraryMatch(final DataType pDtype) {
      return rawGetOneArbitraryMatch(new Object[]{pDtype});
    }

    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pDtype the fixed value of pattern parameter dtype, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final DataType pDtype) {
      return rawHasMatch(new Object[]{pDtype});
    }

    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pDtype the fixed value of pattern parameter dtype, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final DataType pDtype) {
      return rawCountMatches(new Object[]{pDtype});
    }

    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pDtype the fixed value of pattern parameter dtype, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final DataType pDtype, final Consumer <? super FromDataType.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pDtype}, processor);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pDtype the fixed value of pattern parameter dtype, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public FromDataType.Match newMatch(final DataType pDtype) {
      return FromDataType.Match.newMatch(pDtype);
    }

    /**
     * Retrieve the set of values that occur in matches for dtype.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream <DataType> rawStreamAllValuesOfdtype(final Object[] parameters) {
      return rawStreamAllValues(POSITION_DTYPE, parameters).map(DataType.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for dtype.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set <DataType> getAllValuesOfdtype() {
      return rawStreamAllValuesOfdtype(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for dtype.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream <DataType> streamAllValuesOfdtype() {
      return rawStreamAllValuesOfdtype(emptyArray());
    }

    @Override
    protected FromDataType.Match tupleToMatch(final Tuple t) {
      try {
          return FromDataType.Match.newMatch((DataType) t.get(POSITION_DTYPE));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }

    @Override
    protected FromDataType.Match arrayToMatch(final Object[] match) {
      try {
          return FromDataType.Match.newMatch((DataType) match[POSITION_DTYPE]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }

    @Override
    protected FromDataType.Match arrayToMatchMutable(final Object[] match) {
      try {
          return FromDataType.Match.newMutableMatch((DataType) match[POSITION_DTYPE]);
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
    public static IQuerySpecification <FromDataType.Matcher> querySpecification() {
      return FromDataType.instance();
    }
  }

  private FromDataType() {
    super(GeneratedPQuery.INSTANCE);
  }

  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static FromDataType instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }

  @Override
  protected FromDataType.Matcher instantiate(final ViatraQueryEngine engine) {
    return FromDataType.Matcher.on(engine);
  }

  @Override
  public FromDataType.Matcher instantiate() {
    return FromDataType.Matcher.create();
  }

  @Override
  public FromDataType.Match newEmptyMatch() {
    return FromDataType.Match.newEmptyMatch();
  }

  @Override
  public FromDataType.Match newMatch(final Object... parameters) {
    return FromDataType.Match.newMatch((class_.DataType) parameters[0]);
  }

  /**
   * Inner class allowing the singleton instance of {@link FromDataType} to be created 
   *     <b>not </b> at the class load time of the outer class, 
   *     but rather at the first call to {@link FromDataType#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final FromDataType INSTANCE = new FromDataType();

    /**
     * Statically initializes the query specification <b>after </b> the field {@link #INSTANCE} is assigned.
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
    private static final FromDataType.GeneratedPQuery INSTANCE = new GeneratedPQuery();

    private final PParameter parameter_dtype = new PParameter("dtype", "class_.DataType", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("Class", "DataType")), PParameterDirection.INOUT);

    private final List <PParameter> parameters = Arrays.asList(parameter_dtype);

    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }

    @Override
    public String getFullyQualifiedName() {
      return "c2r.version2.fromDataType";
    }

    @Override
    public List <String> getParameterNames() {
      return Arrays.asList("dtype");
    }

    @Override
    public List <PParameter> getParameters() {
      return parameters;
    }

    @Override
    public Set <PBody> doGetContainedBodies() {
      setEvaluationHints(new QueryEvaluationHint(null, QueryEvaluationHint.BackendRequirement.UNSPECIFIED));
      Set <PBody> bodies = new LinkedHashSet<>();
      {
          PBody body = new PBody(this);
          PVariable var_dtype = body.getOrCreateVariableByName("dtype");
          PVariable var_name = body.getOrCreateVariableByName("name");
          new TypeConstraint(body, Tuples.flatTupleOf(var_dtype), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Class", "DataType")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_dtype, parameter_dtype)
          ));
          // 	DataType.name(dtype,name)
          new TypeConstraint(body, Tuples.flatTupleOf(var_dtype), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Class", "DataType")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_dtype, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("Class", "NamedElt", "name")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EString")));
          new Equality(body, var__virtual_0_, var_name);
          // 	name != "Integer"
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new ConstantValue(body, var__virtual_1_, "Integer");
          new Inequality(body, var_name, var__virtual_1_);
          bodies.add(body);
      }
      return bodies;
    }
  }
}
