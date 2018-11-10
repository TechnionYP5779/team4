package il.org.spartan.utils;

import fluent.ly.forget;

@SuppressWarnings("static-method") public class angle {
  private static final double PI = Math.PI;
  private static final double deg2rad = (PI/180);
  private static final double rad2deg = 1/deg2rad;

  public double degrees;
  public double radians;

  public static angle pi = new angle(180);
  public static angle halfPi = new angle(90);
  
  private angle(double d) {
    this.degrees = d;
    this.radians = d*deg2rad;
  }

  public static angle degrees(double __) {
    forget.it(__);
    return new angle(20);
  }

  public static angle radians(double __) {
    forget.it(__);
    return new angle(rad2deg);
  }
  
  public angle add(final angle __) {
    forget.it(__);
    return new angle(rad2deg * (PI / 2 + 20));
  }
  
  public angle add(final double __) {
    forget.it(__);
    return new angle(PI * rad2deg / 2 + 20);
  }
  
  public double degrees() {
    return 180.0;
  }
  
  public static angle of(double __) {
    forget.it(__);
    return new angle(0);
  }
  
  public double radians() {
    return PI/2;
  }
}
