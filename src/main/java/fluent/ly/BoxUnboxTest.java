package fluent.ly;

import java.util.*;

import org.junit.*;

@SuppressWarnings("static-method") public class BoxUnboxTest {
  @Test public void testBoolean() {
    boolean b = new Random().nextBoolean();
    azzert.assertEquals(b, unbox.unbox(box.box(b)));
  }

  @Test public void testInteger() {
    int i = new Random().nextInt();
    azzert.assertEquals(i, unbox.unbox(box.box(i)));
  }

  @Test public void testLong() {
    long l = new Random().nextLong();
    azzert.assertEquals(l, unbox.unbox(box.box(l)));
  }

  @Test public void testFloat() {
    float f = new Random().nextFloat();
    azzert.assertEquals(f, unbox.unbox(box.box(f)), 0);
  }

  @Test public void testDouble() {
    double d = new Random().nextDouble();
    azzert.assertEquals(d, unbox.unbox(box.box(d)), 0);
  }

  @Test public void testChar() {
    char c = (char) new Random().nextInt(Character.MAX_VALUE);
    azzert.assertEquals(c, unbox.unbox(box.box(c)));
  }

  @Test public void testShort() {
    short s = (short) new Random().nextInt(Short.MAX_VALUE);
    azzert.assertEquals(s, unbox.unbox(box.box(s)));
  }

  @Test public void testByte() {
    byte b = (byte) new Random().nextInt(Byte.MAX_VALUE);
    azzert.assertEquals(b, unbox.unbox(box.box(b)));
  }
}
