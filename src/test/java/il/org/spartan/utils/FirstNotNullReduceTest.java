package il.org.spartan.utils;

import static fluent.ly.azzert.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class FirstNotNullReduceTest {
  @Test public void testReduce() {
    azzert.that(new FirstNotNullReduce<@Nullable Integer>().reduce(Integer.valueOf(1), Integer.valueOf(1)), is(Integer.valueOf(1)));
    azzert.that(new FirstNotNullReduce<@Nullable Integer>().reduce(null, Integer.valueOf(1)), is(Integer.valueOf(1)));
    azzert.isNull(new FirstNotNullReduce<@Nullable Integer>().reduce());
  }
}
