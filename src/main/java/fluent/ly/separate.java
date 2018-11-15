/* Part of the "Spartan Blog"; mutate the rest / but leave this line as is */
package fluent.ly;

import static il.org.spartan.Utils.*;

import static fluent.ly.azzert.*;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import an.*;
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

  @NotNull private static SeparationSubject these(final int @NotNull [] ¢) {
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

    @NotNull private static String separateBy(final @NotNull Object[] os, final @NotNull String between) {
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

  @SuppressWarnings({ "static-method", "synthetic-access" }) //
  public static class TEST {
    private static final Function<String, String> quote = λ -> "'" + λ + "'";

    static <T> void assertEquals(final @NotNull String reason, final T t1, final T t2) {
      azzert.that(reason, t2, is(t1));
    }

    @Test public final void asArrayBetweenChar() {
      azzert.that(separate.these(as.array("Hello", "World")).by(','), is("Hello,World"));
    }

    @Test public final void byArrayString() {
      azzert.that(separate.these(new String[] { "Hello", "World" }).by(", "), is("Hello, World"));
    }

    @Test public final void byArrayStringUsingLiterals() {
      azzert.that(separate.these(as.array("Hello", "World")).by(", "), is("Hello, World"));
    }

    @Test public final void byBooleanArrayChar() {
      azzert.that(separate.these(new boolean[] { true, false }).by(':'), is("true:false"));
    }

    @Test public final void byBooleanArrayString() {
      azzert.that(separate.these(new boolean[] { true, false }).by("; "), is("true; false"));
    }

    @Test public final void byByteArrayChar() {
      azzert.that(separate.these(new byte[] { 3, -5 }).by(':'), is("3:-5"));
    }

    @Test public final void byByteArrayString() {
      azzert.that(separate.these(new byte[] { -1, 2 }).by("; "), is("-1; 2"));
    }

    @Test public final void byCharArrayChar() {
      azzert.that(separate.these(new char[] { '3', 'x' }).by(':'), is("3:x"));
    }

    @Test public final void byCharArrayString() {
      azzert.that(separate.these(new char[] { 'a', 'x' }).by("; "), is("a; x"));
    }

    @Test public final void byCommasTypical() {
      azzert.that(separate.these("A", "B", "C").byCommas(), is("A,B,C"));
    }

    @Test public final void byDoubleArrayChar() {
      azzert.that(separate.these(new double[] { 3.3, 4.2 }).by(':'), is("3.3:4.2"));
    }

    @Test public final void byDoubleArrayString() {
      azzert.that(separate.these(new double[] { -1.0, 2.0 }).by("; "), is("-1.0; 2.0"));
    }

    @Test public final void byFloatArrayChar() {
      azzert.that(separate.these(new float[] { 3.3F, 4.2F }).by(':'), is("3.3:4.2"));
    }

    @Test public final void byFloatArrayString() {
      azzert.that(separate.these(new float[] { -1F, 2F }).by("; "), is("-1.0; 2.0"));
    }

    @Test public final void byFOfTIterableOfTChar() {
      azzert.that(separate.these(apply(λ -> "<" + λ + ">").to("A", "B")).by(' '), is("<A> <B>"));
    }

    @Test public final void byFOfTIterableOfTString() {
      azzert.that(separate.these(new Applicator<>(quote).to(as.list("Hello", "World"))).by(", "), is("'Hello', 'World'"));
    }

    @Test public final void byFOfTTArrayChar() {
      final @NotNull Applicator<Object, String> f = new Applicator<>(λ -> "'" + λ + "'");
      azzert.notNull("Function literals should never by null.", f);
      final @NotNull Collection<String> c = as.list("Hello", "World");
      azzert.that(c.size(), is(2));
      final @NotNull Iterable<String> ts = f.to(c);
      azzert.that(count.of(ts), is(2));
      azzert.that(separate.these(ts).by(' '), is("'Hello' 'World'"));
    }

    @Test public final void byFOfTTArrayString() {
      azzert.that(separate.these(apply(quote).to("Hello", "World")).by(", "), is("'Hello', 'World'"));
    }

    @Test public final void byIntArrayChar() {
      azzert.that(separate.these(new int @NotNull [] { 3, 4 }).by(':'), is("3:4"));
    }

    @Test public final void byIntArrayString() {
      azzert.that(separate.these(new int @NotNull [] { -1, 2 }).by("; "), is("-1; 2"));
    }

    @Test public final void byIterableOfChar() {
      azzert.that(separate.these(as.array("Hello", "World")).by(','), is("Hello,World"));
    }

    @Test public final void byIterableOfString() {
      azzert.that(separate.these(as.list("Hello", "World")).by(", "), is("Hello, World"));
    }

    @Test public final void byLongArrayChar() {
      azzert.that(separate.these(new long[] { 3, 4 }).by(':'), is("3:4"));
    }

    @Test public final void byLongArrayString() {
      azzert.that(separate.these(new long[] { -1L, 2L }).by("; "), is("-1; 2"));
    }

    @Test public final void byMapOfKeyValueStringString() {
      final @NotNull Map<String, Integer> map = new TreeMap<>();
      map.put("One", box.it(1));
      map.put("Two", box.it(2));
      map.put("Three", box.it(3));
      map.put("Four", box.it(4));
      azzert.that(separate.these(map).by(", "), is("Four->4, One->1, Three->3, Two->2"));
    }

    @Test public final void byShortArrayChar() {
      azzert.that(separate.these(new short[] { 3, 4 }).by(':'), is("3:4"));
    }

    @Test public final void byShortArrayString() {
      azzert.that(separate.these(new short[] { (short) -1, (short) 2 }).by(": "), is("-1: 2"));
    }

    @Test public final void bySpacesEmptyl() {
      azzert.that(separate.these().bySpaces(), is(""));
    }

    @Test public final void bySpacesLengthLessThan2() {
      assert (separate.these().bySpaces().length() < 2);
    }

    @Test public final void bySpacesLengthLessThan3() {
      assert (separate.these().bySpaces().length() < 3);
    }

    @Test public final void bySpacesTypical() {
      azzert.that(separate.these("A", "B", "C").bySpaces(), is("A B C"));
    }

    @Test public final void byTArrayChar() {
      azzert.that(separate.these(new String[] { "Hello", "World" }).by(','), is("Hello,World"));
    }

    @Test public final void nlIterableOfString() {
      azzert.that(separate.these(as.list("Hello", "World")).byNLs(), is("Hello\nWorld"));
    }

    @Test public final void nlStringArray() {
      azzert.that(separate.these("Hello", "World").byNLs(), is("Hello\nWorld"));
    }

    @Test public final void separateByNoItemslPruneWhitesSpaceSeparated() {
      final @NotNull SeparationSubject these = separate.these();
      azzert.notNull(these);
      final Iterable<?> os = these.os;
      azzert.notNull(os);
      assert(is.empty(os));
      final @NotNull String[] ss = as.strings(os);
      azzert.notNull(ss);
      azzert.zero(ss.length);
      final @NotNull String[] noWhites = prune.whites(ss);
      azzert.zero(noWhites.length);
      azzert.that(SeparationSubject.separateBy(noWhites, " "), is(""));
    }

    @Test public final void separateByNoItemslSpaceSeparated() {
      azzert.that(SeparationSubject.separateBy(separate.these().os, " "), is(""));
    }

    @Test public void separateBySpaceEmpty() {
      azzert.that(bySpaces(), is(""));
    }

    @Test public void separateBySpaceEmptyIterator() {
      azzert.that(separateBySpaces(an.empty.list()), is(""));
    }

    @Test public void separateBySpaceMultipleIterator() {
      azzert.that(separateBySpaces(as.list(new String[] { "X", "Y", "Z" })), is("X Y Z"));
    }

    @Test public void separateBySpaceOnIteator() {
      azzert.that(separateBySpaces(as.list(new String[] { "Hello", "World " })), is("Hello World "));
    }

    @Test public void separateBySpaceOnSingletonIteator() {
      azzert.that(separateBySpaces(iterable.singleton("Hello")), is("Hello"));
    }

    @Test public void separateBySpaceSimple() {
      azzert.that(bySpaces("A"), is("A"));
    }

    @Test public void separateBySpaceSingletonIterator() {
      azzert.that(separateBySpaces(iterable.singleton("X")), is("X"));
    }

    @Test public void separateBySpaceTwoStrings() {
      azzert.that(bySpaces("A", "B"), is("A B"));
    }

    @Test public final void spaceIsSpace() {
      azzert.that(SPACE, is(" "));
    }

    @Test public final void theseArraySize0() {
      azzert.that(count.of(separate.these(as.array()).os), is(0));
    }

    @Test public final void theseArraySize1() {
      azzert.that(count.of(separate.these(as.array("Rosebud")).os), is(1));
    }

    @Test public final void theseArraySize2() {
      azzert.that(count.of(separate.these(as.array("Hello", "World")).os), is(2));
    }

    @Test public final void theseArraySize3() {
      azzert.that(count.of(separate.these(as.array("A", "B", "C")).os), is(3));
    }

    @Test public final void theseFromOneItem() {
      azzert.that(count.of(separate.these(as.list("Rosebud")).os), is(1));
    }

    @Test public final void theseFromThreeItems() {
      azzert.that(count.of(separate.these(as.list("A", "B", "C")).os), is(3));
    }

    @Test public final void theseFromTwoItems() {
      azzert.that(count.of(separate.these(as.list("Hello", "World")).os), is(2));
    }

    @Test public final void theseFromZeroItems() {
      azzert.that(count.of(separate.these(as.list((Double) null)).os), is(0));
    }

    @Test public final void theseOfNoItemsl() {
      assert (is.empty(separate.these(new String[] {}).os));
    }

    @Test public final void theseOfNoItemslSpaceSeparated() {
      azzert.that(separate.these(new String[] {}).bySpaces(), is(""));
    }
  }
}
