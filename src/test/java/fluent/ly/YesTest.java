package fluent.ly;

import org.junit.*;

@SuppressWarnings("static-method") public class YesTest {
  @Test public void ignoringBoolean() {
    assert yes.ignoring(false);
    assert yes.ignoring(true);
  }

  @Test public void ignoringDouble() {
    assert yes.ignoring(0.0);
    assert yes.ignoring(1.0);
    assert yes.ignoring(-1.0);
  }

  @Test public void ignoringLong() {
    assert yes.ignoring(0);
    assert yes.ignoring(1);
    assert yes.ignoring(-1);
  }

  public class MyThread extends Thread {
    @Override public void run() {
      // empty
    }
  }

  @Test public void forgettingRunnable() {
    assert yes.forgetting(new MyThread());
  }

  @Test public void forgettingObjects() {
    assert yes.forgetting("1", "2");
    assert yes.forgetting("1", "2", "3");
    assert yes.forgetting(Integer.valueOf(1), "2");
    assert yes.forgetting("1");
  }
}
