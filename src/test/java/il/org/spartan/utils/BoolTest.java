package il.org.spartan.utils;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class BoolTest {
  @Test public void test_clear() {
    azzert.not(new Bool(true).clear().inner());
    azzert.not(new Bool(false).clear().inner());
  }

  @Test public void testGet() {
    final Bool b1 = new Bool(true);
    azzert.that(b1.get(), is(b1.inner));
    final Bool b2 = new Bool(false);
    azzert.that(b2.get(), is(b2.inner));
  }

  @Test public void testInner() {
    final Bool b1 = new Bool(true);
    azzert.that(b1.inner(), is(b1.inner));
    final Bool b2 = new Bool(false);
    azzert.that(b2.inner(), is(b2.inner));
  }

  @Test public void testSet() {
    final Bool b = new Bool();
    
    b.set(true);
    azzert.aye(b.get());
    azzert.aye(b.inner);
    
    b.set(false);
    azzert.not(b.get());
    azzert.not(b.inner);
    
    b.set();
    azzert.aye(b.get());
    azzert.aye(b.inner);
  }

  @Test public void testValueOf() {
    final Bool b1 = Bool.valueOf(true);
    azzert.aye(b1.get());
    
    b1.set(false);
    azzert.not(b1.get());
    
    b1.set();
    azzert.aye(b1.get());
    
    final Bool b2 = Bool.valueOf(false);
    azzert.not(b2.get());
    
    b2.set(false);
    azzert.not(b2.get());
    
    b2.set();
    azzert.aye(b2.get());
  }
}