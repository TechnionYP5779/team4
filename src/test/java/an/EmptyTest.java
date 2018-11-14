package an;

import java.util.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class EmptyTest {
  @Test public void testList() {
    azzert.assertEquals(0, empty.list().size());
  }

  @Test public void testIterable() {
    final Iterable<?> iterable = empty.iterable();
    final Iterator<?> iterator = iterable.iterator();
    azzert.assertEquals(false, iterator.hasNext());
    Assert.assertEquals(null, iterator.next());
    azzert.assertNotEquals(iterator, iterable.iterator());
  }
}