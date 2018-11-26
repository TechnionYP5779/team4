package fluent.ly;

import static fluent.ly.azzert.*;

import java.util.*;

import org.junit.*;

@SuppressWarnings("static-method") public class countTest {
  @Test public void usecase0() {
    azzert.that(count.of(Arrays.asList("Hello", "World!", "How", "Are", "You")), is(5));
  }

  @Test public void usecase1() {
    azzert.that(count.of(new ArrayList<>()), is(0));
  }

  @Test public void usecase2() {
    azzert.notNull(maybe.yes(new Object()).get());
  }
}
