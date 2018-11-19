package il.org.spartan.utils;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class BooleanOrReducerTest {
  @Test public void testReduce() {
    azzert.that(new BooleanOrReducer().reduce(), is(Boolean.FALSE));
  }

  @Test public void testReduce2() {
    azzert.that(new BooleanOrReducer().reduce(Boolean.FALSE, Boolean.FALSE), is(Boolean.FALSE));
    azzert.that(new BooleanOrReducer().reduce(Boolean.TRUE, Boolean.FALSE), is(Boolean.TRUE));
    azzert.that(new BooleanOrReducer().reduce(Boolean.FALSE, Boolean.TRUE), is(Boolean.TRUE));
    azzert.that(new BooleanOrReducer().reduce(Boolean.TRUE, Boolean.TRUE), is(Boolean.TRUE));
  }

  @Test public void testReduceN() {
    azzert.that(new BooleanOrReducer().reduce(Boolean.FALSE, Boolean.FALSE, Boolean.FALSE), is(Boolean.FALSE));
    azzert.that(new BooleanOrReducer().reduce(Boolean.TRUE, Boolean.FALSE, Boolean.FALSE), is(Boolean.TRUE));
    azzert.that(new BooleanOrReducer().reduce(Boolean.FALSE, Boolean.TRUE, Boolean.FALSE), is(Boolean.TRUE));
    azzert.that(new BooleanOrReducer().reduce(Boolean.TRUE, Boolean.TRUE, Boolean.FALSE), is(Boolean.TRUE));
    azzert.that(new BooleanOrReducer().reduce(Boolean.FALSE, Boolean.FALSE, Boolean.TRUE), is(Boolean.TRUE));
    azzert.that(new BooleanOrReducer().reduce(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE), is(Boolean.TRUE));
    azzert.that(new BooleanOrReducer().reduce(Boolean.FALSE, Boolean.TRUE, Boolean.TRUE), is(Boolean.TRUE));
    azzert.that(new BooleanOrReducer().reduce(Boolean.TRUE, Boolean.TRUE, Boolean.TRUE), is(Boolean.TRUE));
  }
}
