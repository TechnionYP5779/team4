package fluent.ly;

import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

@SuppressWarnings("static-method") public class HasTest {
  @Nullable private final String nul = null;

  @Test public void seriesA01() {
    assert has.nulls(nul);
  }

  @Test public void seriesA02() {
    azzert.nay(has.nulls("A"));
    @NotNull final Iterable<@Nullable String> os = new ArrayList<>();
    ((List<String>) os).add(String.valueOf("A"));
    azzert.nay(has.nulls(os));
  }
}
