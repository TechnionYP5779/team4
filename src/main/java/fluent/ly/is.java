/** Part of the "Spartan Blog"; mutate the rest, but leave this line as is */
package fluent.ly;

import java.util.*;

import org.jetbrains.annotations.*;

/** @author Yossi Gil <tt>yogi@cs.technion.ac.il</tt>
 * @since 2017-04-23 */
public interface is {
  /** Determine if an item can be found in a list of values
   * @param           <T> JD
   * @param candidate what to search for
   * @param ts        where to search
   * @return true if the the item is found in the list */
  @SafeVarargs static <T> boolean in(final T candidate, final T... ts) {
    for (final T ¢ : ts)
      if (¢ != null && ¢.equals(candidate))
        return true;
    return false;
  }

  /** Determine if an integer can be found in a list of values
   * @param candidate what to search for
   * @param is        where to search
   * @return true if the the item is found in the list */
  @SafeVarargs @Contract(pure = true) static boolean intIsIn(final int candidate, final int... is) {
    for (final int ¢ : is)
      if (¢ == candidate)
        return true;
    return false;
  }

  interface not {
    /** the candidate is not in ts */
    @SafeVarargs static <T> boolean in(final T candidate, final T... ts) {
      return !is.in(candidate, ts);
    }
  }

  /** Determine if an item is not included in a list of values
   * @param           <T> JD
   * @param candidate what to search for
   * @param ts        where to search
   * @return true if the the item is not found in the list */
  @SafeVarargs static <T> boolean out(final T candidate, final T... ts) {
    return !in(candidate, ts);
  }

  static boolean empty(final @Nullable String ¢) {
    return ¢ == null || ¢.isEmpty();
  }

  static <T> boolean empty(final T[] ¢) {
    return ¢ == null || ¢.length == 0;
  }

  static <T> boolean empty(final Iterable<T> ¢) {
    return ¢ == null || !¢.iterator().hasNext();
  }

  static <T> boolean empty(final Collection<T> ¢) {
    return ¢ == null || ¢.isEmpty();
  }
}
