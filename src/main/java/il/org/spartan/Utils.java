package il.org.spartan;

import java.io.*;
import java.util.*;
import java.util.function.*;

import org.jetbrains.annotations.*;

import fluent.ly.*;
import il.org.spartan.Utils.FoundHandleForT.*;

/** An empty <code><b>interface</b></code> with a variety of <code>public
 * static</code> utility functions of reasonably wide use.
 * @author Yossi Gil <code><yossi.gil [at] gmail.com></code>
 * @since 2013/07/01 */
@SuppressWarnings("null") public interface Utils {
  String QUOTE = "'";
  String WHITES = "(?m)\\s+";

  @NotNull static <T, C extends Collection<T>> C add(final @NotNull C $, final Iterable<? extends T> ts) {
    for (final T ¢ : ts)
      if (¢ != null)
        $.add(¢);
    return $;
  }

  @SafeVarargs static <T, C extends Collection<T>> @NotNull C add(final @NotNull C $, final T @NotNull... ts) {
    for (final T ¢ : ts)
      if (¢ != null)
        $.add(¢);
    return $;
  }

  @SafeVarargs @NotNull static <T, C extends Collection<T>> C addAll(final @NotNull C $, final Collection<? extends T> @NotNull... tss) {
    for (final Collection<? extends T> ¢ : tss)
      if (¢ != null)
        $.addAll(¢);
    return $;
  }

  @SafeVarargs @NotNull static <T, C extends Collection<T>> C addAll(final @NotNull C $, final Iterable<? extends T> @NotNull... tss) {
    for (final Iterable<? extends T> ¢ : tss)
      if (¢ != null)
        add($, ¢);
    return $;
  }

  @SafeVarargs @NotNull static <T, C extends Collection<T>> C addAll(final @NotNull C $, final T... ts) {
    if (ts != null)
      for (final T ¢ : ts)
        if (¢ != null)
          add($, ¢);
    return $;
  }

  /** Appends an element to an array, by reallocating an array whose size is
   * greater by one and placing the element at the last position.
   * @param    <T> JD
   * @param ts an arbitrary array
   * @param t  an element
   * @return newly created array */
  @NotNull static <T> T[] append(final @NotNull T[] ts, final T t) {
    final T @NotNull [] $ = Arrays.copyOf(ts, 1 + ts.length);
    $[ts.length] = t;
    return $;
  }

  /** @param <F> JD
   * @param   <T> JD
   * @param ¢ JD */
  static <F, T> Applicator<F, T> apply(final Function<F, T> ¢) {
    return new Applicator<>(¢);
  }

  @Nullable static <T> T canBeNull(final T $) {
    return $;
  }

  /** Removes the @Nullable annotation present on the type of a value. This
   * function is mainly used to make <code><b>null</b></code> checkers happy.
   * <p>
   * The parameter is an instance of an arbitrary type, T. The hidden assumption
   * is that a @Nullable annotation is present on T. Thus, the parameter may be
   * either <code><b>null</b></code>, or an actual instance of T.
   * <p>
   * The function returns the same instance it received as a parameter, except
   * that this instance is returned as an instance of the type T <i>without</i>
   * the @Nullable annotation. Execution is aborted with an {@link AssertionError}
   * if the parameter is null.
   * <p>
   * As it turns out, this function is a (slow) logical no-op, but still
   * applicable to arguments of type T, where T does not have the @Nullable
   * annotation present on it.
   * <p>
   * For reasons related to the way non-nullability is managed in Java, the
   * compiler will not warn you from doing applying this function to a
   * {@link NotNull} type. However, there is absolutely no point in removing
   * a @Nullable annotation if the type that does not have it. Doing so a is plain
   * clutter. Since the compiler cannot assist you, you will have to be on the
   * guard.
   * @param   <T> an arbitrary type
   * @param $ an instance of the type parameter
   * @return its parameter, after verifying that it is not
   *         <code><b>null</b></code>
   * @see #mustBeNull(Object) */
  @NotNull static <T> T cantBeNull(final @Nullable T $) {
    azzert.notNull($);
    return $;
  }

