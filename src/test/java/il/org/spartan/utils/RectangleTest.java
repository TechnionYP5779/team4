package il.org.spartan.utils;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class RectangleTest {
  @Test public void constructor() {
    azzert.notNull(new Rectangle(10,20,30,40));
  }
  @Test public void getLen20() {
    Rectangle rec = new Rectangle(10,20,50,40);
    azzert.that(rec.getLen(), is(20));
  }
}
