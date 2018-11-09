package fluent.ly;

import static fluent.ly.azzert.*;

import org.junit.*;

@SuppressWarnings("static-method") public class NilTest {
  @Test public void testIgnoring() {
    Object o = null;
    azzert.that(nil.ignoring(true), is(o));
    azzert.that(nil.ignoring(false), is(o));
    azzert.that(nil.ignoring(1), is(o));
    azzert.that(nil.ignoring(0), is(o));
    azzert.that(nil.ignoring(1.0), is(o));
    azzert.that(nil.ignoring(-1), is(o));
  }
}