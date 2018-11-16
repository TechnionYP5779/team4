package fluent.ly;

import static fluent.ly.azzert.*;

import java.util.*;

import org.junit.*;

@SuppressWarnings("static-method") public class BoxUnboxTest {
  public static final double DOUBLE_DELTA = 0.0001;
  public static final float FLOAT_DELTA = 0.0001f;
  public static final int TEST_ARRAY_SIZE = 100;

  @Test public void testBoolean() {
    final boolean b = new Random().nextBoolean();
    azzert.that(unbox.unboxBoolean(box.boxBoolean(b)), is(b));
    azzert.assertEquals(b, unbox.unboxBoolean(box.it(b)));
  }

  @Test public void testInteger() {
    final int i = new Random().nextInt();
    azzert.assertEquals(i, unbox.unboxInteger(box.boxInteger(i)));
    azzert.assertEquals(i, unbox.it(box.it(i)));
  }

  @Test public void testLong() {
    final long l = new Random().nextLong();
    azzert.that(unbox.unboxLong(box.boxLong(l)), is(l));
    azzert.that(unbox.unboxLong(box.it(l)), is(l));
  }

  @Test public void testFloat() {
    final float f = new Random().nextFloat();
    assert unbox.unboxFloat(box.boxFloat(f)) - f > -1 * FLOAT_DELTA && unbox.unboxFloat(box.boxFloat(f)) - f < FLOAT_DELTA;
    assert unbox.unboxFloat(box.it(f)) - f > -1 * FLOAT_DELTA && unbox.unboxFloat(box.it(f)) - f < FLOAT_DELTA;
  }

  @Test public void testDouble() {
    final double d = new Random().nextDouble();
    assert unbox.unboxDouble(box.boxDouble(d)) - d > -1 * DOUBLE_DELTA && unbox.unboxDouble(box.boxDouble(d)) - d < DOUBLE_DELTA;
    assert unbox.unboxDouble(box.it(d)) - d > -1 * DOUBLE_DELTA && unbox.unboxDouble(box.it(d)) - d < DOUBLE_DELTA;
  }

  @Test public void testChar() {
    final char c = (char) new Random().nextInt(Character.MAX_VALUE);
    azzert.assertEquals(c, unbox.unboxChar(box.boxCharacter(c)));
    azzert.assertEquals(c, unbox.unboxChar(box.it(c)));
  }

  @Test public void testShort() {
    final short s = (short) new Random().nextInt(Short.MAX_VALUE);
    azzert.assertEquals(s, unbox.unboxShort(box.boxShort(s)));
    azzert.assertEquals(s, unbox.unboxShort(box.it(s)));
  }

  @Test public void testByte() {
    final byte b = (byte) new Random().nextInt(Byte.MAX_VALUE);
    azzert.assertEquals(b, unbox.unboxByte(box.boxByte(b)));
    azzert.assertEquals(b, unbox.unboxByte(box.it(b)));
  }

  @Test public void testBooleanArray() {
    final Random r = new Random();
    final boolean[] arr = new boolean[TEST_ARRAY_SIZE];
    for (int ¢ = 1; ¢ < arr.length; ++¢)
      arr[¢] = r.nextBoolean();
    final boolean[] arr_res = unbox.unboxBooleanArray(box.boxBooleanArray(arr));
    for (int ¢ = 0; ¢ < arr.length; ++¢)
      azzert.that(arr_res[¢], is(arr[¢]));
    final boolean[] arr_res_2 = unbox.unboxBooleanArray(box.it(arr));
    for (int ¢ = 0; ¢ < arr.length; ++¢)
      azzert.that(arr_res_2[¢], is(arr[¢]));
  }

  @Test public void testIntegerArray() {
    final Random r = new Random();
    final int[] arr = new int[TEST_ARRAY_SIZE];
    for (int ¢ = 1; ¢ < arr.length; ++¢)
      arr[¢] = r.nextInt();
    final int[] arr_res = unbox.unboxIntegerArray(box.boxIntegerArray(arr));
    for (int ¢ = 0; ¢ < arr.length; ++¢)
      azzert.that(arr_res[¢], is(arr[¢]));
    final int[] arr_res_2 = unbox.unboxIntegerArray(box.it(arr));
    for (int ¢ = 0; ¢ < arr.length; ++¢)
      azzert.that(arr_res_2[¢], is(arr[¢]));
  }

  @Test public void testIntegerList() {
    final Random r = new Random();
    final int[] arr = new int[TEST_ARRAY_SIZE];
    for (int ¢ = 1; ¢ < arr.length; ++¢)
      arr[¢] = r.nextInt();
    final int[] arr_res = unbox.it(Arrays.asList(box.boxIntegerArray(arr)));
    for (int ¢ = 0; ¢ < arr.length; ++¢)
      azzert.that(arr_res[¢], is(arr[¢]));
  }

