package fluent.ly;

import java.util.*;
import org.junit.*;

@SuppressWarnings("static-method") public class BoxUnboxTest {
  public static final double DOUBLE_DELTA = 0.0001;
  public static final float FLOAT_DELTA = 0.0001f;
  public static final int TEST_ARRAY_SIZE = 100;

  @Test public void testBoolean() {
    boolean b = new Random().nextBoolean();
    azzert.assertEquals(b, unbox.unbox(box.box(b)));
    azzert.assertEquals(b, unbox.unbox(box.it(b)));
  }

  @Test public void testInteger() {
    int i = new Random().nextInt();
    azzert.assertEquals(i, unbox.unbox(box.box(i)));
    azzert.assertEquals(i, unbox.it(box.it(i)));
  }

  @Test public void testLong() {
    long l = new Random().nextLong();
    azzert.assertEquals(l, unbox.unbox(box.box(l)));
    azzert.assertEquals(l, unbox.unbox(box.it(l)));
  }

  @Test public void testFloat() {
    float f = new Random().nextFloat();
    azzert.assertEquals(f, unbox.unbox(box.box(f)), FLOAT_DELTA);
    azzert.assertEquals(f, unbox.unbox(box.it(f)), FLOAT_DELTA);
  }

  @Test public void testDouble() {
    double d = new Random().nextDouble();
    azzert.assertEquals(d, unbox.unbox(box.box(d)), DOUBLE_DELTA);
    azzert.assertEquals(d, unbox.unbox(box.it(d)), DOUBLE_DELTA);
  }

  @Test public void testChar() {
    char c = (char) new Random().nextInt(Character.MAX_VALUE);
    azzert.assertEquals(c, unbox.unbox(box.box(c)));
    azzert.assertEquals(c, unbox.unbox(box.it(c)));
  }

  @Test public void testShort() {
    short s = (short) new Random().nextInt(Short.MAX_VALUE);
    azzert.assertEquals(s, unbox.unbox(box.box(s)));
    azzert.assertEquals(s, unbox.unbox(box.it(s)));
  }

  @Test public void testByte() {
    byte b = (byte) new Random().nextInt(Byte.MAX_VALUE);
    azzert.assertEquals(b, unbox.unbox(box.box(b)));
    azzert.assertEquals(b, unbox.unbox(box.it(b)));
  }

  @Test public void testBooleanArray() {
    Random r = new Random();
    boolean[] arr = new boolean[TEST_ARRAY_SIZE];
    for (int ¢ = 1; ¢ < arr.length; ++¢)
      arr[¢] = r.nextBoolean();
    azzert.assertArrayEquals(arr, unbox.unbox(box.box(arr)));
    azzert.assertArrayEquals(arr, unbox.unbox(box.it(arr)));
    
  }

  @Test public void testIntegerArray() {
    Random r = new Random();
    int[] arr = new int[TEST_ARRAY_SIZE];
    for (int ¢ = 1; ¢ < arr.length; ++¢)
      arr[¢] = r.nextInt();
    azzert.assertArrayEquals(arr, unbox.unbox(box.box(arr)));
    azzert.assertArrayEquals(arr, unbox.it(box.it(arr)));
  }

  @Test public void testIntegerList() {
    Random r = new Random();
    int[] arr = new int[TEST_ARRAY_SIZE];
    for (int ¢ = 1; ¢ < arr.length; ++¢)
      arr[¢] = r.nextInt();
    azzert.assertArrayEquals(arr, unbox.it(Arrays.asList(box.box(arr))));
  }  
  
  @Test public void testLongArray() {
    Random r = new Random();
    long[] arr = new long[TEST_ARRAY_SIZE];
    for (int ¢ = 1; ¢ < arr.length; ++¢)
      arr[¢] = r.nextLong();
    azzert.assertArrayEquals(arr, unbox.unbox(box.box(arr)));
    azzert.assertArrayEquals(arr, unbox.unbox(box.it(arr)));
  }

  @Test public void testFloatArray() {
    Random r = new Random();
    float[] arr = new float[TEST_ARRAY_SIZE];
    for (int ¢ = 1; ¢ < arr.length; ++¢)
      arr[¢] = r.nextFloat();
    azzert.assertArrayEquals(arr, unbox.unbox(box.box(arr)), FLOAT_DELTA);
    azzert.assertArrayEquals(arr, unbox.it(box.it(arr)), FLOAT_DELTA);
  }

  @Test public void testDoubleArray() {
    Random r = new Random();
    double[] arr = new double[TEST_ARRAY_SIZE];
    for (int ¢ = 1; ¢ < arr.length; ++¢)
      arr[¢] = r.nextDouble();
    azzert.assertArrayEquals(arr, unbox.unbox(box.box(arr)), DOUBLE_DELTA);
    azzert.assertArrayEquals(arr, unbox.it(box.it(arr)), DOUBLE_DELTA);
  }

  @Test public void testCharArray() {
    Random r = new Random();
    char[] arr = new char[TEST_ARRAY_SIZE];
    for (int ¢ = 1; ¢ < arr.length; ++¢)
      arr[¢] = (char) r.nextInt(Character.MAX_VALUE);
    azzert.assertArrayEquals(arr, unbox.unbox(box.box(arr)));
    azzert.assertArrayEquals(arr, unbox.unbox(box.it(arr)));
  }
  
  @Test public void testShortCollection() {
    Random r = new Random();
    short[] arr = new short[TEST_ARRAY_SIZE];
    for (int ¢ = 1; ¢ < arr.length; ++¢)
      arr[¢] = (short) r.nextInt(Short.MAX_VALUE);
    azzert.assertArrayEquals(arr, unbox.unbox(Arrays.asList(box.box(arr))));
    azzert.assertArrayEquals(arr, unbox.unbox(box.it(arr)));
  }

  @Test public void testShortArray() {
    Random r = new Random();
    short[] arr = new short[TEST_ARRAY_SIZE];
    for (int ¢ = 1; ¢ < arr.length; ++¢)
      arr[¢] = (short) r.nextInt(Short.MAX_VALUE);
    azzert.assertArrayEquals(arr, unbox.unbox(box.box(arr)));
    azzert.assertArrayEquals(arr, unbox.unbox(box.it(arr)));
  }

  @Test public void testByteArray() {
    Random r = new Random();
    byte[] arr = new byte[TEST_ARRAY_SIZE];
    for (int ¢ = 1; ¢ < arr.length; ++¢)
      arr[¢] = (byte) r.nextInt(Byte.MAX_VALUE);
    azzert.assertArrayEquals(arr, unbox.unbox(box.box(arr)));
    azzert.assertArrayEquals(arr, unbox.unbox(box.it(arr)));
  }
}
