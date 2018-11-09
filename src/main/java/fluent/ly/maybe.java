package fluent.ly;

import org.jetbrains.annotations.*;

/** @author Yossi Gil <Yossi.Gil@GMail.COM>
 * @param <T> JD
 * @since @{year}-@{month}-@{day} */
public class maybe<@Nullable T> {
  @NotNull public static <@Nullable T> maybe<T> no() {
    return new maybe<>();
  }

  @NotNull public static <@Nullable T> maybe<T> yes(final T ¢) {
    return new maybe<>(¢);
  }

  @Nullable private T inner;

  /** Instantiates this class.
   * @param inner JD */
  public maybe(final @Nullable T inner) {
    this.inner = inner;
  }

  private maybe() {
    inner = null;
  }

  @NotNull public maybe<@Nullable T> clear() {
    inner = null;
    return this;
  }

  @Nullable public T get() {
    return inner;
  }

  public boolean missing() {
    return inner == null;
  }

  public boolean present() {
    return inner != null;
  }

  @NotNull public maybe<@Nullable T> set(final T inner) {
    this.inner = inner;
    return this;
  }
}
