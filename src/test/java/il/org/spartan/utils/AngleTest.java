package il.org.spartan.utils;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class AngleTest {
  @Test public void degrees20() {
    azzert.that(Angle.degrees(20).degrees, is(20.0));
  }

  @Test public void radians1() {
    azzert.that(Angle.radians(1).radians, is(1.0));
  }

  @Test public void pi() {
    azzert.that(Angle.pi.radians, is(Math.PI));
  }

  @Test public void halfPi() {
    azzert.that(Angle.halfPi.radians, is(Math.PI / 2));
  }

  @Test public void add() {
    azzert.that(Angle.halfPi.add(Angle.degrees(20)).radians, is(Math.PI / 2 + 20));
    azzert.that(Angle.halfPi.add(20).degrees, is(110.0));
  }

  @Test public void degrees() {
    azzert.that(Angle.pi.degrees(), is(180.0));
    azzert.that(Angle.of(20).degrees(), is(180.0));
  }

  @Test public void radians() {
    azzert.that(Angle.pi.radians(), is(Math.PI / 2));
  }
}