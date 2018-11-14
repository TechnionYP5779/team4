package il.org.spartan.utils;

import java.util.*;
import java.util.stream.*;

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
  public int from;
  /** the end of the range (exclusive) */
  public int to;

  /** Instantiates from beginning and end locations
   * @param from JD
   * @param to   JD */
  public Range(final int from, final int to) {
    this.from = from;
    this.to = to;
  }

  public Range() {
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
        if ($ != null && includedIn($))
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

  public class AfterTo extends RangeIterator<AfterTo> {
    public AfterTo from(final int ¢) {
      from = ¢;
      return this;
    }

    public Iterable<Integer> infinite() {
      return Range.infiniteFrom(from, step);
    }

    public AfterTo step(final int ¢) {
      step = ¢;
      return this;
    }

    public Stream<Integer> stream() {
      return StreamSupport.stream(spliterator(), false);
    }

    @Override AfterTo self() {
      return this;
    }
  }

  public class BeforeTo extends RangeIterator<BeforeTo> {
    public Infinite infinite() {
      return Range.infiniteFrom(from, step);
    }

    public AfterTo step(final int ¢) {
      step = ¢;
      return new AfterTo();
    }

    public AfterTo to(final int ¢) {
      to = ¢;
      return new AfterTo();
    }

    @Override public BeforeTo self() {
      return this;
    }
  }

  public class Infinite extends RangeIterator<Infinite> {
    public Infinite from(final int ¢) {
      from = ¢;
      step = 1;
      return this;
    }

    public Iterable<Integer> step(final int ¢) {
      step = ¢;
      return this;
    }

    @Override Infinite self() {
      return this;
    }
  }

  abstract class RangeIterator<Self extends RangeIterator<Self>> implements Iterable<Integer> {
    public final Self exclusive() {
      inclusive = false;
      return self();
    }

    public final Self inclusive() {
      inclusive = true;
      return self();
    }

    public final Self infiniteRange() {
      infinite = true;
      return self();
    }

    @Override public Iterator<Integer> iterator() {
      return new Iterator<Integer>() {
        int next = from;

        @Override public boolean hasNext() {
          return infinite || (inclusive ? next <= to : next < to);
        }

        @Override public Integer next() {
          if (!hasNext())
            throw new NoSuchElementException();
          final int $ = next;
          next += step;
          return Integer.valueOf($);
        }
      };
    }

    abstract Self self();
  }

  public static BeforeTo from(final int ¢) {
    return makeFrom(¢).new BeforeTo();
  }

  public static Infinite infinite() {
    return infiniteFrom(0, 1);
  }

  public static Iterable<Integer> infinite(final int ¢) {
    return from(¢).to(¢).step(0).inclusive();
  }

  public static RangeIterator<?> naturals() {
    return from(0).to(-1).step(1).infiniteRange();
  }

  public static RangeIterator<?> numerals() {
    return from(1).to(-1).step(1).infiniteRange();
  }

  public static RangeIterator<?> odds() {
    return from(1).to(-1).step(2).infiniteRange();
  }

  public static <T> RangeIterator<?> of(final T[] ¢) {
    return from(0).to(¢.length);
  }

  public static AfterTo to(final int to) {
    return makeTo(to).new AfterTo();
  }

  private static Range makeFrom(final int ¢) {
    return new Range() {
      {
        from = ¢;
      }
    };
  }

  private static Range makeTo(final int ¢) {
    return new Range() {
      {
        to = ¢;
      }
    };
  }

  static Infinite infiniteFrom(final int ¢, final int ¢2) {
    final Infinite $ = makeFrom(¢).new Infinite().infiniteRange();
    $.step(¢2);
    return $;
  }

  boolean inclusive;
  boolean infinite;
  int step = 1;
}