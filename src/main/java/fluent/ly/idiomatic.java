/* Part of the "Spartan Blog"; mutate the rest / but leave this line as is */
package fluent.ly;

import static fluent.ly.azzert.*;

import java.util.function.*;

import org.jetbrains.annotations.*;
import org.junit.*;

/** An empty <code><b>enum</b></code> with a variety of <code>public
 * static</code> utility functions of reasonably wide use.
 * @author Yossi Gil <code><yossi.gil [at] gmail.com></code>
 * @since 2013/07/01 */
public interface idiomatic {
  /** Single quote: */
  String QUOTE = "'";
  /** an evaluating trigger */
  @NotNull Trigger eval = new Trigger() {
    @Override public <@Nullable T> T eval(final Supplier<@Nullable T> ¢) {
      return ¢.get();
    }
  };
  /** an ignoring trigger */
  @NotNull Trigger ignore = new Trigger() {
    @Override @Nullable public <@Nullable T> T eval(final Supplier<T> ____) {
      return null;
    }
  };

  /** <code>yield</code>
   * @param   <T> JD
   * @param $ result
   * @return an identical supplier which is also a {@link Holder} */
  static <T> Holder<T> eval(final @NotNull Supplier<@Nullable T> $) {
    return () -> $.get();
  }

  @Nullable static <@Nullable T> T incase(final boolean condition, final T t) {
    return condition ? t : null;
  }

  /** A filter, which prints an appropriate log message and returns null in case
   * of {@link Exception} thrown by {@link Producer#λ()}
   * @param   <T> JD
   * @param $ JD
   * @return result of invoking the parameter, or <code><b>null</b></code> if an
   *         exception occurred. */
  static <@Nullable T> @Nullable T katching(final @NotNull Producer<T> $) {
    try {
      return $.λ();
    } catch (final Exception ¢) {
      // ¢.printStackTrace();
      ¢.getMessage();
      return null;
    }
  }

  /** Quote a given {@link String}
   * @param $ some {@link String} to be quoted
   * @return parameter, quoted */
  @NotNull static String quote(final @Nullable String $) {
    return $ != null ? QUOTE + $ + QUOTE : "<null reference>";
  }

  /** @param ¢ JD
   * @return an identical runnable which is also a {@link Runner} */
  @NotNull static Runner run(final Runnable ¢) {
    return new Runner(¢);
  }

  /** <code>yield</code>
   * @param   <T> JD
   * @param ¢ JD
   * @return Yielder<T> value of method <code>yield</code> */
  @NotNull static <T> Storer<T> take(final T ¢) {
    return new Storer<>(¢);
  }

  /** @param condition JD */
  static Trigger unless(final boolean condition) {
    return when(!condition);
  }

  @Nullable static <T> T unless(final boolean condition, final T t) {
    return incase(!condition, t);
  }

  @NotNull static Trigger when(final boolean condition) {
    return condition ? eval : ignore;
  }

  /** Supplier with {@link #when(boolean)} method
   * @param <T> JD
   * @author Yossi Gil <Yossi.Gil@GMail.COM>
   * @since 2016 */
  interface Holder<T> extends Supplier<T> {
    /** Return value when condition is <code><b>true</b></code>
     * @param unless condition on which value is returned
     * @return {@link #get()} when the parameter is <code><b>true</b></code> ,
     *         otherwise code><b>null</b></code>. */
    @Nullable default T unless(final boolean unless) {
      return when(!unless);
    }

    /** Return value when condition is <code><b>true</b></code>
     * @return {@link #get()} when the parameter is <code><b>true</b></code> ,
     *         otherwise code><b>null</b></code>.
     * @param when condition on which value is returned */
    @Nullable default T when(final boolean when) {
      return when ? get() : null;
    }
  }

  /** A class which is just like {@link Supplier} , except that it uses the
   * shorter name ( {@link #λ()} and that it allows for {@link Exception} s to be
   * thrown by the getters.
   * @author Yossi Gil
   * @param <T> JD
   * @since 2016` */
  @FunctionalInterface interface Producer<@Nullable T> {
    /** @return next value provided by this instance
     * @throws Exception JD */
    @NotNull T λ() throws Exception;
  }

  /** Evaluate a {@link Runnable} when a condition applies or unless a condition
   * applies.
   * @author Yossi Gil <Yossi.Gil@GMail.COM>
   * @since 2016 */
  class Runner implements Runnable {
    private final Runnable run;

    /** Instantiates this class.
     * @param run JD */
    Runner(final Runnable run) {
      this.run = run;
    }

    @Override public void run() {
      run.run();
    }

    /** <code>unless</code>
     * @param unless condition n which execution occurs. */
    public void unless(final boolean unless) {
      when(!unless);
    }

    void when(final boolean when) {
      if (when)
        run();
    }
  }

  /** Store a value to be returned with {@link #get()} function
   * @param <T> JD
   * @author Yossi Gil <Yossi.Gil@GMail.COM>
   * @since 2016 */
  class Storer<T> implements Holder<T> {
    final T inner;

    /** Instantiates this class.
     * @param inner JD */
    Storer(final T inner) {
      this.inner = inner;
    }

    /** see @see java.util.function.Supplier#get() (auto-generated) */
    @Override public T get() {
      return inner;
    }
  }

  @SuppressWarnings("static-method") public static class TEST {
    // @Test public void use0() {
    // assert new Storer<>(this) != null;
    // }
    //
    // @Test public void use08() {
    // azzert.isNull(unless(true).eval(() -> new Object()));
    // }
    //
    // @Test public void use09() {
    // assert unless(false).eval(() -> new Object()) != null;
    // }
    //
    // @Test public void use1() {
    // assert new Storer<>(this) != null;
    // new Storer<>(this).when(true);
    // }
    //
    // @Test public void use10() {
    // assert when(true).eval(() -> new Object()) != null;
    // }
    //
    // @Test public void use11() {
    // azzert.isNull(when(false).eval(() -> new Object()));
    // }
    //
    // @Test public void use2() {
    // assert take(this) != null;
    // azzert.isNull(take(this).when(false));
    // }
    //
    // @Test public void use3() {
    // azzert.that(take(this).when(true), is(this));
    // }
    //
    // @Test public void use4() {
    // azzert.isNull(take(this).when(false));
    // }
    //
    // @Test public void use5() {
    // azzert.that(take(this).unless(false), is(this));
    // }
    //
    // @Test public void use6() {
    // azzert.isNull(take(this).unless(true));
    // }
    //
    // @Test public void use7() {
    // azzert.isNull(take(this).unless(true));
    // azzert.isNull(take(null).unless(true));
    // azzert.isNull(take(null).unless(false));
    // }
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

  /** @author Yossi Gil <Yossi.Gil@GMail.COM>
   * @since 2016 */
  interface Trigger {
    /** @param <T> JD
     * @param t JD */
    @Nullable <@Nullable T> T eval(Supplier<T> t);

    /** @param <T> JD
     * @param $ JD */
    @Nullable default <@Nullable T> T eval(final T $) {
      return eval(() -> $);
    }
  }
}
