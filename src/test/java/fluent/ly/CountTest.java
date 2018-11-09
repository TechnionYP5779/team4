package fluent.ly;

import java.util.*;

import org.junit.*;

import static fluent.ly.azzert.*;

@SuppressWarnings("static-method") public class CountTest {
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
