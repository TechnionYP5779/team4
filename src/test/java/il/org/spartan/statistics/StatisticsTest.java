package il.org.spartan.statistics;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class StatisticsTest {
  @Test public void sampleMean0() {
    azzert.that(Statistics.sampleMean(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0 }), is(3.5));
  }

  @Test public void sampleVariance0() {
    double res = Statistics.sampleVariance(new double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0 });
    azzert.aye(res - 105.0 / 36 > -0.001 && res - 105.0 / 36 < 0.001);
  }

  @Test public void mizzing() {
    // int miss = Statistics.missing();
  }
}
