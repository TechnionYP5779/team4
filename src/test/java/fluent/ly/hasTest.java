package fluent.ly;

import static fluent.ly.azzert.*;

import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

@SuppressWarnings("static-method") public class hasTest {
  @Nullable private final String nul = null;

  @Test public void seriesA01() {
    azzert.aye(has.nulls(nul));
    azzert.aye(has.nulls((Object) null));
    azzert.aye(has.nulls((Object) null, (Object) null, (Object) null));
    azzert.nay(has.nulls());
  }

  @Test public void seriesA02() {
    azzert.nay(has.nulls("A"));
    @NotNull final Iterable<@Nullable String> os = new ArrayList<>();
    ((List<String>) os).add(String.valueOf("A"));
    azzert.nay(has.nulls(os));
  }

  @Test public void seriesA03() {
    final List<String> i = new ArrayList<>();
    i.add("");
    i.add(null);
    i.add("a");
    azzert.nay(has.nulls(i));
  }

  @Test @SuppressWarnings("null") public void seriesA04() {
    final List<String> i = new ArrayList<>();
    azzert.isNull(has.next(-1, i));
    azzert.isNull(has.next(0, i));
    azzert.isNull(has.next(1, i));
    azzert.isNull(has.next(2, i));
    i.add("");
    azzert.that(has.next(-1, i), is(""));
    azzert.that(has.next(0, i), is(""));
    azzert.that(has.next(1, i), is(""));
  }
}
