package fluent.ly;

import java.util.function.*;

import org.jetbrains.annotations.*;

import il.org.spartan.utils.*;

/** A class for lazy, memoizing evaluation of objects of arbitrary type. The
 * evaluation must never return <code><b>null</b></code>. Main purpose is for
 * lazy initialization as in {@code
    static final lazy<Collection<Thing>> things = lazy.get(() -> as.list(//
      new Thing("one"), //
      new Thing("two") //
  ));} use {@code things.get()} to obtain value; it would be computed only on
 * first call, and cached hence after
 * <p>
 * This class is not expected to be instantiated by clients; use as demonstrated
 * above
 * @param <T> JD
 * @author Yossi Gil
 * @since 2017-03-10 */
public interface lazy<@Nullable T> extends Supplier<@Nullable T> {
  static <@Nullable T> lazy<@Nullable T> get(@¢ final Supplier<@Nullable T> ¢) {
    return new lazy<@Nullable T>() {
      /** Cached value; invalid cache if {@code null} */
      @Nullable T $;

      /** [[SuppressWarningsSpartan]] No need to be {@code synchronized} to make it
       * thread safe. Instance is always unique.
       * @Return value of the supplier */
      @Override @Nullable public T get() {
        set($ != null ? $ : ¢.get());
        return $;
      }

      /** [[SuppressWarningsSpartan]] */
      void set(@Nullable T value) {
        $ = value;
      }
    };
  }
}
