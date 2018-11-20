package il.org.spartan.utils;

import fluent.ly.*;

/** Reducer that concatenate strings
 * @author Yossi Gil
 * @since 2017-03-19 */
public class CountingReduce extends Reduce<Integer> {
  @Override public final Integer reduce(final Integer i1, final Integer i2) {
    return box.it(unbox.it(i1) + unbox.it(i2));
  }

  @Override public final Integer reduce() {
    return box.it(0);
  }
}
