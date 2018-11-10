package il.org.spartan.utils;

import static fluent.ly.azzert.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import fluent.ly.*;
import il.org.spartan.utils.Accumulator.*;

@SuppressWarnings("static-method") public class AccumulatorSquarerTest {
  @Test public void testCase() {
    final @NotNull Squarer s = new Squarer();
    azzert.that(s.transform(3), is(9));
    azzert.that(s.transform(0), is(0));
    azzert.that(s.transform(-1), is(1));
  }
}
