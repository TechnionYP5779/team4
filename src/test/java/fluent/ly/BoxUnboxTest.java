package fluent.ly;

import java.util.*;
import org.junit.*;
import static fluent.ly.azzert.*;

@SuppressWarnings("static-method") public class BoxUnboxTest {
  public static final double DOUBLE_DELTA = 0.0001;
  public static final float FLOAT_DELTA = 0.0001f;
  public static final int TEST_ARRAY_SIZE = 100;

  @Test public void testBoolean() {
    boolean b = new Random().nextBoolean();
    azzert.that(unbox.unbox(box.boxBoolean(b)), is(b));
    azzert.assertEquals(b, unbox.unbox(box.it(b)));
  }

  @Test public void testInteger() {
    int i = new Random().nextInt();
    azzert.assertEquals(i, unbox.unbox(box.boxInteger(i)));
    azzert.assertEquals(i, unbox.it(box.it(i)));
  }

  @Test public void testLong() {
    long l = new Random().nextLong();
    azzert.that(unbox.unbox(box.boxLong(l)), is(l));
    azzert.that(unbox.unbox(box.it(l)), is(l));
  }

  @Test public void testFloat() {
    float f = new Random().nextFloat();
    azzert.aye(unbox.unbox(box.boxFloat(f)) - f > -1 * FLOAT_DELTA 
        && unbox.unbox(box.boxFloat(f)) - f < FLOAT_DELTA);
    azzert.aye(unbox.unbox(box.it(f)) - f > -1 * FLOAT_DELTA 
        && unbox.unbox(box.it(f)) - f < FLOAT_DELTA );
  }

  @Test public void testDouble() {
    double d = new Random().nextDouble();
    azzert.aye(unbox.unbox(box.boxDouble(d)) - d > -1 * DOUBLE_DELTA
        && unbox.unbox(box.boxDouble(d)) - d < DOUBLE_DELTA);
    azzert.aye(unbox.unbox(box.it(d)) - d > -1 * DOUBLE_DELTA
        && unbox.unbox(box.it(d)) - d < DOUBLE_DELTA);
  }

  @Test public void testChar() {
    char c = (char) new Random().nextInt(Character.MAX_VALUE);
    azzert.assertEquals(c, unbox.unbox(box.boxCharacter(c)));
    azzert.assertEquals(c, unbox.unbox(box.it(c)));
  }

  @Test public void testShort() {
    short s = (short) new Random().nextInt(Short.MAX_VALUE);
    azzert.assertEquals(s, unbox.unbox(box.boxShort(s)));
    azzert.assertEquals(s, unbox.unbox(box.it(s)));
  }

  @Test public void testByte() {
    byte b = (byte) new Random().nextInt(Byte.MAX_VALUE);
    azzert.assertEquals(b, unbox.unbox(box.boxByte(b)));
    azzert.assertEquals(b, unbox.unbox(box.it(b)));
  }

  @Test public void testBooleanArray() {
    Random r = new Random();
    boolean[] arr = new boolean[TEST_ARRAY_SIZE];
    for (int ¢ = 1; ¢ < arr.length; ++¢)
      arr[¢] = r.nextBoolean();
    boolean[] arr_res = unbox.unbox(box.boxBooleanArray(arr));
    for (int ¢ = 0; ¢ < arr.length; ++¢)
      azzert.that(arr_res[¢], is(arr[¢]));
    
    boolean[] arr_res_2 = unbox.unbox(box.it(arr));
    for (int ¢ = 0; ¢ < arr.length; ++¢)
      azzert.that(arr_res_2[¢], is(arr[¢]));
  }

  @Test public void testIntegerArray() {
    Random r = new Random();
    int[] arr = new int[TEST_ARRAY_SIZE];
    for (int ¢ = 1; ¢ < arr.length; ++¢)
      arr[¢] = r.nextInt();
    
    int[] arr_res = unbox.unbox(box.boxIntegerArray(arr));
    for (int ¢ = 0; ¢ < arr.length; ++¢)
      azzert.that(arr_res[¢], is(arr[¢]));
    
    int[] arr_res_2 = unbox.unbox(box.it(arr));
    for (int ¢ = 0; ¢ < arr.length; ++¢)
      azzert.that(arr_res_2[¢], is(arr[¢]));
  }

  @Test public void testIntegerList() {
    Random r = new Random();
    int[] arr = new int[TEST_ARRAY_SIZE];
    for (int ¢ = 1; ¢ < arr.length; ++¢)
      arr[¢] = r.nextInt();
    
    int[] arr_res = unbox.it(Arrays.asList(box.boxIntegerArray(arr)));
    for (int ¢ = 0; ¢ < arr.length; ++¢)
      azzert.that(arr_res[¢], is(arr[¢]));
  }  
  
