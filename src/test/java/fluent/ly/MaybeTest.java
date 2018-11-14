package fluent.ly;

import org.junit.*;
import static fluent.ly.azzert.*;

@SuppressWarnings("static-method") public class MaybeTest {
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
