package il.org.spartan.statistics;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class ImmutableStatisticsTest {
  @Test public void testFlipping() {
    azzert.that((new ImmutableStatistics() {
      static final long serialVersionUID = 1;
    }).flipping(), is(Double.NaN));
  }
  
  @Test public void testUnit() {
    azzert.isNull((new ImmutableStatistics() {
      static final long serialVersionUID = 1;
    }).unit());
  }
 
}
