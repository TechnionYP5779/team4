package fluent.ly;

import java.util.function.*;

import org.jetbrains.annotations.*;

import fluent.ly.*;

/** TODO Yossi Gil: document class
 * @author Yossi Gil
 * @since 2017-04-12 */
public interface nulling {
  static <@Nullable T> @Nullable T ly(final BooleanSupplier ¢) {
    return nil.ignoring(¢.getAsBoolean());
  }

  static <@Nullable T> @Nullable T ly(final DoubleSupplier ¢) {
    return nil.ignoring(¢.getAsDouble());
  }

  static <@Nullable T> @Nullable T ly(final IntSupplier ¢) {
    return nil.ignoring(¢.getAsInt());
  }

  static <@Nullable T> @Nullable T ly(final LongSupplier ¢) {
    return nil.ignoring(¢.getAsLong());
  }

  static <@Nullable T> @Nullable T ly(final Runnable ¢) {
    ¢.run();
    return the.nil();
  }

  static <@Nullable T, @Nullable R> T ly(final Supplier<R> ¢) {
    return nil.forgetting(¢.get());
  }
}
