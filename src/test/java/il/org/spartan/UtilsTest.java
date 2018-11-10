package il.org.spartan;

import static org.junit.Assert.*;

import static fluent.ly.azzert.*;

import java.io.*;
import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import fluent.ly.*;
import static il.org.spartan.Utils.*;

/** A static nested class hosting unit tests for the nesting class Unit test for
 * the containing class. Note the naming convention: a) names of test methods do
 * not use are not prefixed by "test". This prefix is redundant. b) test methods
 * begin with the name of the method they check.
 * @author Yossi Gil
 * @since 2014-05-31 */
@SuppressWarnings("static-method") public class UtilsTest {
  @NotNull @SuppressWarnings("null") public static Integer[] intToIntegers(final int... is) {
    final Integer @NotNull [] $ = new Integer @NotNull [is.length];
    for (int ¢ = 0; ¢ < is.length; ++¢)
      $[¢] = fluent.ly.box.it(is[¢]);
    return $;
  }


  @Test @SuppressWarnings({"unchecked", "null"}) public void addAllTypical() {
    final Set<String> ss = new HashSet<>();
    accumulate.to(ss).addAll(as.set("A", "B"), null, as.set("B", "C", "D"));
    azzert.nay(ss.contains("E"));
    azzert.nay(ss.contains(null));
    azzert.that(ss.size(), is(4));
    for (final @NotNull String ¢ : ss)
      azzert.aye("", ss.contains(¢));
  }

  @Test @SuppressWarnings("null") public void addTypical() {
    final Set<String> ss = new HashSet<>();
    accumulate.to(ss).add(null, "A", null, "B", "B", null, "C", "D", null);
    azzert.nay(ss.contains("E"));
    azzert.nay(ss.contains(null));
    azzert.that(ss.size(), is(4));
    for (final @NotNull String ¢ : ss)
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

  @Test @SuppressWarnings("null") public void swapDegenerate() {
    final @NotNull String @NotNull [] ss = as.array("A", "B", "C", "D");
    swap(ss, 1, 1);
    assertArrayEquals(as.array("A", "B", "C", "D"), ss);
  }

  @Test @SuppressWarnings("null") public void swapTypical() {
    final @NotNull String @NotNull [] ss = as.array("A", "B", "C", "D");
    swap(ss, 1, 2);
    assertArrayEquals(as.array("A", "C", "B", "D"), ss);
  }

  @Test @SuppressWarnings("null") public void swapTypicalCase() {
    final Integer @NotNull [] $ = intToIntegers(29, 1, 60);
    swap($, 0, 1);
    assertArrayEquals(intToIntegers(1, 29, 60), $);
  }
  
  @Test public void prepend() {
    StringBuilder s = Utils.prepend(new StringBuilder(), 'c');
    azzert.that(s.charAt(0), azzert.is('c'));
    s = Utils.prepend(s, "str");
    azzert.that(s.charAt(0), azzert.is('s'));
  }
  
  @Test public void quoteTest() {
    azzert.that(Utils.quote("abc"),azzert.is("'abc'"));
    azzert.that(Utils.quote(null),azzert.is("<null reference>"));
  }
  
  @Test public void remove() {
    ArrayList<Integer> a = new ArrayList<>();
    Integer x3 = Integer.valueOf(2);
    a.add(Integer.valueOf(2));
    a.add(x3);
    Utils.removeDuplicates(a);
    azzert.that(a.size(),azzert.is(1));
    azzert.that(Utils.removePrefix("abc", "ab"),azzert.is("c"));
    azzert.that(Utils.removeSuffix("abc", "c"),azzert.is("ab"));
    azzert.that(Utils.removeWhites("abc def "),azzert.is("abcdef"));
  }
  
  @Test public void sort() {
    int[] arr = Utils.sort(new int[] { 15, 2, 6 });
    azzert.that(arr[0], is(2));
    azzert.that(arr[1],is(6));
    azzert.that(arr[2],is(15));
  }
  
  @Test public void sqr() {
    azzert.that(Utils.sqr(4.0),azzert.is(16.0));
  }
  
  @Test public void suffixedBy() {
    File f = new File("file1"), g = new File("file2");
    ArrayList<String> slist = new ArrayList<>();
    slist.add("suf1");
    slist.add("e1");
    azzert.aye(Utils.suffixedBy(f, slist));
    azzert.nay(Utils.suffixedBy(g, slist));
    azzert.aye(Utils.suffixedBy(g, "e2"));
    azzert.nay(Utils.suffixedBy("file1", "e2"));
  }
  
  @Test public void nameTest() {
    azzert.that(Utils.name(new File("abc")) ,azzert.is("abc"));
  }
 
}
