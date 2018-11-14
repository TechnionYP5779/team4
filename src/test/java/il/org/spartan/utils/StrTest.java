package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;
import static fluent.ly.azzert.*;

@SuppressWarnings("static-method") public class StrTest {
  @Test public void testStr() {
    isNull(new Str().inner());
  }

  @Test public void testIsEmptyx() {
    azzert.aye(new Str().isEmptyx());
    azzert.not(new Str("message").isEmptyx());
  }

  @Test public void testNotEmpty() {
    azzert.not(new Str().notEmpty());
    azzert.aye(new Str("message").notEmpty());
  }

  @Test public void testSet() {
    new Str().set("set");
    azzert.not(new Str().isEmptyx());
  }
}
