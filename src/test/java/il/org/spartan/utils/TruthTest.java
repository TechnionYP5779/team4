package il.org.spartan.utils;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class TruthTest {
  @Test public void testNot() {
    azzert.that(Truth.T.not(), is(Truth.F));
    azzert.that(Truth.F.not(), is(Truth.T));
    
    azzert.that(Truth.T.not().not(), is(Truth.T));
    azzert.that(Truth.F.not().not(), is(Truth.F));
    
    azzert.that(Truth.T.not().not().not(), is(Truth.F));
    azzert.that(Truth.F.not().not().not(), is(Truth.T));
  }

  @Test public void testOr() {
    azzert.that(Truth.T.or(Truth.T), is(Truth.T));
    azzert.that(Truth.T.or(Truth.F), is(Truth.T));
    azzert.that(Truth.F.or(Truth.T), is(Truth.T));
    azzert.that(Truth.F.or(Truth.F), is(Truth.F));
    
    azzert.that(Truth.T.or(Truth.T).not(), is(Truth.F));
    azzert.that(Truth.T.or(Truth.F).not(), is(Truth.F));
    azzert.that(Truth.F.or(Truth.T).not(), is(Truth.F));
    azzert.that(Truth.F.or(Truth.F).not(), is(Truth.T));
  }

  @Test public void testAnd() {
    azzert.that(Truth.T.and(Truth.T), is(Truth.T));
    azzert.that(Truth.T.and(Truth.F), is(Truth.F));
    azzert.that(Truth.F.and(Truth.T), is(Truth.F));
    azzert.that(Truth.F.and(Truth.F), is(Truth.F));
    
    azzert.that(Truth.T.and(Truth.T).not(), is(Truth.F));
    azzert.that(Truth.T.and(Truth.F).not(), is(Truth.T));
    azzert.that(Truth.F.and(Truth.T).not(), is(Truth.T));
    azzert.that(Truth.F.and(Truth.F).not(), is(Truth.T));
  }
  
  @Test public void testAndOr() {
    azzert.that(Truth.T.and(Truth.T).or(Truth.F), is(Truth.T));
    azzert.that(Truth.T.and(Truth.F).or(Truth.F), is(Truth.F));
    azzert.that(Truth.F.and(Truth.T).or(Truth.F), is(Truth.F));
    azzert.that(Truth.F.and(Truth.F).or(Truth.F), is(Truth.F));
    
    azzert.that(Truth.T.or(Truth.T).and(Truth.T), is(Truth.T));
    azzert.that(Truth.T.or(Truth.F).and(Truth.T), is(Truth.T));
    azzert.that(Truth.F.or(Truth.T).and(Truth.T), is(Truth.T));
    azzert.that(Truth.F.or(Truth.F).and(Truth.T), is(Truth.F));
  }

  @Test public void testToString() {
    azzert.that(Truth.T + "", is("true"));
    azzert.that(Truth.F + "", is("false"));
    azzert.that(Truth.X + "", is("Assertion exception"));
    azzert.that(Truth.N + "", is("Null pointer exception"));
    azzert.that(Truth.R + "", is("Runtime exception"));
    azzert.that(Truth.Ħ + "", is("Throwable of some other kind"));
  }

  @Test public void testLetterOf() {
    azzert.that(Truth.letterOf(() -> true), is("true"));
    azzert.that(Truth.letterOf(() -> false), is("false"));
    azzert.that(Truth.letterOf(null), is("Null pointer exception"));
  }
}