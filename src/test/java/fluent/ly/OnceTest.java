package fluent.ly;

import static fluent.ly.azzert.*;

import org.junit.*;

@SuppressWarnings("static-method") public class OnceTest {
  @Test public void case1() {
    azzert.that(new once("1") + "", is("1"));
  }

  @Test public void case2() {
    azzert.that(new once("2") + "", is("2"));
  }

  @Test public void case3() {
    azzert.that(new once("abc123") + "", is("abc123"));
  }

  @Test public void case4() {
    azzert.that(new once("") + "", is(""));
  }
}
