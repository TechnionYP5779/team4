package il.org.spartan.utils;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class IntTest {
  @Test public void testGet() {
    Int i = new Int(3);
    azzert.that(i.get(), is(3));
  }

  @Test public void testStep() {
    Int i = new Int(3);
    i.step();
    azzert.that(i.get(), is(4));
    i.step();
    azzert.that(i.get(), is(5));
  }

  @Test public void testAdd() {
    Int i = new Int(3);
    i.add(2);
    azzert.that(i.get(), is(5));
    i.add(0);
    azzert.that(i.get(), is(5));
    i.add(-6);
    azzert.that(i.get(), is(-1));
  }

  @Test public void testSet() {
    Int i = new Int(3);
    i.set(2);
    azzert.that(i.get(), is(2));
    i.set(-1);
    azzert.that(i.get(), is(-1));
    i.set(0);
    azzert.that(i.get(), is(0));
  }

  @Test public void testNext() {
    Int i = new Int(3);
    i.next();
    azzert.that(i.get(), is(4));
    i.next();
    azzert.that(i.get(), is(5));
  }

  @Test public void testAddOther() {
    Int i1 = new Int(3);
    Int i2 = new Int(4);
    i1.add(i2);
    azzert.that(i1.get(), is(7));
    azzert.that(i2.get(), is(4));
  }

  @Test public void testClear() {
    Int i = new Int(3);
    i.clear();
    azzert.that(i.get(), is(0));
  }
}