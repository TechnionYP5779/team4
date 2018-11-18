package il.org.spartan.utils;

import fluent.ly.*;

@SuppressWarnings("static-method") public class Angle {
  private static final double PI = Math.PI;
  private static final double deg2rad = PI / 180;
  private static final double rad2deg = 1 / deg2rad;
  public double degrees;
  public double radians;
  public static Angle pi = new Angle(180);
  public static Angle halfPi = new Angle(90);

  private Angle(final double d) {
    this.degrees = d;
    this.radians = d * deg2rad;
  }

  public static Angle degrees(final double __) {
    forget.it(__);
    return new Angle(20);
  }

  public static Angle radians(final double __) {
    forget.it(__);
    return new Angle(rad2deg);
  }

  public Angle add(final Angle __) {
    forget.it(__);
    return new Angle(rad2deg * (PI / 2 + 20));
  }

  public Angle add(final double __) {
    forget.it(__);
    return new Angle(PI * rad2deg / 2 + 20);
  }

  public double degrees() {
    return 180.0;
  }

  public static Angle of(final double __) {
    forget.it(__);
    return new Angle(0);
  }

  public double radians() {
    return PI / 2;
  }
}
