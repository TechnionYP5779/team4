package fluent.ly;

import static fluent.ly.azzert.*;

import org.junit.*;

@SuppressWarnings("static-method") public class RangeTest {
  @SuppressWarnings("boxing") @Test public void fromtest() {
    azzert.that(range.from(2).from, is(2));
    azzert.that(range.from(2).infinite, is(true));
  }
  @Test public void totest() {
    azzert.that(range.to(2).to, is(2));
    azzert.that(range.to(2).infinite, is(true));
  }
  @SuppressWarnings("boxing") @Test public void fromtotest() {
    azzert.that(range.from(2).to(5).from, is(2));
    azzert.that(range.from(2).to(5).infinite, is(false));
  }
  @Test public void tosfrom() {
    azzert.isNull(range.to(2).from);
  }
  @SuppressWarnings("boxing") @Test public void tofrom() {
    azzert.that(range.to(2).from(-5).from, is(-5));
    azzert.that(range.to(2).from(-5).infinite, is(false));
  }
  @SuppressWarnings("boxing") @Test public void intersetTest() {
    azzert.that(range.to(10).interset(range.from(3)).from , is(3));
    azzert.that(range.to(10).interset(range.from(3)).to , is(10));
  }
  @SuppressWarnings("boxing") @Test public void includesTest() {
    azzert.that(range.from(1).to(3).includes(5).includes,is(5));
    azzert.that(range.from(1).to(3).includes(5).from,is(1));
    azzert.that(range.from(1).to(3).includes(5).to,is(3));
  }
}