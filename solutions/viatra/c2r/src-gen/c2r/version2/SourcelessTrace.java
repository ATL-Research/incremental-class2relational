/**
 * Generated from platform:/resource/c2r/src/c2r/version2/queries2.vql
 */
package c2r.version2;

import Trace.TraceEntry;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
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
import org.eclipse.viatra.query.runtime.emf.types.EStructuralFeatureInstancesKey;
import org.eclipse.viatra.query.runtime.matchers.backend.QueryEvaluationHint;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.NegativePatternCall;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameterDirection;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PVisibility;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuple;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuples;
import org.eclipse.viatra.query.runtime.util.ViatraQueryLoggingUtil;
import relational_.Named;

/**
 * A pattern-specific query specification that can instantiate Matcher in a type-safe way.
 * 
 * <p>Original source:
 *         <code><pre>
 *         Find traces and images that has no source.
 *           (Model change removes the source from the trace too)
 *          
 *         pattern sourcelessTrace(trace: TraceEntry, named: Named){
 *         	neg TraceEntry.source(trace, _);
 *         	TraceEntry.target(trace,named);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class SourcelessTrace extends BaseGeneratedEMFQuerySpecification<SourcelessTrace.Matcher> {
  /**
   * Pattern-specific match representation of the c2r.version2.sourcelessTrace pattern,
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
    private TraceEntry fTrace;

    private Named fNamed;

    private static List<String> parameterNames = makeImmutableList("trace", "named");

    private Match(final TraceEntry pTrace, final Named pNamed) {
      this.fTrace = pTrace;
      this.fNamed = pNamed;
    }

    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "trace": return this.fTrace;
          case "named": return this.fNamed;
          default: return null;
      }
    }

    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fTrace;
          case 1: return this.fNamed;
          default: return null;
      }
    }

    public TraceEntry getTrace() {
      return this.fTrace;
    }

    public Named getNamed() {
      return this.fNamed;
    }

    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("trace".equals(parameterName) ) {
          this.fTrace = (TraceEntry) newValue;
          return true;
      }
      if ("named".equals(parameterName) ) {
          this.fNamed = (Named) newValue;
          return true;
      }
      return false;
    }

    public void setTrace(final TraceEntry pTrace) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fTrace = pTrace;
    }

    public void setNamed(final Named pNamed) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fNamed = pNamed;
    }

    @Override
    public String patternName() {
      return "c2r.version2.sourcelessTrace";
    }

    @Override
    public List<String> parameterNames() {
      return SourcelessTrace.Match.parameterNames;
    }

    @Override
    public Object[] toArray() {
      return new Object[]{fTrace, fNamed};
    }

    @Override
    public SourcelessTrace.Match toImmutable() {
      return isMutable() ? newMatch(fTrace, fNamed) : this;
    }

    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"trace\"=" + prettyPrintValue(fTrace) + ", ");
      result.append("\"named\"=" + prettyPrintValue(fNamed));
      return result.toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(fTrace, fNamed);
    }

    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof SourcelessTrace.Match)) {
          SourcelessTrace.Match other = (SourcelessTrace.Match) obj;
          return Objects.equals(fTrace, other.fTrace) && Objects.equals(fNamed, other.fNamed);
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
    public SourcelessTrace specification() {
      return SourcelessTrace.instance();
    }

    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static SourcelessTrace.Match newEmptyMatch() {
      return new Mutable(null, null);
    }

    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @param pNamed the fixed value of pattern parameter named, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static SourcelessTrace.Match newMutableMatch(final TraceEntry pTrace, final Named pNamed) {
      return new Mutable(pTrace, pNamed);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @param pNamed the fixed value of pattern parameter named, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static SourcelessTrace.Match newMatch(final TraceEntry pTrace, final Named pNamed) {
      return new Immutable(pTrace, pNamed);
    }

    private static final class Mutable extends SourcelessTrace.Match {
      Mutable(final TraceEntry pTrace, final Named pNamed) {
        super(pTrace, pNamed);
      }

      @Override
      public boolean isMutable() {
        return true;
      }
    }

    private static final class Immutable extends SourcelessTrace.Match {
      Immutable(final TraceEntry pTrace, final Named pNamed) {
        super(pTrace, pNamed);
      }

      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }

  /**
   * Generated pattern matcher API of the c2r.version2.sourcelessTrace pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * Find traces and images that has no source.
   *   (Model change removes the source from the trace too)
   *  
   * pattern sourcelessTrace(trace: TraceEntry, named: Named){
   * 	neg TraceEntry.source(trace, _);
   * 	TraceEntry.target(trace,named);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see SourcelessTrace
   * 
   */
  public static class Matcher extends BaseMatcher<SourcelessTrace.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static SourcelessTrace.Matcher on(final ViatraQueryEngine engine) {
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
    public static SourcelessTrace.Matcher create() {
      return new Matcher();
    }

    private static final int POSITION_TRACE = 0;

    private static final int POSITION_NAMED = 1;

    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(SourcelessTrace.Matcher.class);

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
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @param pNamed the fixed value of pattern parameter named, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<SourcelessTrace.Match> getAllMatches(final TraceEntry pTrace, final Named pNamed) {
      return rawStreamAllMatches(new Object[]{pTrace, pNamed}).collect(Collectors.toSet());
    }

    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @param pNamed the fixed value of pattern parameter named, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<SourcelessTrace.Match> streamAllMatches(final TraceEntry pTrace, final Named pNamed) {
      return rawStreamAllMatches(new Object[]{pTrace, pNamed});
    }

    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @param pNamed the fixed value of pattern parameter named, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<SourcelessTrace.Match> getOneArbitraryMatch(final TraceEntry pTrace, final Named pNamed) {
      return rawGetOneArbitraryMatch(new Object[]{pTrace, pNamed});
    }

    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @param pNamed the fixed value of pattern parameter named, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final TraceEntry pTrace, final Named pNamed) {
      return rawHasMatch(new Object[]{pTrace, pNamed});
    }

    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @param pNamed the fixed value of pattern parameter named, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final TraceEntry pTrace, final Named pNamed) {
      return rawCountMatches(new Object[]{pTrace, pNamed});
    }

    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @param pNamed the fixed value of pattern parameter named, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final TraceEntry pTrace, final Named pNamed, final Consumer<? super SourcelessTrace.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pTrace, pNamed}, processor);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @param pNamed the fixed value of pattern parameter named, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public SourcelessTrace.Match newMatch(final TraceEntry pTrace, final Named pNamed) {
      return SourcelessTrace.Match.newMatch(pTrace, pNamed);
    }

    /**
     * Retrieve the set of values that occur in matches for trace.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<TraceEntry> rawStreamAllValuesOftrace(final Object[] parameters) {
      return rawStreamAllValues(POSITION_TRACE, parameters).map(TraceEntry.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for trace.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<TraceEntry> getAllValuesOftrace() {
      return rawStreamAllValuesOftrace(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for trace.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<TraceEntry> streamAllValuesOftrace() {
      return rawStreamAllValuesOftrace(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for trace.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<TraceEntry> streamAllValuesOftrace(final SourcelessTrace.Match partialMatch) {
      return rawStreamAllValuesOftrace(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for trace.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<TraceEntry> streamAllValuesOftrace(final Named pNamed) {
      return rawStreamAllValuesOftrace(new Object[]{null, pNamed});
    }

    /**
     * Retrieve the set of values that occur in matches for trace.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<TraceEntry> getAllValuesOftrace(final SourcelessTrace.Match partialMatch) {
      return rawStreamAllValuesOftrace(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for trace.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<TraceEntry> getAllValuesOftrace(final Named pNamed) {
      return rawStreamAllValuesOftrace(new Object[]{null, pNamed}).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for named.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Named> rawStreamAllValuesOfnamed(final Object[] parameters) {
      return rawStreamAllValues(POSITION_NAMED, parameters).map(Named.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for named.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Named> getAllValuesOfnamed() {
      return rawStreamAllValuesOfnamed(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for named.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Named> streamAllValuesOfnamed() {
      return rawStreamAllValuesOfnamed(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for named.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Named> streamAllValuesOfnamed(final SourcelessTrace.Match partialMatch) {
      return rawStreamAllValuesOfnamed(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for named.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Named> streamAllValuesOfnamed(final TraceEntry pTrace) {
      return rawStreamAllValuesOfnamed(new Object[]{pTrace, null});
    }

    /**
     * Retrieve the set of values that occur in matches for named.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Named> getAllValuesOfnamed(final SourcelessTrace.Match partialMatch) {
      return rawStreamAllValuesOfnamed(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for named.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Named> getAllValuesOfnamed(final TraceEntry pTrace) {
      return rawStreamAllValuesOfnamed(new Object[]{pTrace, null}).collect(Collectors.toSet());
    }

    @Override
    protected SourcelessTrace.Match tupleToMatch(final Tuple t) {
      try {
          return SourcelessTrace.Match.newMatch((TraceEntry) t.get(POSITION_TRACE), (Named) t.get(POSITION_NAMED));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }

    @Override
    protected SourcelessTrace.Match arrayToMatch(final Object[] match) {
      try {
          return SourcelessTrace.Match.newMatch((TraceEntry) match[POSITION_TRACE], (Named) match[POSITION_NAMED]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }

    @Override
    protected SourcelessTrace.Match arrayToMatchMutable(final Object[] match) {
      try {
          return SourcelessTrace.Match.newMutableMatch((TraceEntry) match[POSITION_TRACE], (Named) match[POSITION_NAMED]);
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
    public static IQuerySpecification<SourcelessTrace.Matcher> querySpecification() {
      return SourcelessTrace.instance();
    }
  }

  private SourcelessTrace() {
    super(GeneratedPQuery.INSTANCE);
  }

  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static SourcelessTrace instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }

  @Override
  protected SourcelessTrace.Matcher instantiate(final ViatraQueryEngine engine) {
    return SourcelessTrace.Matcher.on(engine);
  }

  @Override
  public SourcelessTrace.Matcher instantiate() {
    return SourcelessTrace.Matcher.create();
  }

  @Override
  public SourcelessTrace.Match newEmptyMatch() {
    return SourcelessTrace.Match.newEmptyMatch();
  }

  @Override
  public SourcelessTrace.Match newMatch(final Object... parameters) {
    return SourcelessTrace.Match.newMatch((Trace.TraceEntry) parameters[0], (relational_.Named) parameters[1]);
  }

  /**
   * Inner class allowing the singleton instance of {@link SourcelessTrace} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link SourcelessTrace#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final SourcelessTrace INSTANCE = new SourcelessTrace();

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
    private static final SourcelessTrace.GeneratedPQuery INSTANCE = new GeneratedPQuery();

    private final PParameter parameter_trace = new PParameter("trace", "Trace.TraceEntry", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("Trace", "TraceEntry")), PParameterDirection.INOUT);

    private final PParameter parameter_named = new PParameter("named", "relational_.Named", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("Relational", "Named")), PParameterDirection.INOUT);

    private final List<PParameter> parameters = Arrays.asList(parameter_trace, parameter_named);

    private class Embedded_1_TraceEntry_source extends BaseGeneratedEMFPQuery {
      private final PParameter parameter_p0 = new PParameter("p0", "Trace.TraceEntry", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("Trace", "TraceEntry")), PParameterDirection.INOUT);

      private final PParameter parameter_p1 = new PParameter("p1", "org.eclipse.emf.ecore.EObject", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.eclipse.org/emf/2002/Ecore", "EObject")), PParameterDirection.INOUT);

      private final List<PParameter> embeddedParameters = Arrays.asList(parameter_p0, parameter_p1);

      public Embedded_1_TraceEntry_source() {
        super(PVisibility.EMBEDDED);
      }

      @Override
      public String getFullyQualifiedName() {
        return GeneratedPQuery.this.getFullyQualifiedName() + "$Embedded_1_TraceEntry_source";
      }

      @Override
      public List<PParameter> getParameters() {
        return embeddedParameters;
      }

      @Override
      public Set<PBody> doGetContainedBodies() {
        PBody body = new PBody(this);
        PVariable var_p0 = body.getOrCreateVariableByName("p0");
        PVariable var_p1 = body.getOrCreateVariableByName("p1");
        body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
           new ExportedParameter(body, var_p0, parameter_p0),
           new ExportedParameter(body, var_p1, parameter_p1)
        ));
        //  TraceEntry.source(trace, _)
        new TypeConstraint(body, Tuples.flatTupleOf(var_p0), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Trace", "TraceEntry")));
        PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
        new TypeConstraint(body, Tuples.flatTupleOf(var_p0, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("Trace", "TraceEntry", "source")));
        new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EObject")));
        new Equality(body, var__virtual_0_, var_p1);
        return Collections.singleton(body);
      }
    }

    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }

    @Override
    public String getFullyQualifiedName() {
      return "c2r.version2.sourcelessTrace";
    }

    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("trace","named");
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
          PVariable var_trace = body.getOrCreateVariableByName("trace");
          PVariable var_named = body.getOrCreateVariableByName("named");
          PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
          new TypeConstraint(body, Tuples.flatTupleOf(var_trace), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Trace", "TraceEntry")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_named), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Relational", "Named")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_trace, parameter_trace),
             new ExportedParameter(body, var_named, parameter_named)
          ));
          // 	neg TraceEntry.source(trace, _)
          new NegativePatternCall(body, Tuples.flatTupleOf(var_trace, var___0_), new SourcelessTrace.GeneratedPQuery.Embedded_1_TraceEntry_source());
          // 	TraceEntry.target(trace,named)
          new TypeConstraint(body, Tuples.flatTupleOf(var_trace), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Trace", "TraceEntry")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_trace, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("Trace", "TraceEntry", "target")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EObject")));
          new Equality(body, var__virtual_0_, var_named);
          bodies.add(body);
      }
      return bodies;
    }
  }
}
