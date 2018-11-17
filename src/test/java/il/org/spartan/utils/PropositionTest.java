package il.org.spartan.utils;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class PropositionTest {
  @Test public void testAND() {
    assert Proposition.AND(Proposition.T, Proposition.T).eval();
    assert !Proposition.AND(Proposition.T, Proposition.F).eval();
    assert !Proposition.AND(Proposition.F, Proposition.T).eval();
    assert !Proposition.AND(Proposition.F, Proposition.F).eval();
    assert Proposition.AND("abc", Proposition.T, Proposition.T).eval();
    assert !Proposition.AND("abc", Proposition.T, Proposition.F).eval();
    assert !Proposition.AND("abc", Proposition.F, Proposition.T).eval();
    assert !Proposition.AND("abc", Proposition.F, Proposition.F).eval();
  }

  @Test public void testOR() {
    assert Proposition.OR(Proposition.T, Proposition.T).eval();
    assert Proposition.OR(Proposition.T, Proposition.F).eval();
    assert Proposition.OR(Proposition.F, Proposition.T).eval();
    assert !Proposition.OR(Proposition.F, Proposition.F).eval();
    assert Proposition.OR("abc", Proposition.T, Proposition.T).eval();
    assert Proposition.OR("abc", Proposition.T, Proposition.F).eval();
    assert Proposition.OR("abc", Proposition.F, Proposition.T).eval();
    assert !Proposition.OR("abc", Proposition.F, Proposition.F).eval();
  }

  @Test public void testNot() {
    assert !Proposition.not(Proposition.T).eval();
    assert Proposition.not(Proposition.F).eval();
  }

  @Test public void testThat() {
    assert Proposition.that(Proposition.T).eval();
    assert !Proposition.that(Proposition.F).eval();
  }

  @Test public void testToString() {
    azzert.that(Proposition.T + "", is("T"));
  }
}
