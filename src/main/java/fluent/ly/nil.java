package fluent.ly;

import static fluent.ly.azzert.*;

import java.util.function.*;

import org.junit.*;

import il.org.spartan.utils.*;

/** TODO Yossi Gil: document class
 * @author Yossi Gil
 * @since 2017-04-10 */
@SuppressWarnings({ "unused", "null" }) public interface nil {
  interface On<T, R> {
    R on(T t);
  }

  static <T> T forgetting(final Object _1, final Object... _2) {
    return null;
  }

  static <T, R> On<T, R> guardingly(final Function<T, R> f) {
    return λ -> λ == null ? null : f.apply(λ);
  }

  static <T> T ignoring(final boolean __) {
    return null;
  }

  static <T> T ignoring(final double __) {
    return null;
  }

  static <T> T ignoring(final long __) {
    return null;
  }
  
  @SuppressWarnings("static-method") public static class TEST {
    @Test public void testIgnoring() {
      Object o = null;
      azzert.that(ignoring(true), is(o));
      azzert.that(ignoring(false), is(o));
      azzert.that(ignoring(1), is(o));
      azzert.that(ignoring(0), is(o));
      azzert.that(ignoring(1.0), is(o));
      azzert.that(ignoring(-1), is(o));
    }
    
    @SuppressWarnings("boxing") @Test public void testForgetting() {
      Object o = null;
      azzert.that(forgetting(0, true, false, -1, 1.0), is(o));
    }
  }
    
}