  @Test public void testLongArray() {
    Random r = new Random();
    long[] arr = new long[TEST_ARRAY_SIZE];
    for (int ¢ = 1; ¢ < arr.length; ++¢)
      arr[¢] = r.nextLong();
    
    long[] arr_res = unbox.unbox(box.boxLongArray(arr));
    for (int ¢ = 0; ¢ < arr.length; ++¢)
      azzert.that(arr_res[¢], is(arr[¢]));
    
    long[] arr_res_2 = unbox.unbox(box.it(arr));
    for (int ¢ = 0; ¢ < arr.length; ++¢)
      azzert.that(arr_res_2[¢], is(arr[¢]));
  }

  @Test public void testFloatArray() {
    Random r = new Random();
    float[] arr = new float[TEST_ARRAY_SIZE];
    for (int ¢ = 1; ¢ < arr.length; ++¢)
      arr[¢] = r.nextFloat();
    
    float[] arr_res = unbox.unbox(box.boxFloatArray(arr));
    for (int ¢ = 0; ¢ < arr.length; ++¢)
      azzert.aye(arr_res[¢] - arr[¢] > -1 * FLOAT_DELTA && arr_res[¢] - arr[¢] < FLOAT_DELTA);
    
    float[] arr_res_2 = unbox.unbox(box.it(arr));
    for (int ¢ = 0; ¢ < arr.length; ++¢)
      azzert.aye(arr_res_2[¢] - arr[¢] > -1 * FLOAT_DELTA &&  arr_res_2[¢] - arr[¢]< FLOAT_DELTA);

  }

  @Test public void testDoubleArray() {
    Random r = new Random();
    double[] arr = new double[TEST_ARRAY_SIZE];
    for (int ¢ = 1; ¢ < arr.length; ++¢)
      arr[¢] = r.nextDouble();
    
    double[] arr_res = unbox.unbox(box.boxDoubleArray(arr));
    for (int ¢ = 0; ¢ < arr.length; ++¢)
      azzert.aye(arr_res[¢] - arr[¢] > -1 * DOUBLE_DELTA && arr_res[¢] - arr[¢] < DOUBLE_DELTA);
    
    double[] arr_res_2 = unbox.unbox(box.it(arr));
    for (int ¢ = 0; ¢ < arr.length; ++¢)
      azzert.aye(arr_res_2[¢] - arr[¢] > -1 * DOUBLE_DELTA &&  arr_res_2[¢] - arr[¢]< DOUBLE_DELTA);
    
  }

  @Test public void testCharArray() {
    Random r = new Random();
    char[] arr = new char[TEST_ARRAY_SIZE];
    for (int ¢ = 1; ¢ < arr.length; ++¢)
      arr[¢] = (char) r.nextInt(Character.MAX_VALUE);
   
    char[] arr_res = unbox.unbox(box.boxCharacterArray(arr));
    for (int ¢ = 0; ¢ < arr.length; ++¢)
      azzert.that(arr_res[¢], is(arr[¢]));
    
    char[] arr_res_2 = unbox.unbox(box.it(arr));
    for (int ¢ = 0; ¢ < arr.length; ++¢)
      azzert.that(arr_res_2[¢], is(arr[¢]));
  }
  
  @Test public void testShortCollection() {
    Random r = new Random();
    short[] arr = new short[TEST_ARRAY_SIZE];
    for (int ¢ = 1; ¢ < arr.length; ++¢)
      arr[¢] = (short) r.nextInt(Short.MAX_VALUE);
    
    short[] arr_res = unbox.unbox(Arrays.asList(box.boxShortArray(arr)));
    for (int ¢ = 0; ¢ < arr.length; ++¢)
      azzert.that(arr_res[¢], is(arr[¢]));
    
    short[] arr_res_2 = unbox.unbox(box.it(arr));
    for (int ¢ = 0; ¢ < arr.length; ++¢)
      azzert.that(arr_res_2[¢], is(arr[¢]));
  }

  @Test public void testShortArray() {
    Random r = new Random();
    short[] arr = new short[TEST_ARRAY_SIZE];
    for (int ¢ = 1; ¢ < arr.length; ++¢)
      arr[¢] = (short) r.nextInt(Short.MAX_VALUE);
    
    short[] arr_res = unbox.unbox(box.boxShortArray(arr));
    for (int ¢ = 0; ¢ < arr.length; ++¢)
      azzert.that(arr_res[¢], is(arr[¢]));
    
    short[] arr_res_2 = unbox.unbox(box.it(arr));
    for (int ¢ = 0; ¢ < arr.length; ++¢)
      azzert.that(arr_res_2[¢], is(arr[¢]));

  }

  @Test public void testByteArray() {
    Random r = new Random();
    byte[] arr = new byte[TEST_ARRAY_SIZE];
    for (int ¢ = 1; ¢ < arr.length; ++¢)
      arr[¢] = (byte) r.nextInt(Byte.MAX_VALUE);
    byte[] arr_res = unbox.unbox(box.boxByteArray(arr));
    for (int ¢ = 0; ¢ < arr.length; ++¢)
      azzert.that(arr_res[¢], is(arr[¢]));
    
    byte[] arr_res_2 = unbox.unbox(box.it(arr));
    for (int ¢ = 0; ¢ < arr.length; ++¢)
      azzert.that(arr_res_2[¢], is(arr[¢]));
  }
}
