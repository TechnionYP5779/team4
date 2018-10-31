package il.org.spartan;
// TODO: Yossi: I commented this one too.

import java.util.*;

import org.jetbrains.annotations.*;

// import static il.org.spartan.utils.___.*;
import il.org.spartan.Aggregator.Aggregation.*;
import il.org.spartan.statistics.*;

/** Similar to {@link CSVWriter}, except that in addition to the production of
 * output to the main CSV file, this class generates a secondary CSV file,
 * recording the essential statistics (min, max, count, etc.) of each numerical
 * column in the main CSV file.
 * @author Yossi Gil
 * @since Dec 25, 2009 */
@SuppressWarnings("null") public class CSVStatistics extends CSVLine.Ordered {
  @NotNull private static final String SUMMARY_EXTENSION = ".summary";

  @NotNull private static String removeExtension(final @NotNull String baseName) {
    return baseName.replaceFirst("\\.csv$", "");
  }

  @NotNull private final String keysHeader;
  final Map<String, RealStatistics> stats = new LinkedHashMap<>();
  final CSVWriter inner;
  final CSVWriter summarizer;

  /** Instantiate this class, setting the names of the main and secondary CSV
   * files.
   * @param baseName   the name of the files into which statistics should be
   *                   written; if this name ends with ".csv", this extension is
   *                   removed.
   * @param keysHeader the name of the column in which the names of the numerical
   *                   columns in the principal file
   * @throws IOException */
  public CSVStatistics(final @NotNull String baseName, final @NotNull String keysHeader) {
    assert baseName != null;
    assert keysHeader != null;
    inner = new CSVWriter(removeExtension(baseName));
    summarizer = new CSVWriter(removeExtension(baseName) + SUMMARY_EXTENSION);
    this.keysHeader = keysHeader;
  }

  public String close() {
    inner.close();
    for (final @NotNull String key : stats.keySet()) {
      final @NotNull CSVLine l = new CSVLine.Ordered.Separated("%");
      l.put(keysHeader, key);
      final ImmutableStatistics s = stats.get(key);
      l//
          .put("$N$", s.n()) //
          .put("\\emph{n/a}", s.missing())//
          .put("Mean", s.n() > 0 ? s.mean() : Double.NaN) //
          .put("Median", s.n() > 0 ? s.median() : Double.NaN)//
          .put("$\\sigma$", s.n() > 0 ? s.sd() : Double.NaN) //
          .put("m.a.d", s.n() > 0 ? s.mad() : Double.NaN) //
          .put("$\\min$", s.n() > 0 ? s.min() : Double.NaN) //
          .put("$\\max$", s.n() > 0 ? s.max() : Double.NaN) //
          .put("Range", s.n() <= 0 ? Double.NaN : s.max() - s.min())//
          .put("Total", s.n() > 0 ? s.sum() : Double.NaN)//
      ;
      summarizer.writeFlush(l);
    }
    return summarizer.close();
  }

  public String mainFileName() {
    return inner.fileName();
  }

  public void nl() {
    inner.writeFlush(this);
  }

  @Override public CSVStatistics put(final @NotNull String key, final double value, final FormatSpecifier... ss) {
    getStatistics(key).record(value);
    super.put(key, value, ss);
    return this;
  }

  @Override public CSVStatistics put(final @NotNull String key, final int value) {
    getStatistics(key).record(value);
    super.put(key, value);
    return this;
  }

  @Override public CSVStatistics put(final @NotNull String key, final long value) {
    getStatistics(key).record(value);
    super.put(key, value);
    return this;
  }

  public String summaryFileName() {
    return summarizer.fileName();
  }

  RealStatistics getStatistics(final @NotNull String key) {
    stats.putIfAbsent(key, new RealStatistics());
    return stats.get(key);
  }

  public class Line extends CSVStatistics.Ordered {
    public void close() {
      inner.writeFlush(this);
    }

    @Override public CSVStatistics put(final @NotNull String key, final double value, final FormatSpecifier... ss) {
      getStatistics(key).record(value);
      super.put(key, value, ss);
      return CSVStatistics.this;
    }

    @Override public CSVStatistics put(final @NotNull String key, final long value) {
      getStatistics(key).record(value);
      super.put(key, value);
      return CSVStatistics.this;
    }
  }
}