  /** Impose an ordering on type <code><b>boolean</b></code> by which
   * <code><b>true</b></code> is greater than <code><b>false</b></code>.
   * @param b1 JD
   * @param b2 JD
   * @return an integer that is negative, zero or positive depending on whether
   *         the first argument is less than, equal to, or greater than the
   *         second.
   * @see Comparable
   * @see Comparator */
  static int compare(final boolean b1, final boolean b2) {
    return b1 == b2 ? 0 : b1 ? 1 : -1;
  }

  /** Remove all non-essential spaces from a string that represents Java code.
   * @param javaCodeFragment JD
   * @return parameter, with all redundant spaces removed from it */
  static String compressSpaces(final @NotNull String javaCodeFragment) {
    String $ = javaCodeFragment.replaceAll("(?m)\\s+", " ").replaceAll("^\\s", "").replaceAll("\\s$", "");
    for (final @NotNull String operator : new String @NotNull [] { ":", "/", "%", ",", "\\{", "\\}", "=", ":", "\\?", ";", "\\+", ">", ">=", "!=",
        "==", "<", "<=", "-", "\\*", "\\|", "\\&", "%", "\\(", "\\)", "[\\^]" })
      $ = $.replaceAll(WHITES + operator, operator).replaceAll(operator + WHITES, operator);
    return cantBeNull($);
  }

  /** Determine whether a string contains any of a list of patterns.
   * @param text     string to be tested
   * @param patterns a list of substrings
   * @return tree iff the the first parameter contains any of the substrings found
   *         in the second parameter */
  static boolean contains(final @NotNull String text, final @Nullable String... patterns) {
    for (final @NotNull String pattern : patterns)
      if (pattern != null && text.contains(pattern))
        return true;
    return false;
  }

  /** Deletes a specified element from an array, by reallocating an array whose
   * size is smaller by one and shifting the other elements down.
   * @param    <T> JD
   * @param ts an arbitrary array
   * @param i  position of element to be deleted
   * @return newly created array */
  @NotNull static <T> T[] delete(final @NotNull T[] ts, final int i) {
    final T @NotNull [] $ = Arrays.copyOf(ts, ts.length - 1);
    System.arraycopy(ts, i + 1, $, i, $.length - i);
    return $;
  }

  /** @param ¢ JD */
  static FoundHandleForInt found(final int ¢) {
    return new FoundHandleForInt(¢);
  }

  /** @param <T> JD
   * @param ¢ JD */
  static <T> FoundHandleForT<T> found(final T ¢) {
    return new FoundHandleForT<>(¢);
  }

  /** Determine whether a <code><b>null</b></code> occurs in a sequence of objects
   * @param os an unknown number of objects
   * @return <code><b>null</b></code> <i>iff</i> one of the parameters is
   *         <code><b>null</b></code> */
  static boolean hasNull(final @Nullable Object... os) {
    for (final Object ¢ : os)
      if (¢ == null)
        return true;
    return false;
  }

  /** Determine whether an integer is a valid list index
   * @param    <T> JD
   * @param i  some integer
   * @param ts a list of things
   * @return <code><b>true</b></code> <i>iff</i> the index is valid index into the
   *         list. and it is the last one in it. */
  static <T> boolean inRange(final int i, final List<T> ts) {
    return i >= 0 && i < ts.size();
  }

  /** Determine if an integer can be found in a list of values
   * @param candidate what to search for
   * @param is        where to search
   * @return true if the the item is found in the list */
  @SafeVarargs static boolean intIsIn(final int candidate, final int... is) {
    for (final int ¢ : is)
      if (¢ == candidate)
        return true;
    return false;
  }

