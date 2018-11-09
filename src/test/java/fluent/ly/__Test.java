package fluent.ly;

import static org.junit.Assert.assertEquals;

import static fluent.ly.azzert.*;
import static fluent.ly.azzert.assertEquals;

import org.junit.*;

import fluent.ly.___.Variant;
import fluent.ly.___.Bug.Assertion.*;
import fluent.ly.___.Bug.Assertion.Value.Numerical.*;
import fluent.ly.___.Bug.Assertion.Variant.*;
import fluent.ly.___.Bug.Contract.*;

@SuppressWarnings("static-method") public class __Test {
  @Test public void ensure() {
    ___.ensure(true);
    try {
      ___.ensure(false);
    } catch (final Postcondition e) {
      azzert.that(e.getMessage(), is(""));
    }
    try {
      ___.ensure(false, "ensure");
    } catch (final Postcondition e) {
      azzert.that(e.getMessage(), is("ensure"));
    }
    try {
      ___.ensure(false, "ensure %s message %s", "this", "now");
    } catch (final Postcondition e) {
      azzert.that(e.getMessage(), is("ensure this message now"));
    }
  }

  @Test public void negative() {
    ___.negative(-1);
    ___.negative(-2);
    ___.negative(-0.3);
    try {
      ___.negative(0);
    } catch (final Negative ¢) {
      azzert.that(¢.getMessage(), is("Found 0 while expecting a negative integer."));
    }
    try {
      ___.negative(0.0);
    } catch (final Negative ¢) {
      azzert.that(¢.getMessage(), is("Found 0.00000 while expecting a negative number."));
    }
    try {
      ___.negative(-1);
    } catch (final Negative ¢) {
      azzert.that(¢.getMessage(), is("Found -1 while expecting a negative integer."));
    }
    try {
      ___.negative(-1.0);
    } catch (final Negative ¢) {
      azzert.that(¢.getMessage(), is("Found -1.00000 while expecting a negative number."));
    }
  }

  @Test public void nonnegative() {
    ___.nonnegative(1);
    ___.nonnegative(2);
    ___.nonnegative(0);
    ___.nonnegative(0.3);
    ___.nonnegative(0.0);
    try {
      ___.nonnegative(1);
    } catch (final NonNegative ¢) {
      azzert.that(¢.getMessage(), is("Found -1 while expecting a negative integer."));
    }
    try {
      ___.nonnegative(1.0);
    } catch (final NonNegative ¢) {
      azzert.that(¢.getMessage(), is("Found -1.00000 while expecting a negative number."));
    }
  }

  @Test public void nonnull() {
    ___.nonnull(new Object());
    try {
      ___.nonnull(null);
    } catch (final Exception ¢) {
      azzert.that(¢.getMessage(), is(""));
    }
    try {
      ___.nonnull(null, "nonnull");
    } catch (final Exception ¢) {
      azzert.that(¢.getMessage(), is("nonnull"));
    }
    try {
      ___.nonnull(null, "nonnull %s message %s", "this", "now");
    } catch (final Exception ¢) {
      azzert.that(¢.getMessage(), is("nonnull this message now"));
    }
  }

  @Test public void nonpositive() {
    ___.nonpositive(-1);
    ___.nonpositive(-2);
    ___.nonpositive(-0.3);
    ___.nonpositive(0);
    ___.nonpositive(0.0);
    try {
      ___.nonpositive(-1);
    } catch (final NonPositive ¢) {
      azzert.that(¢.getMessage(), is("Found -1 while expecting a nonpositive integer."));
    }
    try {
      ___.nonpositive(-1.0);
    } catch (final NonPositive ¢) {
      azzert.that(¢.getMessage(), is("Found -1.00000 while expecting a nonpositive number."));
    }
  }

  @Test public void positive() {
    ___.positive(1);
    ___.positive(2);
    ___.positive(0.3);
    try {
      ___.positive(0);
    } catch (final Positive ¢) {
      azzert.that(¢.getMessage(), is("Found 0 while expecting a positive integer."));
    }
    try {
      ___.positive(0.0);
    } catch (final Positive ¢) {
      azzert.that(¢.getMessage(), is("Found 0.00000 while expecting a positive number."));
    }
    try {
      ___.positive(-1);
    } catch (final Positive ¢) {
      azzert.that(¢.getMessage(), is("Found -1 while expecting a positive integer."));
      }
    try {
      ___.positive(-1.0);
    } catch (final Positive ¢) {
      azzert.that(¢.getMessage(), is("Found -1.00000 while expecting a positive number."));
    }
  }


  @Test public void require() {
    ___.require(true);
    try {
      ___.require(false);
    } catch (final Precondition ¢) {
      azzert.that(¢.getMessage(), is(""));
    }
    try {
      ___.require(false, "requireMessage");
    } catch (final Precondition ¢) {
      azzert.that(¢.getMessage(), is("requireMessage"));
    }
    try {
      ___.require(false, "require %s message %s", "this", "now");
    } catch (final Precondition ¢) {
      azzert.that(¢.getMessage(), is("require this message now"));
    }
  }

  @Test(expected = ___.Bug.class) public void requireBug() {
    ___.require(false);
  }

  @Test(expected = Precondition.class) public void requirePrecondition() {
    ___.require(false);
  }

  @Test public void sure() {
    ___.sure(true);
    try {
      ___.sure(false);
    } catch (final Invariant e) {
      azzert.that(e.getMessage(), is(""));
    }
    try {
      ___.sure(false, "sure");
    } catch (final Invariant e) {
      azzert.that(e.getMessage(), is("sure"));
    }
    try {
      ___.sure(false, "sure %s message %s", "this", "now");
    } catch (final Invariant e) {
      azzert.that(e.getMessage(), is("sure this message now"));
    }
  }

  @Test public void unreachable() {
    try {
      ___.unreachable();
    } catch (final Reachability ¢) {
      assertEquals("", ¢.getMessage());
    }
    try {
      ___.unreachable("unreachable message");
    } catch (final Reachability ¢) {
      azzert.that(¢.getMessage(), is("unreachable message"));
    }
    try {
      ___.unreachable("unreachable %s message %s", "this", "now");
    } catch (final Reachability ¢) {
      azzert.that(¢.getMessage(), is("unreachable this message now"));
    }
  }

  @Test public void variant() {
    {
      final Variant v = new Variant(10);
      assertEquals(10, v.value());
      v.check(9);
      v.check(8);
      v.check(4);
      v.check(2);
      v.check(1);
      v.check(0);
      azzert.that(v.value(), is(0));
    }
    try {
      ___.unused(new Variant(-1));
    } catch (final Initial e) {
      azzert.that(e.getMessage(), is("Initial variant value (-1) is negative"));
    }
    try {
      final Variant v = new Variant(10);
      v.check(8);
      v.check(9);
    } catch (final Nondecreasing ¢) {
      azzert.that(¢.getMessage(), is("New variant value (9) should be less than previous value (8)"));
    }
    try {
      final Variant v = new Variant(10);
      v.check(8);
      v.check(-2);
    } catch (final Underflow ¢) {
      azzert.that(¢.getMessage(), is("New variant value (-2) is negative"));
    }
  }
}
