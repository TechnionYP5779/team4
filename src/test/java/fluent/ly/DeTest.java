package fluent.ly;

import org.junit.*;

@SuppressWarnings("static-method") public class DeTest {
  @Test public void fault1() {
    azzert.notNull(de.fault("a"));
  }

  @Test public void fault2() {
    azzert.notNull(de.fault(null));
  }

  @Test public void fault3() {
    azzert.notNull(de.fault(Integer.valueOf(1)));
  }
}
