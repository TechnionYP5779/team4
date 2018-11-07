package fluent.ly;

import java.util.function.*;

import org.junit.*;

import static fluent.ly.azzert.*;
import static org.mockito.Mockito.*; 


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
      BooleanSupplier mock = mock(BooleanSupplier.class);
      when(mock.getAsBoolean()).thenReturn(true);
      azzert.that(ly(mock), is(true));
    }
    
    @Test public void doubleSupplier() {
      DoubleSupplier mock = mock(DoubleSupplier.class);
      when(mock.getAsDouble()).thenReturn(5.2);
      azzert.that(ly(mock), is(5.2));
    }
    
    @Test public void intSupplier() {
      IntSupplier mock = mock(IntSupplier.class);
      when(mock.getAsInt()).thenReturn(2);
      azzert.that(ly(mock), is(2));
    }
    
    @Test public void longSupplier() {
      LongSupplier mock = mock(LongSupplier.class);
      when(mock.getAsLong()).thenReturn(20L);
      azzert.that(ly(mock), is(20L));
    }
    
    @Test public void anySupplier() {
      Supplier<Boolean> mock = mock(Supplier.class);
      when(mock.get()).thenReturn(true);
      azzert.that(ly(mock), is(true));
    }
  }
}
