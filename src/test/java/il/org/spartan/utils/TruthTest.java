package il.org.spartan.utils;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class TruthTest {
  @Test public void testNot() {
    azzert.that(Truth.T.not(), is(Truth.F));
    azzert.that(Truth.F.not(), is(Truth.T));
  }

  @Test public void testOr() {
    final Truth t = Truth.T, f = Truth.F;
    azzert.that(t.or(t), is(Truth.T));
    azzert.that(t.or(f), is(Truth.T));
    azzert.that(f.or(t), is(Truth.T));
    azzert.that(f.or(f), is(Truth.F));
  }

  @Test public void testAnd() {
    final Truth t = Truth.T, f = Truth.F;
    azzert.that(t.and(t), is(Truth.T));
    azzert.that(t.and(f), is(Truth.F));
    azzert.that(f.and(t), is(Truth.F));
    azzert.that(f.and(f), is(Truth.F));
  }
}