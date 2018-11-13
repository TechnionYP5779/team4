package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class RectangleTest {
  private final double delta = 0.0000001;
  
  @Test public void constructor() {
    azzert.notNull(new Rectangle(10,20,30,40));
  }
  @Test public void getLen20() {
    double res = 20;
    Rectangle rec = new Rectangle(10, 20, 50, 40);
    azzert.aye(rec.getLen() < res + delta && rec.getLen() > res - delta);
  }
  @Test public void getLen30() {
    double res = 30;
    Rectangle rec = new Rectangle(10, 20, 50, 50);
    azzert.aye(rec.getLen() < res + delta && rec.getLen() > res - delta);
  }
  @Test public void getLenY1BiggerThenY2() {
    double res = 26.1;
    Rectangle rec = new Rectangle(10.2, 20.6, 50.7, -5.5);
    azzert.aye(rec.getLen() < res + delta && rec.getLen() > res - delta);
  }
  @Test public void getWidth20() {
    double res = 40;
    Rectangle rec = new Rectangle(10, 20, 50, 40);
    azzert.aye(rec.getWidth() < res + delta && rec.getWidth() > res - delta);
  }
  @Test public void geWidth30() {
    double res = 2.4;
    Rectangle rec = new Rectangle(10, 20, 12.4, 50);
    azzert.aye(rec.getWidth() < res + delta && rec.getWidth() > res - delta);
  }
  @Test public void getWidthX1BiggerThenX2() {
    double res = 4.5;
    Rectangle rec = new Rectangle(10.2, 20.6, 5.7, -5.5);
    azzert.aye(rec.getWidth() < res + delta && rec.getWidth() > res - delta);
  }
  @Test public void perimeter61dot2() {
    double res = 61.2;
    Rectangle rec = new Rectangle(10.2, 20.6, 5.7, -5.5);
    azzert.aye(rec.perimeter() < res + delta && rec.perimeter() > res - delta);
  }
  @Test public void perimeter179dot4() {
    double res = 179.4;
    Rectangle rec = new Rectangle(13.5, -55.3, -12.4, 8.5);
    azzert.aye(rec.perimeter() < res + delta && rec.perimeter() > res - delta);
  }
  @Test public void area1652dot42() {
    double res = 1652.42;
    Rectangle rec = new Rectangle(13.5, -55.3, -12.4, 8.5);
    azzert.aye(rec.area() < res + delta && rec.area() > res - delta);
  }
}
