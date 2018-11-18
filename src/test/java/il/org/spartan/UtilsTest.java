package il.org.spartan;

import static il.org.spartan.Utils.*;

import static fluent.ly.azzert.*;

import java.io.*;
import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import fluent.ly.*;

/** A static nested class hosting unit tests for the nesting class Unit test for
 * the containing class. Note the naming convention: a) names of test methods do
 * not use are not prefixed by "test". This prefix is redundant. b) test methods
 * begin with the name of the method they check.
 * @author Yossi Gil
 * @since 2014-05-31 */
@SuppressWarnings("static-method") public class UtilsTest {
  @NotNull public static Integer[] intToIntegers(final int... is) {
    final @NotNull Integer @NotNull [] $ = new @NotNull Integer @NotNull [is.length];
    for (int ¢ = 0; ¢ < is.length; ++¢)
      $[¢] = fluent.ly.box.it(is[¢]);
    return $;
  }

  @Test @SuppressWarnings("unchecked") public void addAllTypical() {
    final Set<String> ss = new HashSet<>();
    accumulate.to(ss).addAll(as.set("A", "B"), null, as.set("B", "C", "D"));
    azzert.nay(ss.contains("E"));
    azzert.nay(ss.contains(null));
    azzert.that(ss.size(), is(4));
    for (final String ¢ : ss)
      azzert.aye("", ss.contains(¢));
  }

  @Test public void addTypical() {
    final Set<String> ss = new HashSet<>();
    accumulate.to(ss).add(null, "A", null, "B", "B", null, "C", "D", null);
    azzert.nay(ss.contains("E"));
    azzert.nay(ss.contains(null));
    azzert.that(ss.size(), is(4));
    for (final String ¢ : ss)
      azzert.aye("", ss.contains(¢));
    azzert.aye(ss.contains("A"));
  }

  @Test public void cantBeNullOfNull() {
    try {
      cantBeNull(null);
      azzert.fail("AssertionError expected prior to this line.");
    } catch (final AssertionError ¢) {
      forget.it(¢);
      azzert.aye("", true);
    }
  }

  @Test public void cantBeNullTypical() {
    assert cantBeNull(new Object()) != null;
  }

  @Test public void isNullTypical() {
    try {
      isNull(mustBeNull(null));
      azzert.fail("AssertionError expected prior to this line.");
    } catch (final AssertionError ¢) {
      forget.it(¢);
      azzert.aye("", true);
    }
  }

  @Test public void mustBeNullOfNotNull() {
    try {
      mustBeNull(new Object());
      azzert.fail();
    } catch (final AssertionError ¢) {
      forget.it(¢);
      azzert.aye("", true);
    }
  }

  @Test public void quoteEmptyString() {
    azzert.that(idiomatic.quote(""), is("''"));
  }

  @Test public void quoteNull() {
    azzert.that(idiomatic.quote(null), is("<null reference>"));
  }

  @Test public void quoteSimpleString() {
    azzert.that(idiomatic.quote("A"), is("'A'"));
  }

  @Test public void swapDegenerate() {
    final @NotNull String[] ss = as.array("A", "B", "C", "D");
    swap(ss, 1, 1);
    Assert.assertArrayEquals(as.array("A", "B", "C", "D"), ss);
  }

  @Test public void swapTypical() {
    final @NotNull String[] ss = as.array("A", "B", "C", "D");
    swap(ss, 1, 2);
    Assert.assertArrayEquals(as.array("A", "C", "B", "D"), ss);
  }

  @Test public void swapTypicalCase() {
    final @NotNull Integer[] $ = intToIntegers(29, 1, 60);
    swap($, 0, 1);
    azzert.that($[0], is(1));
    azzert.that($[1], is(29));
    azzert.that($[2], is(60));
  }

  @Test public void prepend() {
    StringBuilder s = Utils.prepend(new StringBuilder(), 'c');
    azzert.that(s.charAt(0), is('c'));
    s = Utils.prepend(s, "str");
    azzert.that(s.charAt(0), is('s'));
  }

  @Test public void quoteTest() {
    azzert.that(Utils.quote("abc"), is("'abc'"));
    azzert.that(Utils.quote(null), is("<null reference>"));
  }

  @Test public void remove() {
    final ArrayList<Integer> a = new ArrayList<>();
    final Integer x3 = Integer.valueOf(2);
    a.add(Integer.valueOf(2));
    a.add(x3);
    Utils.removeDuplicates(a);
    azzert.that(a.size(), is(1));
    azzert.that(Utils.removePrefix("abc", "ab"), is("c"));
    azzert.that(Utils.removeSuffix("abc", "c"), is("ab"));
    azzert.that(Utils.removeWhites("abc def "), is("abcdef"));
  }

  @Test public void sort() {
    final int[] arr = Utils.sort(new int[] { 15, 2, 6 });
    azzert.that(arr[0], is(2));
    azzert.that(arr[1], is(6));
    azzert.that(arr[2], is(15));
  }

  @Test public void sqr() {
    azzert.that(Utils.sqr(4.0), is(16.0));
  }

  @Test public void suffixedBy() {
    final File f = new File("file1"), g = new File("file2");
    final ArrayList<String> slist = new ArrayList<>();
    slist.add("suf1");
    slist.add("e1");
    azzert.aye(Utils.suffixedBy(f, slist));
    azzert.nay(Utils.suffixedBy(g, slist));
    azzert.aye(Utils.suffixedBy(g, "e2"));
    azzert.nay(Utils.suffixedBy("file1", "e2"));
  }

