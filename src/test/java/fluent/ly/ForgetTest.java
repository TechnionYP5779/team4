package fluent.ly;

import org.junit.*;

@SuppressWarnings("static-method") public class ForgetTest {
  @Test public void forgetAll() {
    forget.all(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3));
    forget.all(Double.valueOf(1.4), Double.valueOf(2.5), Double.valueOf(3.6));
    forget.all(String.valueOf("1.4"), String.valueOf("2.5"), String.valueOf("3.6"));
    forget.all(Boolean.TRUE, Boolean.FALSE);
    forget.all(Integer.valueOf(1), Double.valueOf(2.5), String.valueOf("3.6"), Boolean.FALSE);
  }

  @Test public void forgetIt() {
    forget.it(1L);
    forget.it(1);
    forget.it(1.4);
    forget.it("1.4");
    forget.it(true);
  }
  
  @Test public void forgetUnused1() {
    forget.unused(1.0, new double[] {1.0});
  }
  
  @Test public void forgetUnused2() {
    forget.unused(1.0, new Object[] {});
  }
  
  @Test public void forgetUnused3() {
    forget.unused(1L, new Object[] {});
  }
  
  @Test public void forgetUnused4() {
    forget.unused(1, new int[] {1});
  }
  
  @Test public void forgetUnused5() {
    forget.unused(1L, new long[] {1L});
  }
}
