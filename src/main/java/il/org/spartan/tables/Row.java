// <a href=http://ssdl-linux.cs.technion.ac.il/wiki/index.php>SSDLPedia</a>
package il.org.spartan.tables;

import java.util.*;

import org.jetbrains.annotations.*;

import fluent.ly.*;
import il.org.spartan.external.*;
import il.org.spartan.utils.*;

/** Represents a row of a {@link Table}
 * @param <Self> uses for fluent API, __ of subclass
 * @author Yossi Gil
 * @since 2017-01-04 */
@SuppressWarnings("null") public abstract class Row<Self extends Row<?>> extends LinkedHashMap<String, Object> {
  private static final long serialVersionUID = 0x5F4CC2841512340L;

  public Row() {
    reset();
  }

  public Self col(final Accumulator ¢) {
    return col(¢.name(), ¢.value());
  }

  public Self col(final Accumulator... ¢) {
    as.list(¢).forEach(this::col);
    return self();
  }

  public Self col(final Enum<?> key, final int value) {
    return col(key + "", value + "");
  }

  public Self col(final Enum<?> key, final @NotNull String value) {
    return col(key + "", value);
  }

  /** Add a key without a value to this instance.
   * @param key The key to be added; must not be {@code null @return {@code
   *            this} */
  public final Self col(final @NotNull String key) {
    return col(key, "");
  }

  /** Add a key and a {@code char} value to this instance
   * @param key The key to be added; must not be {@code null @param value The
   *            value associated with the key @return {@code this} */
  public final Self col(final @NotNull String key, final char value) {
    return col(key, value + "");
  }

  /** Adds a key and a {@code double</b><code> value to this instance &#64;param
      * key The key to be added; must not be {@code null &#64;param value The value
   * associated with the key @return {@code this} */
  public Self col(final @NotNull String key, final double value) {
    return col(key, value + "");
  }

  /** Add a key and an {@code int} value to this instance
   * @param key The key to be added; must not be {@code null @param value The
   *            value associated with the key @return {@code this} */
  public Self col(final @NotNull String key, final int value) {
    return col(key, value + "");
  }

  /** Add a key and a general {@link Object} value to this instance
   * @param key The key to be added; must not be {@code null; must not be
   *        {@code null @param value The value associated with the key @return
   *            {@code this} */
  public final Self col(final @NotNull String key, final Integer value) {
    return value == null ? col(key) : col(key, value.intValue());
  }

  /** Add a key and a {@code long} value to this instance
   * @param key The key to be added; must not be {@code null @param value The
   *            value associated with the key @return {@code this} */
  public Self col(final @NotNull String key, final long value) {
    return col(key, value + "");
  }

  /** Add a key and a non specific {@link Object} value to this instance
   * @param key The key to be added; must not be {@code null; must not be
   *        {@code null @param value The value associated with the key @return
   *            {@code this} */
  public final Self col(final @NotNull String key, final Object value) {
    if (value == null)
      return col(key);
    super.put(key, value);
    return self();
  }

  public final Self col(final @NotNull String key, final Object[] a, final int i) {
    return col(key, a == null || i < 0 || i >= a.length ? null : a[i]);
  }

  public final Self col(final @NotNull String key, final Object... os) {
    return col(key, os == null || os.length == 0 ? null : (Object) os);
  }

  /** A mutator to add a key and a general {@link String} value to this instance
   * @param key The key to be added; must not be {@code null @param value The
   *            value associated with the key @return {@code this} */
  public final Self col(final @NotNull String key, final @NotNull String value) {
    super.put(key, value);
    return self();
  }

  /** Adds all {@link External} properties in a given object.
   * @param t an arbitrary object, usually with some of its fields and methods
   *          marked {@link External}
   * @return the parameter */
  public <T> T extract(final T $) {
    External.Introspector.toOrderedMap($).forEach(this::col);
    return $;
  }

  protected abstract Self reset();

  protected abstract Self self();

  @NotNull public static final String ARRAY_SEPARATOR = "; ";
}
