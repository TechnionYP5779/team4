/* Part of the "Spartan Blog"; mutate the rest / but leave this line as is */
package fluent.ly;

import static il.org.spartan.Utils.*;

import static fluent.ly.azzert.*;

import java.util.*;
import java.util.stream.*;

import org.jetbrains.annotations.*;
import il.org.spartan.*;

/** A utility class providing library functions that take an array or a
 * collection, and return a {@link String} composed by the elements of this
 * collection, separated by a given {@link String} or <code><b>char</b></code>.
 * @author Yossi Gil
 * @since 07/08/2008 */
@SuppressWarnings("null") public enum separate {
  ;
  @NotNull public static final String COMMA = ",";
  @NotNull public static final String DOT = ".";
  @NotNull public static final String NL = "\n";
  @NotNull public static final String SPACE = " ";

  @NotNull public static String bySpaces(final @NotNull String... $) {
    return separateBySpaces(as.list($));
  }

  /** A simple program demonstrating the use of this class. This program prints a
   * comma separated list of its arguments, where special characters in each
   * argument are escaped prior to printing.
   * @param args list of the command line arguments. */
  public static void main(final @NotNull String[] args) {
    System.out.println("Arguments are: " + separate.these(args).by(", "));
  }

  @NotNull public static String separateBySpaces(final Iterable<String> $) {
    return as.string(separateBySpaces($.iterator()));
  }

  @NotNull public static String separateBySpaces(final @NotNull Iterator<String> s) {
    final @NotNull StringBuilder $ = new StringBuilder();
    for (final @NotNull Separator ¢ = new Separator(SPACE); s.hasNext();)
      $.append(¢).append(s.next());
    return as.string($);
  }

  @NotNull public static SeparationSubject these() {
    return new SeparationSubject(new String[] {});
  }

  @NotNull public static SeparationSubject these(final boolean @NotNull [] ¢) {
    return these(box.it(¢));
  }

  @NotNull public static SeparationSubject these(final byte @NotNull [] ¢) {
    return these(box.it(¢));
  }

  @NotNull public static SeparationSubject these(final char @NotNull [] ¢) {
    return these(box.it(¢));
  }

  @NotNull public static SeparationSubject these(final double @NotNull [] ¢) {
    return these(box.it(¢));
  }

  @NotNull public static SeparationSubject these(final float @NotNull [] ¢) {
    return these(box.it(¢));
  }

  @NotNull public static SeparationSubject these(final Iterable<?> os) {
    return new SeparationSubject(os);
  }

  @NotNull public static SeparationSubject these(final long @NotNull [] ¢) {
    return these(box.it(¢));
  }

  @NotNull public static <Key, Value> SeparationSubject these(final @NotNull Map<Key, Value> ¢) {
    cantBeNull(¢);
    final @NotNull List<Object> $ = ¢.keySet().stream().map(λ -> λ + "->" + ¢.get(λ)).collect(Collectors.toList());
    return new SeparationSubject($);
  }

  @NotNull public static SeparationSubject these(final short @NotNull [] ¢) {
    return these(box.it(¢));
  }

  @SafeVarargs @NotNull public static <T> SeparationSubject these(final T... ¢) {
    return new SeparationSubject(¢);
  }

  static <T> void assertEquals(final @NotNull String reason, final T t1, final T t2) {
    azzert.that(reason, t2, is(t1));
  }

  static <T> void assertEquals(final T t1, final T t2) {
    azzert.that(t2, is(t1));
  }

  static void assertFalse(final boolean ¢) {
    azzert.nay(¢);
  }

  static void assertFalse(final @NotNull String reason, final boolean b) {
    azzert.nay(reason, b);
  }

  static <T> void assertNotEquals(final T t1, final T t2) {
    azzert.that(t2, is(t1));
  }

  static void assertTrue(final boolean ¢) {
    assert ¢;
  }

  static void assertTrue(final @NotNull String reason, final boolean b) {
    azzert.aye(reason, b);
  }

  @NotNull static SeparationSubject these(final int @NotNull [] ¢) {
    return these(box.it(¢));
  }

  /** Auxiliary class for fluent API.
   * @author Yossi Gil <tt>yossi.gil@gmail.com</tt>
   * @since 2016-09-10 */
  public static class SeparationSubject {
    /** Separate elements of a given {@link Iterable} collection by a given
     * {{@link String}}
     * @param ts      an {@link Iterable} collection of elements to be separated
     * @param         <T> type of elements in the {@link Iterable} collection
     *                parameter
     * @param between what should be used for separating these elements
     * @return a {{@link String}} obtained by concatenating the textual
     *         representation of the elements in <code>ts</code> separated by
     *         <code>between</code> */
    @NotNull static <T> String by(final @NotNull Iterable<? extends T> ts, final @NotNull String between) {
      final @NotNull Separator s = new Separator(between);
      final @NotNull StringBuffer $ = new StringBuffer();
      for (final T ¢ : ts)
        $.append(s).append(¢);
      return as.string($);
    }

    /** Separate a list of elements by a given {{@link String}}
     * @param os      what needs to be separated
     * @param between what should be used for separating these elements
     * @return a {{@link String}} obtained by concatenating the textual
     *         representation of the elements in <code>ts</code> separated by
     *         <code>between</code> */
    @NotNull static String separateBy(final @NotNull Iterable<?> os, final @NotNull String between) {
      final @NotNull Separator s = new Separator(between);
      final @NotNull StringBuffer $ = new StringBuffer();
      for (final Object ¢ : os)
        $.append(s).append(¢);
      return as.string($);
    }

    @NotNull static String separateBy(final @NotNull Object[] os, final @NotNull String between) {
      final @NotNull Separator s = new Separator(between);
      final @NotNull StringBuffer $ = new StringBuffer();
      for (final Object ¢ : os)
        $.append(s).append(¢);
      return as.string($);
    }

    public final Iterable<?> os;

    public SeparationSubject(final Iterable<?> os) {
      this.os = os;
    }

    public SeparationSubject(final Object[] os) {
      this.os = as.list(os);
    }

    @NotNull public String by(final char between) {
      return by(between + "");
    }

    @NotNull public String by(final @NotNull String between) {
      return separateBy(os, between);
    }

    @NotNull public String byCommas() {
      return by(COMMA);
    }

    @NotNull public String byDots() {
      return separateBy(prune.whites(as.strings(os)), DOT);
    }

    @NotNull public String byNLs() {
      return separateBy(prune.whites(as.strings(os)), NL);
    }

    @NotNull public String byNothing() {
      return separateBy(prune.whites(as.strings(os)), "");
    }

    @NotNull public String bySpaces() {
      return separateBy(prune.whites(as.strings(os)), SPACE);
    }
  }
}
