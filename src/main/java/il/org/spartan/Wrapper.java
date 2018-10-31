package il.org.spartan;

import org.jetbrains.annotations.*;

/** A generic wrapper classes which can store and retrieve values of any type.
 * @author Yossi Gil
 * @since 2015-08-02
 * @param <T> JD */
public class Wrapper<@Nullable T> {
  @Nullable protected T inner;

  /** Instantiates this class */
  public Wrapper() {
    this(null);
  }

  /** Instantiates this class
   * @param inner JD */
  public Wrapper(final @Nullable T inner) {
    this.inner = inner;
  }

  @Override @NotNull @SuppressWarnings("unchecked") public Wrapper<T> clone() throws CloneNotSupportedException {
    return (Wrapper<T>) Utils.cantBeNull(super.clone());
  }

  @Override @SuppressWarnings("unchecked") public final boolean equals(final @Nullable Object ¢) {
    return super.equals(¢) || ¢ != null && getClass() == ¢.getClass() && equals((Wrapper<T>) ¢);
  }

  /** @param ¢ JD
   * @return <code><b>true</b></code> <i>iff</i> method <code>equals</code>
   *         returns <code><b>true</b></code> for the wrapped objects. */
  public boolean equals(final Wrapper<T> ¢) {
    return inner == null ? ¢.inner == null : equalsAux(¢.inner);
  }

  private boolean equalsAux(final T ¢) {
    return inner != null && inner.equals(¢);
  }

  /** @return value wrapped in this object. */
  public T get() {
    return inner;
  }

  @Override @SuppressWarnings("null") public int hashCode() {
    return inner == null ? 0 : inner.hashCode();
  }

  /** set current value */
  public void set(final T inner) {
    this.inner = inner;
  }

  @Override @NotNull public String toString() {
    return inner == null ? "null" : Utils.cantBeNull(inner + "");
  }
}
