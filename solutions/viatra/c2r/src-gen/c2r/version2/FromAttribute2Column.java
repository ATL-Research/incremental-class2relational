/**
 * Generated from platform:/resource/c2r/src/c2r/version2/queries2.vql
 */
package c2r.version2;

import class_.Attribute;
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
 *         <code><pre>
 *         // MODEL_NAVIGATION
 *         pattern fromAttribute2Column(named: Attribute) {
 *         	// MODEL_NAVIGATION
 *         	Attribute.multiValued(named,false);
 *         	// MODEL_NAVIGATION
 *         	Attribute.owner(named,_);
 *         	// MODEL_NAVIGATION
 *         	Attribute.type(named,_);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class FromAttribute2Column extends BaseGeneratedEMFQuerySpecification<FromAttribute2Column.Matcher> {
  /**
   * Pattern-specific match representation of the c2r.version2.fromAttribute2Column pattern,
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
    private Attribute fNamed;

    private static List<String> parameterNames = makeImmutableList("named");

    private Match(final Attribute pNamed) {
      this.fNamed = pNamed;
    }

    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "named": return this.fNamed;
          default: return null;
      }
    }

    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fNamed;
          default: return null;
      }
    }

    public Attribute getNamed() {
      return this.fNamed;
    }

    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("named".equals(parameterName) ) {
          this.fNamed = (Attribute) newValue;
          return true;
      }
      return false;
    }

    public void setNamed(final Attribute pNamed) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fNamed = pNamed;
    }

    @Override
    public String patternName() {
      return "c2r.version2.fromAttribute2Column";
    }

    @Override
    public List<String> parameterNames() {
      return FromAttribute2Column.Match.parameterNames;
    }

    @Override
    public Object[] toArray() {
      return new Object[]{fNamed};
    }

    @Override
    public FromAttribute2Column.Match toImmutable() {
      return isMutable() ? newMatch(fNamed) : this;
    }

    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"named\"=" + prettyPrintValue(fNamed));
      return result.toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(fNamed);
    }

    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof FromAttribute2Column.Match)) {
          FromAttribute2Column.Match other = (FromAttribute2Column.Match) obj;
          return Objects.equals(fNamed, other.fNamed);
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
    public FromAttribute2Column specification() {
      return FromAttribute2Column.instance();
    }

    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static FromAttribute2Column.Match newEmptyMatch() {
      return new Mutable(null);
    }

    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pNamed the fixed value of pattern parameter named, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static FromAttribute2Column.Match newMutableMatch(final Attribute pNamed) {
      return new Mutable(pNamed);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pNamed the fixed value of pattern parameter named, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static FromAttribute2Column.Match newMatch(final Attribute pNamed) {
      return new Immutable(pNamed);
    }

    private static final class Mutable extends FromAttribute2Column.Match {
      Mutable(final Attribute pNamed) {
        super(pNamed);
      }

      @Override
      public boolean isMutable() {
        return true;
      }
    }

    private static final class Immutable extends FromAttribute2Column.Match {
      Immutable(final Attribute pNamed) {
        super(pNamed);
      }

      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }

  /**
   * Generated pattern matcher API of the c2r.version2.fromAttribute2Column pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * // MODEL_NAVIGATION
   * pattern fromAttribute2Column(named: Attribute) {
   * 	// MODEL_NAVIGATION
   * 	Attribute.multiValued(named,false);
   * 	// MODEL_NAVIGATION
   * 	Attribute.owner(named,_);
   * 	// MODEL_NAVIGATION
   * 	Attribute.type(named,_);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see FromAttribute2Column
   * 
   */
  public static class Matcher extends BaseMatcher<FromAttribute2Column.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static FromAttribute2Column.Matcher on(final ViatraQueryEngine engine) {
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
    public static FromAttribute2Column.Matcher create() {
      return new Matcher();
    }

    private static final int POSITION_NAMED = 0;

    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(FromAttribute2Column.Matcher.class);

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
     * @param pNamed the fixed value of pattern parameter named, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<FromAttribute2Column.Match> getAllMatches(final Attribute pNamed) {
      return rawStreamAllMatches(new Object[]{pNamed}).collect(Collectors.toSet());
    }

    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pNamed the fixed value of pattern parameter named, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<FromAttribute2Column.Match> streamAllMatches(final Attribute pNamed) {
      return rawStreamAllMatches(new Object[]{pNamed});
    }

    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pNamed the fixed value of pattern parameter named, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<FromAttribute2Column.Match> getOneArbitraryMatch(final Attribute pNamed) {
      return rawGetOneArbitraryMatch(new Object[]{pNamed});
    }

    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pNamed the fixed value of pattern parameter named, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final Attribute pNamed) {
      return rawHasMatch(new Object[]{pNamed});
    }

    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pNamed the fixed value of pattern parameter named, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final Attribute pNamed) {
      return rawCountMatches(new Object[]{pNamed});
    }

    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pNamed the fixed value of pattern parameter named, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final Attribute pNamed, final Consumer<? super FromAttribute2Column.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pNamed}, processor);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pNamed the fixed value of pattern parameter named, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public FromAttribute2Column.Match newMatch(final Attribute pNamed) {
      return FromAttribute2Column.Match.newMatch(pNamed);
    }

    /**
     * Retrieve the set of values that occur in matches for named.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Attribute> rawStreamAllValuesOfnamed(final Object[] parameters) {
      return rawStreamAllValues(POSITION_NAMED, parameters).map(Attribute.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for named.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Attribute> getAllValuesOfnamed() {
      return rawStreamAllValuesOfnamed(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for named.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Attribute> streamAllValuesOfnamed() {
      return rawStreamAllValuesOfnamed(emptyArray());
    }

    @Override
    protected FromAttribute2Column.Match tupleToMatch(final Tuple t) {
      try {
          return FromAttribute2Column.Match.newMatch((Attribute) t.get(POSITION_NAMED));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }

    @Override
    protected FromAttribute2Column.Match arrayToMatch(final Object[] match) {
      try {
          return FromAttribute2Column.Match.newMatch((Attribute) match[POSITION_NAMED]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }

    @Override
    protected FromAttribute2Column.Match arrayToMatchMutable(final Object[] match) {
      try {
          return FromAttribute2Column.Match.newMutableMatch((Attribute) match[POSITION_NAMED]);
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
    public static IQuerySpecification<FromAttribute2Column.Matcher> querySpecification() {
      return FromAttribute2Column.instance();
    }
  }

  private FromAttribute2Column() {
    super(GeneratedPQuery.INSTANCE);
  }

  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static FromAttribute2Column instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }

  @Override
  protected FromAttribute2Column.Matcher instantiate(final ViatraQueryEngine engine) {
    return FromAttribute2Column.Matcher.on(engine);
  }

  @Override
  public FromAttribute2Column.Matcher instantiate() {
    return FromAttribute2Column.Matcher.create();
  }

  @Override
  public FromAttribute2Column.Match newEmptyMatch() {
    return FromAttribute2Column.Match.newEmptyMatch();
  }

  @Override
  public FromAttribute2Column.Match newMatch(final Object... parameters) {
    return FromAttribute2Column.Match.newMatch((class_.Attribute) parameters[0]);
  }

  /**
   * Inner class allowing the singleton instance of {@link FromAttribute2Column} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link FromAttribute2Column#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final FromAttribute2Column INSTANCE = new FromAttribute2Column();

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
    private static final FromAttribute2Column.GeneratedPQuery INSTANCE = new GeneratedPQuery();

    private final PParameter parameter_named = new PParameter("named", "class_.Attribute", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("Class", "Attribute")), PParameterDirection.INOUT);

    private final List<PParameter> parameters = Arrays.asList(parameter_named);

    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }

    @Override
    public String getFullyQualifiedName() {
      return "c2r.version2.fromAttribute2Column";
    }

    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("named");
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
          PVariable var_named = body.getOrCreateVariableByName("named");
          PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
          PVariable var___1_ = body.getOrCreateVariableByName("_<1>");
          new TypeConstraint(body, Tuples.flatTupleOf(var_named), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Class", "Attribute")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_named, parameter_named)
          ));
          // 	// MODEL_NAVIGATION	Attribute.multiValued(named,false)
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new ConstantValue(body, var__virtual_0_, false);
          new TypeConstraint(body, Tuples.flatTupleOf(var_named), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Class", "Attribute")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_named, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("Class", "Attribute", "multiValued")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EBoolean")));
          new Equality(body, var__virtual_1_, var__virtual_0_);
          // 	// MODEL_NAVIGATION	Attribute.owner(named,_)
          new TypeConstraint(body, Tuples.flatTupleOf(var_named), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Class", "Attribute")));
          PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_named, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("Class", "Attribute", "owner")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_2_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Class", "Class")));
          new Equality(body, var__virtual_2_, var___0_);
          // 	// MODEL_NAVIGATION	Attribute.type(named,_)
          new TypeConstraint(body, Tuples.flatTupleOf(var_named), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Class", "Attribute")));
          PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_named, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("Class", "Attribute", "type")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_3_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Class", "Classifier")));
          new Equality(body, var__virtual_3_, var___1_);
          bodies.add(body);
      }
      return bodies;
    }
  }

  private static boolean evaluateExpression_1_1() {
    return false;
  }
}
