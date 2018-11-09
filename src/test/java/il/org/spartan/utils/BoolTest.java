package il.org.spartan.utils;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class BoolTest {
  @Test public void test_clear() {
    Bool b = new Bool(true);
    azzert.that(b.clear().inner(), is(false));
  }

  @Test public void test_get() {
    Bool b = new Bool(true);
    azzert.that(b.get(), is(b.inner));
  }

  @Test public void test_inner() {
    Bool b = new Bool(true);
    azzert.that(b.inner(), is(b.inner));
  }

  @Test public void test_set() {
    Bool b = new Bool(true);
    azzert.that(b.inner(), is(true));
    b.set(false);
    azzert.that(b.inner(), is(false));
    b.set();
    azzert.that(b.inner(), is(true));
  }
}