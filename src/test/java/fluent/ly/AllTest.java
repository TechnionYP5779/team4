package fluent.ly;

import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

@SuppressWarnings("static-method") public class AllTest {
  @Test public void testNotNull1() {
    assert !all.notNull((Iterable<String>) null);
    final List<String> list = new ArrayList<>();
    list.add("Hello");
    list.add("World");
    assert all.notNull(list);
    list.add(null);
    assert !all.notNull(list);
  }

  @Test public void testNotNull2() {
    assert !all.notNull((@Nullable String[]) null);
    assert all.notNull(new @Nullable String[] { "Hello", "World" });
    assert !all.notNull(new @Nullable String[] { "Hello", null, "World" });
  }
}
