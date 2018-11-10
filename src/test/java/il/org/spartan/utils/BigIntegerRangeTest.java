package il.org.spartan.utils;

import static fluent.ly.azzert.*;

import java.math.*;
import java.util.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class BigIntegerRangeTest {
  
  @Test public void testDefaultValues() {
    BigIntegerRange r = new BigIntegerRange();
    azzert.isNull(r.from());
    azzert.isNull(r.to());
    azzert.that(r.step, is(BigInteger.ONE));
  }
  
  @Test public void testFrom() {
    azzert.that((new BigIntegerRange()).from(BigInteger.valueOf(2)).from(), is(BigInteger.valueOf(2)));
  }
  
  // 2, 3, ...
  @Test public void testToInfinity() {
    BigIntegerRange r = new BigIntegerRange();
    r.from(BigInteger.valueOf(2));
    Iterator<BigInteger> it =  r.numbers();
    for (int ¢ = 0; ¢ < 1; ++¢)
      azzert.that(it.next(), is(BigInteger.valueOf(¢ + 2)));
  }
  
  // 2, ..., 6
  @Test public void testFromFiniteToFinite() {
    BigIntegerRange r = new BigIntegerRange();
    r.from(BigInteger.valueOf(2)).to(BigInteger.valueOf(6));
    Iterator<BigInteger> it = r.numbers();
    for (int ¢ = 0; it.hasNext(); ++¢)
      azzert.that(it.next(), is(BigInteger.valueOf(¢ + 2)));
  }
  
  // -5, ..., 2
  @Test public void testFromFiniteToFinite2() {
    BigIntegerRange r = new BigIntegerRange();
    r.to(BigInteger.valueOf(2)).from(BigInteger.valueOf(-5));
    Iterator<BigInteger> it = r.numbers();
    for (int ¢ = 0; it.hasNext(); ++¢)
      azzert.that(it.next(), is(BigInteger.valueOf(¢ - 5)));
  }
  
  // ..., -3, -2, -1, 0, 1, 2
  @Test public void testFromInfinity() {
    BigIntegerRange r = new BigIntegerRange();
    azzert.that(r.to(BigInteger.valueOf(2)).to(), is(BigInteger.valueOf(2)));
    azzert.isNull(r.from());
  }
  
}
