package fluent.ly;

import java.util.*;

import org.jetbrains.annotations.*;

import static il.org.spartan.Utils.*;

/** A utility class, offering a collection of function to unbox arrays and
 * collection of the boxed versions of the primitive types. The input of each
 * unboxing function is a {@link Collection} or an array of one the following
 * eight reference types
 * <ol>
 * <li>{@link Boolean}
 * <li>{@link Byte}
 * <li>{@link Character}
 * <li>{@link Double}
 * <li>{@link Float}
 * <li>{@link Integer}
 * <li>{@link Long}
 * <li>{@link Short}
 * </ol>
 * The returned value is an array of the equivalent primitive type.
 * <p>
 * Note that unboxing of a single value of a reference type is easy using a
 * function such as {@link Long#longValue()}
 * @author Yossi Gil.
 * @see box */
public enum unbox {
  // A namespace: no values to this <code><b>enum</b></code>
  ;
  public static double[] it(final Double[] ¢) {
    return unboxDoubleArray(¢);
  }

  public static float[] it(final Float[] ¢) {
    return unboxFloatArray(¢);
  }

  public static int it(final Integer ¢) {
    return unbox.unboxInteger(¢);
  }

  public static long it(final Long ¢) {
    return unbox.unboxLong(¢);
  }

  public static double it(final Double ¢) {
    return unbox.unboxDouble(¢);
  }

  public static float it(final Float ¢) {
    return unbox.unboxFloat(¢);
  }

  public static short it(final Short ¢) {
    return unbox.unboxShort(¢);
  }

  public static byte it(final Byte ¢) {
    return unbox.unboxByte(¢);
  }

  public static char it(final Character ¢) {
    return unbox.unboxChar(¢);
  }

  public static boolean it(final Boolean ¢) {
    return unbox.unboxBoolean(cantBeNull(¢));
  }

  public static int[] it(final Integer[] ¢) {
    return unboxIntegerArray(¢);
  }

  public static long[] it(final Long[] ¢) {
    return unboxLongArray(¢);
  }

  public static short[] it(final Short[] ¢) {
    return unboxShortArray(¢);
  }
  
  public static byte[] it(final Byte[] ¢) {
    return unboxByteArray(¢);
  }

  public static char[] it(final Character[] ¢) {
    return unboxCharArray(¢);
  }

  public static boolean[] it(final Boolean[] ¢) {
    return unboxBooleanArray(¢);
  }

  public static int[] it(final List<Integer> ¢) {
    return it(¢.toArray(new Integer[¢.size()]));
  }


  public static short[] it(final Collection<Short> ¢) {
    return it(¢.toArray(new Short[¢.size()]));
  }

  public static boolean unboxBoolean(final @NotNull Boolean ¢) {
    return ¢.booleanValue();
  }

  /** unbox an array of {@link Boolean}s into an array of
   * <code><b>boolean</b></code>s.
   * @param bs an array of {@link Boolean}s
   * @return an equivalent array of <code><b>boolean</b></code>s. */
  public static boolean[] unboxBooleanArray(final Boolean[] bs) {
    final boolean[] $ = new boolean[bs.length];
    for (int ¢ = 0; ¢ < bs.length; ++¢)
      $[¢] = bs[¢].booleanValue();
    return $;
  }

  public static byte unboxByte(final Byte ¢) {
    return ¢.byteValue();
  }

  /** unbox an array of {@link Byte}s into an array of <code><b>byte</b></code> s.
   * @param bs an array of {@link Byte}s
   * @return an equivalent array of <code><b>byte</b></code>s. */
  public static byte[] unboxByteArray(final Byte[] bs) {
    final byte[] $ = new byte[bs.length];
    for (int ¢ = 0; ¢ < bs.length; ++¢)
      $[¢] = bs[¢].byteValue();
    return $;
  }

  public static char unboxChar(final Character ¢) {
    return ¢.charValue();
  }

  /** unbox an array of {@link Character}s into an array of
   * <code><b>char</b></code>s.
   * @param cs an array of {@link Character}s
   * @return an equivalent array of <code><b>char</b></code>s. */
  public static char[] unboxCharArray(final Character[] cs) {
    final char[] $ = new char[cs.length];
    for (int ¢ = 0; ¢ < cs.length; ++¢)
      $[¢] = cs[¢].charValue();
    return $;
  }

  /** unbox a {@link Collection} of {@link Short}s into an array of
   * <code><b>short</b></code>s.
   * @param ss a {@link Collection} of {@link Integer}s
   * @return an equivalent array of <code><b>short</b></code>s. */
  public static short[] unboxShortCollection(final Collection<Short> ss) {
    final short[] $ = new short[ss.size()];
    int i = 0;
    for (final Short v : ss)
      $[i++] = v.shortValue();
    return $;
  }

  public static double unboxDouble(final Double ¢) {
    return ¢.doubleValue();
  }

  /** unbox an array of {@link Double}s into an array of
   * <code><b>double</b></code>s.
   * @param ds an array of {@link Double}s
   * @return an equivalent array of <code><b>double</b></code>s. */
  public static double[] unboxDoubleArray(final Double[] ds) {
    final double @NotNull [] $ = new double[ds.length];
    for (int ¢ = 0; ¢ < ds.length; ++¢)
      $[¢] = ds[¢].floatValue();
    return $;
  }

  public static float unboxFloat(final Float ¢) {
    return ¢.floatValue();
  }

  /** unbox an array of {@link Float}s into an array of <code><b>float</b></code>
   * s.
   * @param fs an array of {@link Float}s
   * @return an equivalent array of <code><b>float</b></code>s. */
  public static float[] unboxFloatArray(final Float[] fs) {
    final float[] $ = new float[fs.length];
    for (int ¢ = 0; ¢ < fs.length; ++¢)
      $[¢] = fs[¢].floatValue();
    return $;
  }

  public static int unboxInteger(final Integer ¢) {
    return ¢.intValue();
  }

  /** unbox an array of {@link Integer}s into an array of <code><b>int</b></code>
   * s.
   * @param is an array of {@link Integer}s
   * @return an equivalent array of <code><b>int</b></code>s. */
  public static int[] unboxIntegerArray(final Integer[] is) {
    final int[] $ = new int[is.length];
    for (int ¢ = 0; ¢ < is.length; ++¢)
      $[¢] = unbox.unboxInteger(is[¢]);
    return $;
  }

  public static long unboxLong(final Long ¢) {
    return ¢.longValue();
  }

  /** unbox an array of {@link Long}s into an array of <code><b>long</b></code> s.
   * @param ls an array of {@link Long}s
   * @return an equivalent array of <code><b>long</b></code>s. */
  public static long[] unboxLongArray(final Long[] ls) {
    final long[] $ = new long[ls.length];
    for (int ¢ = 0; ¢ < ls.length; ++¢)
      $[¢] = ls[¢].longValue();
    return $;
  }

  public static short unboxShort(final Short ¢) {
    return ¢.shortValue();
  }

  /** unbox an array of {@link Short}s into an array of <code><b>short</b></code>
   * s.
   * @param ss an array of {@link Integer}s
   * @return an equivalent array of <code><b>short</b></code>s. */
  public static short[] unboxShortArray(final Short[] ss) {
    final short[] $ = new short[ss.length];
    for (int ¢ = 0; ¢ < ss.length; ++¢)
      $[¢] = ss[¢].shortValue();
    return $;
  }
}
