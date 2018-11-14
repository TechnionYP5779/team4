package il.org.spartan.utils;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;
import il.org.spartan.utils.Accumulator.*;

@SuppressWarnings("static-method") public class AccumulatorSummerTest {
  @Test public void testCase() {
    azzert.that(new Summer().transform(3), is(3));
    azzert.that(new Summer("summer").transform(3), is(3));
  }
}
