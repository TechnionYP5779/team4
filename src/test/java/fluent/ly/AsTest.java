package fluent.ly;

import static fluent.ly.azzert.*;

import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

@SuppressWarnings({ "static-method", "null" }) public class AsTest {
  @Test public void asBitOfFalse() {
    azzert.that(as.bit(false), is(0));
  }

  @Test public void asBitOfTrue() {
    azzert.that(as.bit(true), is(1));
  }

  @Test public void asIntArraySimple() {
    final int @NotNull [] is = as.intArray(100, 200, 200, 12, 13, 0);
    Assert.assertArrayEquals(is, as.intArray(as.ingeterList(is)));
  }

  @Test public void asListSimple() {
    // direct call `as.list(12, 13, 14)` kills Travis --or
    final @NotNull List<Integer> is = as.list(new int @NotNull [] { 12, 13, 14 });
    azzert.that(is.get(0), is(fluent.ly.box.it(12)));
    azzert.that(is.get(1), is(fluent.ly.box.it(13)));
    azzert.that(is.get(2), is(fluent.ly.box.it(14)));
    azzert.that(is.size(), is(3));
  }

  @Test public void stringOfNullString() {
    azzert.that(as.string(null), is("null"));
  }

  @Test public void stringOfNullObject() {
    azzert.that(as.string((Object) null), is("null"));
  }

  @Test public void stringOfString() {
    azzert.that(as.string(""), is(""));
  }

  @Test public void stringWhenToStringReturnsNull() {
    azzert.that(as.string(new Object() {
      @Override @Nullable public String toString() {
        return null;
      }
    }), is("null"));
  }

  @Test public void asIterableOddTillTen() {
    final Iterator<Integer> it = as.asIterable(Integer.valueOf(1), Integer.valueOf(3)).iterator();
    assert it.hasNext();
    azzert.that(it.next(), is(1));
    assert it.hasNext();
    azzert.that(it.next(), is(3));
    assert !it.hasNext();
  }

  @Test public void asIterableOddTillTen1() {
    final Iterator<Integer> it2 = as
        .asIterableLambda(Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(5), Integer.valueOf(7), Integer.valueOf(9)).iterator();
    assert it2.hasNext();
    azzert.that(it2.next(), is(1));
    assert it2.hasNext();
    azzert.that(it2.next(), is(3));
  }

  @Test public void asIterableOddTillTen2() {
    final Iterator<Integer> it3 = as
        .asIterableEssence(Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(5), Integer.valueOf(7), Integer.valueOf(9)).iterator();
    assert it3.hasNext();
    azzert.that(it3.next(), is(1));
    assert it3.hasNext();
    azzert.that(it3.next(), is(3));
  }

  @Test public void asIterableOddTillTen3() {
    final List<Integer> list = as
        .list(as.asIterable(Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(5), Integer.valueOf(7), Integer.valueOf(9)));
    final Integer odds[] = { Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(5), Integer.valueOf(7), Integer.valueOf(9) };
    for (int ¢ = 0; ¢ < odds.length; ++¢)
      azzert.that(list.get(¢), is(odds[¢]));
  }

  @Test public void bit0() {
    azzert.that(as.bit(new Object()), is(1));
    azzert.that(as.bit(null), is(0));
  }

  @Test public void iteratorOfObjs() {
    @NotNull final Object o1 = new Object(), o2 = new Object(), o3 = new Object();
    final Iterator<Object> it = as.iterator(o1, o2, o3);
    azzert.that(it.next(), is(o1));
    azzert.that(it.next(), is(o2));
    azzert.that(it.next(), is(o3));
  }

  @Test public void setOfObjs() {
    @NotNull final Object o2 = new Object(), o3 = new Object();
    azzert.that(as.set(new Object(), o2, o3, o3).size(), is(3));
  }

  @Test public void charToString() {
    azzert.that(as.string('a'), is("a"));
  }

  @Test public void strings1() {
    azzert.that(as.strings(null), is(new String[] {}));
  }

  @Test public void strings2() {
    final List<String> l = new ArrayList<>();
    l.add(null);
    azzert.that(as.strings(l), is(new String[] {}));
  }
}