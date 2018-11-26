package fluent.ly;

import static fluent.ly.azzert.*;

import org.junit.*;

@SuppressWarnings("static-method") public class safeTest {
  @Test public void divTest() {
    azzert.that(safe.div(10.0, 2.0), is(5.0));
    azzert.that(safe.div(0.0, 2.0), is(0.0));
    azzert.that(safe.div(2.0, 0.0), is(1.0));
  }
}
