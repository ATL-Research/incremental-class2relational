/**
 * Generated from platform:/resource/c2r/src/c2r/version2/queries2.vql
 */
package c2r.version2;

import class_.NamedElt;
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
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.matchers.backend.QueryEvaluationHint;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
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
 *         pattern fromClass(named: NamedElt){
 *         	// MODEL_NAVIGATION
 *         	Class(named);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class FromClass extends BaseGeneratedEMFQuerySpecification<FromClass.Matcher> {
  /**
   * Pattern-specific match representation of the c2r.version2.fromClass pattern,
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
    private NamedElt fNamed;

    private static List<String> parameterNames = makeImmutableList("named");

    private Match(final NamedElt pNamed) {
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

    public NamedElt getNamed() {
      return this.fNamed;
    }

    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("named".equals(parameterName) ) {
          this.fNamed = (NamedElt) newValue;
          return true;
      }
      return false;
    }

    public void setNamed(final NamedElt pNamed) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fNamed = pNamed;
    }

    @Override
    public String patternName() {
      return "c2r.version2.fromClass";
    }

    @Override
    public List<String> parameterNames() {
      return FromClass.Match.parameterNames;
    }

    @Override
    public Object[] toArray() {
      return new Object[]{fNamed};
    }

    @Override
    public FromClass.Match toImmutable() {
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
      if ((obj instanceof FromClass.Match)) {
          FromClass.Match other = (FromClass.Match) obj;
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
    public FromClass specification() {
      return FromClass.instance();
    }

    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static FromClass.Match newEmptyMatch() {
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
    public static FromClass.Match newMutableMatch(final NamedElt pNamed) {
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
    public static FromClass.Match newMatch(final NamedElt pNamed) {
      return new Immutable(pNamed);
    }

    private static final class Mutable extends FromClass.Match {
      Mutable(final NamedElt pNamed) {
        super(pNamed);
      }

      @Override
      public boolean isMutable() {
        return true;
      }
    }

    private static final class Immutable extends FromClass.Match {
      Immutable(final NamedElt pNamed) {
        super(pNamed);
      }

      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }

  /**
   * Generated pattern matcher API of the c2r.version2.fromClass pattern,
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
   * pattern fromClass(named: NamedElt){
   * 	// MODEL_NAVIGATION
   * 	Class(named);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see FromClass
   * 
   */
  public static class Matcher extends BaseMatcher<FromClass.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static FromClass.Matcher on(final ViatraQueryEngine engine) {
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
    public static FromClass.Matcher create() {
      return new Matcher();
    }

    private static final int POSITION_NAMED = 0;

    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(FromClass.Matcher.class);

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
    public Collection<FromClass.Match> getAllMatches(final NamedElt pNamed) {
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
    public Stream<FromClass.Match> streamAllMatches(final NamedElt pNamed) {
      return rawStreamAllMatches(new Object[]{pNamed});
    }

    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pNamed the fixed value of pattern parameter named, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<FromClass.Match> getOneArbitraryMatch(final NamedElt pNamed) {
      return rawGetOneArbitraryMatch(new Object[]{pNamed});
    }

    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pNamed the fixed value of pattern parameter named, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final NamedElt pNamed) {
      return rawHasMatch(new Object[]{pNamed});
    }

    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pNamed the fixed value of pattern parameter named, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final NamedElt pNamed) {
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
    public boolean forOneArbitraryMatch(final NamedElt pNamed, final Consumer<? super FromClass.Match> processor) {
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
    public FromClass.Match newMatch(final NamedElt pNamed) {
      return FromClass.Match.newMatch(pNamed);
    }

    /**
     * Retrieve the set of values that occur in matches for named.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<NamedElt> rawStreamAllValuesOfnamed(final Object[] parameters) {
      return rawStreamAllValues(POSITION_NAMED, parameters).map(NamedElt.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for named.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<NamedElt> getAllValuesOfnamed() {
      return rawStreamAllValuesOfnamed(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for named.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<NamedElt> streamAllValuesOfnamed() {
      return rawStreamAllValuesOfnamed(emptyArray());
    }

    @Override
    protected FromClass.Match tupleToMatch(final Tuple t) {
      try {
          return FromClass.Match.newMatch((NamedElt) t.get(POSITION_NAMED));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }

    @Override
    protected FromClass.Match arrayToMatch(final Object[] match) {
      try {
          return FromClass.Match.newMatch((NamedElt) match[POSITION_NAMED]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }

    @Override
    protected FromClass.Match arrayToMatchMutable(final Object[] match) {
      try {
          return FromClass.Match.newMutableMatch((NamedElt) match[POSITION_NAMED]);
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
    public static IQuerySpecification<FromClass.Matcher> querySpecification() {
      return FromClass.instance();
    }
  }

  private FromClass() {
    super(GeneratedPQuery.INSTANCE);
  }

  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static FromClass instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }

  @Override
  protected FromClass.Matcher instantiate(final ViatraQueryEngine engine) {
    return FromClass.Matcher.on(engine);
  }

  @Override
  public FromClass.Matcher instantiate() {
    return FromClass.Matcher.create();
  }

  @Override
  public FromClass.Match newEmptyMatch() {
    return FromClass.Match.newEmptyMatch();
  }

  @Override
  public FromClass.Match newMatch(final Object... parameters) {
    return FromClass.Match.newMatch((class_.NamedElt) parameters[0]);
  }

  /**
   * Inner class allowing the singleton instance of {@link FromClass} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link FromClass#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final FromClass INSTANCE = new FromClass();

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
    private static final FromClass.GeneratedPQuery INSTANCE = new GeneratedPQuery();

    private final PParameter parameter_named = new PParameter("named", "class_.NamedElt", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("Class", "NamedElt")), PParameterDirection.INOUT);

    private final List<PParameter> parameters = Arrays.asList(parameter_named);

    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }

    @Override
    public String getFullyQualifiedName() {
      return "c2r.version2.fromClass";
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
          new TypeConstraint(body, Tuples.flatTupleOf(var_named), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Class", "NamedElt")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_named, parameter_named)
          ));
          // 	// MODEL_NAVIGATION	Class(named)
          new TypeConstraint(body, Tuples.flatTupleOf(var_named), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Class", "Class")));
          bodies.add(body);
      }
      return bodies;
    }
  }
}
