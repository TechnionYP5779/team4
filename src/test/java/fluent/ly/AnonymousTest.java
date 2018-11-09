package fluent.ly;

import static fluent.ly.azzert.*;

import java.util.function.*;

import org.junit.*;

@SuppressWarnings("static-method") public class AnonymousTest {
  @Test public void boolSupplier() {
    BooleanSupplier mock = new BooleanSupplier() {
      @Override
      public boolean getAsBoolean() {
        return true;
      }
    };
    
    azzert.that(anonymous.ly(mock), is(true));
  }
  
  @Test public void doubleSupplier() {
    DoubleSupplier mock = new DoubleSupplier() {
      @Override
      public double getAsDouble() {
        return 5.2;
      }
    };
    
    azzert.that(anonymous.ly(mock), is(5.2));
  }
  
  @Test public void intSupplier() {
    IntSupplier mock = new IntSupplier() {
      @Override
      public int getAsInt() {
        return 2;
      }
    };
    
    azzert.that(anonymous.ly(mock), is(2));
  }
  
  @Test public void longSupplier() {
    LongSupplier mock = new LongSupplier() {
      @Override
      public long getAsLong() {
        return 20L;
      }
    };
    
    azzert.that(anonymous.ly(mock), is(20L));
  }
  
  @Test public void anySupplierNull() {
    Supplier<Boolean> mock = new Supplier<Boolean>() {
      @Override
      public Boolean get() {
        return null;
      }
    };
    
    azzert.isNull(anonymous.ly(mock));
  }
}