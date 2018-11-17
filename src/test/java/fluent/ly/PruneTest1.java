package fluent.ly;

import static fluent.ly.azzert.*;

import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

/** A JUnit test class for the enclosing class.
 * @author Yossi Gil, the Technion.
 * @since 27/08/2008 */
@SuppressWarnings("static-method") public class PruneTest1 {
  @Nullable final String @NotNull [] alternatingArray = new @Nullable String[] { null, "A", null, null, "B", null, null, null, "C", null };
  @NotNull final String @NotNull [] nonNullArray = { "1", "2", "4" };
  @NotNull private final List<String> sparseCollection = as.list(null, null, null, null, null, "A", null, null, null, "B", null, "C", null, null,
      null, null, null);

  @Test public void nullsNotNullArrayLength() {
    azzert.that(nonNullArray.length, is(prune.nulls(nonNullArray).length));
  }

  @Test public void nullsNullArrayItems() {
    azzert.that(prune.nulls(nonNullArray)[0], is("1"));
    azzert.that(prune.nulls(nonNullArray)[1], is("2"));
    azzert.that(prune.nulls(nonNullArray)[2], is("4"));
  }

  @Test public void nullsPruneArrayAltenatingItems() {
    azzert.that(prune.nulls(alternatingArray)[0], is("A"));
    azzert.that(prune.nulls(alternatingArray)[1], is("B"));
    azzert.that(prune.nulls(alternatingArray)[2], is("C"));
  }

  @Test public void nullsPruneArrayAltenatingLength() {
    azzert.that(prune.nulls(alternatingArray).length, is(3));
  }

  @Test public void nullsPruneSparseCollectionContents() {
    final String[] a = prune.nulls(sparseCollection).toArray(new String[3]);
    azzert.that(a[0], is("A"));
    azzert.that(a[1], is("B"));
    azzert.that(a[2], is("C"));
    azzert.that(a.length, is(3));
  }

  @Test public void nullsPruneSparseCollectionLength() {
    azzert.that(prune.nulls(sparseCollection).size(), is(3));
  }

  @Test public void nullsPrunNotNull() {
    azzert.notNull(prune.nulls(sparseCollection));
  }

  @Test public void shrinkArray() {
    azzert.that(prune.shrink(new Object[10]).length, is(0));
  }

  @Test public void shrinkEmptyArray() {
    azzert.that(prune.shrink(new Object[10]).length, is(0));
  }

  @Test public void whitesEmptyArray() {
    azzert.that(prune.whites().length, is(0));
  }

  @Test public void whitesEmptyList() {
    azzert.that(prune.whites().length, is(0));
  }
}
