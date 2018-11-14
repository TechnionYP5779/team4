package il.org.spartan.utils;

import fluent.ly.*;

/** Boolean or reducer
 * @author oran1248
 * @since 2017-04-20 */
public class BooleanOrReducer extends Reduce<Boolean> {
  @Override public Boolean reduce() {
    return Boolean.FALSE;
  }

  @Override public Boolean reduce(final Boolean r1, final Boolean r2) {
    return box.it(Boolean.TRUE.equals(r1) || Boolean.TRUE.equals(r2));
  }
}
