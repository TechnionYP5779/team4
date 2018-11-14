package an;

import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class IterableTest {
  public static final int A_SIZE = 100;
  public static final int B_SIZE = 88;

  private Integer @NotNull [] randIntArray(final int size) {
    final Integer[] $ = new Integer[size];
    final Random rand = new Random();
    for (int ¢ = 0; ¢ < size; ++¢)
      $[¢] = Integer.valueOf(rand.nextInt());
    return $;
  }

  @Test(expected = NullPointerException.class)
  public void testAlternateNullArg1() {
    iterable.alternate(iterable.over(randIntArray(A_SIZE)), null);
  }
  
  @Test(expected = NullPointerException.class)
  public void testAlternateNullArg2() {
    iterable.alternate(null, iterable.over(randIntArray(A_SIZE)));
  }
  
  @Test(expected = NullPointerException.class)
  public void testAlternateNullArg3() {
    iterable.alternate(null, null);
  }
  
  @Test public void testAlternate() {
    final Integer[] a = randIntArray(A_SIZE), b = randIntArray(B_SIZE);
    Iterator<Integer> altn = iterable.alternate(iterable.over(a), iterable.over(b)).iterator();
    for (int ¢ = 0; ¢ < 2 * B_SIZE; ++¢) {
      azzert.aye(altn.hasNext());
      azzert.that(altn.next(), azzert.is(¢ % 2 == 0 ? a[¢ / 2] : b[¢ / 2]));
    }
    for (int ¢ = B_SIZE; ¢ < A_SIZE; ++¢) {
      azzert.aye(altn.hasNext());
      azzert.that(altn.next(), azzert.is(a[¢]));
    }
    azzert.nay(altn.hasNext());
    altn = iterable.alternate(iterable.over(b), iterable.over(a)).iterator();
    for (int ¢ = 0; ¢ < 2 * B_SIZE; ++¢) {
      azzert.aye(altn.hasNext());
      azzert.that(altn.next(), azzert.is(¢ % 2 == 0 ? b[¢ / 2] : a[¢ / 2]));
    }
    for (int ¢ = B_SIZE; ¢ < A_SIZE; ++¢) {
      azzert.aye(altn.hasNext());
      azzert.that(altn.next(), azzert.is(a[¢]));
    }
    azzert.nay(altn.hasNext());
  }
}
