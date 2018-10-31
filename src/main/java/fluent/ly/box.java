// <a href=http://ssdl-linux.cs.technion.ac.il/wiki/index.php>SSDLPedia</a>
package fluent.ly;

import static il.org.spartan.Utils.*;

import org.jetbrains.annotations.*;

import il.org.spartan.*;

/** A utility class, with a collection of function to box primitive types in
 * their reference type equivalent representation. Similarly, this class offers
 * functions to box arrays of primitive types into their reference type
 * equivalent.
 * @author Yossi Gil, the Technion.
 * @since 21/06/2008
 * @see unbox */
@SuppressWarnings("null") public enum box {
  // A namespace: no values to this <code><b>enum</b></code>
  ;
  /** box a <code><b>boolean</b></code> into a {@link Boolean} object.
   * @param ¢ some <code><b>boolean</b></code> value
   * @return a non-<code><b>null</b></code> {@link Boolean} with the value of
   *         <code>c</code> */
  public static Boolean box(final boolean ¢) {
    return Boolean.valueOf(¢);
  }

  @NotNull public static Boolean[] box(final boolean bs[]) {
    final @NotNull Boolean[] $ = new Boolean[bs.length];
    for (int ¢ = 0; ¢ < $.length; ++¢)
      $[¢] = box(bs[¢]);
    return $;
  }

  @NotNull public static Byte box(final byte ¢) {
    return Utils.canBeNull(Byte.valueOf(¢));
  }

  @NotNull public static Byte[] box(final byte bs[]) {
    final Byte @NotNull [] $ = new Byte[bs.length];
    for (int ¢ = 0; ¢ < $.length; ++¢)
      $[¢] = box(bs[¢]);
    return $;
  }

  /** box a <code><b>char</b></code> into a {@link Character} object.
   * @param ¢ some <code><b>char</b></code> value
   * @return a non-<code><b>null</b></code> {@link Character} with the value of
   *         <code>c</code> */
  public static Character box(final char ¢) {
    return Character.valueOf(¢);
  }

  @NotNull public static Character @NotNull [] box(final char cs[]) {
    final Character @NotNull [] $ = new Character[cs.length];
    for (int ¢ = 0; ¢ < $.length; ++¢)
      $[¢] = box(cs[¢]);
    return $;
  }

  /** box a <code><b>double</b></code> into a {@link Double} object.
   * @param ¢ some <code><b>double</b></code> value
   * @return a non-<code><b>null</b></code> {@link Double} with the value of
   *         <code>d</code> */
  public static Double box(final double ¢) {
    return Double.valueOf(¢);
  }

  @NotNull public static Double[] box(final double ds[]) {
    final Double @NotNull [] $ = new Double[ds.length];
    for (int ¢ = 0; ¢ < $.length; ++¢)
      $[¢] = box(ds[¢]);
    return $;
  }

  /** box a <code><b>float</b></code> into a {@link Float} object.
   * @param ¢ some <code><b>float</b></code> value
   * @return a non-<code><b>null</b></code> {@link Float} with the value of
   *         <code>f</code> */
  public static Float box(final float ¢) {
    return Float.valueOf(¢);
  }

  @NotNull public static Float[] box(final float fs[]) {
    final @NotNull Float[] $ = new Float[fs.length];
    for (int ¢ = 0; ¢ < $.length; ++¢)
      $[¢] = box(fs[¢]);
    return $;
  }

  /** box an <code><b>int</b></code> into an {@link Integer} object.
   * @param ¢ some <code><b>int</b></code> value
   * @return a non-<code><b>null</b></code> {@link Integer} with the value of
   *         <code>n</code> */
  public static Integer box(final int ¢) {
    return Integer.valueOf(¢);
  }

  @NotNull public static Integer[] box(final int is[]) {
    final Integer @NotNull [] $ = new Integer[is.length];
    for (int ¢ = 0; ¢ < $.length; ++¢)
      $[¢] = box(is[¢]);
    return $;
  }

  @NotNull public static Long box(final long ¢) {
    return Long.valueOf(¢);
  }

  @NotNull public static Long @NotNull [] box(final long ls[]) {
    final Long @NotNull [] $ = new Long[ls.length];
    for (int ¢ = 0; ¢ < $.length; ++¢)
      $[¢] = box(ls[¢]);
    return $;
  }

