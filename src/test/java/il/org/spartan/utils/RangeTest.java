package il.org.spartan.utils;

import static il.org.spartan.utils.Range.*;

import static fluent.ly.azzert.*;

import java.util.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class RangeTest {
  @Test public void testContructor() {
    final Range r = new Range(1, 3);
    azzert.that(new Range(r), is(r));
    azzert.not(new Range(1, 2).equals(r));
  }

  @Test public void testIncludedIn() {
    azzert.aye(new Range(-1, 3).includedIn(new Range(-1, 3)));
    azzert.aye(new Range(-1, 2).includedIn(new Range(-1, 3)));
    azzert.aye(new Range(0, 3).includedIn(new Range(-1, 3)));
    azzert.aye(new Range(0, 2).includedIn(new Range(-1, 3)));
    azzert.not(new Range(0, 2).includedIn(new Range(0, 1)));
    azzert.not(new Range(-1, 1).includedIn(new Range(0, 1)));
    azzert.not(new Range(0, 5).includedIn(new Range(1, 4)));
    azzert.not(new Range(0, 2).includedIn(new Range(-3, 1)));
    azzert.not(new Range(0, 2).includedIn(new Range(0, 3)));
  }

  @Test public void testMerge() {
    azzert.that(new Range(0, 5), is(new Range(0, 2).merge(new Range(3, 5))));
  }

  @Test public void testIsEmpty() {
    azzert.aye(new Range(0, 0).isEmpty());
    azzert.not(new Range(0, 1).isEmpty());
  }

  @Test public void testHashCode() {
    azzert.that(new Range(0, 0).hashCode(), is(0));
  }

  @Test public void testOverlapping() {
    azzert.aye(new Range(0, 3).overlapping(new Range(0, 3)));
    azzert.aye(new Range(0, 4).overlapping(new Range(0, 3)));
    azzert.aye(new Range(-1, 3).overlapping(new Range(0, 3)));
    azzert.aye(new Range(0, 2).overlapping(new Range(0, 3)));
    azzert.aye(new Range(0, 1).overlapping(new Range(1, 3)));
    azzert.not(new Range(-1, 4).overlapping(new Range(0, 3)));
    azzert.not(new Range(0, 1).overlapping(new Range(2, 3)));
    azzert.not(new Range(2, 3).overlapping(new Range(0, 1)));
  }

  @Test public void testToString() {
    azzert.that(new Range(0, 5) + "", is("[0, 5]"));
  }

  @Test public void testFindIncludedIn() {
    azzert.isNull(new Range(0, 1).findIncludedIn(null));
  }

  @Test public void testEquals() {
    azzert.aye(new Range(0, 1).equals(new Range(0, 1)));
    azzert.not(new Range(0, 1).equals(null));
    azzert.not(new Range(0, 1).equals(new Range(2, 3)));
    azzert.not(new Range(2, 3).equals(new Range(0, 1)));
    azzert.not(new Range(1, 2).equals(new Range(1, 3)));
    azzert.not(new Range(1, 3).equals(new Range(1, 2)));
    azzert.not(new Range(1, 3).equals(new Range(2, 3)));
    azzert.not(new Range(2, 3).equals(new Range(1, 3)));
  }

  @Test public void testPruneIncluders() {
    final LinkedList<Range> list = new LinkedList<>();
    list.add(new Range(0, 1));
    list.add(new Range(1, 2));
    list.add(new Range(2, 3));
    list.add(new Range(3, 4));
    azzert.that(list.size(), is(4));
    new Range(-1, -1).pruneIncluders(list);
    azzert.that(list.size(), is(4));
  }
  
  @Test public void firstTwoNaturals() {
    final Iterator<Integer> it = naturals().iterator();
    azzert.that(it.next(), is(0));
    azzert.that(it.next(), is(1));
  }

  @Test public void firstTwoNaturals2() {
    final Iterator<Integer> it2 = to(-1).from(0).step(1).infiniteRange().iterator();
    azzert.that(it2.next(), is(0));
    azzert.that(it2.next(), is(1));
  }

  @Test public void firstTwoNaturals3() {
    final Iterator<Integer> it3 = infinite().iterator();
    azzert.that(it3.next(), is(0));
    azzert.that(it3.next(), is(1));
  }

  @Test public void firstTwoNaturals4() {
    final Iterator<Integer> it4 = to(-1).from(0).infinite().iterator();
    azzert.that(it4.next(), is(0));
    azzert.that(it4.next(), is(1));
  }

  @Test public void firstTwoNaturals5() {
    final Iterator<Integer> it5 = from(0).self().step(1).infinite().iterator();
    azzert.that(it5.next(), is(0));
    azzert.that(it5.next(), is(1));
  }

  @Test public void firstTwoNaturals6() {
    final Iterator<Integer> it6 = from(0).infinite().iterator();
    azzert.that(it6.next(), is(0));
    azzert.that(it6.next(), is(1));
  }

  @Test public void firstTwoNaturals7() {
    final Iterator<Integer> it7 = infiniteFrom(0, 4).from(2).iterator();
    azzert.that(it7.next(), is(2));
    azzert.that(it7.next(), is(3));
  }

  @Test public void firstTwoNumerlas() {
    final Iterator<Integer> it = numerals().iterator();
    azzert.that(it.next(), is(1));
    azzert.that(it.next(), is(2));
  }

  @Test public void firstTwoOdds() {
    final Iterator<Integer> it = odds().iterator();
    azzert.that(it.next(), is(1));
    azzert.that(it.next(), is(3));
  }

  @Test public void rangeOfArray() {
    final Iterator<Integer> it = of(new Double[] { Double.valueOf(1.1), Double.valueOf(2.2), Double.valueOf(3.3) }).iterator();
    azzert.that(it.next(), is(0));
    azzert.that(it.next(), is(1));
    azzert.that(it.next(), is(2));
    try {
      it.next();
      azzert.fail();
    } catch (final NoSuchElementException ¢) {
      ¢.getMessage();
      return;
    }
  }

  @Test public void infiniteSameValue() {
    final Iterator<Integer> it = infinite(2).iterator();
    azzert.that(it.next(), is(2));
    azzert.that(it.next(), is(2));
  }

  @Test public void exclusiveRange() {
    final Iterator<Integer> it = from(0).to(2).step(1).exclusive().iterator();
    azzert.that(it.next(), is(0));
    azzert.that(it.next(), is(1));
    try {
      it.next();
      azzert.fail();
    } catch (final NoSuchElementException ¢) {
      ¢.getMessage();
      return;
    }
  }

  @Test public void streamOfAfter() {
    azzert.that(to(10).from(0).step(1).stream().findFirst().get(), is(0));
  }
}
