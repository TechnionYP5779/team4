package il.org.spartan.utils;

import static fluent.ly.azzert.*;

import il.org.spartan.utils.Tab;
import org.jetbrains.annotations.*;
import org.junit.*;

import fluent.ly.*;

/** A JUnit test class for the enclosing class.
 * @author Yossi Gil, the Technion.
 * @since 05/08/2008 */
@SuppressWarnings({ "static-method", "null" }) public class TabTest {
  @NotNull private static String cat(final @NotNull String s1, final @NotNull String s2) {
    return "[[" + s1 + "]][[" + s2 + "]]";
  }

  @Test public void emptyContent() {
    azzert.that(new Tab("abc") + "", is(""));
  }

  @Test public void emptyFalse() {
    final @NotNull Tab t = new Tab("abc");
    t.more();
    assertFalse(t.isEmpty());
  }

  @Test public void emtpyTrue() {
    assertTrue(new Tab().isEmpty());
  }

  @Test public void testBeginAtLevelOne() {
    final @NotNull Tab t = new Tab("abc");
    t.more();
    azzert.that(cat(t.begin(), t + ""), is(cat("abc", "abcabc")));
  }

  @Test public void testBeginAtZero() {
    final @NotNull Tab t = new Tab("abc");
    azzert.that(cat(t.begin(), t + ""), is(cat("", "abc")));
  }

  @Test(expected = ___.Bug.Contract.Precondition.class) //
  public void testDecrementFailsWhenDone() {
    new Tab("abc").less();
  }

  @Test public void testDone() {
    assertTrue(new Tab().isEmpty());
  }

  @Test public void testEndAtLevelOne() {
    final @NotNull Tab t = new Tab("abc");
    t.more();
    azzert.that(cat(t.end(), t + ""), is(cat("", "")));
  }

  @Test public void testEndAtLevelTwo() {
    final @NotNull Tab t = new Tab("abc");
    t.more();
    t.more();
    azzert.that(cat(t.end(), t + ""), is(cat("abc", "abc")));
  }

  @Test(expected = ___.Bug.Contract.Precondition.class) //
  public void testEndAtLevelZero() {
    final @NotNull Tab t = new Tab("abc");
    azzert.that(cat(t.end(), t + ""), is(cat("", "")));
  }

  @Test public void testOneMore() {
    final @NotNull Tab t = new Tab("abc");
    t.more();
    azzert.that(t + "", is("abc"));
  }

  @Test public void testOneMoreOneLess() {
    final @NotNull Tab t = new Tab("abc");
    t.more();
    t.less();
    azzert.that(t + "", is(""));
  }

  @Test public void testTwoMore() {
    final @NotNull Tab t = new Tab("abc");
    t.more();
    t.more();
    azzert.that(t + "", is("abcabc"));
  }

  @Test public void testTwoMoreOneLess() {
    final @NotNull Tab t = new Tab("abc");
    t.more();
    t.more();
    t.less();
    azzert.that(t + "", is("abc"));
  }

  @Test public void testTwoMoreTwoLessOneMore() {
    final @NotNull Tab t = new Tab("abc");
    t.more();
    t.more();
    t.less();
    t.less();
    t.more();
    azzert.that(t + "", is("abc"));
  }

  @Test public void testTwoMoreTwoLessTwoMore() {
    final @NotNull Tab t = new Tab("abc");
    t.more();
    t.more();
    t.less();
    t.less();
    t.more();
    t.more();
    azzert.that(t + "", is("abcabc"));
  }
}
