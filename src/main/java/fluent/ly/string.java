package fluent.ly;

import static fluent.ly.___.*;

import java.io.*;
import java.util.*;

import org.jetbrains.annotations.*;

import il.org.spartan.*;

/** A bunch of string functions.
 * @author Yossi Gil */
public enum string {
  // No elements in this name space
  ;
  static final int MAX_FIRST = 20;
  static final int MAX_LAST = 10;

  public static double atod(final @NotNull String ¢) {
    return Double.parseDouble(¢);
  }

  public static float atof(final @NotNull String ¢) {
    return Float.parseFloat(¢);
  }

  public static int atoi(final @NotNull String ¢) {
    return Integer.parseInt(¢);
  }

  public static long atol(final @NotNull String ¢) {
    return Long.parseLong(¢);
  }

  @NotNull public static String capitalize(final @NotNull String ¢) {
    return ¢.length() == 0 ? ¢ : (first(¢) + "").toUpperCase() + the.rest(¢).toLowerCase();
  }

  @NotNull public static String cat(final @NotNull String... ss) {
    final @NotNull StringBuilder $ = new StringBuilder("");
    for (final @NotNull String ¢ : ss)
      $.append(¢);
    return $ + "";
  }

  @NotNull public static String cat(final @NotNull String[]... sss) {
    final @NotNull StringBuilder $ = new StringBuilder("");
    for (final @NotNull String[] ¢ : sss)
      $.append(cat(¢));
    return $ + "";
  }

  public static double delta(final double a, final double d) {
    return a == d ? 0 : signum(a) != signum(d) ? Double.NaN : 2 * Math.abs(a - d) / Math.abs(a + d);
  }

  @NotNull public static String dtoa(final double ¢) {
    return ¢ + "";
  }

  public static <T> boolean eq(final @Nullable T a, final @Nullable T b) {
    return a == null ? b == null : a.equals(b);
  }

  @NotNull public static String esc(final char ¢) {
    switch (¢) {
      case '\n':
        return "\\n";
      case '\r':
        return "\\r";
      case '\t':
        return "\\t";
      case '\f':
        return "\\f";
      case '\b':
        return "\\b";
      case '\\':
        return "\\\\";
      default:
        return ¢ + "";
    }
  }

  @NotNull public static String esc(final @Nullable String s) {
    if (s == null)
      return "(null)";
    final @NotNull StringBuilder $ = new StringBuilder(s.length());
    for (int ¢ = 0; ¢ < s.length(); ++¢)
      $.append(esc(s.charAt(¢)));
    return $ + "";
  }

  @NotNull public static String expandLeadingTabs(final @NotNull String s) {
    nonnull(s);
    for (@NotNull String $ = s;;) {
      final @NotNull String newValue = Utils.cantBeNull($.replaceAll("(?m)^([\t]*)\t", "$1    "));
      if ($.equals(newValue))
        return $;
      $ = newValue;
    }
  }

  @NotNull public static String fill(final int i, final char c) {
    return fill(i, c + "");
  }

  @NotNull public static String fill(final int i, final @NotNull String s) {
    final @NotNull StringBuilder $ = new StringBuilder();
    for (int ¢ = 0; ¢ < i; ++¢)
      $.append(s);
    return $ + "";
  }

  public static char first(final @NotNull String ¢) {
    nonnull(¢);
    positive(¢.length());
    return ¢.charAt(0);
  }

  @NotNull public static String ftoa(final float ¢) {
    return ¢ + "";
  }

  public static boolean isDouble(final @NotNull String s) {
    try {
      Double.parseDouble(s);
      return true;
    } catch (final NumberFormatException ¢) {
      forget.it(¢);
      return false;
    }
  }

  public static boolean isFloat(final @NotNull String s) {
    try {
      Float.parseFloat(s);
      return true;
    } catch (final NumberFormatException ¢) {
      forget.it(¢);
      return false;
    }
  }

  public static boolean isInt(final @NotNull String s) {
    try {
      Integer.parseInt(s);
      return true;
    } catch (final NumberFormatException ¢) {
      forget.it(¢);
      return false;
    }
  }

  public static boolean isLong(final @NotNull String s) {
    try {
      Long.parseLong(s);
      return true;
    } catch (final NumberFormatException ¢) {
      forget.it(¢);
      return false;
    }
  }

  @NotNull public static String itoa(final int ¢) {
    return ¢ + "";
  }

  @NotNull public static String javaCase(final @NotNull String ¢) {
    return ¢.length() == 0 ? ¢ : (first(¢) + "").toLowerCase() + the.rest(¢);
  }

  public static char last(final @NotNull String ¢) {
    nonnull(¢);
    positive(¢.length());
    return ¢.charAt(¢.length() - 1);
  }