  /** Determine whether an {@link Object} is the last in a {@link List} .
   * @param o  JD
   * @param os JD
   * @return <code><b>true</b></code> <i>iff</i> the {@link Object} parameter is
   *         the same as the last element of the {@link List} parameter */
  static boolean lastIn(final Object o, final List<?> os) {
    return the.last(os) == o;
  }

  /** Aborts in case a given value is <code><b>null</b></code>.
   * <p>
   * This function is the lesser used dual of {@link #cantBeNull(Object)} .
   * @param   <T> some arbitrary type
   * @param $ an instance of the type parameter which is required to be
   *          <code><b>null</b></code>.
   * @return parameter */
  static <@Nullable T> @Nullable Void mustBeNull(final @Nullable T $) {
    azzert.isNull($);
    return null;
  }

  /** @param ¢ JD
   * @return name of the parameter, which must not be <code><b>null</b></code> */
  static String name(final File ¢) {
    return cantBeNull(¢.getName());
  }

  /** Prepend a given <code><b>char</b></code> to a {@link StringBuilder}
   * @param $ prepend to what
   * @param c what needs to be prepended
   * @return {@link StringBuilder} parameter with the <code><b>char</b></code>
   *         parameter prepended to it */
  static StringBuilder prepend(final @NotNull StringBuilder $, final char c) {
    return cantBeNull($.insert(0, c));
  }

  /** Prepend a given {@link String} to a {@link StringBuilder}
   * @param $ prepend to what
   * @param s what needs to be prepended
   * @return {@link StringBuilder} parameter with the {@link String} parameter
   *         prepended to it */
  static StringBuilder prepend(final @NotNull StringBuilder $, final @NotNull String s) {
    return cantBeNull($.insert(0, s));
  }

  /** Quote a given {@link String}
   * @param $ some {@link String} to be quoted
   * @return parameter, quoted */
  static String quote(final @Nullable String $) {
    return $ != null ? QUOTE + $ + QUOTE : "<null reference>";
  }

  /** Remove any duplicates that may be present in a given {@link List}
   * @param    <T> JD
   * @param ts JD */
  static <T> void removeDuplicates(final List<T> ts) {
    final Set<T> noDuplicates = new LinkedHashSet<>(ts);
    ts.clear();
    ts.addAll(noDuplicates);
  }

  /** Remove all occurrences of a given prefix from a given {@link String} .
   * @param s      JD
   * @param prefix what should be removed
   * @return parameter after all such occurrences are removed. */
  static String removePrefix(final @NotNull String s, final @NotNull String prefix) {
    for (String $ = s;; $ = $.substring(prefix.length()))
      if (!$.startsWith(prefix))
        return $;
  }

  /** Remove all occurrences of a given suffix from a given string.
   * @param s      JD
   * @param suffix what should be removed
   * @return parameter after all such occurrences are removed. */
  static String removeSuffix(final @NotNull String s, final @NotNull String suffix) {
    for (String $ = s;; $ = $.substring(0, $.length() - suffix.length()))
      if (!$.endsWith(suffix))
        return $;
  }

  /** Remove all occurrences of white space character in a given {@link String}
   * @param ¢ JD
   * @return parameter after all such occurrences are removed. */
  static String removeWhites(final @NotNull String ¢) {
    return cantBeNull(¢.replaceAll("\\s+", ""));
  }

  /** Sorts an array
   * @param ¢ what to sort
   * @return given array with elements in sorted order */
  static int @NotNull [] sort(final int @NotNull [] ¢) {
    Arrays.sort(¢);
    return ¢;
  }

  /** Computes the square of a given double
   * @param ¢ some number
   * @return square of the parameter */
  static double sqr(final double ¢) {
    return ¢ * ¢;
  }

  /** Determine whether a file name ends with any one of the supplied extensions.
   * @param f        a file to examine
   * @param suffixes a list of potential extensions.
   * @return <code><b>true</b></code> <em>iff</em>the file name ends with any one
   *         of the supplied extensions. */
  static boolean suffixedBy(final File f, final Iterable<String> suffixes) {
    return suffixedBy(name(f), suffixes);
  }

