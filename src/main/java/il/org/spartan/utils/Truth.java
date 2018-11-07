package il.org.spartan.utils;

import static fluent.ly.azzert.*;

import java.util.function.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import fluent.ly.*;

public enum Truth {
  T("true"), //
  F("false"), //
  X("Assertion exception"), //
  N("Null pointer exception"), //
  R("Runtime exception"), //
  Ħ("Throwable of some other kind");
  public static Truth truthOf(final BooleanSupplier $) {
    try {
      return $.getAsBoolean() ? T : F;
    } catch (final NullPointerException ¢) {
      forget.it(¢);
      return N;
    } catch (final AssertionError ¢) {
      forget.it(¢);
      return X;
    } catch (final RuntimeException ¢) {
      forget.it(¢);
      return R;
    } catch (final Throwable ¢) {
      forget.it(¢);
      return Ħ;
    }
  }

  Truth not() {
    return this == T ? F : //
        this == F ? T : //
            this;
  }

  Truth or(final Truth other) {
    return this == T ? this : other;
  }

  Truth and(final Truth other) {
    return this == F ? this : other;
  }

  public static String letterOf(final BooleanSupplier ¢) {
    return truthOf(¢) + "";
  }

  @NotNull public final String description;

  Truth(final @NotNull String description) {
    this.description = description;
  }

  @Override public String toString() {
    return description;
  }
  
  
  
  @SuppressWarnings("static-method") public static class TEST {
    @Test public void testNot() {
      Truth t = Truth.T;
      azzert.that(t.not(), is(Truth.F));
      Truth f = Truth.F;
      azzert.that(f.not(), is(Truth.T));
    }
    
    @Test public void testOr() {
      Truth t = Truth.T;
      Truth f = Truth.F;
      azzert.that(t.or(t), is(Truth.T));
      azzert.that(t.or(f), is(Truth.T));
      azzert.that(f.or(t), is(Truth.T));
      azzert.that(f.or(f), is(Truth.F));
    }
    
    @Test public void testAnd() {
      Truth t = Truth.T;
      Truth f = Truth.F;
      azzert.that(t.and(t), is(Truth.T));
      azzert.that(t.and(f), is(Truth.F));
      azzert.that(f.and(t), is(Truth.F));
      azzert.that(f.and(f), is(Truth.F));
    }

  }
  
  
  
}