  @Test public void testLongArray() {
    final Random r = new Random();
    final long[] arr = new long[TEST_ARRAY_SIZE];
    for (int ¢ = 1; ¢ < arr.length; ++¢)
      arr[¢] = r.nextLong();
    final long[] arr_res = unbox.unboxLongArray(box.boxLongArray(arr));
    for (int ¢ = 0; ¢ < arr.length; ++¢)
      azzert.that(arr_res[¢], is(arr[¢]));
    final long[] arr_res_2 = unbox.unboxLongArray(box.it(arr));
    for (int ¢ = 0; ¢ < arr.length; ++¢)
      azzert.that(arr_res_2[¢], is(arr[¢]));
  }

  @Test public void testFloatArray() {
    final Random r = new Random();
    final float[] arr = new float[TEST_ARRAY_SIZE];
    for (int ¢ = 1; ¢ < arr.length; ++¢)
      arr[¢] = r.nextFloat();
    final float[] arr_res = unbox.unboxFloatArray(box.boxFloatArray(arr));
    for (int ¢ = 0; ¢ < arr.length; ++¢)
      azzert.aye(arr_res[¢] - arr[¢] > -1 * FLOAT_DELTA && arr_res[¢] - arr[¢] < FLOAT_DELTA);
    final float[] arr_res_2 = unbox.unboxFloatArray(box.it(arr));
    for (int ¢ = 0; ¢ < arr.length; ++¢)
      azzert.aye(arr_res_2[¢] - arr[¢] > -1 * FLOAT_DELTA && arr_res_2[¢] - arr[¢] < FLOAT_DELTA);
  }

  @Test public void testDoubleArray() {
    final Random r = new Random();
    final double[] arr = new double[TEST_ARRAY_SIZE];
    for (int ¢ = 1; ¢ < arr.length; ++¢)
      arr[¢] = r.nextDouble();
    final double[] arr_res = unbox.unboxDoubleArray(box.boxDoubleArray(arr));
    for (int ¢ = 0; ¢ < arr.length; ++¢)
      azzert.aye(arr_res[¢] - arr[¢] > -1 * DOUBLE_DELTA && arr_res[¢] - arr[¢] < DOUBLE_DELTA);
    final double[] arr_res_2 = unbox.unboxDoubleArray(box.it(arr));
    for (int ¢ = 0; ¢ < arr.length; ++¢)
      azzert.aye(arr_res_2[¢] - arr[¢] > -1 * DOUBLE_DELTA && arr_res_2[¢] - arr[¢] < DOUBLE_DELTA);
  }

  @Test public void testCharArray() {
    final Random r = new Random();
    final char[] arr = new char[TEST_ARRAY_SIZE];
    for (int ¢ = 1; ¢ < arr.length; ++¢)
      arr[¢] = (char) r.nextInt(Character.MAX_VALUE);
    final char[] arr_res = unbox.unboxCharArray(box.boxCharacterArray(arr));
    for (int ¢ = 0; ¢ < arr.length; ++¢)
      azzert.that(arr_res[¢], is(arr[¢]));
    final char[] arr_res_2 = unbox.unboxCharArray(box.it(arr));
    for (int ¢ = 0; ¢ < arr.length; ++¢)
      azzert.that(arr_res_2[¢], is(arr[¢]));
  }

  @Test public void testShortCollection() {
    final Random r = new Random();
    final short[] arr = new short[TEST_ARRAY_SIZE];
    for (int ¢ = 1; ¢ < arr.length; ++¢)
      arr[¢] = (short) r.nextInt(Short.MAX_VALUE);
    final short[] arr_res = unbox.unboxShortCollection(Arrays.asList(box.boxShortArray(arr)));
    for (int ¢ = 0; ¢ < arr.length; ++¢)
      azzert.that(arr_res[¢], is(arr[¢]));
    final short[] arr_res_2 = unbox.unboxShortArray(box.it(arr));
    for (int ¢ = 0; ¢ < arr.length; ++¢)
      azzert.that(arr_res_2[¢], is(arr[¢]));
  }

  @Test public void testShortArray() {
    final Random r = new Random();
    final short[] arr = new short[TEST_ARRAY_SIZE];
    for (int ¢ = 1; ¢ < arr.length; ++¢)
      arr[¢] = (short) r.nextInt(Short.MAX_VALUE);
    final short[] arr_res = unbox.unboxShortArray(box.boxShortArray(arr));
    for (int ¢ = 0; ¢ < arr.length; ++¢)
      azzert.that(arr_res[¢], is(arr[¢]));
    final short[] arr_res_2 = unbox.unboxShortArray(box.it(arr));
    for (int ¢ = 0; ¢ < arr.length; ++¢)
      azzert.that(arr_res_2[¢], is(arr[¢]));
  }

  @Test public void testByteArray() {
    final Random r = new Random();
    final byte[] arr = new byte[TEST_ARRAY_SIZE];
    for (int ¢ = 1; ¢ < arr.length; ++¢)
      arr[¢] = (byte) r.nextInt(Byte.MAX_VALUE);
    final byte[] arr_res = unbox.unboxByteArray(box.boxByteArray(arr));
    for (int ¢ = 0; ¢ < arr.length; ++¢)
      azzert.that(arr_res[¢], is(arr[¢]));
    final byte[] arr_res_2 = unbox.unboxByteArray(box.it(arr));
    for (int ¢ = 0; ¢ < arr.length; ++¢)
      azzert.that(arr_res_2[¢], is(arr[¢]));
  }
}
