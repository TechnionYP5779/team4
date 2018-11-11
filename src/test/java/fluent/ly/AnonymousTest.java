package fluent.ly;

import static fluent.ly.azzert.*;

import java.util.function.*;

import org.junit.*;

@SuppressWarnings("static-method") public class AnonymousTest {
  @Test public void boolSupplier() {
    azzert.aye(anonymous.ly(new BooleanSupplier() {
      @Override public boolean getAsBoolean() {
        return true;
      }
    }));
  }

  @Test public void doubleSupplier() {
    azzert.that(anonymous.ly(new DoubleSupplier() {
      @Override public double getAsDouble() {
        return 5.2;
      }
    }), is(5.2));
  }

  @Test public void intSupplier() {
    azzert.that(anonymous.ly(new IntSupplier() {
      @Override public int getAsInt() {
        return 2;
      }
    }), is(2));
  }

  @Test public void longSupplier() {
    azzert.that(anonymous.ly(new LongSupplier() {
      @Override public long getAsLong() {
        return 20L;
      }
    }), is(20L));
  }

  @Test public void anySupplierNull() {
    azzert.isNull(anonymous.ly(new Supplier<Boolean>() {
      @Override public Boolean get() {
        return null;
      }
    }));
  }
}