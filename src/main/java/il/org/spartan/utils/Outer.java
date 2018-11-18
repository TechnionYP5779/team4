package il.org.spartan.utils;

import org.jetbrains.annotations.*;

import il.org.spartan.*;

/** TODO Yossi Gil: document class
 * @author Yossi Gil
 * @since 2017-03-21 */
@SuppressWarnings({"unchecked", "null"}) public class Outer<Inner> {
  public Inner inner;

  public Outer(final Inner inner) {
    this.inner = inner;
    if (inner == null || inner == this)
      throw new IllegalArgumentException();
  }

  @Override public boolean equals(final Object ¢) {
    return ¢ == this || (¢ != null && getClass() == ¢.getClass() && equals((Outer<Inner>) ¢));
  }

  protected boolean equals(final Outer<Inner> other) {
    if (inner == null) {
      if (other.inner != null)
        return false;
    } else if (!inner.equals(other.inner))
      return false;
    return true;
  }

  @Override public int hashCode() {
    return inner == null ? 0 : 31 + Utils.hash(inner);
  }

  /** @return value wrapped in this object. */
  public Inner get() {
    return inner;
  }

  /** set current value */
  public void set(final Inner ¢) {
    this.inner = ¢;
  }

  @Override @NotNull public String toString() {
    return inner == null ? "null" : Utils.cantBeNull(inner + "");
  }

  @Override @NotNull public Outer<Inner> clone() throws CloneNotSupportedException {
    return (Outer<Inner>) Utils.cantBeNull(super.clone());
  }
}
