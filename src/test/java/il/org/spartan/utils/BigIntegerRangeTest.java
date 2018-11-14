package il.org.spartan.utils;

import static fluent.ly.azzert.*;

import java.math.*;
import java.util.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class BigIntegerRangeTest {
  @Test public void testDefaultValues() {
    final BigIntegerRange r = new BigIntegerRange();
    azzert.isNull(r.from());
    azzert.isNull(r.to());
    azzert.that(r.step, is(BigInteger.ONE));
  }

  @Test public void testFrom() {
    azzert.that(new BigIntegerRange().from(BigInteger.valueOf(2)).from(), is(BigInteger.valueOf(2)));
  }

  // 2, 3, ...
  @Test public void testToInfinity() {
    final BigIntegerRange r = new BigIntegerRange();
    r.from(BigInteger.valueOf(2));
    final Iterator<BigInteger> it = r.numbers();
    for (int ¢ = 0; ¢ < 1; ++¢)
      azzert.that(it.next(), is(BigInteger.valueOf(¢ + 2)));
  }

  // 2, ..., 6
  @Test public void testFromFiniteToFinite() {
    final BigIntegerRange r = new BigIntegerRange();
    r.from(BigInteger.valueOf(2)).to(BigInteger.valueOf(6));
    final Iterator<BigInteger> it = r.numbers();
    for (int ¢ = 0; it.hasNext(); ++¢)
      azzert.that(it.next(), is(BigInteger.valueOf(¢ + 2)));
  }

  // -5, ..., 2
  @Test public void testFromFiniteToFinite2() {
    final BigIntegerRange r = new BigIntegerRange();
    r.to(BigInteger.valueOf(2)).from(BigInteger.valueOf(-5));
    final Iterator<BigInteger> it = r.numbers();
    for (int ¢ = 0; it.hasNext(); ++¢)
      azzert.that(it.next(), is(BigInteger.valueOf(¢ - 5)));
  }

  // ..., -3, -2, -1, 0, 1, 2
  @Test public void testFromInfinity() {
    final BigIntegerRange r = new BigIntegerRange();
    azzert.that(r.to(BigInteger.valueOf(2)).to(), is(BigInteger.valueOf(2)));
    azzert.isNull(r.from());
  }

  @Test public void testIntersection() {
    final BigIntegerRange range = new BigIntegerRange().from(BigInteger.valueOf(3));
    final Iterator<BigInteger> it = new BigIntegerRange().to(BigInteger.valueOf(10)).interset(range).numbers();
    for (int ¢ = 0; ¢ < 8; ++¢)
      azzert.that(it.next(), is(BigInteger.valueOf(¢ + 3)));
  }

  @Test public void testIncludes() {
    final BigIntegerRange range = new BigIntegerRange();
    range.from(BigInteger.valueOf(3)).to(BigInteger.valueOf(7));
    azzert.not(range.includes(BigInteger.valueOf(2)));
  }
}
