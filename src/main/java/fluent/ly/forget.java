package fluent.ly;

/** TODO Yossi Gil: document class
 * @author Yossi Gil
 * @since 2017-04-16 */
public interface forget {
  /** This class is used to suppress the "Unused Variable" warning without using
   * the corresponding annotation */
  /** suppress the warning for all object in arguments */
  @SuppressWarnings("unused") static void all(final Object _1, final Object... _2) {
    /**/ }

  /** suppress the warning for a primitive boolean */
  @SuppressWarnings("unused") static void it(final boolean __) {
    /**/ }

  /** suppress the warning for a primitive double */
  @SuppressWarnings("unused") static void it(final double __) {
    /**/ }

  /** suppress the warning for a primitive long */
  @SuppressWarnings("unused") static void it(final long __) {
    /**/ }

  /** suppress the warning for any other object */
  @SuppressWarnings("unused") static void it(final Object __) {
    /**/ }
}
