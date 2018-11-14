package an;

import java.util.*;

import org.junit.*;

import fluent.ly.*;
import static fluent.ly.azzert.*;

@SuppressWarnings("static-method") public class EmptyTest {
  @Test public void testList() {
    azzert.that(empty.list().size(), is(0));
  }

  @SuppressWarnings("null") @Test public void testIterable() {
    final Iterable<?> iterable = empty.iterable();
    final Iterator<?> iterator = iterable.iterator();
    azzert.nay(iterator.hasNext());
    azzert.isNull(iterator.next());
    azzert.that( iterable.iterator(), not(iterator));
  }
}