package fluent.ly;

import static fluent.ly.azzert.*;

import org.junit.*;

@SuppressWarnings("static-method") public class NilTest {
  private final Object o = null;

  @Test public void testIgnoring0() {
    azzert.that(nil.ignoring(true), is(o));
  }

  @Test public void testIgnoring1() {
    azzert.that(nil.ignoring(false), is(o));
  }

  @Test public void testIgnoring2() {
    azzert.that(nil.ignoring(1), is(o));
  }

  @Test public void testIgnoring3() {
    azzert.that(nil.ignoring(0), is(o));
  }

  @Test public void testIgnoring4() {
    azzert.that(nil.ignoring(1.0), is(o));
  }

  @Test public void testIgnoring5() {
    azzert.that(nil.ignoring(-1), is(o));
  }
  
  @Test public void testForgetting1() {
    azzert.isNull(nil.forgetting(null));
  }
  
  @Test public void testForgetting2() {
    azzert.isNull(nil.forgetting("1"));
  }
  
  @Test public void testForgetting3() {
    azzert.isNull(nil.forgetting(Integer.valueOf(1)));
  }
}