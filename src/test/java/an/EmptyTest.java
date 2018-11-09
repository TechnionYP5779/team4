package an;

import java.util.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class EmptyTest {
  @Test public void testList() {
    azzert.assertEquals(0, empty.list().size());
  }

  @Test @SuppressWarnings("static-access") public void testIterable() {
    Iterable<?> iterable = empty.iterable();
    Iterator<?> iterator = iterable.iterator();
    azzert.assertEquals(false, iterator.hasNext());
    azzert.assertEquals(null, iterator.next());
    azzert.assertNotEquals(iterator, iterable.iterator());
  }
}