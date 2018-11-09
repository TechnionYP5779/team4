package il.org.spartan.statistics;

import static fluent.ly.azzert.*;

import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.Test;

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

  @SuppressWarnings("static-method") public static class TEST {
    final RealStatistics s11_20_5 = new RealStatistics().record(11).record(20).record(5);
    final RealStatistics s15 = new RealStatistics().record(5).record(3).record(1).record(2).record(4);
    final RealStatistics s07 = new RealStatistics().record(0).record(5).record(6).record(3).record(1).record(2).record(4).record(7);
    final RealStatistics s_4x0_5x1 = new RealStatistics().record(0).record(0).record(0).record(0)//
        .record(1).record(1).record(1).record(1).record(1);
    final ImmutableStatistics s = new RealStatistics().record(11).record(20).record(5);

    @Test public void all() {
      s11_20_5.median();
      s11_20_5.mad();
      final double @NotNull [] vs = s11_20_5.all();
      that(vs.length, is(3));
      aye(11 - vs[0] < 1E-20 && 11 - vs[0] > -1 * 1E-20);
      aye(20 - vs[1] < 1E-20 && 20 - vs[1] > -1 * 1E-20);
      aye(5 - vs[2] < 1E-20 && 5 - vs[2] > -1 * 1E-20);
    }

    @Test public void all0() {
      that(new RealStatistics().all().length, is(0));
    }

    @Test public void all1() {
      that(new RealStatistics().record(0).all().length, is(1));
    }

    @Test public void all5() {
      that(new RealStatistics().record(0, 1, 2, 4, 5).all().length, is(5));
    }

    @Test public void max() {
      aye(20 - s11_20_5.max() < 1E-6 && 20 - s11_20_5.max() > -1 * 1E-6);
      aye(5 - s15.max() < 1E-6 && 5 - s15.max() > -1 * 1E-6);
      aye(7 - s07.max() < 1E-6 && 7 - s07.max() > -1 * 1E-6);
      aye(1 - s_4x0_5x1.max() < 1E-6 && 1 - s_4x0_5x1.max() > -1 * 1E-6);
    }

    @Test public void mean() {
      aye(12 - s11_20_5.mean() < 1E-6 && 12 - s11_20_5.mean() > -1 * 1E-6);
      aye(3 - s15.mean() < 1E-6 && 3 - s15.mean() > -1 * 1E-6);
      aye(3.5 - s07.mean() < 1E-6 && 3.5 - s07.mean() > -1 * 1E-6);
      aye(5 / 9.0 - s_4x0_5x1.mean() < 1E-6 && 5 / 9.0 - s_4x0_5x1.mean() > -1 * 1E-6);
    }

    @Test(expected = ArithmeticException.class) public void meanEmpty() {
      final @NotNull RealStatistics x = new RealStatistics();
      aye(x.mean() < 1E-20 && x.mean() > -1 * 1E-20);
      x.relativeError();
    }

    @Test public void meanZero() {
      final @NotNull RealStatistics x = new RealStatistics().record(1).record(-1);
      aye(x.mean() < 1E-20 && x.mean() > -1 * 1E-20);
      x.relativeError();
    }

    @Test public void median() {
      assertEquals(11, s11_20_5.median(), 1E-6);
      assertEquals(3, s15.median(), 1E-6);
      assertEquals(3.5, s07.median(), 1E-6);
      assertEquals(1, s_4x0_5x1.median(), 1E-6);
      assertEquals(1, s_4x0_5x1.record(1).median(), 1E-6);
      assertEquals(1, s_4x0_5x1.record(5).median(), 1E-6);
      assertEquals(1, s_4x0_5x1.record(5).record(6).median(), 1E-6);
      assertEquals(1, s_4x0_5x1.record(0).median(), 1E-6);
      assertEquals(1, s_4x0_5x1.record(0).median(), 1E-6);
      assertEquals(1, s_4x0_5x1.record(0).median(), 1E-6);
      assertEquals(1, s_4x0_5x1.record(0).median(), 1E-6);
      assertEquals(0.5, s_4x0_5x1.record(0).median(), 1E-6);
      assertEquals(0, s_4x0_5x1.record(0).median(), 1E-6);
    }

    @Test(expected = ArithmeticException.class) public void medianEmpty() {
      new RealStatistics().median();
    }

    @Test public void medianMiddle() {
      assertEquals(0.5, s_4x0_5x1.record(0).median(), 1E-6);
    }

    @Test public void medianMovingDown() {
      assertEquals(0, s_4x0_5x1.record(0).record(0).median(), 1E-6);
    }

    @Test public void mediannMovingDown() {
      assertEquals(0, s_4x0_5x1.record(0).record(0).median(), 1E-6);
    }

    @Test public void medianNotMovingUp() {
      assertEquals(1, s_4x0_5x1.record(5).record(6).median(), 1E-6);
    }

    @Test public void min() {
      assertEquals(5, s11_20_5.min(), 1E-6);
      assertEquals(1, s15.min(), 1E-6);
      assertEquals(0, s07.min(), 1E-6);
      assertEquals(0, s_4x0_5x1.min(), 1E-6);
    }

    @Test public void n() {
      that(s11_20_5.n(), is(3));
      that(s15.n(), is(5));
      that(s07.n(), is(8));
      that(s_4x0_5x1.n(), is(9));
    }

    @Test public void simpleLength() {
      that(s.n(), is(3));
      that(s15.n(), is(5));
      that(s07.n(), is(8));
      that(s_4x0_5x1.n(), is(9));
    }

    @Test public void sum() {
      assertEquals(36, s11_20_5.sum(), 1E-6);
      assertEquals(15, s15.sum(), 1E-6);
      assertEquals(28, s07.sum(), 1E-6);
      assertEquals(5.0, s_4x0_5x1.sum(), 1E-6);
    }

    @Test public void testMax() {
      assertEquals(20, s.max(), 1E-6);
      assertEquals(5, s15.max(), 1E-6);
      assertEquals(7, s07.max(), 1E-6);
      assertEquals(1, s_4x0_5x1.max(), 1E-6);
    }

    @Test public void testMean() {
      assertEquals(12, s.mean(), 1E-6);
      assertEquals(3, s15.mean(), 1E-6);
      assertEquals(3.5, s07.mean(), 1E-6);
      assertEquals(5 / 9.0, s_4x0_5x1.mean(), 1E-6);
    }

    @Test public void testMedian() {
      assertEquals(11, s.median(), 1E-6);
      assertEquals(3, s15.median(), 1E-6);
      assertEquals(3.5, s07.median(), 1E-6);
      assertEquals(1, s_4x0_5x1.median(), 1E-6);
      assertEquals(1, s_4x0_5x1.record(1).median(), 1E-6);
      assertEquals(1, s_4x0_5x1.record(5).median(), 1E-6);
      assertEquals(1, s_4x0_5x1.record(5).record(6).median(), 1E-6);
      assertEquals(1, s_4x0_5x1.record(0).median(), 1E-6);
      assertEquals(1, s_4x0_5x1.record(0).median(), 1E-6);
      assertEquals(1, s_4x0_5x1.record(0).median(), 1E-6);
      assertEquals(1, s_4x0_5x1.record(0).median(), 1E-6);
      assertEquals(0.5, s_4x0_5x1.record(0).median(), 1E-6);
      assertEquals(0, s_4x0_5x1.record(0).median(), 1E-6);
    }

    @Test(expected = ArithmeticException.class) public void testMedianEmpty() {
      new RealStatistics().median();
    }

    @Test public void testMedianMiddle() {
      assertEquals(0.5, s_4x0_5x1.record(0).median(), 1E-6);
    }

    @Test public void testMedianNotMovingUp() {
      assertEquals(1, s_4x0_5x1.record(5).record(6).median(), 1E-6);
    }

    @Test public void testMin() {
      assertEquals(5, s.min(), 1E-6);
      assertEquals(1, s15.min(), 1E-6);
      assertEquals(0, s07.min(), 1E-6);
      assertEquals(0, s_4x0_5x1.min(), 1E-6);
    }

    @Test public void testSum() {
      assertEquals(36, s.sum(), 1E-6);
      assertEquals(15, s15.sum(), 1E-6);
      assertEquals(28, s07.sum(), 1E-6);
      assertEquals(5.0, s_4x0_5x1.sum(), 1E-6);
    }
  }
}
