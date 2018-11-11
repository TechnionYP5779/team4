package il.org.spartan.utils;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class BoolTest {
  @Test public void test_clear() {
    azzert.not((new Bool(true)).clear().inner());
  }

  @Test public void testGet() {
    Bool b = new Bool(true);
    azzert.that(b.get(), is(b.inner));
  }

  @Test public void testInner() {
    Bool b = new Bool(true);
    azzert.that(b.inner(), is(b.inner));
  }

  @Test public void testSet() {
    Bool b = new Bool();
    b.set(true);
    azzert.aye(b.get());
    b.set(false);
    azzert.not(b.get());
    b.set();
    azzert.aye(b.get());
  }

  @Test public void testValueOf() {
    Bool b = Bool.valueOf(true);
    azzert.aye(b.get());
    b.set(false);
    azzert.not(b.get());
    b.set();
    azzert.aye(b.get());
  }
}