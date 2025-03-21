/**
 * Generated from platform:/resource/c2r/src/c2r/version2/queries2.vql
 */
package c2r.version2;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
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
 *         pattern makeInteger(){
 *         	// MODEL_NAVIGATION
 *         	Class(_);
 *         // MODEL_NAVIGATION
 *         } or {
 *         	// MODEL_NAVIGATION
 *         	DataType.name(_,"Integer");
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class MakeInteger extends BaseGeneratedEMFQuerySpecification<MakeInteger.Matcher> {
  /**
   * Pattern-specific match representation of the c2r.version2.makeInteger pattern,
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
    private static List<String> parameterNames = makeImmutableList();

    private Match() {
      
    }

    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          default: return null;
      }
    }

    @Override
    public Object get(final int index) {
      return null;
    }

    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      return false;
    }

    @Override
    public String patternName() {
      return "c2r.version2.makeInteger";
    }

    @Override
    public List<String> parameterNames() {
      return MakeInteger.Match.parameterNames;
    }

    @Override
    public Object[] toArray() {
      return new Object[]{};
    }

    @Override
    public MakeInteger.Match toImmutable() {
      return isMutable() ? newMatch() : this;
    }

    @Override
    public String prettyPrint() {
      return "[]";
    }

    @Override
    public int hashCode() {
      return Objects.hash();
    }

    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof MakeInteger.Match)) {
          return true;
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
    public MakeInteger specification() {
      return MakeInteger.instance();
    }

    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static MakeInteger.Match newEmptyMatch() {
      return new Mutable();
    }

    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the new, mutable (partial) match object.
     * 
     */
    public static MakeInteger.Match newMutableMatch() {
      return new Mutable();
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @return the (partial) match object.
     * 
     */
    public static MakeInteger.Match newMatch() {
      return new Immutable();
    }

    private static final class Mutable extends MakeInteger.Match {
      Mutable() {
        super();
      }

      @Override
      public boolean isMutable() {
        return true;
      }
    }

    private static final class Immutable extends MakeInteger.Match {
      Immutable() {
        super();
      }

      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }

  /**
   * Generated pattern matcher API of the c2r.version2.makeInteger pattern,
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
   * pattern makeInteger(){
   * 	// MODEL_NAVIGATION
   * 	Class(_);
   * // MODEL_NAVIGATION
   * } or {
   * 	// MODEL_NAVIGATION
   * 	DataType.name(_,"Integer");
   * }
   * </pre></code>
   * 
   * @see Match
   * @see MakeInteger
   * 
   */
  public static class Matcher extends BaseMatcher<MakeInteger.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static MakeInteger.Matcher on(final ViatraQueryEngine engine) {
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
    public static MakeInteger.Matcher create() {
      return new Matcher();
    }

    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(MakeInteger.Matcher.class);

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
     * Indicates whether the (parameterless) pattern matches or not.
     * @return true if the pattern has a valid match.
     * 
     */
    public boolean hasMatch() {
      return rawHasMatch(new Object[]{});
    }

    @Override
    protected MakeInteger.Match tupleToMatch(final Tuple t) {
      try {
          return MakeInteger.Match.newMatch();
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }

    @Override
    protected MakeInteger.Match arrayToMatch(final Object[] match) {
      try {
          return MakeInteger.Match.newMatch();
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }

    @Override
    protected MakeInteger.Match arrayToMatchMutable(final Object[] match) {
      try {
          return MakeInteger.Match.newMutableMatch();
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
    public static IQuerySpecification<MakeInteger.Matcher> querySpecification() {
      return MakeInteger.instance();
    }
  }

  private MakeInteger() {
    super(GeneratedPQuery.INSTANCE);
  }

  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static MakeInteger instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }

  @Override
  protected MakeInteger.Matcher instantiate(final ViatraQueryEngine engine) {
    return MakeInteger.Matcher.on(engine);
  }

  @Override
  public MakeInteger.Matcher instantiate() {
    return MakeInteger.Matcher.create();
  }

  @Override
  public MakeInteger.Match newEmptyMatch() {
    return MakeInteger.Match.newEmptyMatch();
  }

  @Override
  public MakeInteger.Match newMatch(final Object... parameters) {
    return MakeInteger.Match.newMatch();
  }

  /**
   * Inner class allowing the singleton instance of {@link MakeInteger} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link MakeInteger#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final MakeInteger INSTANCE = new MakeInteger();

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
    private static final MakeInteger.GeneratedPQuery INSTANCE = new GeneratedPQuery();

    private final List<PParameter> parameters = Arrays.asList();

    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }

    @Override
    public String getFullyQualifiedName() {
      return "c2r.version2.makeInteger";
    }

    @Override
    public List<String> getParameterNames() {
      return Arrays.asList();
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
          PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
          ));
          // 	// MODEL_NAVIGATION	Class(_)
          new TypeConstraint(body, Tuples.flatTupleOf(var___0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Class", "Class")));
          bodies.add(body);
      }
      {
          PBody body = new PBody(this);
          PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
          ));
          // 	// MODEL_NAVIGATION	DataType.name(_,"Integer")
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new ConstantValue(body, var__virtual_0_, "Integer");
          new TypeConstraint(body, Tuples.flatTupleOf(var___0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Class", "DataType")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var___0_, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("Class", "NamedElt", "name")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EString")));
          new Equality(body, var__virtual_1_, var__virtual_0_);
          bodies.add(body);
      }
      return bodies;
    }
  }
}
