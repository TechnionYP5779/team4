package il.org.spartan.utils;

import static org.mockito.Mockito.*;

import static fluent.ly.azzert.*;

import java.util.function.*;

import org.junit.*;

import fluent.ly.*;

/** A poor man's approximation of a mutable boolean, which is so much more
 * convenient than {@link Boolean}
 * @author Ori Marcovitch
 * @since Oct 16, 2016 */
public final class Bool {
  public static Bool valueOf(final boolean ¢) {
    return new Bool(¢);
  }

  public boolean inner;

  public Bool() {
  }

  public Bool(final boolean b) {
    inner = b;
  }

  public Bool clear() {
    return set(false);
  }

  public boolean get() {
    return inner;
  }

  /** Function form, good substitute for auto-boxing */
  public Boolean inner() {
    return Boolean.valueOf(inner);
  }

  public Bool set() {
    return set(true);
  }

  public Bool set(final boolean ¢) {
    inner = ¢;
    return this;
  }
  
  @SuppressWarnings("static-method") public static class TEST {
    @Test public void test_clear() {
      Bool b = new Bool(true);
      azzert.that(b.clear().inner(), is(false));
    }
    
    @Test public void test_get() {
      Bool b = new Bool(true);
      azzert.that(b.get(), is(b.inner));
    }
    
    @Test public void test_inner() {
      Bool b = new Bool(true);
      azzert.that(b.inner(), is(b.inner));
    }
    
    @Test public void test_set() {
      Bool b = new Bool(true);
      azzert.that(b.inner(), is(true));
      b.set(false);
      azzert.that(b.inner(), is(false));
      b.set();
      azzert.that(b.inner(), is(true));
    }
  }
}
