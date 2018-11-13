package il.org.spartan.utils;

public class Rectangle {
  private double y1, y2;
  
  public Rectangle(double x1, double y1, double x2, double y2) {
    this.y1 = y1;
    this.y2 = y2;
  }

  public double getLen() {
    return (this.y2 > this.y1) ? (this.y2 - this.y1) : (this.y1 - this.y2) ;
  }
}
