package il.org.spartan.utils;

import java.util.function.*;

import org.junit.*;

import fluent.ly.*;
import static fluent.ly.azzert.*;


@SuppressWarnings("static-method") public class PropositionReducerTest {
  @Test public void reduce1() {
    azzert.that((new PropositionReducer<Integer>(new Reduce<Integer>() {
      @Override public Integer reduce() {
        return box.boxInteger(0);
      }

      @Override public Integer reduce(Integer r1, Integer r2) {
        return box.boxInteger(unbox.unboxInteger(r1) + unbox.unboxInteger(r2));
      }
    }) {
      @Override protected Integer map(BooleanSupplier ¢) {
        return box.boxInteger(¢.getAsBoolean() ? 1 : 0);
      }
    }).reduce(() -> true), is(Integer.valueOf(1)));
  }
  
  
  @Test public void reduceAndAllTrue() {
    azzert.that((new PropositionReducer<Integer>(new Reduce<Integer>() {
      @Override public Integer reduce() {
        return box.boxInteger(0);
      }

      @Override public Integer reduce(Integer r1, Integer r2) {
        return box.boxInteger(unbox.unboxInteger(r1) + unbox.unboxInteger(r2));
      }
    }) {
      @Override protected Integer map(BooleanSupplier ¢) {
        return box.boxInteger(¢.getAsBoolean() ? 1 : 0);
      }
    }).reduce(new Proposition.And(() -> true, new BooleanSupplier[] {()->true})), is(Integer.valueOf(2)));
  }
  
  @Test public void reduceAndWithFalse() {
    azzert.that((new PropositionReducer<Integer>(new Reduce<Integer>() {
      @Override public Integer reduce() {
        return box.boxInteger(0);
      }

      @Override public Integer reduce(Integer r1, Integer r2) {
        return box.boxInteger(unbox.unboxInteger(r1) + unbox.unboxInteger(r2));
      }
    }) {
      @Override protected Integer map(BooleanSupplier ¢) {
        return box.boxInteger(¢.getAsBoolean() ? 1 : 0);
      }
    }).reduce(new Proposition.And(() -> true, new BooleanSupplier[] {()->false})), is(Integer.valueOf(1)));
  }
}
