package fluent.ly;

import static il.org.spartan.Utils.*;

import java.util.*;
import java.util.stream.*;

import org.jetbrains.annotations.*;

/** @noinspection unused */
public interface lisp {
  @Nullable static <T> List<T> chop(final @NotNull List<T> ¢) {
    if (¢.isEmpty())
      return null;
    ¢.remove(0);
    return ¢;
  }

  @NotNull static <T> List<T> cons(final T first, final @NotNull List<T> rest) {
    rest.add(0, first);
    return rest;
  }

  @Nullable static <T> T next(final int i, final @Nullable List<@Nullable T> ts) {
    return inRange(i + 1, ts) ? get(ts, i) : the.lastOf(ts);
  }

  static <T> @Nullable T get(final List<@Nullable T> ts, final int i) {
    return ts == null ? null : ts.get(i + 1);
  }

  /** Retrieve previous item in a list
   * @param i  an index of specific item in a list
   * @param ts the indexed list
   * @return previous item in the list, if such an item exists, otherwise, the
   *         last node */
  static <T> T prev(final int i, final @NotNull List<T> ts) {
    return ts.get(i < 1 ? 0 : i - 1);
  }

  @Contract("null, _, _ -> null") @Nullable static <T> List<T> replace(final @Nullable List<T> ts, final T element, final int index) {
    if (ts == null || index < 0 || index >= ts.size())
      return ts;
    ts.remove(index);
    ts.add(index, element);
    return ts;
  }

  @Contract("null, _ -> null") @Nullable static <T> List<T> replaceFirst(final List<T> ts, final T element) {
    return replace(ts, element, 0);
  }

  @Contract("null, _ -> null") @Nullable static <T> List<T> replaceLast(final @NotNull List<T> ts, final T element) {
    return replace(ts, element, ts.size() - 1);
  }

  @NotNull static <T> Iterable<T> rest2(final @NotNull Iterable<T> ¢) {
    return the.lastOf(the.lastOf(¢));
  }

  /** @param o the assignment operator to compare all to
   * @param os A unknown number of assignments operators
   * @return whether all the operator are the same or false otherwise */
  static boolean areEqual(final Object o, final Object... os) {
    return !hasNull(o, os) && Stream.of(os).allMatch(λ -> λ == o);
  }

  static <T> List<T> chopLast(final List<T> ¢) {
    final List<T> $ = as.list(¢);
    $.remove($.size() - 1);
    return $;
  }

  static String chopLast(final @NotNull String ¢) {
    return ¢.substring(0, ¢.length() - 1);
  }

  static <T> void removeFromList(final Iterable<T> items, final List<T> from) {
    items.forEach(from::remove);
  }

  static <T> void removeLast(final List<T> ¢) {
    ¢.remove(¢.size() - 1);
  }

  /** swaps two elements in an indexed list in given indexes, if they are legal
   * @param $  the indexed list
   * @param i1 the index of the first element
   * @param i2 the index of the second element
   * @return the list after swapping the elements */
  static <T> List<T> swap(final List<T> $, final int i1, final int i2) {
    if (i1 >= $.size() || i2 >= $.size())
      return $;
    final T t = $.get(i1);
    replace($, $.get(i2), i1);
    replace($, t, i2);
    return $;
  }
}
