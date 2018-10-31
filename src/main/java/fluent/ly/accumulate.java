/* Part of the "Spartan Blog"; mutate the rest / but leave this line as is */
package fluent.ly;

import java.util.*;

import org.jetbrains.annotations.*;

/** @author Yossi Gil <Yossi.Gil@GMail.COM>
 * @param <T> JD
 * @param <C> JD
 * @since 2016 */
public interface accumulate<T, C extends Collection<T>> {
  /** @param <T> JD
   * @param   <C> JD
   * @param c JD */
  static <T, C extends Collection<T>> @NotNull accumulate<T, C> to(final @NotNull C c) {
    return new accumulate<T, C>() {
      @Override @NotNull public accumulate<T, C> add(final @Nullable T ¢) {
        if (¢ == null)
          return this;
        c.add(¢);
        return this;
      }

      @Override @NotNull public C elements() {
        return c;
      }
    };
  }

  /** @param ts JD
   * @return <code><b>this</b></code> */
  @NotNull default accumulate<T, C> add(final @NotNull Iterable<? extends @Nullable T> ts) {
    for (final @Nullable T ¢ : ts)
      if (¢ != null)
        add(¢);
    return this;
  }

  /** @param t JD
   * @return <code><b>this</b></code> */
  @NotNull accumulate<T, C> add(@Nullable T t);

  /** @param ts JD
   * @return <code><b>this</b></code> */
  @NotNull default accumulate<T, C> add(@SuppressWarnings("unchecked") final T... ts) {
    if (ts != null)
      for (final @Nullable T ¢ : ts)
        if (¢ != null)
          add(¢);
    return this;
  }

  /** @param ts JD
   * @return <code><b>this</b></code> */
  @NotNull default accumulate<T, C> addAll(final @Nullable Iterable<? extends T> ts) {
    if (ts != null)
      for (final @Nullable T ¢ : ts)
        if (¢ != null)
          add(¢);
    return this;
  }

  /** @param tss JD
   * @return <code><b>this</b></code> */
  @NotNull default accumulate<T, C> addAll(@SuppressWarnings("unchecked") final @Nullable Iterable<? extends T>... tss) {
    if (tss != null)
      for (final Iterable<? extends T> ¢ : tss)
        addAll(¢);
    return this;
  }

  @NotNull C elements();
}
