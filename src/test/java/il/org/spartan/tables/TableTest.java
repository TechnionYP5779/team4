package il.org.spartan.tables;

import org.junit.*;

import fluent.ly.*;

import static fluent.ly.azzert.*;

@SuppressWarnings("static-method") public class TableTest {
  @Test public void constructFromObject() {
    Integer a = Integer.valueOf(0);
    @SuppressWarnings("resource") Table t = new Table(a);
    azzert.that(t.baseName(), is("/var/folders/6j/jg35p1d110x3ydng0fsn2b_00000gn/T//.*"));
    azzert.that(t.description(), is("Table named  produced in 5 formats (versions) in /var/folders/6j/jg35p1d110x3ydng0fsn2b_00000gn/T//.*\n" + 
        "The table has 1 data rows, each consisting of 1 columns.\n" + 
        "Table header is  [null]\n" + 
        "\t 1. /var/folders/6j/jg35p1d110x3ydng0fsn2b_00000gn/T//.txt\n" + 
        "\t 2. /var/folders/6j/jg35p1d110x3ydng0fsn2b_00000gn/T//.tex\n" + 
        "\t 3. /var/folders/6j/jg35p1d110x3ydng0fsn2b_00000gn/T//.tex2\n" + 
        "\t 4. /var/folders/6j/jg35p1d110x3ydng0fsn2b_00000gn/T//.csv\n" + 
        "\t 5. /var/folders/6j/jg35p1d110x3ydng0fsn2b_00000gn/T//.markdown\n"));
    t.close();
  }
  
  @Test public void stats() {
    Integer a = Integer.valueOf(0);
    @SuppressWarnings("resource") Table t = new Table(a);
    t.add(Statistic.mean, Statistic.σ);
    azzert.that(t.statisics[2] + "", is("mean"));
    t.reset();
    t.close();
  }
}
