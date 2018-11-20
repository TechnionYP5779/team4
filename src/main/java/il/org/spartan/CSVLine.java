// <a href=http://ssdl-linux.cs.technion.ac.il/wiki/index.php>SSDLPedia</a>
package il.org.spartan;

import static fluent.ly.box.*;

import java.util.*;
import java.util.Map.*;

import org.jetbrains.annotations.*;

import fluent.ly.*;
import il.org.spartan.Aggregator.*;
import il.org.spartan.Aggregator.Aggregation.*;
import il.org.spartan.external.*;
import il.org.spartan.streotypes.*;
import il.org.spartan.utils.*;
import il.org.spartan.utils.Separate.*;

/** import static il.org.spartan.utils.Box.*; import
 * il.org.spartan.streotypes.*; import il.org.spartan.statistics.*; import
 * il.org.spartan.utils.*; import static il.org.spartan.utils.Box.*; import
 * java.util.*; import java.util.Map.*; import il.org.spartan.utils.*; /**
 * import java.util.*; import java.util.Map.*; import il.org.spartan.utils.*;
 * /** Create a line in an "Comma Separated Values" format from a sequence of
 * named values.
 * @author Yossi Gil */
@SuppressWarnings("null") public abstract class CSVLine extends AbstractStringProperties implements Cloneable {
  @NotNull public static final String ARRAY_SEPARATOR = ";";
  final Map<String, String> map;
  protected final Aggregator aggregator = new Aggregator();

  /** Instantiate {@link CSVLine}.
   * @param map which implementation should we use for storing values */
  CSVLine(final Map<String, String> map) {
    this.map = map;
  }

  /** Instantiate {@link CSVLine}.
   * @param renderer
   * @param map      which implementation should we use for storing values */
  CSVLine(final Renderer renderer, final Map<String, String> map) {
    super(renderer);
    this.map = map;
  }

  public boolean aggregating() {
    return !aggregator.isEmpty();
  }

  public Iterable<Aggregation> aggregations() {
    return aggregator.aggregations();
  }

  @NotNull public final String asKeyValuePairs() {
    return Separate.by((F<@NotNull Entry<@NotNull String, @NotNull String>>) λ -> λ.getKey() + "=" + λ.getValue(), entries(), ", ");
  }

  public final Iterable<? extends Map.Entry<String, String>> entries() {
    return map.entrySet();
  }

  /** Adds all {@link External} properties in a given object.
   * @param $ an arbitrary object, usually with some of its fields and methods
   *          marked {@link External}
   * @return the parameter */
  public <T> T extract(final T $) {
    for (@NotNull final Entry<String, String> ¢ : External.Introspector.toOrderedMap($).entrySet())
      put(¢.getKey(), ¢.getValue());
    return $;
  }

  @Override public String get(final @NotNull String key) {
    return map.get(key);
  }

  @Override @NotNull public Collection<String> keys() {
    return map.keySet();
  }

  public CSVLine put(final Accumulator ¢) {
    return put(¢.name(), ¢.value());
  }

  public CSVLine put(@NotNull final Accumulator... as) {
    for (@NotNull final Accumulator ¢ : as)
      put(¢);
    return this;
  }

  public CSVLine put(final Enum<?> key, final int value) {
    return put(key + "", value + "");
  }

  public CSVLine put(final Enum<?> key, final @NotNull String value) {
    return put(key + "", value);
  }

  /** Add a key without a value to this instance.
   * @param key The key to be added; must not be <code><b>null</b></code>
   * @return this */
  public final CSVLine put(final @NotNull String key) {
    return put(key, "");
  }

  /** Add a key and a <code><b>boolean</b></code> value to this instance
   * @param key   The key to be added; must not be <code><b>null</b></code>
   * @param value The value associated with the key
   * @return this */
  public final CSVLine put(final @NotNull String key, final boolean value) {
    return put(key, value + "");
  }

  /** Add a key and a <code><b>char</b></code> value to this instance
   * @param key   The key to be added; must not be <code><b>null</b></code>
   * @param value The value associated with the key
   * @return this */
  public final CSVLine put(final @NotNull String key, final char value) {
    return put(key, value + "");
  }

  /** Add a key and a <code><b>double</b><code> value to this instance
                                                   *
                                                   * &#64;param key
                                                   *          The key to be added; must not be <code><b>null</b></code>
   * @param value The value associated with the key
   * @return this */
  public CSVLine put(final @NotNull String key, final double value) {
    return put(key, value, new FormatSpecifier[0]);
  }

  /** Add a key and a <code><b>double</b><code> value to this instance
                                                   *
                                                   * &#64;param key
                                                   *          The key to be added; must not be <code><b>null</b></code>
   * @param value The value associated with the key
   * @param ss    Which (if any) aggregate statistics should be produced for this
   *              column
   * @return this */
  public CSVLine put(final @NotNull String key, final double value, final FormatSpecifier... ss) {
    aggregator.record(key, value, ss);
    return put(key, value + "");
  }

