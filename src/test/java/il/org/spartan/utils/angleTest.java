package il.org.spartan.utils;

import org.junit.*;

import static fluent.ly.azzert.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class angleTest {
  @Test public void degrees20() {
    azzert.that(angle.degrees(20).degrees, is(20.0));
  }

  @Test public void radians1() {
    azzert.that(angle.radians(1).radians, is(1.0));
  }

  @Test public void pi() {
    azzert.that(angle.pi.radians, is(Math.PI));
  }

  @Test public void halfPi() {
    azzert.that(angle.halfPi.radians, is(Math.PI / 2));
  }

  @Test public void add() {
    azzert.that(angle.halfPi.add(angle.degrees(20)).radians, is(Math.PI / 2 + 20));
    azzert.that(angle.halfPi.add(20).degrees, is(110.0));
  }

  @Test public void degrees() {
    azzert.that(angle.pi.degrees(), is(180.0));
    azzert.that(angle.of(20).degrees(), is(180.0));
  }

  @Test public void radians() {
    azzert.that(angle.pi.radians(), is(Math.PI/2));
  }
}