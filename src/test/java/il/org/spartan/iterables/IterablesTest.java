package il.org.spartan.iterables;

import static il.org.spartan.Utils.*;

import static fluent.ly.azzert.*;

import org.junit.*;

import an.*;
import fluent.ly.*;

//
/** A static nested class hosting unit tests for the nesting class Unit test for
 * the containing class. Note the naming convention: a) names of test methods do
 * not use are not prefixed by "test". This prefix is redundant. b) test methods
 * begin with the name of the method they check.
 * @author Yossi Gil
 * @since 2014-05-31 */
@SuppressWarnings("static-method") public class IterablesTest {
  @Test public void containsDegenerate() {
    azzert.nay(contains("Hello"));
  }

  @Test public void containseturnsFalseTypical() {
    azzert.nay(contains("Hello", null, "x", "y", null, "z", "w", "u", "v"));
  }

  @Test public void containsSimple() {
    azzert.aye("", contains("Hello", "e"));
  }

  @Test public void containsTypical() {
    azzert.aye("", contains("Hello", "a", "b", "c", "d", "e", "f"));
  }

  @Test public void containsWithNulls() {
    azzert.aye("", contains("Hello", null, "a", "b", null, "c", "d", "e", "f", null));
  }

  @Test public void countDoesNotIncludeNull() {
    azzert.that(iterables.count(iterable.over(null, "One", null, "Two", null, "Three")), is(3));
  }

  @Test public void countEmpty() {
    azzert.that(iterables.count(iterables.<String> empty()), is(0));
  }

  @Test public void countSingleton() {
    azzert.that(iterables.count(iterable.singleton(new Object())), is(1));
  }

  @Test public void countThree() {
    azzert.that(iterables.count(iterable.over("One", "Two", "Three")), is(3));
  }
}
