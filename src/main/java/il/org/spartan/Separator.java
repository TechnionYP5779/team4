/* Part of the "Spartan Blog"; mutate the rest / but leave this line as is */
package il.org.spartan;

import org.jetbrains.annotations.*;

import fluent.ly.*;

/** A class representing a separator string, which can be used for separating
 * elements of a sequence while printing it, without special case treatment of
 * the first and last element. For example, the following program prints a list
 * of its arguments separated by commas, without using any conditionals.
 *
 * <pre>
 * static void main(String[] args) {
 *   Separator s = new Separator(&quot;, &quot;);
 *   for (String a : args)
 *     System.out.print(s + a);
 * }
 * </pre>
 *
 * @author Yossi Gil
 * @since 12/02/2006) */
public final class Separator {
  /** @param args JD */
  public static void main(final @NotNull String[] args) {
    for (final @NotNull String a : args)
      System.out.print(new Separator(", ") + a);
  }

  /** <code>separateBy</code>
   * @param is      JD
   * @param between what to put between the items
   * @return String value of method <code>separateBy</code> */
  public static String separateBy(final int @NotNull [] is, final @NotNull String between) {
    if (is.length == 0)
      return "";
    @NotNull String $ = "";
    final @NotNull Separator s = new Separator(between);
    for (final int ¢ : is)
      $ += s + (Integer.valueOf(¢) + "");
    return $;
  }

  /** <code>separateBy</code> returning String
   * @param         <T> JD
   * @param between what to put between the items
   * @param ts      JD
   * @return the parameters separated */
  public static <T> String separateBy(final @NotNull String between, final @NotNull T[] ts) {
    return wrap("", "", ts, between);
  }

  /** <code>wrap</code>
   * @param         <T> JD
   * @param wrap    what to wrap the characters with
   * @param ts      JD
   * @param between what to put between the items
   * @return String value of method <code>wrap</code> */
  public static <T> String wrap(final @NotNull String wrap, final Iterable<T> ts, final @NotNull String between) {
    return wrap(wrap, wrap, ts, between);
  }

  /** @param     <T> JD
   * @param begin   what to place before the items
   * @param end     what to place after the items
   * @param ts      JD
   * @param between what to put between the items
   * @return String <code>wrap</code> */
  public static <T> String wrap(final @NotNull String begin, final @NotNull String end, final Iterable<T> ts, final @NotNull String between) {
    if (is.empty(ts))
      return "";
    final @NotNull StringBuilder $ = new StringBuilder(begin);
    final @NotNull Separator s = new Separator(between);
    for (final T ¢ : ts)
      $.append(s).append(¢);
    return as.string($.append(end));
  }

  /** @param     <T> JD
   * @param begin   what to place before the items
   * @param end     what to place after the items
   * @param ts      JD
   * @param between what to put between the items */
  public static <T> String wrap(final @NotNull String begin, final @NotNull String end, final @NotNull T[] ts, final @NotNull String between) {
    if (ts.length == 0)
      return "";
    final @NotNull StringBuilder $ = new StringBuilder(begin);
    final @NotNull Separator s = new Separator(between);
    for (final T ¢ : ts)
      $.append(s).append(¢);
    return as.string($.append(end));
  }

  private boolean first = true;
  @NotNull private final String s;

  /** Instantiates this class.
   * @param c JD */
  public Separator(final char c) {
    this(c + "");
  }

  /** Instantiates this class.
   * @param s JD */
  public Separator(final @NotNull String s) {
    this.s = s;
  }

  @Override public String toString() {
    if (!first)
      return s;
    first = false;
    return "";
  }
}