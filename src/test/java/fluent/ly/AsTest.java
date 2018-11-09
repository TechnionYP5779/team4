package fluent.ly;

import static org.junit.Assert.*;

import static fluent.ly.azzert.*;

import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;


@SuppressWarnings("static-method") public class AsTest {
  @Test public void asBitOfFalse() {
    azzert.that(as.bit(false), is(0));
  }

  @Test public void asBitOfTrue() {
    azzert.that(as.bit(true), is(1));
  }

  @Test public void asIntArraySimple() {
    final int @NotNull [] is = as.intArray(100, 200, 200, 12, 13, 0);
    assertArrayEquals(is, as.intArray(as.ingeterList(is)));
  }

  @Test public void asListSimple() {
    // direct call `as.list(12, 13, 14)` kills Travis --or
    final @NotNull List<Integer> is = as.list(new int @NotNull [] { 12, 13, 14 });
    azzert.that(is.get(0), is(fluent.ly.box.it(12)));
    azzert.that(is.get(1), is(fluent.ly.box.it(13)));
    azzert.that(is.get(2), is(fluent.ly.box.it(14)));
    azzert.that(is.size(), is(3));
  }

  @Test public void stringOfNull() {
    azzert.that(as.string(null), is("null"));
  }

  @Test public void stringWhenToStringReturnsNull() {
    azzert.that(as.string(new Object() {
      @Override @Nullable public String toString() {
        return null;
      }
    }), is("null"));
  }
  
  @Test public void asIterableOddTillTen() {
    Iterator<Integer> it = as.asIterable(1,3,5,7,9).iterator();
    
    azzert.that(it.hasNext(), is(true));
    azzert.that(it.next(), is(1));
    azzert.that(it.hasNext(), is(true));
    azzert.that(it.next(), is(3));
    
    Iterator<Integer> it2 = as.asIterableLambda(1,3,5,7,9).iterator();
    
    azzert.that(it2.hasNext(), is(true));
    azzert.that(it2.next(), is(1));
    azzert.that(it2.hasNext(), is(true));
    azzert.that(it2.next(), is(3));
    
    Iterator<Integer> it3 = as.asIterableEssence(1,3,5,7,9).iterator();
    
    azzert.that(it3.hasNext(), is(true));
    azzert.that(it3.next(), is(1));
    azzert.that(it3.hasNext(), is(true));
    azzert.that(it3.next(), is(3));
    
    List<Integer> list = as.list(as.asIterable(1,3,5,7,9));
    Integer odds[] = {1,3,5,7,9};
    for(int i = 0; i < odds.length; i++) {
      azzert.that(list.get(i), is(odds[i]));
    }
  }
  
  @Test public void bit0() {
    azzert.that(as.bit(new Object()), is(1));
    azzert.that(as.bit(null), is(0));
  }
  
  @Test public void iteratorOfObjs() {
    @NotNull Object o1 = new Object();
    @NotNull Object o2 = new Object();
    @NotNull Object o3 = new Object();
    Iterator<Object> it = as.iterator(o1, o2, o3);
    azzert.that(it.next(), is(o1));
    azzert.that(it.next(), is(o2));
    azzert.that(it.next(), is(o3));
  }
  
  @Test public void setOfObjs() {
    @NotNull Object o1 = new Object();
    @NotNull Object o2 = new Object();
    @NotNull Object o3 = new Object();
    Set<?> s = as.set(o1,o2,o3,o3);
    azzert.that(s.size(), is(3));
  }
  
  @Test public void charToString() {
    azzert.that(as.string('a'), is("a"));
  }
  
}
