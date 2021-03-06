package fluent.ly;

import static fluent.ly.azzert.*;

import org.junit.*;

@SuppressWarnings("static-method") public class anonymousTest {
  @Test public void boolSupplier() {
    assert anonymous.ly(() -> true);
  }

  @Test public void doubleSupplier() {
    azzert.that(anonymous.ly(() -> 5.2), is(5.2));
  }

  @Test public void intSupplier() {
    azzert.that(anonymous.ly(() -> 2), is(2));
  }

  @Test public void longSupplier() {
    azzert.that(anonymous.ly(() -> 20L), is(20L));
  }

  @Test public void anySupplierNull() {
    isNull(anonymous.ly(() -> null));
  }
}