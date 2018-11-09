package fluent.ly;
import static fluent.ly.azzert.*;

import java.util.function.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import static fluent.ly.idiomatic.*;

@SuppressWarnings("static-method") public class IdiomaticTest {
    @Test public void evalAndIgnoreTrigger() {
      Supplier<@Nullable Integer> supp = new Supplier<@Nullable Integer>() {
        @Override public Integer get() {
          return Integer.valueOf(10);
        }
      };
      azzert.that(eval.eval(supp), is(Integer.valueOf(10)));
      azzert.isNull(ignore.eval(supp));
      azzert.that(eval.eval(new Integer(10)), is(Integer.valueOf(10)));
      azzert.isNull(ignore.eval(new Integer(10)));
    }

    @Test public void evalOfSupplier() {
      azzert.that(eval(new Supplier<@Nullable Integer>() {
        @Override public Integer get() {
          return Integer.valueOf(10);
        }
      }).get(), is(Integer.valueOf(10)));
    }

    @Test public void incaseTrue() {
      azzert.that(incase(5 > 3, Integer.valueOf(10)), is(Integer.valueOf(10)));
    }

    @Test public void incaseFalse() {
      azzert.isNull(incase(5 > 7, Integer.valueOf(10)));
    }

    @Test public void katchingNoException() {
      azzert.that(katching(new Producer<@Nullable Integer>() {
        @Override public @NotNull Integer λ() throws Exception {
          @NotNull Integer i = new Integer(10);
          return i;
        }
      }), is(Integer.valueOf(10)));
    }

    @Test public void katchingException() {
      azzert.isNull(katching(new Producer<@Nullable Integer>() {
        @Override public @NotNull Integer λ() throws Exception {
          throw new Exception();
        }
      }));
    }

    @Test public void quoteNotNull() {
      azzert.that(quote(new String("Hello")), is(new String("'Hello'")));
    }

    @Test public void quoteNull() {
      azzert.that(quote(null), is(new String("<null reference>")));
    }

    @Test public void runner() {
      Runner r = run(new Runnable() {
        @Override public void run() {
          return;
        }
      });
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
      azzert.that(take(new Integer(10)).get(), is(Integer.valueOf(10)));
    }

    @Test public void unlessTrigger() {
      Supplier<@Nullable Integer> supp = new Supplier<@Nullable Integer>() {
        @Override public Integer get() {
          return new Integer(10);
        }
      };
      azzert.isNull(unless(5 > 3).eval(supp));
      azzert.that(unless(5 < 3).eval(supp), is(Integer.valueOf(10)));
    }

    @Test public void holderUnless() {
      Holder<Integer> holder = new Holder<Integer>() {
        @Override public Integer get() {
          return new Integer(10);
        }
      };
      azzert.that(holder.unless(5 < 3), is(Integer.valueOf(10)));
      azzert.isNull(holder.unless(5 > 3));
    }
  }