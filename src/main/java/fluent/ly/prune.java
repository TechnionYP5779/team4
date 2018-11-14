/* Part of the "Spartan Blog"; mutate the rest / but leave this line as is */
package fluent.ly;

import static il.org.spartan.Utils.*;

import static fluent.ly.azzert.*;

import java.util.*;
import java.util.function.*;

import org.jetbrains.annotations.*;
import org.junit.*;

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
  private static <T> T[] shrink(final T @NotNull [] ¢) {
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

  /** A JUnit test class for the enclosing class.
   * @author Yossi Gil, the Technion.
   * @since 27/08/2008 */
  @SuppressWarnings({ "static-method", "synthetic-access" }) //
  public static class TEST1 {
    @Nullable final String[] alternatingArray = new @Nullable String[] { null, "A", null, null, "B", null, null, null, "C", null };
    @NotNull final String[] nonNullArray = { "1", "2", "4" };
    @NotNull private final List<String> sparseCollection = as.list(null, null, null, null, null, "A", null, null, null, "B", null, "C", null, null,
        null, null, null);

    @Test public void nullsNotNullArrayLength() {
      azzert.that(nonNullArray.length, is(nulls(nonNullArray).length));
    }

    @Test public void nullsNullArrayItems() {
      azzert.that(nulls(nonNullArray)[0], is("1"));
      azzert.that(nulls(nonNullArray)[1], is("2"));
      azzert.that(nulls(nonNullArray)[2], is("4"));
    }

    @Test public void nullsPruneArrayAltenatingItems() {
      azzert.that(nulls(alternatingArray)[0], is("A"));
      azzert.that(nulls(alternatingArray)[1], is("B"));
      azzert.that(nulls(alternatingArray)[2], is("C"));
    }

    @Test public void nullsPruneArrayAltenatingLength() {
      azzert.that(nulls(alternatingArray).length, is(3));
    }

    @Test public void nullsPruneSparseCollectionContents() {
      final String[] a = nulls(sparseCollection).toArray(new String[3]);
      azzert.that(a[0], is("A"));
      azzert.that(a[1], is("B"));
      azzert.that(a[2], is("C"));
      azzert.that(a.length, is(3));
    }

    @Test public void nullsPruneSparseCollectionLength() {
      azzert.that(nulls(sparseCollection).size(), is(3));
    }

    @Test public void nullsPrunNotNull() {
      azzert.notNull(prune.nulls(sparseCollection));
    }

    @Test public void shrinkArray() {
      azzert.that(shrink(new Object[10]).length, is(0));
    }

    @Test public void shrinkEmptyArray() {
      azzert.that(shrink(new Object[10]).length, is(0));
    }

    @Test public void whitesEmptyArray() {
      azzert.that(prune.whites().length, is(0));
    }

    @Test public void whitesEmptyList() {
      azzert.that(prune.whites().length, is(0));
    }
  }

  /** A JUnit test class for the enclosing class.
   * @author Yossi Gil, the Technion.
   * @since 27/08/2008 */
  @SuppressWarnings({ "static-method", "synthetic-access" }) public static class TEST2 {
    @NotNull final String @NotNull [] alternatingArray = new String[] { null, "A", null, null, "B", null, null, null, "C", null };
    @NotNull final String @NotNull [] nonNullArray = { "1", "2", "4" };
    @NotNull final Supplier<List<String>> x = () -> {
      final List<String> $ = an.empty.list();
      $.add(null);
      $.add(null);
      $.add(null);
      $.add(null);
      $.add(null);
      $.add("A");
      $.add(null);
      $.add(null);
      $.add(null);
      $.add("B");
      $.add(null);
      $.add("C");
      $.add(null);
      $.add(null);
      $.add(null);
      $.add(null);
      return $;
    };
    @NotNull private final List<String> sparseCollection = new Supplier<List<String>>() {
      @Override @NotNull public List<String> get() {
        @NotNull final List<String> $ = an.empty.list();
        $.add(null);
        $.add(null);
        $.add(null);
        $.add(null);
        $.add(null);
        $.add("A");
        $.add(null);
        $.add(null);
        $.add(null);
        $.add("B");
        $.add(null);
        $.add("C");
        $.add(null);
        $.add(null);
        $.add(null);
        $.add(null);
        return $;
      }
    }.get();

    @Test public void testNotNullArrayItems() {
      azzert.that(nulls(nonNullArray)[0], is("1"));
      azzert.that(nulls(nonNullArray)[1], is("2"));
      azzert.that(nulls(nonNullArray)[2], is("4"));
    }

    @Test public void testNotNullArrayLength() {
      azzert.that(nulls(nonNullArray).length, is(nonNullArray.length));
    }

    @Test public void testPruneArrayAltenatingItems() {
      azzert.that(nulls(alternatingArray)[0], is("A"));
      azzert.that(nulls(alternatingArray)[1], is("B"));
      azzert.that(nulls(alternatingArray)[2], is("C"));
    }

    @Test public void testPruneArrayAltenatingLength() {
      azzert.that(nulls(alternatingArray).length, is(3));
    }

    @Test public void testPruneSparseCollectionContents() {
      final @NotNull String[] a = nulls(sparseCollection).toArray(new String[3]);
      azzert.that(a[0], is("A"));
      azzert.that(a[1], is("B"));
      azzert.that(a[2], is("C"));
      azzert.that(a.length, is(3));
    }

    @Test public void testPruneSparseCollectionLength() {
      azzert.that(nulls(sparseCollection).size(), is(3));
    }

    @Test public void testPrunNotNull() {
      azzert.notNull(nulls(sparseCollection));
    }

    @Test public void testShrink() {
      azzert.that(shrink(new Object[10]).length, is(0));
    }
  }
}
