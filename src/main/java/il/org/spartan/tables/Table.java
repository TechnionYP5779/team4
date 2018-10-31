package il.org.spartan.tables;

import java.io.*;
import java.util.*;

import org.jetbrains.annotations.*;

import an.*;
import fluent.ly.*;
import il.org.spartan.statistics.*;
import il.org.spartan.utils.*;

/** A relation is just another name for a table that contains elements of __
 * {@link Record}. This class provides fluent API for generating tables,
 * including aggregation information.
 * @author Yossi Gil
 * @since 2016-12-25 */
@SuppressWarnings("null") public class Table extends Row<Table> implements Closeable {
  private static final long serialVersionUID = 0x4AA7BE471985E874L;
  String path;

  public Table(final Object o) {
    this(o.getClass());
  }

  public Table(final Class<?> c) {
    this(classToNormalizedFileName(c));
  }

  public Table(final @NotNull String name) {
    this(name, TableRenderer.builtin.values());
  }

  /** @param name output file name
   * @param rs   {@code TableRenderer}'s to use when writing to files (e.g. CSV,
   *             TEX, TXT).
   * @author oran1248
   * @since 2017-04-21 */
  @SuppressWarnings("resource") public Table(final @NotNull String name, final TableRenderer... rs) {
    this.name = name.toLowerCase();
    as.list(rs).forEach(r -> {
      try {
        writers.add(new RecordWriter(r, path()));
      } catch (final IOException ¢) {
        close();
        throw new RuntimeException(¢);
      }
    });
  }

  @SuppressWarnings("resource") public Table(final @NotNull String name, final @NotNull String outputFolder) {
    this.name = name.toLowerCase();
    path = outputFolder.lastIndexOf('/') == outputFolder.length() ? outputFolder : outputFolder + System.getProperty("file.separator", "/");
    as.list(TableRenderer.builtin.values()).forEach(r -> {
      try {
        writers.add(new RecordWriter(r, path()));
      } catch (final IOException ¢) {
        close();
        throw new RuntimeException(¢);
      }
    });
  }

  public Table(final Class<?> c, final @NotNull String outputFolder) {
    this(classToNormalizedFileName(c), outputFolder);
  }

  private int length;
  @NotNull public final String name;
  Statistic[] statisics = Statistic.values();
  final Map<String, RealStatistics> stats = new LinkedHashMap<>();
  private final List<RecordWriter> writers = an.empty.list();

  public String baseName() {
    return system.tmp + name + ".*";
  }

  /** Close operation from {@link Closeable} for saving output files.
   * @author oran1248
   * @since 2017-04-21 */
  @Override public void close() {
    if (!stats.isEmpty())
      for (final Statistic s : statisics) {
        for (final @NotNull String key : keySet()) {
          final RealStatistics r = getRealStatistics(key);
          put(key, r == null || r.n() == 0 ? "" : box.it(s.of(r)));
        }
        final @NotNull String key = lastEmptyColumn();
        for (final RecordWriter ¢ : writers) {
          put(key, ¢.renderer.render(s));
          ¢.writeFooter(this);
        }
      }
    writers.forEach(RecordWriter::close);
  }

  private String lastEmptyColumn() {
    String $ = null;
    for (final @NotNull String key : keySet()) {
      final RealStatistics r = getRealStatistics(key);
      if (r != null && r.n() != 0)
        break;
      $ = key;
    }
    return $;
  }

  @Override public Table col(final @NotNull String key, final double value) {
    getRealStatistics(key).record(value);
    return super.col(key, value);
  }

  @Override public Table col(final @NotNull String key, final int value) {
    getRealStatistics(key).record(value);
    return super.col(key, value);
  }

  @Override public Table col(final @NotNull String key, final long value) {
    getRealStatistics(key).record(value);
    super.col(key, value);
    return this;
  }

  public String description() {
    String $ = "Table named " + name + " produced in " + writers.size() + " formats (versions) in " + baseName() + "\n" + //
        "The table has " + length() + " data rows, each consisting of " + size() + " columns.\n" + //
        "Table header is  " + keySet() + "\n"; //
    if (!stats.isEmpty())
      $ += "The table consists of " + stats.size() + " numerical columns: " + stats.keySet() + "\n";
    final Int n = new Int();
    return $ + writers.stream().map(λ -> "\t " + ++n.inner + ". " + λ.fileName + "\n").reduce((x, y) -> x + y).get();
  }

  RealStatistics getRealStatistics(final @NotNull String key) {
    stats.computeIfAbsent(key, λ -> new RealStatistics());
    return stats.get(key);
  }

  public int length() {
    return length;
  }

  public void nl() {
    writers.forEach(λ -> λ.write(this));
    reset();
  }

  private String path() {
    return (path != null ? path : system.tmp) + name;
  }

  public Table noStatistics() {
    statisics = new Statistic[0];
    return this;
  }

  public Table remove(final Statistic... ¢) {
    final List<Statistic> $ = as.list(statisics);
    $.removeAll(as.list(¢));
    return set($);
  }

  public Table add(final Statistic... ¢) {
    final List<Statistic> $ = as.list(statisics);
    $.addAll(as.list(¢));
    return set($);
  }

  @Override protected Table reset() {
    keySet().forEach(λ -> put(λ, ""));
    put(null, ++length + "");
    return this;
  }

  /* @formatter:off*/ @Override

   protected Table self() { return this; } /*@formatter:on*/

  private Table set(final List<Statistic> ¢) {
    return set(¢.toArray(new Statistic[¢.size()]));
  }

  Table set(final Statistic... ¢) {
    statisics = ¢;
    return this;
  }

  public static String classToNormalizedFileName(final Class<?> ¢) {
    return classToNormalizedFileName(¢.getSimpleName());
  }

  static String classToNormalizedFileName(final @NotNull String className) {
    return separate.these(the.lastOf(iterable.over(cCamelCase.components(className)))).by('-').toLowerCase();
  }
}
