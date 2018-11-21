package fluent.ly;

import static fluent.ly.azzert.*;

import java.util.function.*;

import org.junit.*;

@SuppressWarnings("static-method") public class nilTest {
  private final Object o = null;

  @Test public void testIgnoring0() {
    azzert.that(nil.ignoring(true), is(o));
  }

  @Test public void testIgnoring1() {
    azzert.that(nil.ignoring(false), is(o));
  }

  @Test public void testIgnoring2() {
    azzert.that(nil.ignoring(1), is(o));
  }

  @Test public void testIgnoring3() {
    azzert.that(nil.ignoring(0), is(o));
  }

  @Test public void testIgnoring4() {
    azzert.that(nil.ignoring(1.0), is(o));
  }

  @Test public void testIgnoring5() {
    azzert.that(nil.ignoring(-1), is(o));
  }

  @Test public void testForgetting1() {
    azzert.isNull(nil.forgetting(null));
  }

  @Test public void testForgetting2() {
    azzert.isNull(nil.forgetting("1"));
  }

  @Test public void testForgetting3() {
    azzert.isNull(nil.forgetting(Integer.valueOf(1)));
  }

  static String helloString = "Hello";

  @Test public void t() {
    final Integer i1 = nil.guardingly(String::length).on(helloString);
    azzert.that(i1, is(5));
    final Integer i2 = nil.guardingly(String::length).on(nullString);
    azzert.that(i1, is(5));
    isNull(i2);
    final Integer i3 = nil.guardingly(f).on(nullString);
    azzert.that(i1, is(5));
    isNull(i2);
    isNull(i3);
    nil.guardingly(State::getName).on(null);
    nil.guardingly(State::getName).on(californiaCustomer.getAddress().getState());
  }

  String nullString;
  final Customer californiaCustomer = () -> () -> new State() {
    @Override public String getName() {
      return "California";
    }
  };
  final Function<String, Integer> f = String::length;
  final Customer nullAddressCustomer = () -> null;
  final Customer nullNameCustomer = () -> () -> new State() {/***/
  };
  final Customer nullStateCustomer = () -> () -> null;
  final Customer nullStateCustomer1 = () -> () -> null;

  //@formatter:off
  interface Address { State getState(); }
  interface Customer { Address getAddress(); }
  interface State {default String getName() { return null; } }
}