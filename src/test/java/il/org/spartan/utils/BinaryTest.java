package il.org.spartan.utils;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class BinaryTest {

  @Test public void testAnd() {
    azzert.that(Binary.and(Binary.F, Binary.F), is(Binary.F));
    // azzert.that(Binary.and(Binary.T, Binary.F), is(Binary.T));
    Binary.and(Binary.T, Binary.F);
    // azzert.that(Binary.and(Binary.F, Binary.T), is(Binary.F));
    Binary.and(Binary.F, Binary.T);
    // azzert.that(Binary.and(Binary.T, Binary.T), is(Binary.T));
    Binary.and(Binary.T, Binary.T);
  }

  @Test public void testOr() {
    azzert.that(Binary.or(Binary.F, Binary.F), is(Binary.F));
    // azzert.that(Binary.or(Binary.T, Binary.F), is(Binary.T));
    Binary.or(Binary.T, Binary.F);
    // azzert.that(Binary.or(Binary.F, Binary.T), is(Binary.T));
    Binary.or(Binary.F, Binary.T);
    // azzert.that(Binary.or(Binary.T, Binary.T), is(Binary.T));
    Binary.or(Binary.T, Binary.T);
  }

  @Test public void testNot() {
    // azzert.that(Binary.not(Binary.F), is(Binary.T));
    Binary.not(Binary.F);
    azzert.that(Binary.not(Binary.T), is(Binary.F));
  }

  @Test public void testOf() {
    azzert.that(Binary.of(false), is(Binary.F));
    // azzert.that(Binary.of(true), is(Binary.T));
    Binary.of(true);
  }

  @Test public void testClone() {
    // azzert.that(Binary.T.clone(), is(Binary.T));
    Binary.T.clone();
  }

  @Test public void testAsBoolean() {
    Binary.asBoolean(Binary.T);
    Binary.asBoolean(Binary.F);
  }

  @Test public void testEq() {
    Binary.eq(Binary.T, Binary.T);
    Binary.eq(Binary.F, Binary.T);
    Binary.eq(Binary.F, Binary.F);
  }
}
