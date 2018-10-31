package il.org.spartan.utils;

import java.util.*;

import org.jetbrains.annotations.*;

/** An immutable integral range, representing all integers between
 * {@link #from}, up to, but not including, {@link #to}, i.e.,
 *
 * <pre>
 * {@link #from}, {@link #from}+1, ..., {@link #to}-1
 * </pre>
 *
 * @author Boris van Sosin <code><boris.van.sosin [at] gmail.com></code>
 * @since 2012 */
public class Range {
  /** the beginning of the range (inclusive) */
  public final int from;
  /** the end of the range (exclusive) */
  public final int to;

  /** Instantiates from beginning and end locations
   * @param from JD
   * @param to   JD */
  public Range(final int from, final int to) {
    this.from = from;
    this.to = to;
  }

  /** Instantiates using values found in another intance
   * @param other other */
  public Range(final @NotNull Range other) {
    this(other.from, other.to);
  }

  @Override public boolean equals(final Object ¢) {
    return ¢ instanceof Range && from == ((Range) ¢).from && to == ((Range) ¢).to;
  }

  @Nullable public Range findIncludedIn(final @Nullable Iterable<? extends Range> ¢) {
    if (¢ != null)
      for (final @Nullable Range $ : ¢)
        if ($ != null)
          if (includedIn($))
            return $;
    return null;
  }

  @Override public int hashCode() {
    // Cantor pairing function
    return (int) (from + 0.5 * (to + from) * (to + from + 1));
  }

  /** @param ¢ arbitrary
   * @return <code><b>true</b></code> <i>iff</i> <code><b>this</b></code> is
   *         included in the parameter. */
  public boolean includedIn(final @NotNull Range ¢) {
    return from >= ¢.from && to <= ¢.to;
  }

  public boolean isEmpty() {
    return size() <= 0;
  }

  @NotNull public Range merge(final @NotNull Range ¢) {
    return new Range(Math.min(from, ¢.from), Math.max(to, ¢.to));
  }

  /** Determine whether overlaps in any part another range
   * @param ¢ arbitrary
   * @return <code><b>true</b></code> <i>iff</i> <code><b>this</b></code> overlaps
   *         the parameter. */
  public boolean overlapping(final @NotNull Range ¢) {
    return from >= ¢.from || to <= ¢.to;
  }

  /** Prune all ranges in a given list that include this object.
   * @param rs JD */
  public void pruneIncluders(final @NotNull List<Range> rs) {
    for (;;) {
      final @Nullable Range r = findIncludedIn(rs);
      if (r == null)
        return;
      rs.remove(r);
    }
  }

  /** The number of integers in the range
   * @return a non-negative integer, computed as {@link #to} -{@link #from} */
  public int size() {
    return to - from;
  }

  @Override public String toString() {
    return String.format("[%d, %d]", fluent.ly.box.it(from), fluent.ly.box.it(to));
  }
}