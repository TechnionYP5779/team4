package il.org.spartan.statistics;

import java.util.*;

import org.jetbrains.annotations.*;

import fluent.ly.*;

/** A class to compute statistics, e.g., the minimal and maximal value, the mean
 * and the standard deviation, of a sequence of real numbers.
 * @author Yossi Gil, */
public class RealStatistics extends ImmutableStatistics {
  /** A field for identifying a streamed version of objects of this class; we use
   * the values of <code>1L</code> to maintain upward compatibility. */
  private static final long serialVersionUID = 1;

  public static double[] increase(final double @NotNull [] ¢) {
    return Arrays.copyOf(¢, 2 * ¢.length + 1);
  }

  @NotNull public RealStatistics record(final double... vs) {
    for (final double v : vs)
      record(v);
    return this;
  }

  @NotNull public RealStatistics record(final double v) {
    return Double.isNaN(v) || Double.isInfinite(v) ? recordMissing() : recordValue(v);
  }

  @NotNull public Statistics record(final @Nullable Double v) {
    return v == null ? recordMissing() : record(v.doubleValue());
  }

  @NotNull public RealStatistics recordMissing() {
    ++missing;
    return this;
  }

  @SuppressWarnings("null") @NotNull protected RealStatistics recordValue(final double v) {
    if (n() == 0) {
      min = max = v;
      flips = 2;
    }
    if (n == values.length)
      values = increase(values);
    values[n++] = v;
    flips += as.bit(min > v || max < v);
    min = Math.min(min, v);
    max = Math.max(max, v);
    double d = 1;
    for (int ¢ = 0; ¢ < MOMENTS; ++¢, d *= v)
      moments[¢] += d;
    return this;
  }
}
