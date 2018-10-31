// <a href=http://ssdl-linux.cs.technion.ac.il/wiki/index.php>SSDLPedia</a>
package il.org.spartan.utils;

import static fluent.ly.___.*;
import static fluent.ly.azzert.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import fluent.ly.*;

/** Prefix text with varying indentation level. Class can be used for an
 * indented printout of a hierarchical tree data structure, e.g.,:
 *
 * <pre>
 * void printTree(TreeNode t) {
 *   printTree(new Tab(), t);
 * }
 *
 * void printTree(Tab tab, TreeNode t) {
 *   System.out.println(tab + &quot;Node: &quot; + t.data);
 *   tab.more();
 *   printTree(tab, t.left);
 *   printTree(tab, t.right);
 *   tab.less();
 * }
 * </pre>
 *
 * @author Adrian Kuhn
 * @since August 4th, 2008 */
@SuppressWarnings("null") public class Tab {
  /** What to add before each indented line of text? */
  private String indentation = "";
  @NotNull public final String tab;

  /** Instantiate this class with the default <code>'\t'</code> tabulation
   * character. */
  public Tab() {
    this("\t");
  }

  /** Instantiate this class with a specified tabulation {@link String}.
   * @param tab a {@link String} by which indentation should be increased at each
   *            {@link #more()} action. */
  public Tab(final @NotNull String tab) {
    this.tab = tab;
  }

  /** Increase indentation but returns the previous tabulation string.
   * @return the previous tabulation string. */
  public String begin() {
    final @NotNull String $ = toString();
    more();
    return $;
  }

  /** Decrease indentation level and returns the new tabulation string.
   * @return the new tabulation string. */
  public String end() {
    less();
    return toString();
  }

  /** Determine whether backward tabbing is not possible any more.
   * @return <code><b>true</b></code> <i>iff</i> if this instance cannot provide
   *         any lesser indentation. */
  public boolean isEmpty() {
    return indentation.length() == 0;
  }

  /** Decrease indentation level. */
  public void less() {
    require(!isEmpty());
    indentation = indentation.substring(0, indentation.length() - tab.length());
  }

  /** Send a formatted, indented by this instance, line to {@link System#out}.
   * @param format A format string as described in {@link PrintStream#printf}.
   *               This format string should not include the terminating
   *               <code>'\n'</code> character.
   * @param os     Arguments, referenced by the format specifiers in the format
   *               string */
  public void linef(final @NotNull String format, final Object... os) {
    System.out.printf(toString() + format + "\n", os);
  }

  /** Increase indentation level */
  public void more() {
    indentation += tab;
  }

  /** Send a formatted line, indented by this instance, to {@link System#out}.
   * @param os what to print */
  public void println(final @NotNull Object... os) {
    final @NotNull StringBuilder sb = new StringBuilder();
    for (final Object ¢ : os)
      sb.append(¢);
    System.out.println(toString() + sb);
  }

  /* Provides the actual indentation {@link String}
   *
   * @see java.lang.Object#toString() */
  @Override public String toString() {
    return indentation;
  }

  /** A JUnit test class for the enclosing class.
   * @author Yossi Gil, the Technion.
   * @since 05/08/2008 */
  @SuppressWarnings("static-method") public static class TEST {
    @NotNull private static String cat(final @NotNull String s1, final @NotNull String s2) {
      return "[[" + s1 + "]][[" + s2 + "]]";
    }

    @Test public void emptyContent() {
      azzert.that(new Tab("abc") + "", is(""));
    }

    @Test public void emptyFalse() {
      final @NotNull Tab t = new Tab("abc");
      t.more();
      assert !t.isEmpty();
    }

    @Test public void emtpyTrue() {
      assert new Tab().isEmpty();
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
      assert new Tab().isEmpty();
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
}
