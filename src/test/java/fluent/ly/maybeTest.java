package fluent.ly;

import static fluent.ly.azzert.*;

import org.junit.*;

@SuppressWarnings("static-method") public class maybeTest {
  @Test public void usecase0() {
    isNull(maybe.no().get());
  }

  @Test public void usecase1() {
    isNull(maybe.yes(null).get());
  }

  @Test public void usecase2() {
    azzert.notNull(maybe.yes(new Object()).get());
  }
}
