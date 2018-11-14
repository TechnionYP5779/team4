package fluent.ly;

import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

public class HasTest {
  @Nullable private final String nul = null;

  @Test public void seriesA01() {
    azzert.aye(has.nulls(nul));
  }

  @Test @SuppressWarnings("static-method") public void seriesA02() {
    azzert.nay(has.nulls("A"));
    @NotNull final Iterable<@Nullable String> os = new ArrayList<>();
    ((List<String>) os).add(String.valueOf("A"));
    azzert.nay(has.nulls(os));
  }
}
