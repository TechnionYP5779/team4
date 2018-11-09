package fluent.ly;

import java.util.*;

import org.junit.*;

@SuppressWarnings("static-method") public class CountTest {
  @Test public void usecase0() {
    azzert.assertTrue(count.of(Arrays.asList("Hello", "World!", "How", "Are", "You")) == 5);
  }

  @Test public void usecase1() {
    azzert.assertTrue(count.of(new ArrayList<>()) == 0);
  }

  @Test public void usecase2() {
    assert maybe.yes(new Object()).get() != null;
  }
}
