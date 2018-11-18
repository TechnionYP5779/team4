package fluent.ly;

/** TODO Yossi Gil: document class
 * @author Yossi Gil
 * @since 2017-04-10 */
public interface yes {
  interface On<T, R> {
    R on(T t);
  }

  static boolean forgetting(final Runnable ¢) {
    ¢.run();
    return true;
  }

  static boolean forgetting(final Object _1, final Object... _2) {
    forget.it(_1);
    forget.it(_2);
    return true;
  }

  static boolean ignoring(final boolean __) {
    forget.it(__);
    return true;
  }

  static boolean ignoring(final double __) {
    forget.it(__);
    return true;
  }

  static boolean ignoring(final long __) {
    forget.it(__);
    return true;
  }
}
