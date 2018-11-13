package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class RectangleTest {
  private final double delta = 0.0000001;
  
  @Test public void constructor() {
    azzert.notNull(new Rectangle(10,20,30,40));
  }
  @Test public void getLen20() {
    Rectangle rec = new Rectangle(10, 20, 50, 40);
    azzert.aye(rec.getLen() < delta + 20.0 && rec.getLen() > 20.0 - delta);
  }
  @Test public void getLen30() {
    Rectangle rec = new Rectangle(10, 20, 50, 50);
    azzert.aye(rec.getLen() < delta + 30.0 && rec.getLen() > 30.0 - delta);
  }
  @Test public void getLenY1BiggerThenY2() {
    Rectangle rec = new Rectangle(10.2, 20.6, 50.7, -5.5);
    azzert.aye(rec.getLen() < delta + 26.1 && rec.getLen() > 26.1 - delta);
  }
  @Test public void getWidth20() {
    Rectangle rec = new Rectangle(10, 20, 50, 40);
    azzert.aye(rec.getWidth() < delta + 40 && rec.getWidth() > 40 - delta);
  }
  @Test public void geWidth30() {
    Rectangle rec = new Rectangle(10, 20, 12.4, 50);
    azzert.aye(rec.getWidth() < delta + 2.4 && rec.getWidth() > 2.4 - delta);
  }
  @Test public void getWidthX1BiggerThenX2() {
    Rectangle rec = new Rectangle(10.2, 20.6, 5.7, -5.5);
    azzert.aye(rec.getWidth() < delta + 4.5 && rec.getWidth() > 4.5 - delta);
  }
  @Test public void perimeter() {
    Rectangle rec = new Rectangle(10.2, 20.6, 5.7, -5.5);
    azzert.aye(rec.perimeter() < delta + 39.2 && rec.perimeter() > 39.2 - delta);
  }
}
