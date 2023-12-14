/**
 * Generated from platform:/resource/c2r/src/c2r/version2/queries2.vql
 */
package c2r.version2;

import Trace.TraceEntry;
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
import org.eclipse.emf.ecore.EObject;
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
 *         Helper to access trace info
 *          
 *         pattern traceMapping(source: EObject, trace: TraceEntry, idx: EInt, target: EObject){
 *         	TraceEntry.source(trace,source);
 *         	TraceEntry.target(trace,target);
 *         	TraceEntry.index(trace,idx);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class TraceMapping extends BaseGeneratedEMFQuerySpecification<TraceMapping.Matcher> {
  /**
   * Pattern-specific match representation of the c2r.version2.traceMapping pattern,
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
    private EObject fSource;

    private TraceEntry fTrace;

    private Integer fIdx;

    private EObject fTarget;

    private static List<String> parameterNames = makeImmutableList("source", "trace", "idx", "target");

    private Match(final EObject pSource, final TraceEntry pTrace, final Integer pIdx, final EObject pTarget) {
      this.fSource = pSource;
      this.fTrace = pTrace;
      this.fIdx = pIdx;
      this.fTarget = pTarget;
    }

    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "source": return this.fSource;
          case "trace": return this.fTrace;
          case "idx": return this.fIdx;
          case "target": return this.fTarget;
          default: return null;
      }
    }

    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fSource;
          case 1: return this.fTrace;
          case 2: return this.fIdx;
          case 3: return this.fTarget;
          default: return null;
      }
    }

    public EObject getSource() {
      return this.fSource;
    }

    public TraceEntry getTrace() {
      return this.fTrace;
    }

    public Integer getIdx() {
      return this.fIdx;
    }

    public EObject getTarget() {
      return this.fTarget;
    }

    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("source".equals(parameterName) ) {
          this.fSource = (EObject) newValue;
          return true;
      }
      if ("trace".equals(parameterName) ) {
          this.fTrace = (TraceEntry) newValue;
          return true;
      }
      if ("idx".equals(parameterName) ) {
          this.fIdx = (Integer) newValue;
          return true;
      }
      if ("target".equals(parameterName) ) {
          this.fTarget = (EObject) newValue;
          return true;
      }
      return false;
    }

    public void setSource(final EObject pSource) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fSource = pSource;
    }

    public void setTrace(final TraceEntry pTrace) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fTrace = pTrace;
    }

    public void setIdx(final Integer pIdx) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fIdx = pIdx;
    }

    public void setTarget(final EObject pTarget) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fTarget = pTarget;
    }

    @Override
    public String patternName() {
      return "c2r.version2.traceMapping";
    }

    @Override
    public List<String> parameterNames() {
      return TraceMapping.Match.parameterNames;
    }

    @Override
    public Object[] toArray() {
      return new Object[]{fSource, fTrace, fIdx, fTarget};
    }

    @Override
    public TraceMapping.Match toImmutable() {
      return isMutable() ? newMatch(fSource, fTrace, fIdx, fTarget) : this;
    }

    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"source\"=" + prettyPrintValue(fSource) + ", ");
      result.append("\"trace\"=" + prettyPrintValue(fTrace) + ", ");
      result.append("\"idx\"=" + prettyPrintValue(fIdx) + ", ");
      result.append("\"target\"=" + prettyPrintValue(fTarget));
      return result.toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(fSource, fTrace, fIdx, fTarget);
    }

    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof TraceMapping.Match)) {
          TraceMapping.Match other = (TraceMapping.Match) obj;
          return Objects.equals(fSource, other.fSource) && Objects.equals(fTrace, other.fTrace) && Objects.equals(fIdx, other.fIdx) && Objects.equals(fTarget, other.fTarget);
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
    public TraceMapping specification() {
      return TraceMapping.instance();
    }

    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static TraceMapping.Match newEmptyMatch() {
      return new Mutable(null, null, null, null);
    }

    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pSource the fixed value of pattern parameter source, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @param pIdx the fixed value of pattern parameter idx, or null if not bound.
     * @param pTarget the fixed value of pattern parameter target, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static TraceMapping.Match newMutableMatch(final EObject pSource, final TraceEntry pTrace, final Integer pIdx, final EObject pTarget) {
      return new Mutable(pSource, pTrace, pIdx, pTarget);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pSource the fixed value of pattern parameter source, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @param pIdx the fixed value of pattern parameter idx, or null if not bound.
     * @param pTarget the fixed value of pattern parameter target, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static TraceMapping.Match newMatch(final EObject pSource, final TraceEntry pTrace, final Integer pIdx, final EObject pTarget) {
      return new Immutable(pSource, pTrace, pIdx, pTarget);
    }

    private static final class Mutable extends TraceMapping.Match {
      Mutable(final EObject pSource, final TraceEntry pTrace, final Integer pIdx, final EObject pTarget) {
        super(pSource, pTrace, pIdx, pTarget);
      }

      @Override
      public boolean isMutable() {
        return true;
      }
    }

    private static final class Immutable extends TraceMapping.Match {
      Immutable(final EObject pSource, final TraceEntry pTrace, final Integer pIdx, final EObject pTarget) {
        super(pSource, pTrace, pIdx, pTarget);
      }

      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }

  /**
   * Generated pattern matcher API of the c2r.version2.traceMapping pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * Helper to access trace info
   *  
   * pattern traceMapping(source: EObject, trace: TraceEntry, idx: EInt, target: EObject){
   * 	TraceEntry.source(trace,source);
   * 	TraceEntry.target(trace,target);
   * 	TraceEntry.index(trace,idx);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see TraceMapping
   * 
   */
  public static class Matcher extends BaseMatcher<TraceMapping.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static TraceMapping.Matcher on(final ViatraQueryEngine engine) {
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
    public static TraceMapping.Matcher create() {
      return new Matcher();
    }

    private static final int POSITION_SOURCE = 0;

    private static final int POSITION_TRACE = 1;

    private static final int POSITION_IDX = 2;

    private static final int POSITION_TARGET = 3;

    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(TraceMapping.Matcher.class);

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
     * @param pSource the fixed value of pattern parameter source, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @param pIdx the fixed value of pattern parameter idx, or null if not bound.
     * @param pTarget the fixed value of pattern parameter target, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<TraceMapping.Match> getAllMatches(final EObject pSource, final TraceEntry pTrace, final Integer pIdx, final EObject pTarget) {
      return rawStreamAllMatches(new Object[]{pSource, pTrace, pIdx, pTarget}).collect(Collectors.toSet());
    }

    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pSource the fixed value of pattern parameter source, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @param pIdx the fixed value of pattern parameter idx, or null if not bound.
     * @param pTarget the fixed value of pattern parameter target, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<TraceMapping.Match> streamAllMatches(final EObject pSource, final TraceEntry pTrace, final Integer pIdx, final EObject pTarget) {
      return rawStreamAllMatches(new Object[]{pSource, pTrace, pIdx, pTarget});
    }

    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pSource the fixed value of pattern parameter source, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @param pIdx the fixed value of pattern parameter idx, or null if not bound.
     * @param pTarget the fixed value of pattern parameter target, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<TraceMapping.Match> getOneArbitraryMatch(final EObject pSource, final TraceEntry pTrace, final Integer pIdx, final EObject pTarget) {
      return rawGetOneArbitraryMatch(new Object[]{pSource, pTrace, pIdx, pTarget});
    }

    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pSource the fixed value of pattern parameter source, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @param pIdx the fixed value of pattern parameter idx, or null if not bound.
     * @param pTarget the fixed value of pattern parameter target, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final EObject pSource, final TraceEntry pTrace, final Integer pIdx, final EObject pTarget) {
      return rawHasMatch(new Object[]{pSource, pTrace, pIdx, pTarget});
    }

    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pSource the fixed value of pattern parameter source, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @param pIdx the fixed value of pattern parameter idx, or null if not bound.
     * @param pTarget the fixed value of pattern parameter target, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final EObject pSource, final TraceEntry pTrace, final Integer pIdx, final EObject pTarget) {
      return rawCountMatches(new Object[]{pSource, pTrace, pIdx, pTarget});
    }

    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pSource the fixed value of pattern parameter source, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @param pIdx the fixed value of pattern parameter idx, or null if not bound.
     * @param pTarget the fixed value of pattern parameter target, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final EObject pSource, final TraceEntry pTrace, final Integer pIdx, final EObject pTarget, final Consumer<? super TraceMapping.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pSource, pTrace, pIdx, pTarget}, processor);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pSource the fixed value of pattern parameter source, or null if not bound.
     * @param pTrace the fixed value of pattern parameter trace, or null if not bound.
     * @param pIdx the fixed value of pattern parameter idx, or null if not bound.
     * @param pTarget the fixed value of pattern parameter target, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public TraceMapping.Match newMatch(final EObject pSource, final TraceEntry pTrace, final Integer pIdx, final EObject pTarget) {
      return TraceMapping.Match.newMatch(pSource, pTrace, pIdx, pTarget);
    }

    /**
     * Retrieve the set of values that occur in matches for source.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<EObject> rawStreamAllValuesOfsource(final Object[] parameters) {
      return rawStreamAllValues(POSITION_SOURCE, parameters).map(EObject.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for source.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<EObject> getAllValuesOfsource() {
      return rawStreamAllValuesOfsource(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for source.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<EObject> streamAllValuesOfsource() {
      return rawStreamAllValuesOfsource(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for source.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<EObject> streamAllValuesOfsource(final TraceMapping.Match partialMatch) {
      return rawStreamAllValuesOfsource(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for source.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<EObject> streamAllValuesOfsource(final TraceEntry pTrace, final Integer pIdx, final EObject pTarget) {
      return rawStreamAllValuesOfsource(new Object[]{null, pTrace, pIdx, pTarget});
    }

    /**
     * Retrieve the set of values that occur in matches for source.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<EObject> getAllValuesOfsource(final TraceMapping.Match partialMatch) {
      return rawStreamAllValuesOfsource(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for source.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<EObject> getAllValuesOfsource(final TraceEntry pTrace, final Integer pIdx, final EObject pTarget) {
      return rawStreamAllValuesOfsource(new Object[]{null, pTrace, pIdx, pTarget}).collect(Collectors.toSet());
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
    public Stream<TraceEntry> streamAllValuesOftrace(final TraceMapping.Match partialMatch) {
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
    public Stream<TraceEntry> streamAllValuesOftrace(final EObject pSource, final Integer pIdx, final EObject pTarget) {
      return rawStreamAllValuesOftrace(new Object[]{pSource, null, pIdx, pTarget});
    }

    /**
     * Retrieve the set of values that occur in matches for trace.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<TraceEntry> getAllValuesOftrace(final TraceMapping.Match partialMatch) {
      return rawStreamAllValuesOftrace(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for trace.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<TraceEntry> getAllValuesOftrace(final EObject pSource, final Integer pIdx, final EObject pTarget) {
      return rawStreamAllValuesOftrace(new Object[]{pSource, null, pIdx, pTarget}).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for idx.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Integer> rawStreamAllValuesOfidx(final Object[] parameters) {
      return rawStreamAllValues(POSITION_IDX, parameters).map(Integer.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for idx.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Integer> getAllValuesOfidx() {
      return rawStreamAllValuesOfidx(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for idx.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Integer> streamAllValuesOfidx() {
      return rawStreamAllValuesOfidx(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for idx.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Integer> streamAllValuesOfidx(final TraceMapping.Match partialMatch) {
      return rawStreamAllValuesOfidx(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for idx.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Integer> streamAllValuesOfidx(final EObject pSource, final TraceEntry pTrace, final EObject pTarget) {
      return rawStreamAllValuesOfidx(new Object[]{pSource, pTrace, null, pTarget});
    }

    /**
     * Retrieve the set of values that occur in matches for idx.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Integer> getAllValuesOfidx(final TraceMapping.Match partialMatch) {
      return rawStreamAllValuesOfidx(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for idx.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Integer> getAllValuesOfidx(final EObject pSource, final TraceEntry pTrace, final EObject pTarget) {
      return rawStreamAllValuesOfidx(new Object[]{pSource, pTrace, null, pTarget}).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for target.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<EObject> rawStreamAllValuesOftarget(final Object[] parameters) {
      return rawStreamAllValues(POSITION_TARGET, parameters).map(EObject.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for target.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<EObject> getAllValuesOftarget() {
      return rawStreamAllValuesOftarget(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for target.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<EObject> streamAllValuesOftarget() {
      return rawStreamAllValuesOftarget(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for target.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<EObject> streamAllValuesOftarget(final TraceMapping.Match partialMatch) {
      return rawStreamAllValuesOftarget(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for target.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<EObject> streamAllValuesOftarget(final EObject pSource, final TraceEntry pTrace, final Integer pIdx) {
      return rawStreamAllValuesOftarget(new Object[]{pSource, pTrace, pIdx, null});
    }

    /**
     * Retrieve the set of values that occur in matches for target.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<EObject> getAllValuesOftarget(final TraceMapping.Match partialMatch) {
      return rawStreamAllValuesOftarget(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for target.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<EObject> getAllValuesOftarget(final EObject pSource, final TraceEntry pTrace, final Integer pIdx) {
      return rawStreamAllValuesOftarget(new Object[]{pSource, pTrace, pIdx, null}).collect(Collectors.toSet());
    }

    @Override
    protected TraceMapping.Match tupleToMatch(final Tuple t) {
      try {
          return TraceMapping.Match.newMatch((EObject) t.get(POSITION_SOURCE), (TraceEntry) t.get(POSITION_TRACE), (Integer) t.get(POSITION_IDX), (EObject) t.get(POSITION_TARGET));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }

    @Override
    protected TraceMapping.Match arrayToMatch(final Object[] match) {
      try {
          return TraceMapping.Match.newMatch((EObject) match[POSITION_SOURCE], (TraceEntry) match[POSITION_TRACE], (Integer) match[POSITION_IDX], (EObject) match[POSITION_TARGET]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }

    @Override
    protected TraceMapping.Match arrayToMatchMutable(final Object[] match) {
      try {
          return TraceMapping.Match.newMutableMatch((EObject) match[POSITION_SOURCE], (TraceEntry) match[POSITION_TRACE], (Integer) match[POSITION_IDX], (EObject) match[POSITION_TARGET]);
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
    public static IQuerySpecification<TraceMapping.Matcher> querySpecification() {
      return TraceMapping.instance();
    }
  }

  private TraceMapping() {
    super(GeneratedPQuery.INSTANCE);
  }

  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static TraceMapping instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }

  @Override
  protected TraceMapping.Matcher instantiate(final ViatraQueryEngine engine) {
    return TraceMapping.Matcher.on(engine);
  }

  @Override
  public TraceMapping.Matcher instantiate() {
    return TraceMapping.Matcher.create();
  }

  @Override
  public TraceMapping.Match newEmptyMatch() {
    return TraceMapping.Match.newEmptyMatch();
  }

  @Override
  public TraceMapping.Match newMatch(final Object... parameters) {
    return TraceMapping.Match.newMatch((org.eclipse.emf.ecore.EObject) parameters[0], (Trace.TraceEntry) parameters[1], (java.lang.Integer) parameters[2], (org.eclipse.emf.ecore.EObject) parameters[3]);
  }

  /**
   * Inner class allowing the singleton instance of {@link TraceMapping} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link TraceMapping#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final TraceMapping INSTANCE = new TraceMapping();

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
    private static final TraceMapping.GeneratedPQuery INSTANCE = new GeneratedPQuery();

    private final PParameter parameter_source = new PParameter("source", "org.eclipse.emf.ecore.EObject", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.eclipse.org/emf/2002/Ecore", "EObject")), PParameterDirection.INOUT);

    private final PParameter parameter_trace = new PParameter("trace", "Trace.TraceEntry", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("Trace", "TraceEntry")), PParameterDirection.INOUT);

    private final PParameter parameter_idx = new PParameter("idx", "java.lang.Integer", new EDataTypeInSlotsKey((EDataType)getClassifierLiteralSafe("http://www.eclipse.org/emf/2002/Ecore", "EInt")), PParameterDirection.INOUT);

    private final PParameter parameter_target = new PParameter("target", "org.eclipse.emf.ecore.EObject", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.eclipse.org/emf/2002/Ecore", "EObject")), PParameterDirection.INOUT);

    private final List<PParameter> parameters = Arrays.asList(parameter_source, parameter_trace, parameter_idx, parameter_target);

    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }

    @Override
    public String getFullyQualifiedName() {
      return "c2r.version2.traceMapping";
    }

    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("source","trace","idx","target");
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
          PVariable var_source = body.getOrCreateVariableByName("source");
          PVariable var_trace = body.getOrCreateVariableByName("trace");
          PVariable var_idx = body.getOrCreateVariableByName("idx");
          PVariable var_target = body.getOrCreateVariableByName("target");
          new TypeConstraint(body, Tuples.flatTupleOf(var_source), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EObject")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_trace), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Trace", "TraceEntry")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_idx), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EInt")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_target), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EObject")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_source, parameter_source),
             new ExportedParameter(body, var_trace, parameter_trace),
             new ExportedParameter(body, var_idx, parameter_idx),
             new ExportedParameter(body, var_target, parameter_target)
          ));
          // 	TraceEntry.source(trace,source)
          new TypeConstraint(body, Tuples.flatTupleOf(var_trace), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Trace", "TraceEntry")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_trace, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("Trace", "TraceEntry", "source")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EObject")));
          new Equality(body, var__virtual_0_, var_source);
          // 	TraceEntry.target(trace,target)
          new TypeConstraint(body, Tuples.flatTupleOf(var_trace), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Trace", "TraceEntry")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_trace, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("Trace", "TraceEntry", "target")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EObject")));
          new Equality(body, var__virtual_1_, var_target);
          // 	TraceEntry.index(trace,idx)
          new TypeConstraint(body, Tuples.flatTupleOf(var_trace), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Trace", "TraceEntry")));
          PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_trace, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("Trace", "TraceEntry", "index")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_2_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EInt")));
          new Equality(body, var__virtual_2_, var_idx);
          bodies.add(body);
      }
      return bodies;
    }
  }
}