  /** Determine whether a file name ends with any one of the supplied extensions.
   * @param f        a file to examine
   * @param suffixes a list of potential extensions.
   * @return <code><b>true</b></code> <em>iff</em>the file name ends with any one
   *         of the supplied extensions. */
  static boolean suffixedBy(final File f, final @NotNull String @NotNull... suffixes) {
    return suffixedBy(name(f), suffixes);
  }

  /** Determine whether a string ends with any one of the supplied suffixes.
   * @param s        a string to examine
   * @param suffixes a list of potential suffixes
   * @return <code><b>true</b></code> <em>iff</em> <code>s</code> ends with any
   *         one of the supplied suffixes. */
  static boolean suffixedBy(final @NotNull String s, final Iterable<String> suffixes) {
    for (final @NotNull String end : suffixes)
      if (s.endsWith(end))
        return true;
    return false;
  }

  /** Determine whether a string ends with any one of the supplied suffixes.
   * @param s        a string to examine
   * @param suffixes a list of potential suffixes
   * @return <code><b>true</b></code> <em>iff</em> <code>s</code> ends with any
   *         one of the supplied suffixes. */
  static boolean suffixedBy(final @NotNull String s, final @NotNull String... suffixes) {
    for (final @NotNull String end : suffixes)
      if (s.endsWith(end))
        return true;
    return false;
  }

  /** Swap the contents of two cells in a given array
   * @param    <T> type of array elements
   * @param ts the given array
   * @param i  index of one cell
   * @param j  index of another cell */
  static <T> void swap(final T[] ts, final int i, final int j) {
    final T t = ts[i];
    ts[i] = ts[j];
    ts[j] = t;
  }

  /** Reifies the notion of a function
   * @author Yossi Gil
   * @param <F> the type of the function's argument
   * @param <T> the type of the function's result */
  class Applicator<F, T> {
    private final Function<F, T> function;

    /** Instantiates this class
     * @param function which function to apply? */
    public Applicator(final Function<F, T> function) {
      this.function = function;
    }

    @SafeVarargs public final Iterable<T> to(final @NotNull F... fs) {
      final List<T> $ = new ArrayList<>();
      for (final F ¢ : fs)
        if (¢ != null)
          $.add(function.apply(¢));
      return $;
    }

    /** @param <FS> JD
     * @param s JD */
    public <FS extends Iterable<? extends F>> Iterable<T> to(final @NotNull FS s) {
      final List<T> $ = new ArrayList<>();
      for (final @Nullable F ¢ : s)
        if (¢ != null)
          $.add(function.apply(¢));
      return $;
    }
  }

  /** @author Yossi Gil <Yossi.Gil@GMail.COM>
   * @param <T> JD
   * @since 2016 */
  class FoundHandleForT<T> {
    final T candidate;

    /** Instantiates this class.
     * @param candidate what to search for */
    public FoundHandleForT(final T candidate) {
      this.candidate = candidate;
    }

    /** Determine if an integer can be found in a list of values
     * @param ts where to search
     * @return true if the the item is found in the list */
    @SafeVarargs public final boolean in(final @NotNull T... ts) {
      for (final T ¢ : ts)
        if (¢ != null && ¢.equals(candidate))
          return true;
      return false;
    }

    /** @author Yossi Gil <Yossi.Gil@GMail.COM>
     * @since 2016 */
    public static class FoundHandleForInt {
      final int candidate;

      /** Instantiates this class.
       * @param candidate what to search for */
      public FoundHandleForInt(final int candidate) {
        this.candidate = candidate;
      }

      /** Determine if an integer can be found in a list of values
       * @param is where to search
       * @return true if the the item is found in the list */
      @SafeVarargs public final boolean in(final int... is) {
        for (final int ¢ : is)
          if (¢ == candidate)
            return true;
        return false;
      }
    }
  }

  static int hash(final Object ¢) {
    return ¢ == null ? 0 : ¢.hashCode();
  }
}
