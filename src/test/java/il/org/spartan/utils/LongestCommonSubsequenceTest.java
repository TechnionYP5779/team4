package il.org.spartan.utils;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class LongestCommonSubsequenceTest {
  @Test public void testSimilarity() {
    azzert.that(new LongestCommonSubsequence("abc123", "abc").similarity(), is(2.0 / 3.0));
    azzert.that(new LongestCommonSubsequence("abc123", "abc123").similarity(), is(1.0));
    azzert.that(new LongestCommonSubsequence("abc123", "def").similarity(), is(0.0));
    azzert.that(new LongestCommonSubsequence("abc123", "").similarity(), is(0.0));
    azzert.that(new LongestCommonSubsequence("", "abc123").similarity(), is(0.0));
  }
}
