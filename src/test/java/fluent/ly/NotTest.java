package fluent.ly;

import org.junit.*;

@SuppressWarnings("static-method") public class NotTest {
  @Test public void nill1() {
    assert !not.nil(null);
  }

  @Test public void nill2() {
    assert not.nil(Integer.valueOf(1));
  }

  @Test public void in1() {
    assert not.in("");
  }

  @Test public void in2() {
    assert !not.in("", "");
  }
}
