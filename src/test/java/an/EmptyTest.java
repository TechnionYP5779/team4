package an;

import static fluent.ly.azzert.*;

import java.util.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class EmptyTest {
  @Test public void testList() {
    azzert.that(empty.list().size(), is(0));
  }

  @Test public void testIterable() {
    final Iterable<?> iterable = empty.iterable();
    final Iterator<?> iterator = iterable.iterator();
    azzert.nay(iterator.hasNext());
    azzert.isNull(iterator.next());
    assert iterable.iterator() != iterator;
  }
}