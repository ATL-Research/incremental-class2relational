/**
 * Generated from platform:/resource/c2r/src/c2r/version2/queries2.vql
 */
package c2r.version2;

import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;

/**
 * A pattern group formed of all public patterns defined in queries2.vql.
 * 
 * <p>Use the static instance as any {@link interface org.eclipse.viatra.query.runtime.api.IQueryGroup}, to conveniently prepare
 * a VIATRA Query engine for matching all patterns originally defined in file queries2.vql,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package c2r.version2, the group contains the definition of the following patterns: <ul>
 * <li>makeInteger </li>
 * <li>fromDataType </li>
 * <li>fromClass </li>
 * <li>fromAttribute2Table </li>
 * <li>fromAttribute2Column </li>
 * <li>namedMap </li>
 * <li>postName </li>
 * <li>traceMapping </li>
 * <li>typeMapping </li>
 * <li>specifiedTypeMapping </li>
 * <li>sourcelessTrace </li>
 * </ul>
 * 
 * @see IQueryGroup
 * 
 */
@SuppressWarnings("all")
public final class Queries2 extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryRuntimeException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static Queries2 instance() {
    if (INSTANCE == null) {
        INSTANCE = new Queries2();
    }
    return INSTANCE;
  }

  private static Queries2 INSTANCE;

  private Queries2() {
    querySpecifications.add(MakeInteger.instance());
    querySpecifications.add(FromDataType.instance());
    querySpecifications.add(FromClass.instance());
    querySpecifications.add(FromAttribute2Table.instance());
    querySpecifications.add(FromAttribute2Column.instance());
    querySpecifications.add(NamedMap.instance());
    querySpecifications.add(PostName.instance());
    querySpecifications.add(TraceMapping.instance());
    querySpecifications.add(TypeMapping.instance());
    querySpecifications.add(SpecifiedTypeMapping.instance());
    querySpecifications.add(SourcelessTrace.instance());
  }

  public MakeInteger getMakeInteger() {
    return MakeInteger.instance();
  }

  public MakeInteger.Matcher getMakeInteger(final ViatraQueryEngine engine) {
    return MakeInteger.Matcher.on(engine);
  }

  public FromDataType getFromDataType() {
    return FromDataType.instance();
  }

  public FromDataType.Matcher getFromDataType(final ViatraQueryEngine engine) {
    return FromDataType.Matcher.on(engine);
  }

  public FromClass getFromClass() {
    return FromClass.instance();
  }

  public FromClass.Matcher getFromClass(final ViatraQueryEngine engine) {
    return FromClass.Matcher.on(engine);
  }

  public FromAttribute2Table getFromAttribute2Table() {
    return FromAttribute2Table.instance();
  }

  public FromAttribute2Table.Matcher getFromAttribute2Table(final ViatraQueryEngine engine) {
    return FromAttribute2Table.Matcher.on(engine);
  }

  public FromAttribute2Column getFromAttribute2Column() {
    return FromAttribute2Column.instance();
  }

  public FromAttribute2Column.Matcher getFromAttribute2Column(final ViatraQueryEngine engine) {
    return FromAttribute2Column.Matcher.on(engine);
  }

  public NamedMap getNamedMap() {
    return NamedMap.instance();
  }

  public NamedMap.Matcher getNamedMap(final ViatraQueryEngine engine) {
    return NamedMap.Matcher.on(engine);
  }

  public PostName getPostName() {
    return PostName.instance();
  }

  public PostName.Matcher getPostName(final ViatraQueryEngine engine) {
    return PostName.Matcher.on(engine);
  }

  public TraceMapping getTraceMapping() {
    return TraceMapping.instance();
  }

  public TraceMapping.Matcher getTraceMapping(final ViatraQueryEngine engine) {
    return TraceMapping.Matcher.on(engine);
  }

  public TypeMapping getTypeMapping() {
    return TypeMapping.instance();
  }

  public TypeMapping.Matcher getTypeMapping(final ViatraQueryEngine engine) {
    return TypeMapping.Matcher.on(engine);
  }

  public SpecifiedTypeMapping getSpecifiedTypeMapping() {
    return SpecifiedTypeMapping.instance();
  }

  public SpecifiedTypeMapping.Matcher getSpecifiedTypeMapping(final ViatraQueryEngine engine) {
    return SpecifiedTypeMapping.Matcher.on(engine);
  }

  public SourcelessTrace getSourcelessTrace() {
    return SourcelessTrace.instance();
  }

  public SourcelessTrace.Matcher getSourcelessTrace(final ViatraQueryEngine engine) {
    return SourcelessTrace.Matcher.on(engine);
  }
}
