/* Part of the "Spartan Blog"; mutate the rest / but leave this line as is */
package fluent.ly;

import static il.org.spartan.Utils.*;

import java.util.*;

import org.jetbrains.annotations.*;

/** A <b>Utility class</b> providing functions to remove
 * <code><b>null</b></code> elements from arrays and iterable collections. For
 * example, to process the non-<code><b>null</b></code> elements of an array:
 *
 * <pre>
 * void f(String ss[]) {
 *     for (String s: Prune.nulls(ss))
 *     		// ... s is not null.
 * }
 * </pre>
 *
 * @author Yossi Gil
 * @since 27/08/2008 */
@SuppressWarnings("null") public enum prune {
  ;
  @NotNull private static String @NotNull [] asArrray(final @NotNull List<String> $) {
    return cantBeNull($.toArray(new String[0]));
  }

  @NotNull public static <T, C extends Collection<T>> C nulls(final @NotNull C $) {
    for (final Iterator<T> ¢ = $.iterator(); ¢.hasNext();)
      if (¢.next() == null)
        ¢.remove();
    return $;
  }

  @NotNull public static <T> List<T> nulls(final @NotNull Iterable<T> ts) {
    final @NotNull ArrayList<T> $ = new ArrayList<>();
    for (final @Nullable T ¢ : ts)
      if (¢ != null)
        $.add(¢);
    return $;
  }

  @NotNull public static <T> T[] nulls(final T[] ts) {
    final @NotNull List<@NotNull T> $ = new ArrayList<>();
    if (ts != null)
      for (final @Nullable T ¢ : ts)
        if (¢ != null)
          $.add(¢);
    return cantBeNull($.toArray(shrink(ts)));
  }

  /** Shrink an array size to zero.
   * @param   <T> type of elements in the input array.
   * @param ¢ an array of values.
   * @return an array of size 0 of elements of type <code>T</code>. */
  static <T> T[] shrink(final T @NotNull [] ¢) {
    return Arrays.copyOf(¢, 0);
  }

  @SafeVarargs public static <T> @NotNull String @NotNull [] whites(final @Nullable T @Nullable... ts) {
    final @NotNull List<@NotNull String> $ = an.empty.list();
    if (ts != null)
      for (final @Nullable T ¢ : ts)
        if (¢ != null)
          accumulate.to($).add((¢ + "").trim());
    return asArrray($);
  }
}
