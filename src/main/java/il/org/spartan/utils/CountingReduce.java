package il.org.spartan.utils;

/** Reducer that concatenate strings
 * @author Yossi Gil
 * @since 2017-03-19 */
public class CountingReduce extends Reduce<Integer> {
  @Override public final Integer reduce(final Integer i1, final Integer i2) {
    return Integer.valueOf(i1.intValue() + i2.intValue());
  }

  @Override public final Integer reduce() {
    return Integer.valueOf(0);
  }
}
