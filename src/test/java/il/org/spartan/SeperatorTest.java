package il.org.spartan;

import static fluent.ly.azzert.*;

import java.util.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class SeperatorTest {
  @Test public void seperateIntByComma() {
    azzert.that(Separator.separateBy(new int[] { 4, 5 }, ","), is("4,5"));
  }

  @Test @SuppressWarnings("null") public void seperateObjsByComma() {
    azzert.that(Separator.separateBy(",", new Double[] { Double.valueOf(4.2), Double.valueOf(5.1) }), is("4.2,5.1"));
  }

  @Test public void wrap() {
    azzert.that(Separator.wrap("\"", Arrays.asList(box.boxInteger(1), box.boxInteger(2), box.boxInteger(3)), ","), is("\"1,2,3\""));
  }
}
