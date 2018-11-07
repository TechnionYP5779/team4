package fluent.ly;

import java.util.*;

import org.junit.*;

public interface count {
  static <T> int of(final Iterable<T> ts) {
    int $ = 0;
    for (@SuppressWarnings("unused") final T __ : ts)
      ++$;
    return $;
  }
  @SuppressWarnings("static-method") public static class TEST {
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
}
