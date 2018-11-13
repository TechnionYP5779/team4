package il.org.spartan.utils;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class RectangleTest {
  @Test public void constructor() {
    azzert.notNull(new Rectangle(10,20,30,40));
  }
  @Test public void getLen20() {
    azzert.that((new Rectangle(10, 20, 50, 40)).getLen(), is(20.0));
  }
  @Test public void getLen30() {
    azzert.that((new Rectangle(10, 20, 50, 50)).getLen(), is(30.0));
  }
  @Test public void getLenY1BiggerThenY2() {
    azzert.that((new Rectangle(10.2, 20.6, 50.7, -5.5)).getLen(), is(26.1));
  }
}
