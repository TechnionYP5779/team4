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
    azzert.assertEquals(N * M, pairs.length);
  }
  
  @Test public void testEquals() {
    Pair<String, Integer> hello1 = Pair.newPair("Hello", Integer.valueOf(1));
    Pair<String, Integer> hello2 = Pair.newPair("Hello", Integer.valueOf(2));
    Pair<String, Integer> shalom1 = Pair.newPair("Shalom", Integer.valueOf(2));
    Pair<String, Integer> nullPair = new Pair<>(null, null);
    Pair<String, Integer> firstNull = new Pair<>(null, Integer.valueOf(1));
    Pair<String, Integer> ident = Pair.newPair("Hello", Integer.valueOf(1));
    
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
  
  @SuppressWarnings("static-access") @Test public void testToString() {
    String pairString = Pair.newPair("Hello", Integer.valueOf(1)).toString();
    azzert.assertEquals("<Hello,1>", pairString);
    
  }
  
  @Test public void testHashCode() {
    String first = "Hello";
    Integer second = Integer.valueOf(2);
    Pair<String, Integer> p = Pair.newPair(first, second);
    azzert.assertEquals(Utils.hash(second) ^ Utils.hash(first) >>> 1, p.hashCode());
    
  }
}
