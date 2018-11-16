package fluent.ly;

import static fluent.ly.azzert.*;
import static fluent.ly.idiomatic.*;

import java.util.function.*;

import org.jetbrains.annotations.*;
import org.junit.*;


@SuppressWarnings("static-method") public class IdiomaticTest {
  @Test public void evalAndIgnoreTrigger() {
    final Supplier<@Nullable Integer> supp = () -> Integer.valueOf(10);
    azzert.that(eval.eval(supp), is(Integer.valueOf(10)));
    azzert.isNull(ignore.eval(supp));
    azzert.that(eval.eval(Integer.valueOf(10)), is(Integer.valueOf(10)));
    azzert.isNull(ignore.eval(Integer.valueOf(10)));
  }

  @Test public void evalOfSupplier() {
    azzert.that(eval(() -> Integer.valueOf(10)).get(), is(Integer.valueOf(10)));
  }

  @Test public void incaseTrue() {
    azzert.that(incase(5 > 3, Integer.valueOf(10)), is(Integer.valueOf(10)));
  }

  @Test public void incaseFalse() {
    azzert.isNull(incase(5 > 7, Integer.valueOf(10)));
  }

  @Test public void katchingException() {
    azzert.isNull(katching(new Producer<@Nullable Integer>() {
      @Override @NotNull public Integer λ() throws Exception {
        throw new Exception();
      }
    }));
  }

  @Test public void quoteNotNull() {
    azzert.that(quote(String.valueOf("Hello")), is(String.valueOf("'Hello'")));
  }

  @Test public void quoteNull() {
    azzert.that(quote(null), is(String.valueOf("<null reference>")));
  }

  @Test public void runner() {
    final Runner r = run(() -> {
      /**/});
    r.unless(5 < 3);
    r.unless(5 > 3);
  }

  @Test public void unlessFalse() {
    azzert.that(unless(5 < 3, Integer.valueOf(10)), is(Integer.valueOf(10)));
  }

  @Test public void unlessTrue() {
    azzert.isNull(unless(5 > 3, Integer.valueOf(10)));
  }

  @Test public void takeInteger() {
    azzert.that(take(Integer.valueOf(10)).get(), is(Integer.valueOf(10)));
  }

  @Test public void unlessTrigger() {
    final Supplier<@Nullable Integer> supp = () -> Integer.valueOf(10);
    azzert.isNull(unless(5 > 3).eval(supp));
    azzert.that(unless(5 < 3).eval(supp), is(Integer.valueOf(10)));
  }

  @Test public void holderUnless() {
    final Holder<Integer> holder = () -> Integer.valueOf(10);
    azzert.that(holder.unless(5 < 3), is(Integer.valueOf(10)));
    azzert.isNull(holder.unless(5 > 3));
  }
}