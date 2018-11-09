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
}
