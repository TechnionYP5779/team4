package il.org.spartan.utils;

public class Rectangle {
  private int y1, y2;
  
  public Rectangle(int x1, int y1, int x2, int y2) {
    this.y1 = y1;
    this.y2 = y2;
  }

  public int getLen() {
    return this.y2 - this.y1;
  }
}
