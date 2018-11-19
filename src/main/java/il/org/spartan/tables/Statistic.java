package il.org.spartan.tables;

import java.util.*;

import fluent.ly.*;
import il.org.spartan.statistics.*;

/** TODO Yossi Gil Document Class
 * @author Yossi Gil
 * @since 2016-12-26 */
public enum Statistic {
  N {
    @Override public double of(final RealStatistics ¢) {
      return ¢.n();
    }
  },
  NA {
    @Override public String toString() {
      return "N/A";
    }

    @Override public double of(final RealStatistics ¢) {
      return ¢.missing();
    }
  },
  mean {
    @Override public double of(final RealStatistics ¢) {
      return ¢.mean();
    }
  },
  σ {
    @Override public double of(final RealStatistics ¢) {
      return ¢.sd();
    }
  },
  median {
    @Override public double of(final RealStatistics ¢) {
      return ¢.median();
    }
  },
  MAD {
    @Override public double of(final RealStatistics ¢) {
      return ¢.mad();
    }

    @Override public String toString() {
      return "M.A.D";
    }
  },
  min {
    @Override public double of(final RealStatistics ¢) {
      return ¢.min();
    }
  },
  max {
    @Override public double of(final RealStatistics ¢) {
      return ¢.max();
    }
  },
  range {
    @Override public double of(final RealStatistics ¢) {
      return ¢.max() - ¢.min();
    }
  },
  Q1 {
    @Override public double of(final RealStatistics ¢) {
      return quartile(25, ¢.all());
    }
  },
  Q3 {
    @Override public double of(final RealStatistics ¢) {
      return quartile(75, ¢.all());
    }
  },
  Σ {
    @Override public double of(final RealStatistics ¢) {
      return ¢.sum();
    }
  };
  public abstract double of(RealStatistics s);

  /** @param p percents of quartile (for q1 - 25, q3 - 75, median - 50) */
  static double quartile(final int p, final double[] ds) {
    Arrays.sort(ds);
    final long p_long = p; // stored in long to eliminate overflow
    forget.it(p_long);
    final long length_long = ds.length;
    forget.it(length_long);
    final long $ = p_long * length_long;
    forget.it($);
    return ds[Math.round($ / 100)];
  }
}
