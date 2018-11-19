package il.org.spartan.utils;

import static fluent.ly.azzert.*;

import java.util.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class ChainStringToIntegerMapTest {
  @Test public void testCase() {
    final ChainStringToIntegerMap map = new ChainStringToIntegerMap();
    azzert.not(map.containsKey("abc"));
    azzert.not(map.containsValue(1));
    azzert.aye(map.isEmpty());
    azzert.that(map.size(), is(0));
    map.put("abc", 1);
    azzert.aye(map.containsKey("abc"));
    azzert.aye(map.containsValue(1));
    azzert.not(map.isEmpty());
    azzert.that(map.size(), is(1));
    azzert.that(map.get("abc"), is(1));
    map.put("def", -1);
    azzert.aye(map.containsKey("def"));
    azzert.aye(map.containsValue(-1));
    azzert.not(map.isEmpty());
    azzert.that(map.size(), is(2));
    azzert.that(map.get("def"), is(-1));
    final Set<String> keys = new HashSet<>();
    keys.add("abc");
    keys.add("def");
    azzert.that(keys, is(map.keySet()));
    final Collection<Integer> values = new HashSet<>();
    values.add(Integer.valueOf(1));
    map.values();
    map.entrySet();
    map.remove("abc");
    map.remove("def");
    azzert.not(map.containsKey("abc"));
    azzert.not(map.containsValue(1));
    azzert.not(map.containsKey("def"));
    azzert.not(map.containsValue(-1));
    azzert.aye(map.isEmpty());
    azzert.that(map.size(), is(0));
    map.putIfAbsent("abc", 1);
    azzert.aye(map.containsKey("abc"));
    azzert.aye(map.containsValue(1));
    azzert.not(map.isEmpty());
    azzert.that(map.size(), is(1));
    azzert.that(map.get("abc"), is(1));
  }

  @Test public void testPutAll() {
    final Map<String, Integer> map = new HashMap<>();
    map.put("a", Integer.valueOf(1));
    map.put("b", Integer.valueOf(2));
    map.put("c", Integer.valueOf(3));
    final ChainStringToIntegerMap copy = new ChainStringToIntegerMap();
    copy.putAll(map);
    azzert.aye(copy.containsKey("a"));
    azzert.aye(copy.containsValue(1));
    azzert.aye(copy.containsKey("b"));
    azzert.aye(copy.containsValue(2));
    azzert.aye(copy.containsKey("c"));
    azzert.aye(copy.containsValue(3));
    map.put("d", Integer.valueOf(4));
    map.put("e", Integer.valueOf(5));
    map.put("f", Integer.valueOf(6));
    azzert.not(copy.containsKey("d"));
    azzert.not(copy.containsValue(4));
    azzert.not(copy.containsKey("e"));
    azzert.not(copy.containsValue(5));
    azzert.not(copy.containsKey("f"));
    azzert.not(copy.containsValue(6));
  }

  @Test public void testPutOn() {
    final ChainStringToIntegerMap map = new ChainStringToIntegerMap();
    map.putOn(1, "a", "b", "c");
    azzert.aye(map.containsValue(1));
    azzert.aye(map.containsKey("a"));
    azzert.aye(map.containsKey("b"));
    azzert.aye(map.containsKey("c"));
    map.putOn(2, "d", "e", "f");
    azzert.aye(map.containsValue(2));
    azzert.aye(map.containsKey("d"));
    azzert.aye(map.containsKey("e"));
    azzert.aye(map.containsKey("f"));
  }
}