  @Test public void nameTest() {
    azzert.that(Utils.name(new File("abc")), is("abc"));
  }

  @Test public void addIterableToCollection() {
    final List<Integer> list1 = new ArrayList<>();
    list1.add(Integer.valueOf(4));
    list1.add(Integer.valueOf(5));
    list1.add(Integer.valueOf(6));
    @NotNull final Collection<Integer> list2 = new ArrayList<>();
    list2.add(Integer.valueOf(1));
    list2.add(Integer.valueOf(2));
    list2.add(Integer.valueOf(3));
    final Collection<Integer> res = Utils.add(list2, list1);
    for (int ¢ = 0; ¢ < 6; ++¢)
      azzert.that(((List<Integer>) res).get(¢), is(¢ + 1));
  }

  @Test public void addValuesToCollection() {
    @NotNull final Collection<Integer> list2 = new ArrayList<>();
    list2.add(Integer.valueOf(1));
    list2.add(Integer.valueOf(2));
    list2.add(Integer.valueOf(3));
    final Collection<Integer> res = Utils.add(list2, Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6));
    for (int ¢ = 0; ¢ < 6; ++¢)
      azzert.that(((List<Integer>) res).get(¢), is(¢ + 1));
  }

  @Test public void addCollectionsToCollection() {
    final List<Integer> list1 = new ArrayList<>();
    list1.add(Integer.valueOf(4));
    list1.add(Integer.valueOf(5));
    list1.add(Integer.valueOf(6));
    final List<Integer> list3 = new ArrayList<>();
    list3.add(Integer.valueOf(7));
    list3.add(Integer.valueOf(8));
    list3.add(Integer.valueOf(9));
    @NotNull final Collection<Integer> list2 = new ArrayList<>();
    list2.add(Integer.valueOf(1));
    list2.add(Integer.valueOf(2));
    list2.add(Integer.valueOf(3));
    final Collection<Integer> res = Utils.addAll(list2, list1, list3);
    for (int ¢ = 0; ¢ < 9; ++¢)
      azzert.that(((List<Integer>) res).get(¢), is(¢ + 1));
  }

  @Test public void addIterablesToCollection() {
    final List<Integer> list1 = new ArrayList<>();
    list1.add(Integer.valueOf(4));
    list1.add(Integer.valueOf(5));
    list1.add(Integer.valueOf(6));
    final List<Integer> list3 = new ArrayList<>();
    list3.add(Integer.valueOf(7));
    list3.add(Integer.valueOf(8));
    list3.add(Integer.valueOf(9));
    @NotNull final Collection<Integer> list2 = new ArrayList<>();
    list2.add(Integer.valueOf(1));
    list2.add(Integer.valueOf(2));
    list2.add(Integer.valueOf(3));
    final Collection<Integer> res = Utils.addAll(list2, (Iterable<Integer>) list1, (Iterable<Integer>) list3);
    for (int ¢ = 0; ¢ < 9; ++¢)
      azzert.that(((List<Integer>) res).get(¢), is(¢ + 1));
  }

  @Test public void addAllElementsToCollection() {
    @NotNull final Collection<Integer> list2 = new ArrayList<>();
    list2.add(Integer.valueOf(1));
    list2.add(Integer.valueOf(2));
    list2.add(Integer.valueOf(3));
    final Collection<Integer> res = Utils.addAll(list2, Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6));
    for (int ¢ = 0; ¢ < 6; ++¢)
      azzert.that(((List<Integer>) res).get(¢), is(¢ + 1));
  }

  @Test public void appendToArray() {
    @SuppressWarnings("null") @NotNull final Integer a[] = { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3) },
        res[] = Utils.append(a, Integer.valueOf(4));
    for (int ¢ = 0; ¢ < 4; ++¢)
      azzert.that(res[¢], is(¢ + 1));
  }

  @Test public void compressingSpaces() {
    azzert.that(Utils.compressSpaces("a        :  (   %   ,   {   }   =   ==   <   <=   -   *   |   &   %   (   )   [^]"),
        is("a:(%,{}===<<=-*|&%()[^]"));
  }

  @Test public void deleteFromArray() {
    @SuppressWarnings("null") @NotNull final Integer a[] = { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3) }, res[] = Utils.delete(a, 1);
    azzert.that(res[0], is(1));
    azzert.that(res[1], is(3));
  }

  @Test public void HasNullTrue() {
    azzert.aye(Utils.hasNull(new Object(), null));
  }

  @Test public void HasNullFalse() {
    azzert.not(Utils.hasNull(new Object(), new Object()));
  }

  @Test public void intIsInTrue() {
    azzert.aye(Utils.intIsIn(1, 1, 2, 3));
  }

  @Test public void intIsInFalse() {
    azzert.not(Utils.intIsIn(5, 1, 2, 3));
  }

  @Test public void foundHandler() {
    final FoundHandleForT<Integer> fh = new Utils.FoundHandleForT<>(Integer.valueOf(1));
    azzert.aye(fh.in(Utils.cantBeNull(Integer.valueOf(1)), Utils.cantBeNull(Integer.valueOf(2)), Utils.cantBeNull(Integer.valueOf(3))));
    azzert.not(fh.in(Utils.cantBeNull(Integer.valueOf(2)), Utils.cantBeNull(Integer.valueOf(3))));
  }

  @Test public void foundHandlerInt() {
    final FoundHandleForT.FoundHandleForInt fh = new Utils.FoundHandleForT.FoundHandleForInt(1);
    azzert.aye(fh.in(1, 2, 3));
    azzert.not(fh.in(2, 3));
  }
}