  /** box a <code><b>short</b></code> into a {@link Short} object.
   * @param ¢ some <code><b>short</b></code> value
   * @return a non-<code><b>null</b></code> {@link Short} with the value of
   *         <code>s</code> */
  public static Short box(final short ¢) {
    return Short.valueOf(¢);
  }

  @NotNull public static Short[] box(final short ss[]) {
    final Short @NotNull [] $ = new Short[ss.length];
    for (int ¢ = 0; ¢ < $.length; ++¢)
      $[¢] = box(ss[¢]);
    return $;
  }

  /** box a <code><b>boolean</b></code> into a {@link Boolean} object.
   * @param ¢ some <code><b>boolean</b></code> value
   * @return a non-<code><b>null</b></code> {@link Boolean} with the value of
   *         <code>c</code> */
  public static Boolean it(final boolean ¢) {
    return cantBeNull(Boolean.valueOf(¢));
  }

  @NotNull public static Boolean[] it(final boolean bs[]) {
    final Boolean @NotNull [] $ = new Boolean @NotNull [bs.length];
    for (int ¢ = 0; ¢ < $.length; ++¢)
      $[¢] = box(bs[¢]);
    return $;
  }

  /** box a <code><b>byte</b></code> into a {@link Byte} object.
   * @param ¢ some <code><b>long</b></code> value
   * @return a non-<code><b>null</b></code> {@link Long} with the value of
   *         <code>l</code> */
  public static Byte it(final byte ¢) {
    return cantBeNull(Byte.valueOf(¢));
  }

  @NotNull public static Byte[] it(final byte bs[]) {
    final Byte @NotNull [] $ = new Byte @NotNull [bs.length];
    for (int ¢ = 0; ¢ < $.length; ++¢)
      $[¢] = box(bs[¢]);
    return $;
  }

  @NotNull public static Character it(final char ¢) {
    return cantBeNull(Character.valueOf(¢));
  }

  @NotNull public static Character @NotNull [] it(final char cs[]) {
    final @NotNull Character @NotNull [] $ = new Character @NotNull [cs.length];
    for (int ¢ = 0; ¢ < $.length; ++¢)
      $[¢] = it(cs[¢]);
    return $;
  }

  /** box a <code><b>double</b></code> into a {@link Double} object.
   * @param ¢ some <code><b>double</b></code> value
   * @return a non-<code><b>null</b></code> {@link Double} with the value of
   *         <code>d</code> */
  public static Double it(final double ¢) {
    return cantBeNull(Double.valueOf(¢));
  }

  @NotNull public static Double[] it(final double ds[]) {
    final Double @NotNull [] $ = new Double[ds.length];
    for (int ¢ = 0; ¢ < $.length; ++¢)
      $[¢] = box(ds[¢]);
    return $;
  }

  /** box a <code><b>float</b></code> into a {@link Float} object.
   * @param ¢ some <code><b>float</b></code> value
   * @return a non-<code><b>null</b></code> {@link Float} with the value of
   *         <code>f</code> */
  @NotNull public static Float it(final float ¢) {
    return cantBeNull(Float.valueOf(¢));
  }

  @NotNull public static Float[] it(final float fs[]) {
    final @NotNull Float @NotNull [] $ = new Float @NotNull [fs.length];
    for (int ¢ = 0; ¢ < $.length; ++¢)
      $[¢] = it(fs[¢]);
    return $;
  }

  /** box an <code><b>int</b></code> into an {@link Integer} object.
   * @param ¢ some <code><b>int</b></code> value
   * @return a non-<code><b>null</b></code> {@link Integer} with the value of
   *         <code>n</code>
   * @see #box(int) */
  public static Integer it(final int ¢) {
    return box(¢);
  }

  @NotNull public static Integer[] it(final int ¢[]) {
    return box(¢);
  }

  @NotNull public static Long it(final long ¢) {
    return cantBeNull(Long.valueOf(¢));
  }

  @NotNull public static Long @NotNull [] it(final long ls[]) {
    final @NotNull Long @NotNull [] $ = new Long[ls.length];
    for (int ¢ = 0; ¢ < $.length; ++¢)
      $[¢] = it(ls[¢]);
    return $;
  }

  @NotNull public static Short it(final short ¢) {
    return cantBeNull(Short.valueOf(¢));
  }

  @NotNull public static Short @NotNull [] it(final short ss[]) {
    final @NotNull Short @NotNull [] $ = new Short @NotNull [ss.length];
    for (int ¢ = 0; ¢ < $.length; ++¢)
      $[¢] = it(ss[¢]);
    return $;
  }
}
