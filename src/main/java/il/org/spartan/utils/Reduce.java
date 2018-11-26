package il.org.spartan.utils;

import java.util.*;
import java.util.stream.*;

/** An abstract reducer of an associative, but not necessarily commutative
 * operation. This operation must also have a neutral element (#{@link Reduce}).
 * @param <R>
 * @since 2017-01-29 */
public abstract class Reduce<R> {
  public abstract R reduce();

  /** @param ¢ the element to be reduced
   * @return the exact same element */
  public final R reduce(final R ¢) {
    return ¢;
  }

  /** @param r1 first element
   * @param r2 second element
   * @return the reduce operation between r1 and r2. */
  public abstract R reduce(R r1, R r2);

  /** @param $ array of elements
   * @return the reduce operation of N elements in the array */
  public final R reduce(final R[] $) {
    return $ == null ? reduce() : Stream.of($).filter(Objects::nonNull).reduce(this::reduce).orElse(reduce());
  }

  /** @param r1 first element
   * @param r2 second element
   * @param rs rest of elements
   * @return the reduce operation of N elements */
  @SafeVarargs public final R reduce(final R r1, final R r2, final R... rs) {
    return reduce(r1, reduce(r2, reduce(rs)));
  }
}
