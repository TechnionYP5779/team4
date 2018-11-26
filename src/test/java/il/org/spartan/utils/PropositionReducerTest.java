package il.org.spartan.utils;

import static fluent.ly.azzert.*;

import java.util.function.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class PropositionReducerTest {
  @Test public void reduce1() {
    azzert.that(new PropositionReducer<Integer>(new Reduce<Integer>() {
      @Override public Integer reduce() {
        return box.it(0);
      }

      @Override public Integer reduce(final Integer r1, final Integer r2) {
        return box.it(unbox.it(r1) + unbox.it(r2));
      }
    }) {
      @Override protected Integer map(final BooleanSupplier ¢) {
        return box.it(¢.getAsBoolean() ? 1 : 0);
      }
    }.reduce(() -> true), is(Integer.valueOf(1)));
  }

  @Test public void reduceAndAllTrue() {
    azzert.that(new PropositionReducer<Integer>(new Reduce<Integer>() {
      @Override public Integer reduce() {
        return box.it(0);
      }

      @Override public Integer reduce(final Integer r1, final Integer r2) {
        return box.it(unbox.it(r1) + unbox.it(r2));
      }
    }) {
      @Override protected Integer map(final BooleanSupplier ¢) {
        return box.it(¢.getAsBoolean() ? 1 : 0);
      }
    }.reduce(new Proposition.And(() -> true, new BooleanSupplier[] { () -> true })), is(Integer.valueOf(2)));
  }

  @Test public void reduceAndWithFalse() {
    azzert.that(new PropositionReducer<Integer>(new Reduce<Integer>() {
      @Override public Integer reduce() {
        return box.it(0);
      }

      @Override public Integer reduce(final Integer r1, final Integer r2) {
        return box.it(unbox.it(r1) + unbox.it(r2));
      }
    }) {
      @Override protected Integer map(final BooleanSupplier ¢) {
        return box.it(¢.getAsBoolean() ? 1 : 0);
      }
    }.reduce(new Proposition.And(() -> true, new BooleanSupplier[] { () -> false })), is(Integer.valueOf(1)));
  }
}