  @NotNull public static String lowCounter(final int ¢) {
    switch (¢) {
      case -1:
        return "";
      case 0:
        return "a";
      default:
        return tolow(¢);
    }
  }

  @NotNull public static String ltoa(final long ¢) {
    return ¢ + "";
  }

  @NotNull public static String ordinal(final int ¢) {
    nonnegative(¢);
    switch (¢ % 10) {
      case 1:
        return ¢ + (¢ == 11 ? "th" : "st");
      case 2:
        return ¢ + (¢ == 12 ? "th" : "nd");
      default:
        return ¢ + "th";
    }
  }

  @NotNull public static String paren(final Object ¢) {
    return "(" + ¢ + ")";
  }

  @NotNull public static String pluralize(final int i, final @NotNull String singular) {
    return pluralize(i, singular, singular + "s");
  }

  @NotNull public static String pluralize(final int i, final @NotNull String singular, final @NotNull String plural) {
    switch (i) {
      case 0:
        return "no " + plural;
      case 1:
        return singular;
      case 2:
        return "two " + plural;
      case 3:
        return "three " + plural;
      case 4:
        return "four " + plural;
      case 5:
        return "five " + plural;
      case 6:
        return "six " + plural;
      case 7:
        return "seven " + plural;
      case 8:
        return "eight " + plural;
      case 9:
        return "nine " + plural;
      default:
        return i + " " + plural;
    }
  }

  @NotNull public static String pretty(final @NotNull String singular, final Collection<?> a) {
    return pretty(singular, singular + "s", a);
  }

  @NotNull public static String pretty(final @NotNull String singular, final @NotNull String plural, final @Nullable Collection<?> a) {
    if (a == null || a.isEmpty())
      return "";
    if (a.size() == 1)
      return "1 " + singular + ": " + a.iterator().next() + "\n";
    @NotNull String $ = a.size() + " " + plural + ":\n";
    int n = 0;
    final @NotNull once ellipsis = new once("\t...\n");
    for (final Object ¢ : a) {
      ++n;
      $ += n > MAX_FIRST && n <= a.size() - MAX_LAST ? ellipsis : "\t" + n + ") " + ¢ + "\n";
    }
    return $;
  }

  @NotNull public static String quote(final Object ¢) {
    return wrap('\'', ¢ + "");
  }

  @NotNull public static String repeat(final int i, final char c) {
    return repeat(i, c + "");
  }

  @NotNull public static String repeat(final int i, final @NotNull String s) {
    final @NotNull StringBuffer $ = new StringBuffer();
    for (int ¢ = 0; ¢ < i; ++¢)
      $.append(s);
    return $ + "";
  }

  public static int signum(final double ¢) {
    return ¢ == 0 ? 0 : ¢ > 0 ? 1 : -1;
  }

  @NotNull public static String sprintf(final @NotNull String format, final Object... args) {
    try (Formatter $ = new Formatter()) {
      return $.format(format, args) + "";
    }
  }

  public static String sprintf(final @NotNull String[] args) {
    switch (args.length) {
      case 0:
        return "";
      case 1:
        return args[0];
      default:
        final Object @NotNull [] $ = new Object[args.length - 1];
        for (int ¢ = 1; ¢ < args.length; ++¢)
          $[¢ - 1] = args[¢];
        return new Formatter().format(args[0], $) + "";
    }
  }

  /** Strip the first and last character of a string.
   * @param ¢ a non-<code><b>null</b></code> string of length at least two to
   *          strip
   * @return <code>s</code> but without its first and last character. */
  public static String strip(final @NotNull String ¢) {
    nonnull(¢);
    require(¢.length() >= 2);
    return ¢.substring(1, ¢.length() - 1);
  }

  @NotNull public static List<String> toLines(final @NotNull String s) throws IOException {
    final @NotNull List<String> $ = new ArrayList<>();
    for (final @NotNull BufferedReader br = new BufferedReader(new StringReader(s));;) {
      final @Nullable String line = br.readLine();
      if (line == null)
        return $;
      $.add(line);
    }
  }

  @NotNull public static String upCounter(final int ¢) {
    switch (¢) {
      case -1:
        return "";
      case 0:
        return "A";
      default:
        return toup(¢);
    }
  }

  public static String visualize(final @NotNull String ¢) {
    return esc(¢).replaceAll(" ", "\\s");
  }

  @NotNull public static String wrap(final char with, final @NotNull String s) {
    return with + s + with;
  }

  @NotNull public static String wrap(final @NotNull String with, final @NotNull String s) {
    return with + s + with;
  }

  @NotNull private static String tolow(final int ¢) {
    return ¢ == 0 ? "" : tolow(¢ / 26) + (char) (¢ % 26 + 'a');
  }

  @NotNull private static String toup(final int ¢) {
    return ¢ == 0 ? "" : toup(¢ / 26) + (char) (¢ % 26 + 'A');
  }
}
