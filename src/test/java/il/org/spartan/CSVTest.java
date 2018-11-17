package il.org.spartan;

import static fluent.ly.azzert.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import fluent.ly.*;
import il.org.spartan.tables.*;

@SuppressWarnings("static-method") public class CSVTest {
  @Test public void combineClasses() {
    azzert.that(CSV.combine(new Class<?>[] { Integer.class, Double.class }), is("java.lang.Integer,java.lang.Double"));
  }

  @Test @SuppressWarnings("null") public void combineInstances() {
    azzert.that(CSV.combine(new Integer[] { Integer.valueOf(5), Integer.valueOf(4) }), is("5,4"));
  }

  @Test public void combineEnums() {
    azzert.that(CSV.combine(new Statistic[] { Statistic.mean, Statistic.N }), is("mean,N"));
  }

  @Test public void escaped() {
    azzert.that(CSV.escape(CSV.combine(new Statistic[] { Statistic.mean, Statistic.N })), is("mean\\.N"));
  }

  @Test public void splitEnum() {
    azzert.that(CSV.split(Statistic.class, "mean,N"), is(new Statistic[] { Statistic.mean, Statistic.N }));
  }

  @Test public void splitClasses() {
    @SuppressWarnings("null") @NotNull final Class<@Nullable ?>[] c = new @NotNull Class<@Nullable ?>[] { Integer.class, Double.class };
    c.toString();
    azzert.that(CSV.splitToClasses("java.lang.Integer,java.lang.Double"), is(c));
  }

  @Test @SuppressWarnings("null") public void dataToCsv() {
    azzert.that(CSV.toCsv(new String[][] { { "5", "4" }, { "Hello", "World" } }).replaceAll("\r\n", "\n"), is("5,4\nHello,World\n"));
  }

  @Test @SuppressWarnings("null") public void unescaped() {
    azzert.that(CSV.unescape(CSV.escape(CSV.combine(new Statistic[] { Statistic.mean, Statistic.N }))), is("mean,N"));
  }
}