  /** Add a key and a <code><b>double</b><code> value to this instance
                                                   *
                                                   * &#64;param key
                                                   *          The key to be added; must not be <code><b>null</b></code>
   * @param value  The value associated with the key
   * @param format How should the value be formatted
   * @param ss     Which (if any) aggregate statistics should be produced for this
   *               column
   * @return this */
  public CSVLine put(final @NotNull String key, final double value, final @NotNull String format, @NotNull final FormatSpecifier... ss) {
    aggregator.record(key, value, ss);
    ___.sure(ss.length == 0 || aggregating());
    return put(key, String.format(format, it(value)));
  }

  /** Add a key and a general <code><b>float</b><code> value to this instance
                                                   *
                                                   * &#64;param key
                                                   *          The key to be added; must not be <code><b>null</b></code>
   * @param value The value associated with the key
   * @return this */
  public final CSVLine put(final @NotNull String key, final float value) {
    return put(key, value + "");
  }

  /** Add a key and an <code><b>int</b></code> value to this instance
   * @param key   The key to be added; must not be <code><b>null</b></code>
   * @param value The value associated with the key
   * @return this */
  public CSVLine put(final @NotNull String key, final int value) {
    return put(key, value + "");
  }

  /** Add a key and an <code><b>int</b></code> value to this instance
   * @param key    The key to be added; must not be <code><b>null</b></code>
   * @param value  The value associated with the key
   * @param format How should this value be formatted?
   * @param ss     List of aggregations to collect on this column and their
   *               respective formatting
   * @return this */
  public CSVLine put(final @NotNull String key, final int value, final @NotNull String format, @NotNull final FormatSpecifier... ss) {
    aggregator.record(key, value, ss);
    ___.sure(ss.length == 0 || aggregating());
    return put(key, String.format(format, it(value)));
  }

  /** Add a key and a general {@link Object} value to this instance
   * @param key   The key to be added; must not be <code><b>null</b></code>; must
   *              not be <code><b>null</b></code>
   * @param value The value associated with the key
   * @return this */
  public final CSVLine put(final @NotNull String key, @Nullable final Integer value) {
    return value == null ? put(key) : put(key, value + "");
  }

  /** Add a key and a <code><b>long</b></code> value to this instance
   * @param key   The key to be added; must not be <code><b>null</b></code>
   * @param value The value associated with the key
   * @return this */
  public CSVLine put(final @NotNull String key, final long value) {
    return put(key, value + "");
  }

  /** Add a key and a general {@link Object} value to this instance
   * @param key   The key to be added; must not be <code><b>null</b></code>; must
   *              not be <code><b>null</b></code>
   * @param value The value associated with the key
   * @return this */
  public final CSVLine put(final @NotNull String key, @Nullable final Object value) {
    return value == null ? put(key) : put(key, value + "");
  }

  public final CSVLine put(final @NotNull String key, @Nullable final Object a[], final int i) {
    return put(key, a == null || i < 0 || i >= a.length ? null : a[i]);
  }

  public final CSVLine put(final @NotNull String key, @Nullable final Object[] os) {
    return put(key, os == null ? "null" : Separate.by(os, ARRAY_SEPARATOR));
  }

  /** Add a key and a <code><b>short</b></code> value to this instance
   * @param key   The key to be added; must not be <code><b>null</b></code>
   * @param value The value associated with the key
   * @return this */
  public CSVLine put(final @NotNull String key, final short value) {
    return put(key, value + "");
  }

  @Override @NotNull public final CSVLine put(final @NotNull String key, final @NotNull String value) {
    map.put(key, value);
    return this;
  }

  /** A mutator to add a key and a general {@link String} value to this instance
   * @param key   The key to be added; must not be <code><b>null</b></code>
   * @param value The value associated with the key
   * @return this */
  public final CSVLine putAggregatorColumn(final @NotNull String key, final @NotNull String value) {
    aggregator.markColumn(key);
    return put(key, value);
  }

  @Override public int size() {
    return map.size();
  }

  @Override @NotNull public Collection<String> values() {
    return map.values();
  }

  protected void addAggregates(final AbstractStringProperties to, final Aggregation a) {
    aggregator.addAggregates(map.keySet(), to, a);
  }

  @Canopy public static class Ordered extends CSVLine {
    public Ordered() {
      super(new LinkedHashMap<String, String>());
    }

    public Ordered(final Renderer renderer) {
      super(renderer, new LinkedHashMap<String, String>());
    }

    public class Separated extends CSVLine.Ordered {
      @NotNull final String separator;

      public Separated(final @NotNull String separator) {
        this.separator = separator;
      }
    }
  }

  @Canopy public static final class Sorterd extends CSVLine {
    public Sorterd() {
      super(new TreeMap<String, String>());
    }
  }
}
