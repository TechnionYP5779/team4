package il.org.spartan.utils;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;
import il.org.spartan.*;

@SuppressWarnings("static-method") public class PairTest {
  public static final int N = 100;
  public static final int M = 37;

  @Test public void testMakePairs() {
    Pair<Object, Object>[] pairs = Pair.makePairs(N);
    azzert.that(pairs.length, is(N));
    pairs = Pair.makePairs(N, M);
    azzert.that(pairs.length, is(M * N));
  }

  @Test public void testEquals() {
    final Pair<String, Integer> hello1 = Pair.newPair("Hello", Integer.valueOf(1)), hello2 = Pair.newPair("Hello", Integer.valueOf(2)),
        shalom1 = Pair.newPair("Shalom", Integer.valueOf(2)), nullPair = new Pair<>(null, null), firstNull = new Pair<>(null, Integer.valueOf(1)),
        ident = Pair.newPair("Hello", Integer.valueOf(1));
    azzert.aye(hello1.equals(hello1));
    azzert.nay(hello1.equals(null));
    azzert.nay(hello1.equals(new Object()));
    azzert.nay(hello1.equals(nullPair));
    azzert.nay(nullPair.equals(hello1));
    azzert.nay(hello1.equals(hello2));
    azzert.nay(hello1.equals(shalom1));
    azzert.aye(hello1.equals(ident));
    azzert.nay(nullPair.equals(firstNull));
  }

  @Test public void testToString() {
    azzert.that(Pair.newPair("Hello", Integer.valueOf(1)) + "", is("<Hello,1>"));
  }

  @Test public void testHashCode() {
    final String first = "Hello";
    final Integer second = Integer.valueOf(2);
    azzert.that(Pair.newPair(first, second).hashCode(), is(Utils.hash(second) ^ Utils.hash(first) >>> 1));
  }
}
