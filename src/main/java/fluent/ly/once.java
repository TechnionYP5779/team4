// <a href=http://ssdl-linux.cs.technion.ac.il/wiki/index.php>SSDLPedia</a>
package fluent.ly;

import org.jetbrains.annotations.*;

/** A class to manage printing a {@link String} exactly once. In the first
 * invocation of {@link #toString()}, the initial value is returned. In all
 * subsequent invocations, the empty string is returned.
 * @see Separator
 * @author Yossi Gil
 * @since 21/08/2007 */
public class once {
  @Nullable private String value;

  public once(final @NotNull String value) {
    this.value = defaults.to(value, "");
  }

  @Override @Nullable public String toString() {
    final @Nullable String $ = value;
    value = null;
    return $;
  }
}
