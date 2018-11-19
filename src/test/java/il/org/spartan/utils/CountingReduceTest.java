package il.org.spartan.utils;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class CountingReduceTest {
  @Test public void testReduce0() {
    azzert.that(new CountingReduce().reduce(), is(0));
  }

  @Test public void testReduce2() {
    azzert.that(new CountingReduce().reduce(Integer.valueOf(1), Integer.valueOf(2)), is(3));
    azzert.that(new CountingReduce().reduce(Integer.valueOf(0), Integer.valueOf(0)), is(0));
    azzert.that(new CountingReduce().reduce(Integer.valueOf(1), Integer.valueOf(-1)), is(0));
    azzert.that(new CountingReduce().reduce(Integer.valueOf(2), Integer.valueOf(2)), is(4));
  }

  @Test public void testReduceN() {
    azzert.that(new CountingReduce().reduce(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(0)), is(3));
    azzert.that(new CountingReduce().reduce(Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)), is(0));
    azzert.that(new CountingReduce().reduce(Integer.valueOf(1), Integer.valueOf(-1), Integer.valueOf(0)), is(0));
    azzert.that(new CountingReduce().reduce(Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(0)), is(4));
    azzert.that(new CountingReduce().reduce(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(-1)), is(2));
    azzert.that(new CountingReduce().reduce(Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1)), is(-1));
    azzert.that(new CountingReduce().reduce(Integer.valueOf(1), Integer.valueOf(-1), Integer.valueOf(-1)), is(-1));
    azzert.that(new CountingReduce().reduce(Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(-1)), is(3));
  }
}
