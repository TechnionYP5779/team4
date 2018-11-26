package fluent.ly;

import static fluent.ly.azzert.*;

import org.junit.*;

@SuppressWarnings("static-method") public class zeroTest {
  @Test public void forgetBoolean() {
    azzert.that(zero.forget(true), is(0));
    azzert.that(zero.forget(false), is(0));
  }

  @Test public void forgetDouble() {
    azzert.that(zero.forget(0.0), is(0));
    azzert.that(zero.forget(1.0), is(0));
    azzert.that(zero.forget(-1.0), is(0));
    azzert.that(zero.forget(2.6), is(0));
    azzert.that(zero.forget(5.4), is(0));
    azzert.that(zero.forget(-1.111111111111111), is(0));
  }

  @Test public void forgetLong() {
    azzert.that(zero.forget(0), is(0));
    azzert.that(zero.forget(1), is(0));
    azzert.that(zero.forget(-1), is(0));
    azzert.that(zero.forget(111111), is(0));
    azzert.that(zero.forget(222222), is(0));
    azzert.that(zero.forget(-12345), is(0));
  }

  @Test public void forgetting() {
    azzert.that(zero.forgetting(null), is(0));
  }
}
