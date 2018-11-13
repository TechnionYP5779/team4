package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class RectangleTest {
  
  private final double delta = 0.0000001;
  
  private void compareDelta(double res, double expected) {
    azzert.aye(res < delta + expected && res > expected - delta);
  }
  
  @Test public void constructor() {
    azzert.notNull(new Rectangle(10,20,30,40));
  }
  
  @Test public void getX1_10() {
    compareDelta(new Rectangle(10, 20, 50, 40).getX1(), 10);
  }
  
  @Test public void getY1_20() {
    compareDelta(new Rectangle(10, 20, 50, 40).getY1(), 20);
  }
  
  @Test public void getX2_50() {
    compareDelta(new Rectangle(10, 20, 50, 40).getX2(), 50);
  }
  
  @Test public void getY2_40() {
    compareDelta(new Rectangle(10, 20, 50, 40).getY2(), 40);
  }
  
  @Test public void getX1_432dot2() {
    compareDelta(new Rectangle(432.2, -14.5, 53256.2, 0).getX1(), 432.2);
  }
  
  @Test public void getY1_minus14dot5() {
    compareDelta(new Rectangle(432.2, -14.5, 53256.2, 0).getY1(), -14.5);
  }
  
  @Test public void getX2_53256dot2() {
    compareDelta(new Rectangle(432.2, -14.5, 53256.2, 0).getX2(), 53256.2);
  }
  
  @Test public void getY2_0() {
    compareDelta(new Rectangle(432.2, -14.5, 53256.2, 0).getY2(), 0);
  }
  
  @Test public void getLen20() {
    compareDelta(new Rectangle(10, 20, 50, 40).getLen(), 20);
  }
  
  @Test public void getLen30() {
    compareDelta(new Rectangle(10, 20, 50, 50).getLen(), 30);
  }
  
  @Test public void getLenY1BiggerThenY2() {
    compareDelta(new Rectangle(10.2, 20.6, 50.7, -5.5).getLen(), 26.1);
  }
  
  @Test public void getWidth20() {
    compareDelta(new Rectangle(10, 20, 50, 40).getWidth(), 40);
  }
  
  @Test public void geWidth30() {
    compareDelta(new Rectangle(10, 20, 12.4, 50).getWidth(), 2.4);
  }
  
  @Test public void getWidthX1BiggerThenX2() {
    compareDelta(new Rectangle(10.2, 20.6, 5.7, -5.5).getWidth(), 4.5);
  }
  
  @Test public void perimeter61dot2() {
    compareDelta(new Rectangle(10.2, 20.6, 5.7, -5.5).perimeter(), 61.2);
  }
  
  @Test public void perimeter179dot4() {
    compareDelta(new Rectangle(13.5, -55.3, -12.4, 8.5).perimeter(), 179.4);
  }
  
  @Test public void area1652dot42() {
    compareDelta(new Rectangle(13.5, -55.3, -12.4, 8.5).area(), 1652.42);
  }
  
  @Test public void area12025() {
    compareDelta(new Rectangle(-4.5, 23, 245.5 , -25.1).area(), 12025);
  }
  
  @Test public void rotation() {
    compareDelta(new Rectangle(5, 2, 7 , 5).rotation().getX1(), 5);
  }
  
  @Test public void rotation2() {
    compareDelta(new Rectangle(5, 2, 7 , 5).rotation().getY1(), 2);
  }
  
  @Test public void rotation3() {
    compareDelta(new Rectangle(5, 2, 7 , 5).rotation().getX2(), 2);
  }
  
  @Test public void rotation4() {
    compareDelta(new Rectangle(5, 2, 7 , 5).rotation().getY2(), 4);
  }
  
  @Test public void rotation5() {
    compareDelta(new Rectangle(5, 2, 7 , 5).rotation().rotation().getX2(), 3);
  }
  
}
