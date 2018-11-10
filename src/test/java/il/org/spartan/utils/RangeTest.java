package il.org.spartan.utils;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class RangeTest {
  @Test public void testContructor() {
    Range r = new Range(1, 3);
    azzert.that(new Range(r), is(r));
    azzert.not((new Range(1, 2)).equals(r));
  }
  
  @Test public void testHashCode() {
    azzert.that((new Range(0, 0)).hashCode(), is(0));
  }
  
  @Test public void testIsEmpty() {
    azzert.aye((new Range(0, 0)).isEmpty());
    azzert.not((new Range(0, 1)).isEmpty());
  }
  
  @Test public void testIncludedIn() {
    azzert.aye((new Range(0, 2)).includedIn(new Range(-1, 3)));
    azzert.aye((new Range(-1, 2)).includedIn(new Range(-1, 3)));
    azzert.aye((new Range(0, 3)).includedIn(new Range(-1, 3)));
    azzert.aye((new Range(-1, 3)).includedIn(new Range(-1, 3)));
    
    azzert.not((new Range(0, 2)).includedIn(new Range(0, 1)));
    azzert.not((new Range(0, 2)).includedIn(new Range(-3, 1)));
    azzert.not((new Range(0, 2)).includedIn(new Range(0, 3)));
  }
  
  @Test public void testMerge() {
    azzert.that(new Range(0, 5), is(new Range(0, 2).merge(new Range(3, 5))));
  }
  
  @Test public void testOverlapping() {
    azzert.aye(new Range(0, 5).overlapping(new Range(0, 3)));
    azzert.aye(new Range(0, 2).overlapping(new Range(0, 3)));
    azzert.aye(new Range(0, 1).overlapping(new Range(1, 3)));
    
    azzert.not(new Range(0, 1).overlapping(new Range(2, 3)));
    azzert.not(new Range(2, 3).overlapping(new Range(0, 1)));
  }
  
  @Test public void testToString() {
    azzert.that((new Range(0, 5) + ""), is("[0, 5]"));
  }
  
  @Test public void testFindIncludedIn() {
    azzert.isNull((new Range(0, 1).findIncludedIn(null)));
  }
  
  
}
