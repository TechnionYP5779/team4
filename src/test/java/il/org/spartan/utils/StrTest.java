package il.org.spartan.utils;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class StrTest {
  @Test public void testStr() {
    azzert.isNull(new Str().inner());
  }

  @Test public void testIsEmptyx() {
    azzert.aye(new Str().isEmptyx());
    azzert.not(new Str("message").isEmptyx());
  }

  @Test public void testNotEmpty() {
    azzert.not(new Str().notEmpty());
    azzert.aye(new Str("message").notEmpty());
  }

  @Test public void testSet1() {
    final Str s = new Str();
    azzert.isNull(s.inner());
    azzert.aye(new Str().isEmptyx());
    azzert.not(new Str().notEmpty());
    s.set("set");
    azzert.that(s.inner(), is("set"));
    azzert.not(new Str().isEmptyx());
  }

  @Test public void testSet2() {
    final Str s = new Str();
    s.set("abc");
    azzert.that(s.inner(), is("abc"));
    azzert.not(new Str().isEmptyx());
  }

  @Test public void testSet3() {
    final Str s = new Str();
    s.set("123");
    azzert.that(s.inner(), is("123"));
    azzert.not(new Str().isEmptyx());
  }

  @Test public void testSet4() {
    final Str s = new Str();
    s.set("");
    azzert.that(s.inner(), is(""));
    azzert.aye(new Str().isEmptyx());
    azzert.not(new Str().notEmpty());
  }

  @Test public void testSet5() {
    final Str s = new Str();
    s.set("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    azzert.not(new Str().isEmptyx());
    azzert.that(s.inner(), is("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
  }
}
