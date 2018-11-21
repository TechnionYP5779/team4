package a;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class SingletonTest {
  @Test public void intListSingelton() {
    azzert.that(singleton.list(Integer.valueOf(5)).size(), is(1));
  }

  @Test public void intArraySingelton() {
    azzert.that(singleton.array(new Object()).length, is(1));
  }
}
