package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;
import il.org.spartan.*;

@SuppressWarnings("static-method") public class PairTest {
  public static final int N = 100;
  public static final int M = 37;

  @Test public void testMakePairs() {
    Pair<Object, Object>[] pairs = Pair.makePairs(N);
    azzert.assertEquals(N, pairs.length);
    pairs = Pair.makePairs(N, M);
    azzert.assertEquals(M * N, pairs.length);
  }

  @Test public void testEquals() {
    final Pair<String, Integer> hello1 = Pair.newPair("Hello", Integer.valueOf(1)), hello2 = Pair.newPair("Hello", Integer.valueOf(2)),
        shalom1 = Pair.newPair("Shalom", Integer.valueOf(2)), nullPair = new Pair<>(null, null), firstNull = new Pair<>(null, Integer.valueOf(1)),
        ident = Pair.newPair("Hello", Integer.valueOf(1));
    azzert.assertEquals(true, hello1.equals(hello1));
    azzert.assertEquals(false, hello1.equals(null));
    azzert.assertEquals(false, hello1.equals(new Object()));
    azzert.assertEquals(false, hello1.equals(nullPair));
    azzert.assertEquals(false, nullPair.equals(hello1));
    azzert.assertEquals(false, hello1.equals(hello2));
    azzert.assertEquals(false, hello1.equals(shalom1));
    azzert.assertEquals(true, hello1.equals(ident));
    azzert.assertEquals(false, nullPair.equals(firstNull));
  }

  @Test public void testToString() {
    Assert.assertEquals("<Hello,1>", Pair.newPair("Hello", Integer.valueOf(1)) + "");
  }

  @Test public void testHashCode() {
    final String first = "Hello";
    final Integer second = Integer.valueOf(2);
    azzert.assertEquals(Utils.hash(second) ^ Utils.hash(first) >>> 1, Pair.newPair(first, second).hashCode());
  }
}
