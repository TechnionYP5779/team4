package fluent.ly;

import org.junit.*;

@SuppressWarnings("static-method") public class MaybeTest {
  @Test public void usecase0() {
    azzert.isNull(maybe.no().get());
  }

  @Test public void usecase1() {
    azzert.isNull(maybe.yes(null).get());
  }

  @Test public void usecase2() {
    azzert.notNull(maybe.yes(new Object()).get());
  }
}
