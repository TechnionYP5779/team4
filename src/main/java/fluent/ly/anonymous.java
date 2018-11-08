package fluent.ly;

import java.util.function.*;

import org.junit.*;

import static fluent.ly.azzert.*;


/** TODO Yossi Gil: document class
 * @author Yossi Gil
 * @since 2017-04-12 */
public interface anonymous {
  static boolean ly(final BooleanSupplier $) {
    return $.getAsBoolean();
  }

  static double ly(final DoubleSupplier $) {
    return $.getAsDouble();
  }

  static int ly(final IntSupplier $) {
    return $.getAsInt();
  }

  static long ly(final LongSupplier $) {
    return $.getAsLong();
  }

  static <T> T ly(final Supplier<T> $) {
    return $.get();
  }
  
  @SuppressWarnings("static-method") public static class TEST {
    @Test public void boolSupplier() {
      BooleanSupplier mock = new BooleanSupplier() {
        @Override
        public boolean getAsBoolean() {
          return true;
        }
      };
      
      azzert.that(ly(mock), is(true));
    }
    
    @Test public void doubleSupplier() {
      DoubleSupplier mock = new DoubleSupplier() {
        @Override
        public double getAsDouble() {
          return 5.2;
        }
      };
      
      azzert.that(ly(mock), is(5.2));
    }
    
    @Test public void intSupplier() {
      IntSupplier mock = new IntSupplier() {
        @Override
        public int getAsInt() {
          return 2;
        }
      };
      
      azzert.that(ly(mock), is(2));
    }
    
    @Test public void longSupplier() {
      LongSupplier mock = new LongSupplier() {
        @Override
        public long getAsLong() {
          return 20L;
        }
      };
      
      azzert.that(ly(mock), is(20L));
    }
    
    @Test public void anySupplierNull() {
      Supplier<Boolean> mock = new Supplier<Boolean>() {
        @Override
        public Boolean get() {
          return null;
        }
      };
      
      azzert.isNull(ly(mock));
    }
  }
}
