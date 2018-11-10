package il.org.spartan.utils;

import java.util.*;

import org.junit.*;

import fluent.ly.*;

import static fluent.ly.azzert.*;

@SuppressWarnings({"static-method", "null"}) public class PairsListTest {
  @Test public void testRecord() {
    Double x = Double.valueOf(5.2), y = Double.valueOf(3.1);
    PairsList<Double> pl = new PairsList<>();
    pl.record(x,y);
    Iterator<PairsList<Double>.Pair> it = pl.iterator();
    PairsList<Double>.Pair expected = pl.new Pair(x, y);
    azzert.aye(it.hasNext());
    azzert.that(it.next(), is(expected));
    azzert.aye(!it.hasNext());
  }
  
  @Test public void iterationSorted() {
    Double x1 = Double.valueOf(5.2), y1 = Double.valueOf(3.1), x2 = Double.valueOf(5.2), y2 = Double.valueOf(3.0); 
    PairsList<Double> pl = new PairsList<>();
    pl.record(x1,y1);
    pl.record(x2,y2);
    PairsList<Double>.Pair expectedFirst = pl.new Pair(x2, y2), expectedSecond = pl.new Pair(x1, y1);
    Iterator<PairsList<Double>.Pair> it = pl.iterator();
    azzert.that(it.next(), is(expectedFirst));
    azzert.that(it.next(), is(expectedSecond));
  }
  
  @Test public void statisticsCount() {
    Double x1 = Double.valueOf(5.2), y1 = Double.valueOf(3.1), x2 = Double.valueOf(5.2), y2 = Double.valueOf(3.0); 
    PairsList<Double> pl = new PairsList<>();
    pl.record(x1,y1);
    pl.record(x2,y2);
    azzert.that(pl.count(), is(2));
  }
  
  @Test public void statisticsMean() {
    Double x1 = Double.valueOf(5.0), y1 = Double.valueOf(3.0), x2 = Double.valueOf(7.0), y2 = Double.valueOf(1.0); 
    PairsList<Double> pl = new PairsList<>();
    pl.record(x1,y1);
    pl.record(x2,y2);
    azzert.that(pl.mean(), is(pl.new Pair(Double.valueOf(6.0), Double.valueOf(2.0))));
  }
  
  @Test public void statisticsVariance() {
    Double x1 = Double.valueOf(5.0), y1 = Double.valueOf(3.0), x2 = Double.valueOf(7.0), y2 = Double.valueOf(1.0); 
    PairsList<Double> pl = new PairsList<>();
    pl.record(x1,y1);
    pl.record(x2,y2);
    azzert.that(pl.variance(), is(pl.new Pair(Double.valueOf(2.0), Double.valueOf(2.0))));
  }
  
  @Test public void statisticsCoVariance() {
    Double x1 = Double.valueOf(5.0), y1 = Double.valueOf(3.0), x2 = Double.valueOf(7.0), y2 = Double.valueOf(1.0); 
    PairsList<Double> pl = new PairsList<>();
    pl.record(x1,y1);
    pl.record(x2,y2);
    azzert.that(pl.co_variance(), is(-2.0));
  }
  
  @Test public void linearRegression() {
    Double x1 = Double.valueOf(5.0), y1 = Double.valueOf(3.0), x2 = Double.valueOf(7.0), y2 = Double.valueOf(1.0); 
    PairsList<Double> pl = new PairsList<>();
    pl.record(x1,y1);
    pl.record(x2,y2);
    azzert.that(pl.linear_regression(), is(pl.new Pair(Double.valueOf(8.0), Double.valueOf(-1.0))));
  }
}
