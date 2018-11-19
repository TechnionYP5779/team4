package il.org.spartan.utils;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class TruthTest {
  @Test public void testNot1() {
    azzert.that(Truth.T.not(), is(Truth.F));
  }

  @Test public void testNot2() {
    azzert.that(Truth.F.not(), is(Truth.T));
  }

  @Test public void testNot3() {
    azzert.that(Truth.T.not().not(), is(Truth.T));
  }

  @Test public void testNot4() {
    azzert.that(Truth.F.not().not(), is(Truth.F));
  }

  @Test public void testNot5() {
    azzert.that(Truth.T.not().not().not(), is(Truth.F));
  }

  @Test public void testNot6() {
    azzert.that(Truth.F.not().not().not(), is(Truth.T));
  }

  @Test public void testOr1() {
    azzert.that(Truth.T.or(Truth.T), is(Truth.T));
    azzert.that(Truth.T.or(Truth.F), is(Truth.T));
    azzert.that(Truth.F.or(Truth.T), is(Truth.T));
    azzert.that(Truth.F.or(Truth.F), is(Truth.F));
  }

  @Test public void testOr2() {
    azzert.that(Truth.T.or(Truth.T).not(), is(Truth.F));
    azzert.that(Truth.T.or(Truth.F).not(), is(Truth.F));
    azzert.that(Truth.F.or(Truth.T).not(), is(Truth.F));
    azzert.that(Truth.F.or(Truth.F).not(), is(Truth.T));
  }

  @Test public void testAnd1() {
    azzert.that(Truth.T.and(Truth.T), is(Truth.T));
    azzert.that(Truth.T.and(Truth.F), is(Truth.F));
    azzert.that(Truth.F.and(Truth.T), is(Truth.F));
    azzert.that(Truth.F.and(Truth.F), is(Truth.F));
  }

  @Test public void testAnd2() {
    azzert.that(Truth.T.and(Truth.T).not(), is(Truth.F));
    azzert.that(Truth.T.and(Truth.F).not(), is(Truth.T));
    azzert.that(Truth.F.and(Truth.T).not(), is(Truth.T));
    azzert.that(Truth.F.and(Truth.F).not(), is(Truth.T));
  }

  @Test public void testAndOr1() {
    azzert.that(Truth.T.and(Truth.T).or(Truth.F), is(Truth.T));
    azzert.that(Truth.T.and(Truth.F).or(Truth.F), is(Truth.F));
    azzert.that(Truth.F.and(Truth.T).or(Truth.F), is(Truth.F));
    azzert.that(Truth.F.and(Truth.F).or(Truth.F), is(Truth.F));
  }

  @Test public void testAndOr2() {
    azzert.that(Truth.T.or(Truth.T).and(Truth.T), is(Truth.T));
    azzert.that(Truth.T.or(Truth.F).and(Truth.T), is(Truth.T));
    azzert.that(Truth.F.or(Truth.T).and(Truth.T), is(Truth.T));
    azzert.that(Truth.F.or(Truth.F).and(Truth.T), is(Truth.F));
  }

  @Test public void testToString1() {
    azzert.that(Truth.T + "", is("true"));
  }

  @Test public void testToString2() {
    azzert.that(Truth.T + "", is("true"));
  }

  @Test public void testToString3() {
    azzert.that(Truth.F + "", is("false"));
  }

  @Test public void testToString4() {
    azzert.that(Truth.X + "", is("Assertion exception"));
  }

  @Test public void testToString5() {
    azzert.that(Truth.N + "", is("Null pointer exception"));
  }

  @Test public void testToString6() {
    azzert.that(Truth.R + "", is("Runtime exception"));
  }

  @Test public void testToString7() {
    azzert.that(Truth.Ħ + "", is("Throwable of some other kind"));
  }

  @Test public void testLetterOf1() {
    azzert.that(Truth.letterOf(() -> true), is("true"));
  }

  @Test public void testLetterOf2() {
    azzert.that(Truth.letterOf(() -> false), is("false"));
  }

  @Test public void testLetterOf3() {
    azzert.that(Truth.letterOf(null), is("Null pointer exception"));
  }
}