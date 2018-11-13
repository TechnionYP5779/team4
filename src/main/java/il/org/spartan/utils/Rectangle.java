package il.org.spartan.utils;

public class Rectangle {
  private double y1, y2, x1, x2;
  
  public Rectangle(double x1, double y1, double x2, double y2) {
    this.y1 = y1;
    this.y2 = y2;
    this.x1 = x1;
    this.x2 = x2;
  }

  public double getLen() {
    return (y2 > y1) ? (y2 - y1) : (y1 - y2) ;
  }

  public double getWidth() {
    return (x2 > x1) ? (x2 - x1) : (x1 - x2) ;
  }

  public double perimeter() {
    return 2*(getLen()+getWidth());
  }
}
