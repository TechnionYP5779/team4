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
    azzert.that(unbox.it(box.boxBoolean(b)), is(b));
    azzert.that(unbox.it(box.it(b)), is(b));
  }

  @Test public void testInteger() {
    final int i = new Random().nextInt();
    azzert.that(unbox.it(box.it(i)), is(i));
    azzert.that(unbox.it(box.it(i)), is(i));
  }

  @Test public void testLong() {
    final long l = new Random().nextLong();
    azzert.that(unbox.it(box.boxLong(l)), is(l));
    azzert.that(unbox.it(box.it(l)), is(l));
  }

  @Test public void testFloat() {
    final float f = new Random().nextFloat();
    assert unbox.it(box.boxFloat(f)) - f > -1 * FLOAT_DELTA && unbox.it(box.boxFloat(f)) - f < FLOAT_DELTA;
    assert unbox.it(box.it(f)) - f > -1 * FLOAT_DELTA && unbox.it(box.it(f)) - f < FLOAT_DELTA;
  }

  @Test public void testDouble() {
    final double d = new Random().nextDouble();
    assert unbox.it(box.boxDouble(d)) - d > -1 * DOUBLE_DELTA && unbox.it(box.boxDouble(d)) - d < DOUBLE_DELTA;
    assert unbox.it(box.boxDouble(d)) - d > -1 * DOUBLE_DELTA && unbox.it(box.it(d)) - d < DOUBLE_DELTA;
  }

  @Test public void testChar() {
    final char c = (char) new Random().nextInt(Character.MAX_VALUE);
    azzert.that(unbox.it(box.boxCharacter(c)), is(c));
    azzert.that(unbox.it(box.it(c)), is(c));
  }

  @Test public void testShort() {
    final short s = (short) new Random().nextInt(Short.MAX_VALUE);
    azzert.that(unbox.it(box.boxShort(s)), is(s));
    azzert.that(unbox.it(box.it(s)), is(s));
  }

  @Test public void testByte() {
    final byte b = (byte) new Random().nextInt(Byte.MAX_VALUE);
    azzert.that(unbox.it(box.boxByte(b)), is(b));
    azzert.that(unbox.it(box.it(b)), is(b));
  }

  @Test public void testBooleanArray() {
    final Random r = new Random();
    final boolean[] arr = new boolean[TEST_ARRAY_SIZE];
    for (int ¢ = 1; ¢ < arr.length; ++¢)
      arr[¢] = r.nextBoolean();
    final boolean[] arr_res = unbox.it(box.boxBooleanArray(arr));
    for (int ¢ = 0; ¢ < arr.length; ++¢)
      azzert.that(arr_res[¢], is(arr[¢]));
    final boolean[] arr_res_2 = unbox.it(box.it(arr));
    for (int ¢ = 0; ¢ < arr.length; ++¢)
      azzert.that(arr_res_2[¢], is(arr[¢]));
  }

  @Test public void testIntegerArray() {
    final Random r = new Random();
    final int[] arr = new int[TEST_ARRAY_SIZE];
    for (int ¢ = 1; ¢ < arr.length; ++¢)
      arr[¢] = r.nextInt();
    final int[] arr_res = unbox.it(box.it(arr));
    for (int ¢ = 0; ¢ < arr.length; ++¢)
      azzert.that(arr_res[¢], is(arr[¢]));
    final int[] arr_res_2 = unbox.it(box.it(arr));
    for (int ¢ = 0; ¢ < arr.length; ++¢)
      azzert.that(arr_res_2[¢], is(arr[¢]));
  }

  @Test public void testIntegerList() {
    final Random r = new Random();
    final int[] arr = new int[TEST_ARRAY_SIZE];
    for (int ¢ = 1; ¢ < arr.length; ++¢)
      arr[¢] = r.nextInt();
    final int[] arr_res = unbox.it(Arrays.asList(box.it(arr)));
    for (int ¢ = 0; ¢ < arr.length; ++¢)
      azzert.that(arr_res[¢], is(arr[¢]));
  }

  @Test public void testLongArray() {
    final Random r = new Random();
    final long[] arr = new long[TEST_ARRAY_SIZE];
    for (int ¢ = 1; ¢ < arr.length; ++¢)
      arr[¢] = r.nextLong();
    final long[] arr_res = unbox.it(box.boxLongArray(arr));
    for (int ¢ = 0; ¢ < arr.length; ++¢)
      azzert.that(arr_res[¢], is(arr[¢]));
    final long[] arr_res_2 = unbox.it(box.it(arr));
    for (int ¢ = 0; ¢ < arr.length; ++¢)
      azzert.that(arr_res_2[¢], is(arr[¢]));
  }

  @Test public void testFloatArray() {
    final Random r = new Random();
    final float[] arr = new float[TEST_ARRAY_SIZE];
    for (int ¢ = 1; ¢ < arr.length; ++¢)
      arr[¢] = r.nextFloat();
    final float[] arr_res = unbox.it(box.boxFloatArray(arr));
    for (int ¢ = 0; ¢ < arr.length; ++¢)
      azzert.aye(arr_res[¢] - arr[¢] > -1 * FLOAT_DELTA && arr_res[¢] - arr[¢] < FLOAT_DELTA);
    final float[] arr_res_2 = unbox.it(box.it(arr));
    for (int ¢ = 0; ¢ < arr.length; ++¢)
      azzert.aye(arr_res_2[¢] - arr[¢] > -1 * FLOAT_DELTA && arr_res_2[¢] - arr[¢] < FLOAT_DELTA);
  }

  @Test public void testDoubleArray() {
    final Random r = new Random();
    final double[] arr = new double[TEST_ARRAY_SIZE];
    for (int ¢ = 1; ¢ < arr.length; ++¢)
      arr[¢] = r.nextDouble();
    final double[] arr_res = unbox.it(box.boxDoubleArray(arr));
    for (int ¢ = 0; ¢ < arr.length; ++¢)
      azzert.aye(arr_res[¢] - arr[¢] > -1 * DOUBLE_DELTA && arr_res[¢] - arr[¢] < DOUBLE_DELTA);
    final double[] arr_res_2 = unbox.it(box.it(arr));
    for (int ¢ = 0; ¢ < arr.length; ++¢)
      azzert.aye(arr_res_2[¢] - arr[¢] > -1 * DOUBLE_DELTA && arr_res_2[¢] - arr[¢] < DOUBLE_DELTA);
  }

  @Test public void testCharArray() {
    final Random r = new Random();
    final char[] arr = new char[TEST_ARRAY_SIZE];
    for (int ¢ = 1; ¢ < arr.length; ++¢)
      arr[¢] = (char) r.nextInt(Character.MAX_VALUE);
    final char[] arr_res = unbox.it(box.boxCharacterArray(arr));
    for (int ¢ = 0; ¢ < arr.length; ++¢)
      azzert.that(arr_res[¢], is(arr[¢]));
    final char[] arr_res_2 = unbox.it(box.it(arr));
    for (int ¢ = 0; ¢ < arr.length; ++¢)
      azzert.that(arr_res_2[¢], is(arr[¢]));
  }

  @Test public void testShortCollection() {
    final Random r = new Random();
    final short[] arr = new short[TEST_ARRAY_SIZE];
    for (int ¢ = 1; ¢ < arr.length; ++¢)
      arr[¢] = (short) r.nextInt(Short.MAX_VALUE);
    final short[] arr_res = unbox.it(Arrays.asList(box.boxShortArray(arr)));
    for (int ¢ = 0; ¢ < arr.length; ++¢)
      azzert.that(arr_res[¢], is(arr[¢]));
    final short[] arr_res_2 = unbox.it(box.it(arr));
    for (int ¢ = 0; ¢ < arr.length; ++¢)
      azzert.that(arr_res_2[¢], is(arr[¢]));
  }

  @Test public void testShortArray() {
    final Random r = new Random();
    final short[] arr = new short[TEST_ARRAY_SIZE];
    for (int ¢ = 1; ¢ < arr.length; ++¢)
      arr[¢] = (short) r.nextInt(Short.MAX_VALUE);
    final short[] arr_res = unbox.it(box.boxShortArray(arr));
    for (int ¢ = 0; ¢ < arr.length; ++¢)
      azzert.that(arr_res[¢], is(arr[¢]));
    final short[] arr_res_2 = unbox.it(box.it(arr));
    for (int ¢ = 0; ¢ < arr.length; ++¢)
      azzert.that(arr_res_2[¢], is(arr[¢]));
  }

  @Test public void testByteArray() {
    final Random r = new Random();
    final byte[] arr = new byte[TEST_ARRAY_SIZE];
    for (int ¢ = 1; ¢ < arr.length; ++¢)
      arr[¢] = (byte) r.nextInt(Byte.MAX_VALUE);
    final byte[] arr_res = unbox.it(box.boxByteArray(arr));
    for (int ¢ = 0; ¢ < arr.length; ++¢)
      azzert.that(arr_res[¢], is(arr[¢]));
    final byte[] arr_res_2 = unbox.it(box.it(arr));
    for (int ¢ = 0; ¢ < arr.length; ++¢)
      azzert.that(arr_res_2[¢], is(arr[¢]));
  }

  @Test public void testItDouble() {
    azzert.that(unbox.it(new Double[] { Double.valueOf(1.0) }), is(new Double[] { Double.valueOf(1.0) }));
  }

  @Test public void testItFloat() {
    azzert.that(unbox.it(new Float[] { Float.valueOf("1.0") }), is(new Float[] { Float.valueOf("1.0") }));
  }
}
