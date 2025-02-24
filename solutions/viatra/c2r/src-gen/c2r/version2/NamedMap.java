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
import org.eclipse.viatra.query.runtime.matchers.context.common.JavaTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.matchers.psystem.IExpressionEvaluator;
import org.eclipse.viatra.query.runtime.matchers.psystem.IValueProvider;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExpressionEvaluation;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.TypeFilterConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.ConstantValue;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameterDirection;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PVisibility;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuple;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuples;
import org.eclipse.viatra.query.runtime.util.ViatraQueryLoggingUtil;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import relational_.Named;

/**
 * A pattern-specific query specification that can instantiate Matcher in a type-safe way.
 * 
 * <p>Original source:
 *         <code> <pre>
 *         ///////////////////
 *         // Property mapping
 *         ///////////////////
 *         
 *         
 *           Determine the names of the mapped objects
 *          
 *         pattern namedMap(named: Named, name: java String){
 *         	//Names for mapped DataTypes
 *         	//NOTE: Integer is not mapped
 *         	DataType.name(dtype,name);
 *         	find traceMapping(dtype,_,0,named);
 *         } or {
 *         	//If a Class if mapped to a Table
 *         	//Table name
 *         	Class(class);
 *         	find traceMapping(class,_,0,named); //Index 0 is the table
 *         	Class.name(class,name);	
 *         } or {
 *         	//If a Class if mapped to a Table
 *         	//Id column name
 *         	Class(class);
 *         	find traceMapping(class,_,1,named); //Index 1 is the id column
 *         	Column(named);
 *         	name == "objectId";	
 *         } or {
 *         	//If an Attribute is mapped to a table
 *         	//Table name
 *         //	Attribute(attr);
 *         	Attribute.multiValued(attr,true);
 *         	find traceMapping(attr,_,0,named); //Index 0 is the table
 *         	Attribute.name(attr, aname);
 *         	Attribute.owner(attr,class);
 *         	Class.name(class,cname);
 *         	name == eval(cname+'_'+aname);
 *         } or {
 *         	//If an Attribute is mapped to a table
 *         	//owner column name
 *         //	Attribute(attr);
 *         	Attribute.multiValued(attr,true);
 *         	find traceMapping(attr,_,1,named); //Index 1 is the id-column
 *         	Attribute.owner(attr,class);
 *         	Class.name(class,cname);
 *         	name == eval(cname.toFirstLower+"Id");
 *         } or {
 *         	//If an Attribute is mapped to a table
 *         	//Value name
 *         //	Attribute(attr);
 *         	Attribute.multiValued(attr,true);
 *         	find traceMapping(attr,_,2,named); //Index 2 is the value column
 *         	Attribute.name(attr,aname);
 *         	find postName(attr,pname);
 *         	name == eval(aname.toFirstLower+pname);
 *         } or {
 *         	//If an Attribute is mapped to a Column
 *         	//Column name
 *         //	Attribute(attr);
 *         	Attribute.multiValued(attr,false);
 *         	find traceMapping(attr,_,0,named);
 *         	Attribute.name(attr, aname);
 *         	find postName(attr,pname);
 *         	name == eval(aname+pname);
 *         }
 * </pre> </code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class NamedMap extends BaseGeneratedEMFQuerySpecification <NamedMap.Matcher> {
  /**
   * Pattern-specific match representation of the c2r.version2.namedMap pattern,
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
    private Named fNamed;

    private String fName;

    private static List <String> parameterNames = makeImmutableList("named", "name");

    private Match(final Named pNamed, final String pName) {
      this.fNamed = pNamed;
      this.fName = pName;
    }

    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "named": return this.fNamed;
          case "name": return this.fName;
          default: return null;
      }
    }

    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fNamed;
          case 1: return this.fName;
          default: return null;
      }
    }

    public Named getNamed() {
      return this.fNamed;
    }

    public String getName() {
      return this.fName;
    }

    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("named".equals(parameterName) ) {
          this.fNamed = (Named) newValue;
          return true;
      }
      if ("name".equals(parameterName) ) {
          this.fName = (String) newValue;
          return true;
      }
      return false;
    }

    public void setNamed(final Named pNamed) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fNamed = pNamed;
    }

    public void setName(final String pName) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fName = pName;
    }

    @Override
    public String patternName() {
      return "c2r.version2.namedMap";
    }

    @Override
    public List <String> parameterNames() {
      return NamedMap.Match.parameterNames;
    }

    @Override
    public Object[] toArray() {
      return new Object[]{fNamed, fName};
    }

    @Override
    public NamedMap.Match toImmutable() {
      return isMutable() ? newMatch(fNamed, fName) : this;
    }

    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"named\"=" + prettyPrintValue(fNamed) + ", ");
      result.append("\"name\"=" + prettyPrintValue(fName));
      return result.toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(fNamed, fName);
    }

    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof NamedMap.Match)) {
          NamedMap.Match other = (NamedMap.Match) obj;
          return Objects.equals(fNamed, other.fNamed) && Objects.equals(fName, other.fName);
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
    public NamedMap specification() {
      return NamedMap.instance();
    }

    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static NamedMap.Match newEmptyMatch() {
      return new Mutable(null, null);
    }

    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pNamed the fixed value of pattern parameter named, or null if not bound.
     * @param pName the fixed value of pattern parameter name, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static NamedMap.Match newMutableMatch(final Named pNamed, final String pName) {
      return new Mutable(pNamed, pName);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pNamed the fixed value of pattern parameter named, or null if not bound.
     * @param pName the fixed value of pattern parameter name, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static NamedMap.Match newMatch(final Named pNamed, final String pName) {
      return new Immutable(pNamed, pName);
    }

    private static final class Mutable extends NamedMap.Match {
      Mutable(final Named pNamed, final String pName) {
        super(pNamed, pName);
      }

      @Override
      public boolean isMutable() {
        return true;
      }
    }

    private static final class Immutable extends NamedMap.Match {
      Immutable(final Named pNamed, final String pName) {
        super(pNamed, pName);
      }

      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }

  /**
   * Generated pattern matcher API of the c2r.version2.namedMap pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code> <pre>
   * ///////////////////
   * // Property mapping
   * ///////////////////
   * 
   * 
   *   Determine the names of the mapped objects
   *  
   * pattern namedMap(named: Named, name: java String){
   * 	//Names for mapped DataTypes
   * 	//NOTE: Integer is not mapped
   * 	DataType.name(dtype,name);
   * 	find traceMapping(dtype,_,0,named);
   * } or {
   * 	//If a Class if mapped to a Table
   * 	//Table name
   * 	Class(class);
   * 	find traceMapping(class,_,0,named); //Index 0 is the table
   * 	Class.name(class,name);	
   * } or {
   * 	//If a Class if mapped to a Table
   * 	//Id column name
   * 	Class(class);
   * 	find traceMapping(class,_,1,named); //Index 1 is the id column
   * 	Column(named);
   * 	name == "objectId";	
   * } or {
   * 	//If an Attribute is mapped to a table
   * 	//Table name
   * //	Attribute(attr);
   * 	Attribute.multiValued(attr,true);
   * 	find traceMapping(attr,_,0,named); //Index 0 is the table
   * 	Attribute.name(attr, aname);
   * 	Attribute.owner(attr,class);
   * 	Class.name(class,cname);
   * 	name == eval(cname+'_'+aname);
   * } or {
   * 	//If an Attribute is mapped to a table
   * 	//owner column name
   * //	Attribute(attr);
   * 	Attribute.multiValued(attr,true);
   * 	find traceMapping(attr,_,1,named); //Index 1 is the id-column
   * 	Attribute.owner(attr,class);
   * 	Class.name(class,cname);
   * 	name == eval(cname.toFirstLower+"Id");
   * } or {
   * 	//If an Attribute is mapped to a table
   * 	//Value name
   * //	Attribute(attr);
   * 	Attribute.multiValued(attr,true);
   * 	find traceMapping(attr,_,2,named); //Index 2 is the value column
   * 	Attribute.name(attr,aname);
   * 	find postName(attr,pname);
   * 	name == eval(aname.toFirstLower+pname);
   * } or {
   * 	//If an Attribute is mapped to a Column
   * 	//Column name
   * //	Attribute(attr);
   * 	Attribute.multiValued(attr,false);
   * 	find traceMapping(attr,_,0,named);
   * 	Attribute.name(attr, aname);
   * 	find postName(attr,pname);
   * 	name == eval(aname+pname);
   * }
   * </pre> </code>
   * 
   * @see Match
   * @see NamedMap
   * 
   */
  public static class Matcher extends BaseMatcher <NamedMap.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static NamedMap.Matcher on(final ViatraQueryEngine engine) {
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
    public static NamedMap.Matcher create() {
      return new Matcher();
    }

    private static final int POSITION_NAMED = 0;

    private static final int POSITION_NAME = 1;

    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(NamedMap.Matcher.class);

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
     * @param pName the fixed value of pattern parameter name, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection <NamedMap.Match> getAllMatches(final Named pNamed, final String pName) {
      return rawStreamAllMatches(new Object[]{pNamed, pName}).collect(Collectors.toSet());
    }

    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE </strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined </strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pNamed the fixed value of pattern parameter named, or null if not bound.
     * @param pName the fixed value of pattern parameter name, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream <NamedMap.Match> streamAllMatches(final Named pNamed, final String pName) {
      return rawStreamAllMatches(new Object[]{pNamed, pName});
    }

    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pNamed the fixed value of pattern parameter named, or null if not bound.
     * @param pName the fixed value of pattern parameter name, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional <NamedMap.Match> getOneArbitraryMatch(final Named pNamed, final String pName) {
      return rawGetOneArbitraryMatch(new Object[]{pNamed, pName});
    }

    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pNamed the fixed value of pattern parameter named, or null if not bound.
     * @param pName the fixed value of pattern parameter name, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final Named pNamed, final String pName) {
      return rawHasMatch(new Object[]{pNamed, pName});
    }

    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pNamed the fixed value of pattern parameter named, or null if not bound.
     * @param pName the fixed value of pattern parameter name, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final Named pNamed, final String pName) {
      return rawCountMatches(new Object[]{pNamed, pName});
    }

    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pNamed the fixed value of pattern parameter named, or null if not bound.
     * @param pName the fixed value of pattern parameter name, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final Named pNamed, final String pName, final Consumer <? super NamedMap.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pNamed, pName}, processor);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pNamed the fixed value of pattern parameter named, or null if not bound.
     * @param pName the fixed value of pattern parameter name, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public NamedMap.Match newMatch(final Named pNamed, final String pName) {
      return NamedMap.Match.newMatch(pNamed, pName);
    }

    /**
     * Retrieve the set of values that occur in matches for named.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream <Named> rawStreamAllValuesOfnamed(final Object[] parameters) {
      return rawStreamAllValues(POSITION_NAMED, parameters).map(Named.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for named.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set <Named> getAllValuesOfnamed() {
      return rawStreamAllValuesOfnamed(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for named.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream <Named> streamAllValuesOfnamed() {
      return rawStreamAllValuesOfnamed(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for named.
     * </p>
     * <strong>NOTE </strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined </strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream <Named> streamAllValuesOfnamed(final NamedMap.Match partialMatch) {
      return rawStreamAllValuesOfnamed(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for named.
     * </p>
     * <strong>NOTE </strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined </strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream <Named> streamAllValuesOfnamed(final String pName) {
      return rawStreamAllValuesOfnamed(new Object[]{null, pName});
    }

    /**
     * Retrieve the set of values that occur in matches for named.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set <Named> getAllValuesOfnamed(final NamedMap.Match partialMatch) {
      return rawStreamAllValuesOfnamed(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for named.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set <Named> getAllValuesOfnamed(final String pName) {
      return rawStreamAllValuesOfnamed(new Object[]{null, pName}).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for name.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream <String> rawStreamAllValuesOfname(final Object[] parameters) {
      return rawStreamAllValues(POSITION_NAME, parameters).map(String.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for name.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set <String> getAllValuesOfname() {
      return rawStreamAllValuesOfname(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for name.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream <String> streamAllValuesOfname() {
      return rawStreamAllValuesOfname(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for name.
     * </p>
     * <strong>NOTE </strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined </strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream <String> streamAllValuesOfname(final NamedMap.Match partialMatch) {
      return rawStreamAllValuesOfname(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for name.
     * </p>
     * <strong>NOTE </strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined </strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream <String> streamAllValuesOfname(final Named pNamed) {
      return rawStreamAllValuesOfname(new Object[]{pNamed, null});
    }

    /**
     * Retrieve the set of values that occur in matches for name.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set <String> getAllValuesOfname(final NamedMap.Match partialMatch) {
      return rawStreamAllValuesOfname(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for name.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set <String> getAllValuesOfname(final Named pNamed) {
      return rawStreamAllValuesOfname(new Object[]{pNamed, null}).collect(Collectors.toSet());
    }

    @Override
    protected NamedMap.Match tupleToMatch(final Tuple t) {
      try {
          return NamedMap.Match.newMatch((Named) t.get(POSITION_NAMED), (String) t.get(POSITION_NAME));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }

    @Override
    protected NamedMap.Match arrayToMatch(final Object[] match) {
      try {
          return NamedMap.Match.newMatch((Named) match[POSITION_NAMED], (String) match[POSITION_NAME]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }

    @Override
    protected NamedMap.Match arrayToMatchMutable(final Object[] match) {
      try {
          return NamedMap.Match.newMutableMatch((Named) match[POSITION_NAMED], (String) match[POSITION_NAME]);
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
    public static IQuerySpecification <NamedMap.Matcher> querySpecification() {
      return NamedMap.instance();
    }
  }

  private NamedMap() {
    super(GeneratedPQuery.INSTANCE);
  }

  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static NamedMap instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }

  @Override
  protected NamedMap.Matcher instantiate(final ViatraQueryEngine engine) {
    return NamedMap.Matcher.on(engine);
  }

  @Override
  public NamedMap.Matcher instantiate() {
    return NamedMap.Matcher.create();
  }

  @Override
  public NamedMap.Match newEmptyMatch() {
    return NamedMap.Match.newEmptyMatch();
  }

  @Override
  public NamedMap.Match newMatch(final Object... parameters) {
    return NamedMap.Match.newMatch((relational_.Named) parameters[0], (java.lang.String) parameters[1]);
  }

  /**
   * Inner class allowing the singleton instance of {@link NamedMap} to be created 
   *     <b>not </b> at the class load time of the outer class, 
   *     but rather at the first call to {@link NamedMap#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final NamedMap INSTANCE = new NamedMap();

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
    private static final NamedMap.GeneratedPQuery INSTANCE = new GeneratedPQuery();

    private final PParameter parameter_named = new PParameter("named", "relational_.Named", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("Relational", "Named")), PParameterDirection.INOUT);

    private final PParameter parameter_name = new PParameter("name", "java.lang.String", new JavaTransitiveInstancesKey(java.lang.String.class), PParameterDirection.INOUT);

    private final List <PParameter> parameters = Arrays.asList(parameter_named, parameter_name);

    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }

    @Override
    public String getFullyQualifiedName() {
      return "c2r.version2.namedMap";
    }

    @Override
    public List <String> getParameterNames() {
      return Arrays.asList("named","name");
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
          PVariable var_named = body.getOrCreateVariableByName("named");
          PVariable var_name = body.getOrCreateVariableByName("name");
          PVariable var_dtype = body.getOrCreateVariableByName("dtype");
          PVariable var___0_ = body.getOrCreateVariableByName("_ <0>");
          new TypeConstraint(body, Tuples.flatTupleOf(var_named), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Relational", "Named")));
          new TypeFilterConstraint(body, Tuples.flatTupleOf(var_name), new JavaTransitiveInstancesKey(java.lang.String.class));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_named, parameter_named),
             new ExportedParameter(body, var_name, parameter_name)
          ));
          // 	//Names for mapped DataTypes	//NOTE: Integer is not mapped	DataType.name(dtype,name)
          new TypeConstraint(body, Tuples.flatTupleOf(var_dtype), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Class", "DataType")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_dtype, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("Class", "NamedElt", "name")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EString")));
          new Equality(body, var__virtual_0_, var_name);
          // 	find traceMapping(dtype,_,0,named)
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new ConstantValue(body, var__virtual_1_, 0);
          new PositivePatternCall(body, Tuples.flatTupleOf(var_dtype, var___0_, var__virtual_1_, var_named), TraceMapping.instance().getInternalQueryRepresentation());
          bodies.add(body);
      }
      {
          PBody body = new PBody(this);
          PVariable var_named = body.getOrCreateVariableByName("named");
          PVariable var_name = body.getOrCreateVariableByName("name");
          PVariable var_class = body.getOrCreateVariableByName("class");
          PVariable var___0_ = body.getOrCreateVariableByName("_ <0>");
          new TypeConstraint(body, Tuples.flatTupleOf(var_named), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Relational", "Named")));
          new TypeFilterConstraint(body, Tuples.flatTupleOf(var_name), new JavaTransitiveInstancesKey(java.lang.String.class));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_named, parameter_named),
             new ExportedParameter(body, var_name, parameter_name)
          ));
          // 	//If a Class if mapped to a Table	//Table name	Class(class)
          new TypeConstraint(body, Tuples.flatTupleOf(var_class), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Class", "Class")));
          // 	find traceMapping(class,_,0,named)
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new ConstantValue(body, var__virtual_0_, 0);
          new PositivePatternCall(body, Tuples.flatTupleOf(var_class, var___0_, var__virtual_0_, var_named), TraceMapping.instance().getInternalQueryRepresentation());
          //  //Index 0 is the table	Class.name(class,name)
          new TypeConstraint(body, Tuples.flatTupleOf(var_class), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Class", "Class")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_class, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("Class", "NamedElt", "name")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EString")));
          new Equality(body, var__virtual_1_, var_name);
          bodies.add(body);
      }
      {
          PBody body = new PBody(this);
          PVariable var_named = body.getOrCreateVariableByName("named");
          PVariable var_name = body.getOrCreateVariableByName("name");
          PVariable var_class = body.getOrCreateVariableByName("class");
          PVariable var___0_ = body.getOrCreateVariableByName("_ <0>");
          new TypeConstraint(body, Tuples.flatTupleOf(var_named), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Relational", "Named")));
          new TypeFilterConstraint(body, Tuples.flatTupleOf(var_name), new JavaTransitiveInstancesKey(java.lang.String.class));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_named, parameter_named),
             new ExportedParameter(body, var_name, parameter_name)
          ));
          // 	//If a Class if mapped to a Table	//Id column name	Class(class)
          new TypeConstraint(body, Tuples.flatTupleOf(var_class), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Class", "Class")));
          // 	find traceMapping(class,_,1,named)
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new ConstantValue(body, var__virtual_0_, 1);
          new PositivePatternCall(body, Tuples.flatTupleOf(var_class, var___0_, var__virtual_0_, var_named), TraceMapping.instance().getInternalQueryRepresentation());
          //  //Index 1 is the id column	Column(named)
          new TypeConstraint(body, Tuples.flatTupleOf(var_named), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Relational", "Column")));
          // 	name == "objectId"
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new ConstantValue(body, var__virtual_1_, "objectId");
          new Equality(body, var_name, var__virtual_1_);
          bodies.add(body);
      }
      {
          PBody body = new PBody(this);
          PVariable var_named = body.getOrCreateVariableByName("named");
          PVariable var_name = body.getOrCreateVariableByName("name");
          PVariable var_attr = body.getOrCreateVariableByName("attr");
          PVariable var___0_ = body.getOrCreateVariableByName("_ <0>");
          PVariable var_aname = body.getOrCreateVariableByName("aname");
          PVariable var_class = body.getOrCreateVariableByName("class");
          PVariable var_cname = body.getOrCreateVariableByName("cname");
          new TypeConstraint(body, Tuples.flatTupleOf(var_named), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Relational", "Named")));
          new TypeFilterConstraint(body, Tuples.flatTupleOf(var_name), new JavaTransitiveInstancesKey(java.lang.String.class));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_named, parameter_named),
             new ExportedParameter(body, var_name, parameter_name)
          ));
          // 	//If an Attribute is mapped to a table	//Table name//	Attribute(attr);	Attribute.multiValued(attr,true)
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new ConstantValue(body, var__virtual_0_, true);
          new TypeConstraint(body, Tuples.flatTupleOf(var_attr), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Class", "Attribute")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_attr, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("Class", "Attribute", "multiValued")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EBoolean")));
          new Equality(body, var__virtual_1_, var__virtual_0_);
          // 	find traceMapping(attr,_,0,named)
          PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
          new ConstantValue(body, var__virtual_2_, 0);
          new PositivePatternCall(body, Tuples.flatTupleOf(var_attr, var___0_, var__virtual_2_, var_named), TraceMapping.instance().getInternalQueryRepresentation());
          //  //Index 0 is the table	Attribute.name(attr, aname)
          new TypeConstraint(body, Tuples.flatTupleOf(var_attr), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Class", "Attribute")));
          PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_attr, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("Class", "NamedElt", "name")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_3_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EString")));
          new Equality(body, var__virtual_3_, var_aname);
          // 	Attribute.owner(attr,class)
          new TypeConstraint(body, Tuples.flatTupleOf(var_attr), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Class", "Attribute")));
          PVariable var__virtual_4_ = body.getOrCreateVariableByName(".virtual{4}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_attr, var__virtual_4_), new EStructuralFeatureInstancesKey(getFeatureLiteral("Class", "Attribute", "owner")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_4_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Class", "Class")));
          new Equality(body, var__virtual_4_, var_class);
          // 	Class.name(class,cname)
          new TypeConstraint(body, Tuples.flatTupleOf(var_class), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Class", "Class")));
          PVariable var__virtual_5_ = body.getOrCreateVariableByName(".virtual{5}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_class, var__virtual_5_), new EStructuralFeatureInstancesKey(getFeatureLiteral("Class", "NamedElt", "name")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_5_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EString")));
          new Equality(body, var__virtual_5_, var_cname);
          // 	name == eval(cname+'_'+aname)
          PVariable var__virtual_6_ = body.getOrCreateVariableByName(".virtual{6}");
          new ExpressionEvaluation(body, new IExpressionEvaluator() {
          
              @Override
              public String getShortDescription() {
                  return "Expression evaluation from pattern namedMap";
              }
              
              @Override
              public Iterable <String> getInputParameterNames() {
                  return Arrays.asList("aname", "cname");}
          
              @Override
              public Object evaluateExpression(IValueProvider provider) throws Exception {
                  String aname = (String) provider.getValue("aname");
                  String cname = (String) provider.getValue("cname");
                  return evaluateExpression_4_3(aname, cname);
              }
          },  var__virtual_6_ , false);
          new Equality(body, var_name, var__virtual_6_);
          bodies.add(body);
      }
      {
          PBody body = new PBody(this);
          PVariable var_named = body.getOrCreateVariableByName("named");
          PVariable var_name = body.getOrCreateVariableByName("name");
          PVariable var_attr = body.getOrCreateVariableByName("attr");
          PVariable var___0_ = body.getOrCreateVariableByName("_ <0>");
          PVariable var_class = body.getOrCreateVariableByName("class");
          PVariable var_cname = body.getOrCreateVariableByName("cname");
          new TypeConstraint(body, Tuples.flatTupleOf(var_named), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Relational", "Named")));
          new TypeFilterConstraint(body, Tuples.flatTupleOf(var_name), new JavaTransitiveInstancesKey(java.lang.String.class));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_named, parameter_named),
             new ExportedParameter(body, var_name, parameter_name)
          ));
          // 	//If an Attribute is mapped to a table	//owner column name//	Attribute(attr);	Attribute.multiValued(attr,true)
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new ConstantValue(body, var__virtual_0_, true);
          new TypeConstraint(body, Tuples.flatTupleOf(var_attr), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Class", "Attribute")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_attr, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("Class", "Attribute", "multiValued")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EBoolean")));
          new Equality(body, var__virtual_1_, var__virtual_0_);
          // 	find traceMapping(attr,_,1,named)
          PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
          new ConstantValue(body, var__virtual_2_, 1);
          new PositivePatternCall(body, Tuples.flatTupleOf(var_attr, var___0_, var__virtual_2_, var_named), TraceMapping.instance().getInternalQueryRepresentation());
          //  //Index 1 is the id-column	Attribute.owner(attr,class)
          new TypeConstraint(body, Tuples.flatTupleOf(var_attr), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Class", "Attribute")));
          PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_attr, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("Class", "Attribute", "owner")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_3_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Class", "Class")));
          new Equality(body, var__virtual_3_, var_class);
          // 	Class.name(class,cname)
          new TypeConstraint(body, Tuples.flatTupleOf(var_class), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Class", "Class")));
          PVariable var__virtual_4_ = body.getOrCreateVariableByName(".virtual{4}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_class, var__virtual_4_), new EStructuralFeatureInstancesKey(getFeatureLiteral("Class", "NamedElt", "name")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_4_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EString")));
          new Equality(body, var__virtual_4_, var_cname);
          // 	name == eval(cname.toFirstLower+"Id")
          PVariable var__virtual_5_ = body.getOrCreateVariableByName(".virtual{5}");
          new ExpressionEvaluation(body, new IExpressionEvaluator() {
          
              @Override
              public String getShortDescription() {
                  return "Expression evaluation from pattern namedMap";
              }
              
              @Override
              public Iterable <String> getInputParameterNames() {
                  return Arrays.asList("cname");}
          
              @Override
              public Object evaluateExpression(IValueProvider provider) throws Exception {
                  String cname = (String) provider.getValue("cname");
                  return evaluateExpression_5_3(cname);
              }
          },  var__virtual_5_ , false);
          new Equality(body, var_name, var__virtual_5_);
          bodies.add(body);
      }
      {
          PBody body = new PBody(this);
          PVariable var_named = body.getOrCreateVariableByName("named");
          PVariable var_name = body.getOrCreateVariableByName("name");
          PVariable var_attr = body.getOrCreateVariableByName("attr");
          PVariable var___0_ = body.getOrCreateVariableByName("_ <0>");
          PVariable var_aname = body.getOrCreateVariableByName("aname");
          PVariable var_pname = body.getOrCreateVariableByName("pname");
          new TypeConstraint(body, Tuples.flatTupleOf(var_named), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Relational", "Named")));
          new TypeFilterConstraint(body, Tuples.flatTupleOf(var_name), new JavaTransitiveInstancesKey(java.lang.String.class));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_named, parameter_named),
             new ExportedParameter(body, var_name, parameter_name)
          ));
          // 	//If an Attribute is mapped to a table	//Value name//	Attribute(attr);	Attribute.multiValued(attr,true)
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new ConstantValue(body, var__virtual_0_, true);
          new TypeConstraint(body, Tuples.flatTupleOf(var_attr), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Class", "Attribute")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_attr, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("Class", "Attribute", "multiValued")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EBoolean")));
          new Equality(body, var__virtual_1_, var__virtual_0_);
          // 	find traceMapping(attr,_,2,named)
          PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
          new ConstantValue(body, var__virtual_2_, 2);
          new PositivePatternCall(body, Tuples.flatTupleOf(var_attr, var___0_, var__virtual_2_, var_named), TraceMapping.instance().getInternalQueryRepresentation());
          //  //Index 2 is the value column	Attribute.name(attr,aname)
          new TypeConstraint(body, Tuples.flatTupleOf(var_attr), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Class", "Attribute")));
          PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_attr, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("Class", "NamedElt", "name")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_3_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EString")));
          new Equality(body, var__virtual_3_, var_aname);
          // 	find postName(attr,pname)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_attr, var_pname), PostName.instance().getInternalQueryRepresentation());
          // 	name == eval(aname.toFirstLower+pname)
          PVariable var__virtual_4_ = body.getOrCreateVariableByName(".virtual{4}");
          new ExpressionEvaluation(body, new IExpressionEvaluator() {
          
              @Override
              public String getShortDescription() {
                  return "Expression evaluation from pattern namedMap";
              }
              
              @Override
              public Iterable <String> getInputParameterNames() {
                  return Arrays.asList("aname", "pname");}
          
              @Override
              public Object evaluateExpression(IValueProvider provider) throws Exception {
                  String aname = (String) provider.getValue("aname");
                  String pname = (String) provider.getValue("pname");
                  return evaluateExpression_6_3(aname, pname);
              }
          },  var__virtual_4_ , false);
          new Equality(body, var_name, var__virtual_4_);
          bodies.add(body);
      }
      {
          PBody body = new PBody(this);
          PVariable var_named = body.getOrCreateVariableByName("named");
          PVariable var_name = body.getOrCreateVariableByName("name");
          PVariable var_attr = body.getOrCreateVariableByName("attr");
          PVariable var___0_ = body.getOrCreateVariableByName("_ <0>");
          PVariable var_aname = body.getOrCreateVariableByName("aname");
          PVariable var_pname = body.getOrCreateVariableByName("pname");
          new TypeConstraint(body, Tuples.flatTupleOf(var_named), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Relational", "Named")));
          new TypeFilterConstraint(body, Tuples.flatTupleOf(var_name), new JavaTransitiveInstancesKey(java.lang.String.class));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_named, parameter_named),
             new ExportedParameter(body, var_name, parameter_name)
          ));
          // 	//If an Attribute is mapped to a Column	//Column name//	Attribute(attr);	Attribute.multiValued(attr,false)
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new ConstantValue(body, var__virtual_0_, false);
          new TypeConstraint(body, Tuples.flatTupleOf(var_attr), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Class", "Attribute")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_attr, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("Class", "Attribute", "multiValued")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EBoolean")));
          new Equality(body, var__virtual_1_, var__virtual_0_);
          // 	find traceMapping(attr,_,0,named)
          PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
          new ConstantValue(body, var__virtual_2_, 0);
          new PositivePatternCall(body, Tuples.flatTupleOf(var_attr, var___0_, var__virtual_2_, var_named), TraceMapping.instance().getInternalQueryRepresentation());
          // 	Attribute.name(attr, aname)
          new TypeConstraint(body, Tuples.flatTupleOf(var_attr), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("Class", "Attribute")));
          PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_attr, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("Class", "NamedElt", "name")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_3_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EString")));
          new Equality(body, var__virtual_3_, var_aname);
          // 	find postName(attr,pname)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_attr, var_pname), PostName.instance().getInternalQueryRepresentation());
          // 	name == eval(aname+pname)
          PVariable var__virtual_4_ = body.getOrCreateVariableByName(".virtual{4}");
          new ExpressionEvaluation(body, new IExpressionEvaluator() {
          
              @Override
              public String getShortDescription() {
                  return "Expression evaluation from pattern namedMap";
              }
              
              @Override
              public Iterable <String> getInputParameterNames() {
                  return Arrays.asList("aname", "pname");}
          
              @Override
              public Object evaluateExpression(IValueProvider provider) throws Exception {
                  String aname = (String) provider.getValue("aname");
                  String pname = (String) provider.getValue("pname");
                  return evaluateExpression_7_3(aname, pname);
              }
          },  var__virtual_4_ , false);
          new Equality(body, var_name, var__virtual_4_);
          bodies.add(body);
      }
      return bodies;
    }
  }

  private static int evaluateExpression_1_1() {
    return 0;
  }

  private static int evaluateExpression_2_1() {
    return 0;
  }

  private static int evaluateExpression_3_1() {
    return 1;
  }

  private static boolean evaluateExpression_4_1() {
    return true;
  }

  private static int evaluateExpression_4_2() {
    return 0;
  }

  private static String evaluateExpression_4_3(final String aname, final String cname) {
    return ((cname + "_") + aname);
  }

  private static boolean evaluateExpression_5_1() {
    return true;
  }

  private static int evaluateExpression_5_2() {
    return 1;
  }

  private static String evaluateExpression_5_3(final String cname) {
    String _firstLower = StringExtensions.toFirstLower(cname);
    String _plus = (_firstLower + "Id");
    return _plus;
  }

  private static boolean evaluateExpression_6_1() {
    return true;
  }

  private static int evaluateExpression_6_2() {
    return 2;
  }

  private static String evaluateExpression_6_3(final String aname, final String pname) {
    String _firstLower = StringExtensions.toFirstLower(aname);
    String _plus = (_firstLower + pname);
    return _plus;
  }

  private static boolean evaluateExpression_7_1() {
    return false;
  }

  private static int evaluateExpression_7_2() {
    return 0;
  }

  private static String evaluateExpression_7_3(final String aname, final String pname) {
    return (aname + pname);
  }
}
