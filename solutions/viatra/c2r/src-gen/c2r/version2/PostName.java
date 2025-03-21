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
import org.eclipse.viatra.query.runtime.matchers.context.common.JavaTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.TypeFilterConstraint;
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
 *         // helper
 *         pattern postName(attr: Attribute, post: java String){
 *         	// MODEL_NAVIGATION
 *         	Attribute.type(attr, type);
 *         	// MODEL_NAVIGATION
 *         	Class(type);
 *         	// Transformation
 *         	post == "Id";
 *         // transformation
 *         } or {
 *         	// MODEL_NAVIGATION
 *         	Attribute.type(attr, type);
 *         	// MODEL_NAVIGATION
 *         	DataType(type);
 *         	// transformation 
 *         	post == "";
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class PostName extends BaseGeneratedEMFQuerySpecification<PostName.Matcher> {
  /**
   * Pattern-specific match representation of the c2r.version2.postName pattern,
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
    private Attribute fAttr;

    private String fPost;

    private static List<String> parameterNames = makeImmutableList("attr", "post");

    private Match(final Attribute pAttr, final String pPost) {
      this.fAttr = pAttr;
      this.fPost = pPost;
    }

    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "attr": return this.fAttr;
          case "post": return this.fPost;
          default: return null;
      }
    }

    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fAttr;
          case 1: return this.fPost;
          default: return null;
      }
    }

    public Attribute getAttr() {
      return this.fAttr;
    }

    public String getPost() {
      return this.fPost;
    }

    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("attr".equals(parameterName) ) {
          this.fAttr = (Attribute) newValue;
          return true;
      }
      if ("post".equals(parameterName) ) {
          this.fPost = (String) newValue;
          return true;
      }
      return false;
    }

    public void setAttr(final Attribute pAttr) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fAttr = pAttr;
    }

    public void setPost(final String pPost) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fPost = pPost;
    }

    @Override
    public String patternName() {
      return "c2r.version2.postName";
    }

    @Override
    public List<String> parameterNames() {
      return PostName.Match.parameterNames;
    }

    @Override
    public Object[] toArray() {
      return new Object[]{fAttr, fPost};
    }

    @Override
    public PostName.Match toImmutable() {
      return isMutable() ? newMatch(fAttr, fPost) : this;
    }

    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"attr\"=" + prettyPrintValue(fAttr) + ", ");
      result.append("\"post\"=" + prettyPrintValue(fPost));
      return result.toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(fAttr, fPost);
    }

    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof PostName.Match)) {
          PostName.Match other = (PostName.Match) obj;
          return Objects.equals(fAttr, other.fAttr) && Objects.equals(fPost, other.fPost);
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
    public PostName specification() {
      return PostName.instance();
    }

    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static PostName.Match newEmptyMatch() {
      return new Mutable(null, null);
    }

    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pAttr the fixed value of pattern parameter attr, or null if not bound.
     * @param pPost the fixed value of pattern parameter post, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static PostName.Match newMutableMatch(final Attribute pAttr, final String pPost) {
      return new Mutable(pAttr, pPost);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pAttr the fixed value of pattern parameter attr, or null if not bound.
     * @param pPost the fixed value of pattern parameter post, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static PostName.Match newMatch(final Attribute pAttr, final String pPost) {
      return new Immutable(pAttr, pPost);
    }

    private static final class Mutable extends PostName.Match {
      Mutable(final Attribute pAttr, final String pPost) {
        super(pAttr, pPost);
      }

      @Override
      public boolean isMutable() {
        return true;
      }
    }

    private static final class Immutable extends PostName.Match {
      Immutable(final Attribute pAttr, final String pPost) {
        super(pAttr, pPost);
      }

      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }

  /**
   * Generated pattern matcher API of the c2r.version2.postName pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * // helper
   * pattern postName(attr: Attribute, post: java String){
   * 	// MODEL_NAVIGATION
   * 	Attribute.type(attr, type);
   * 	// MODEL_NAVIGATION
   * 	Class(type);
   * 	// Transformation
   * 	post == "Id";
   * // transformation
   * } or {
   * 	// MODEL_NAVIGATION
   * 	Attribute.type(attr, type);
   * 	// MODEL_NAVIGATION
   * 	DataType(type);
   * 	// transformation 
   * 	post == "";
   * }
   * </pre></code>
   * 
   * @see Match
   * @see PostName
   * 
   */
  public static class Matcher extends BaseMatcher<PostName.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static PostName.Matcher on(final ViatraQueryEngine engine) {
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
    public static PostName.Matcher create() {
      return new Matcher();
    }

    private static final int POSITION_ATTR = 0;

    private static final int POSITION_POST = 1;

    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(PostName.Matcher.class);

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
     * @param pAttr the fixed value of pattern parameter attr, or null if not bound.
     * @param pPost the fixed value of pattern parameter post, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<PostName.Match> getAllMatches(final Attribute pAttr, final String pPost) {
      return rawStreamAllMatches(new Object[]{pAttr, pPost}).collect(Collectors.toSet());
    }

    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pAttr the fixed value of pattern parameter attr, or null if not bound.
     * @param pPost the fixed value of pattern parameter post, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<PostName.Match> streamAllMatches(final Attribute pAttr, final String pPost) {
      return rawStreamAllMatches(new Object[]{pAttr, pPost});
    }

    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pAttr the fixed value of pattern parameter attr, or null if not bound.
     * @param pPost the fixed value of pattern parameter post, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<PostName.Match> getOneArbitraryMatch(final Attribute pAttr, final String pPost) {
      return rawGetOneArbitraryMatch(new Object[]{pAttr, pPost});
    }

    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pAttr the fixed value of pattern parameter attr, or null if not bound.
     * @param pPost the fixed value of pattern parameter post, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final Attribute pAttr, final String pPost) {
      return rawHasMatch(new Object[]{pAttr, pPost});
    }

    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pAttr the fixed value of pattern parameter attr, or null if not bound.
     * @param pPost the fixed value of pattern parameter post, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final Attribute pAttr, final String pPost) {
      return rawCountMatches(new Object[]{pAttr, pPost});
    }

    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pAttr the fixed value of pattern parameter attr, or null if not bound.
     * @param pPost the fixed value of pattern parameter post, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final Attribute pAttr, final String pPost, final Consumer<? super PostName.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pAttr, pPost}, processor);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pAttr the fixed value of pattern parameter attr, or null if not bound.
     * @param pPost the fixed value of pattern parameter post, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public PostName.Match newMatch(final Attribute pAttr, final String pPost) {
      return PostName.Match.newMatch(pAttr, pPost);
    }

    /**
     * Retrieve the set of values that occur in matches for attr.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Attribute> rawStreamAllValuesOfattr(final Object[] parameters) {
      return rawStreamAllValues(POSITION_ATTR, parameters).map(Attribute.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for attr.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Attribute> getAllValuesOfattr() {
      return rawStreamAllValuesOfattr(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for attr.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Attribute> streamAllValuesOfattr() {
      return rawStreamAllValuesOfattr(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for attr.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Attribute> streamAllValuesOfattr(final PostName.Match partialMatch) {
      return rawStreamAllValuesOfattr(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for attr.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Attribute> streamAllValuesOfattr(final String pPost) {
      return rawStreamAllValuesOfattr(new Object[]{null, pPost});
    }

    /**
     * Retrieve the set of values that occur in matches for attr.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Attribute> getAllValuesOfattr(final PostName.Match partialMatch) {
      return rawStreamAllValuesOfattr(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for attr.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Attribute> getAllValuesOfattr(final String pPost) {
      return rawStreamAllValuesOfattr(new Object[]{null, pPost}).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for post.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<String> rawStreamAllValuesOfpost(final Object[] parameters) {
      return rawStreamAllValues(POSITION_POST, parameters).map(String.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for post.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOfpost() {
      return rawStreamAllValuesOfpost(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for post.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<String> streamAllValuesOfpost() {
      return rawStreamAllValuesOfpost(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for post.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<String> streamAllValuesOfpost(final PostName.Match partialMatch) {
      return rawStreamAllValuesOfpost(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for post.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<String> streamAllValuesOfpost(final Attribute pAttr) {
      return rawStreamAllValuesOfpost(new Object[]{pAttr, null});
    }

    /**
     * Retrieve the set of values that occur in matches for post.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOfpost(final PostName.Match partialMatch) {
      return rawStreamAllValuesOfpost(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for post.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOfpost(final Attribute pAttr) {
      return rawStreamAllValuesOfpost(new Object[]{pAttr, null}).collect(Collectors.toSet());
    }

    @Override
    protected PostName.Match tupleToMatch(final Tuple t) {
      try {
          return PostName.Match.newMatch((Attribute) t.get(POSITION_ATTR), (String) t.get(POSITION_POST));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }

    @Override
    protected PostName.Match arrayToMatch(final Object[] match) {
      try {
          return PostName.Match.newMatch((Attribute) match[POSITION_ATTR], (String) match[POSITION_POST]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }

    @Override
    protected PostName.Match arrayToMatchMutable(final Object[] match) {
      try {
          return PostName.Match.newMutableMatch((Attribute) match[POSITION_ATTR], (String) match[POSITION_POST]);
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
    public static IQuerySpecification<PostName.Matcher> querySpecification() {
      return PostName.instance();
    }
  }

  private PostName() {
    super(GeneratedPQuery.INSTANCE);
  }

  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static PostName instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }

  @Override
  protected PostName.Matcher instantiate(final ViatraQueryEngine engine) {
    return PostName.Matcher.on(engine);
  }

  @Override
  public PostName.Matcher instantiate() {
    return PostName.Matcher.create();
  }

  @Override
  public PostName.Match newEmptyMatch() {
    return PostName.Match.newEmptyMatch();
  }

  @Override
  public PostName.Match newMatch(final Object... parameters) {
    return PostName.Match.newMatch((class_.Attribute) parameters[0], (java.lang.String) parameters[1]);
  }

  /**
   * Inner class allowing the singleton instance of {@link PostName} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link PostName#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final PostName INSTANCE = new PostName();

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
    private static final PostName.GeneratedPQuery INSTANCE = new GeneratedPQuery();

    private final PParameter parameter_attr = new PParameter("attr", "class_.Attribute", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("Class", "Attribute")), PParameterDirection.INOUT);

    private final PParameter parameter_post = new PParameter("post", "java.lang.String", new JavaTransitiveInstancesKey(java.lang.String.class), PParameterDirection.INOUT);

    private final List<PParameter> parameters = Arrays.asList(parameter_attr, parameter_post);

    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }

    @Override
    public String getFullyQualifiedName() {
      return "c2r.version2.postName";
    }

    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("attr","post");
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
          PVariable var_attr = body.getOrCreateVariableByName("attr");
          PVariable var_post = body.getOrCreateVariableByName("post");
          PVariable var_type = body.getOrCreateVariableByName("type");
          new TypeConstraint(body, Tuples.flatTupleOf(var_attr), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Class", "Attribute")));
          new TypeFilterConstraint(body, Tuples.flatTupleOf(var_post), new JavaTransitiveInstancesKey(java.lang.String.class));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_attr, parameter_attr),
             new ExportedParameter(body, var_post, parameter_post)
          ));
          // 	// MODEL_NAVIGATION	Attribute.type(attr, type)
          new TypeConstraint(body, Tuples.flatTupleOf(var_attr), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Class", "Attribute")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_attr, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("Class", "Attribute", "type")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Class", "Classifier")));
          new Equality(body, var__virtual_0_, var_type);
          // 	// MODEL_NAVIGATION	Class(type)
          new TypeConstraint(body, Tuples.flatTupleOf(var_type), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Class", "Class")));
          // 	// Transformation	post == "Id"
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new ConstantValue(body, var__virtual_1_, "Id");
          new Equality(body, var_post, var__virtual_1_);
          bodies.add(body);
      }
      {
          PBody body = new PBody(this);
          PVariable var_attr = body.getOrCreateVariableByName("attr");
          PVariable var_post = body.getOrCreateVariableByName("post");
          PVariable var_type = body.getOrCreateVariableByName("type");
          new TypeConstraint(body, Tuples.flatTupleOf(var_attr), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Class", "Attribute")));
          new TypeFilterConstraint(body, Tuples.flatTupleOf(var_post), new JavaTransitiveInstancesKey(java.lang.String.class));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_attr, parameter_attr),
             new ExportedParameter(body, var_post, parameter_post)
          ));
          // 	// MODEL_NAVIGATION	Attribute.type(attr, type)
          new TypeConstraint(body, Tuples.flatTupleOf(var_attr), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Class", "Attribute")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_attr, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("Class", "Attribute", "type")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Class", "Classifier")));
          new Equality(body, var__virtual_0_, var_type);
          // 	// MODEL_NAVIGATION	DataType(type)
          new TypeConstraint(body, Tuples.flatTupleOf(var_type), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Class", "DataType")));
          // 	// transformation 	post == ""
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new ConstantValue(body, var__virtual_1_, "");
          new Equality(body, var_post, var__virtual_1_);
          bodies.add(body);
      }
      return bodies;
    }
  }
}
