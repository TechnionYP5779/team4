package il.org.spartan.utils;

import static fluent.ly.azzert.*;

import java.util.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings({ "static-method", "null" }) public class PairsListTest {
  @Test public void testRecord() {
    final Double x = Double.valueOf(5.2), y = Double.valueOf(3.1);
    final PairsList<Double> pl = new PairsList<>();
    pl.record(x, y);
    final Iterator<PairsList<Double>.Pair> it = pl.iterator();
    final PairsList<Double>.Pair expected = pl.new Pair(x, y);
    azzert.aye(it.hasNext());
    azzert.that(it.next(), is(expected));
    azzert.nay(it.hasNext());
  }

  @Test public void iterationSorted() {
    final Double x1 = Double.valueOf(5.2), y1 = Double.valueOf(3.1), x2 = Double.valueOf(5.2), y2 = Double.valueOf(3.0);
    final PairsList<Double> pl = new PairsList<>();
    pl.record(x1, y1);
    pl.record(x2, y2);
    final PairsList<Double>.Pair expectedFirst = pl.new Pair(x2, y2), expectedSecond = pl.new Pair(x1, y1);
    final Iterator<PairsList<Double>.Pair> it = pl.iterator();
    azzert.that(it.next(), is(expectedFirst));
    azzert.that(it.next(), is(expectedSecond));
  }

  @Test public void statisticsCount() {
    final Double x1 = Double.valueOf(5.2), y1 = Double.valueOf(3.1), x2 = Double.valueOf(5.2), y2 = Double.valueOf(3.0);
    final PairsList<Double> pl = new PairsList<>();
    pl.record(x1, y1);
    pl.record(x2, y2);
    azzert.that(pl.count(), is(2));
  }

  @Test public void statisticsMean() {
    final Double x1 = Double.valueOf(5.0), y1 = Double.valueOf(3.0), x2 = Double.valueOf(7.0), y2 = Double.valueOf(1.0);
    final PairsList<Double> pl = new PairsList<>();
    isNull(pl.mean());
    pl.record(x1, y1);
    pl.record(x2, y2);
    azzert.that(pl.mean(), is(pl.new Pair(Double.valueOf(6.0), Double.valueOf(2.0))));
  }

  @Test public void statisticsVariance() {
    final Double x1 = Double.valueOf(5.0), y1 = Double.valueOf(3.0), x2 = Double.valueOf(7.0), y2 = Double.valueOf(1.0);
    final PairsList<Double> pl = new PairsList<>();
    isNull(pl.variance());
    pl.record(x1, y1);
    pl.record(x2, y2);
    azzert.that(pl.variance(), is(pl.new Pair(Double.valueOf(2.0), Double.valueOf(2.0))));
  }

  @Test public void statisticsCoVariance() {
    final Double x1 = Double.valueOf(5.0), y1 = Double.valueOf(3.0), x2 = Double.valueOf(7.0), y2 = Double.valueOf(1.0);
    final PairsList<Double> pl = new PairsList<>();
    azzert.that(pl.co_variance(), is(0.0));
    pl.record(x1, y1);
    pl.record(x2, y2);
    azzert.that(pl.co_variance(), is(-2.0));
  }

  @Test public void linearRegression() {
    final Double x1 = Double.valueOf(5.0), y1 = Double.valueOf(3.0), x2 = Double.valueOf(7.0), y2 = Double.valueOf(1.0);
    final PairsList<Double> pl = new PairsList<>();
    isNull(pl.linear_regression());
    pl.record(x1, y1);
    pl.record(x2, y2);
    azzert.that(pl.linear_regression(), is(pl.new Pair(Double.valueOf(8.0), Double.valueOf(-1.0))));
  }

  @Test public void equalzSameObject() {
    final Double x1 = Double.valueOf(5.2), y1 = Double.valueOf(3.1), x2 = Double.valueOf(5.2), y2 = Double.valueOf(3.0);
    final PairsList<Double> pl = new PairsList<>();
    pl.record(x1, y1);
    pl.record(x2, y2);
    final PairsList<Double>.Pair p = pl.new Pair(x2, y2);
    azzert.that(p, is(p));
  }

  // This tests equals of different types, it is intended to have the warning
  // unlikely-arg-type.
  @Test @SuppressWarnings("unlikely-arg-type") public void equalzObjNotOfClass() {
    final Double x1 = Double.valueOf(5.2), y1 = Double.valueOf(3.1), x2 = Double.valueOf(5.2), y2 = Double.valueOf(3.0);
    final PairsList<Double> pl = new PairsList<>();
    pl.record(x1, y1);
    pl.record(x2, y2);
    azzert.nay(pl.new Pair(x2, y2).equals(Integer.valueOf(5)));
  }

  @Test public void equalzObjNull() {
    final Double x1 = Double.valueOf(5.2), y1 = Double.valueOf(3.1), x2 = Double.valueOf(5.2), y2 = Double.valueOf(3.0);
    final PairsList<Double> pl = new PairsList<>();
    pl.record(x1, y1);
    pl.record(x2, y2);
    azzert.nay(pl.new Pair(x2, y2).equals(null));
  }

  @Test public void notEqualz() {
    final Double x1 = Double.valueOf(5.2), y1 = Double.valueOf(3.1), x2 = Double.valueOf(5.2), y2 = Double.valueOf(3.0);
    final PairsList<Double> pl = new PairsList<>();
    pl.record(x1, y1);
    pl.record(x2, y2);
    azzert.nay(pl.new Pair(x2, y2).equals(pl.new Pair(x1, y1)));
  }
}
