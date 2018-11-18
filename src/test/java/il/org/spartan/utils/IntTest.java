package il.org.spartan.utils;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class IntTest {
  @Test public void testGet() {
    azzert.that(new Int(3).get(), is(3));
    azzert.that(new Int(0).get(), is(0));
    azzert.that(new Int(-1).get(), is(-1));
  }

  @Test public void testStep() {
    final Int i = new Int(3);
    
    i.step();
    azzert.that(i.get(), is(4));
    
    i.step();
    azzert.that(i.get(), is(5));
    
    i.step();
    azzert.that(i.get(), is(6));
    
    i.step();
    azzert.that(i.get(), is(7));
    
    i.step();
    azzert.that(i.get(), is(8));
    
    final Int i1 = new Int(-1);
    i1.step(); 
    i1.step();
    i1.step();
    azzert.that(i1.get(), is(2));
  }

  @Test public void testAdd() {
    final Int i = new Int(3);
    i.add(2);
    azzert.that(i.get(), is(5));
    
    i.add(0);
    azzert.that(i.get(), is(5));
    
    i.add(-6);
    azzert.that(i.get(), is(-1));
    
    i.add(1);
    azzert.that(i.get(), is(0));
    
    i.add(1);
    azzert.that(i.get(), is(1));
    
    i.add(1);
    azzert.that(i.get(), is(2));
  }

  @Test public void testSet() {
    final Int i = new Int(3);
    
    i.set(2);
    azzert.that(i.get(), is(2));
    
    i.set(-1);
    azzert.that(i.get(), is(-1));
    
    i.set(0);
    azzert.that(i.get(), is(0));
  }

  @Test public void testNext() {
    final Int i = new Int(3);
    i.next();
    azzert.that(i.get(), is(4));
    
    i.next();
    azzert.that(i.get(), is(5));
    
    i.next();
    azzert.that(i.get(), is(6));
    
    i.next();
    azzert.that(i.get(), is(7));
    
    i.next();
    azzert.that(i.get(), is(8));
  }

  @Test public void testAddOther() {
    final Int i1 = new Int(3), i2 = new Int(4), i3 = new Int(0), i4 = new Int(-1);
    i1.add(i2);
    azzert.that(i1.get(), is(7));
    azzert.that(i2.get(), is(4));
    
    i1.add(i3);
    azzert.that(i1.get(), is(7));
    azzert.that(i2.get(), is(4));
    
    i1.add(i4);
    azzert.that(i1.get(), is(6));
    azzert.that(i4.get(), is(-1));
  }

  @Test public void testClear() {
    final Int i = new Int(3);
    i.clear();
    azzert.that(i.get(), is(0));
    
    final Int i1 = new Int(0);
    i1.clear();
    azzert.that(i1.get(), is(0));
    
    final Int i2 = new Int(-1);
    i2.clear();
    azzert.that(i2.get(), is(0));
  }

  @Test public void testContsrtuctor() {
    final Int i = new Int();
    i.clear();
    azzert.that(i.get(), is(0));
  }

  @Test public void testInner() {
    final Int i = new Int();
    i.clear();
    azzert.that(i.inner(), is(0));
    
    i.add(1);
    azzert.that(i.inner(), is(1));
    
    i.next();
    azzert.that(i.inner(), is(2));
  }

  @Test public void testValueOf() {
    azzert.that(Int.valueOf(4).inner(), is(4));
  }

  @Test public void testToString() {
    azzert.that(new Int(4) + "", is("4"));
    azzert.that(new Int(0) + "", is("0"));
    azzert.that(new Int(-1) + "", is("-1"));
  }
}