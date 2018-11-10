package il.org.spartan.utils;
import static fluent.ly.azzert.*;

import java.util.*;

import org.junit.*;
import fluent.ly.*;

@SuppressWarnings("static-method") public class ChainStringToIntegerMapTest {
  @Test public void testCase() {
    ChainStringToIntegerMap map = new ChainStringToIntegerMap();
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
    
    Set<String> keys = new HashSet<>();
    keys.add("abc");
    azzert.that(keys, is(map.keySet()));  
    
    Collection<Integer> values = new HashSet<>();
    values.add(Integer.valueOf(1));
    map.values();
    map.entrySet();
    //azzert.that(values, is(map.values()));
    
    map.remove("abc");
    azzert.not(map.containsKey("abc"));
    azzert.not(map.containsValue(1));
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
    Map<String, Integer> map = new HashMap<>(); 
    map.put("a", Integer.valueOf(1));
    map.put("b", Integer.valueOf(2));
    map.put("c", Integer.valueOf(3));
    
    ChainStringToIntegerMap copy = new ChainStringToIntegerMap();
    copy.putAll(map);
    azzert.aye(copy.containsKey("a"));
    azzert.aye(copy.containsValue(1));
    azzert.aye(copy.containsKey("b"));
    azzert.aye(copy.containsValue(2));
    azzert.aye(copy.containsKey("c"));
    azzert.aye(copy.containsValue(3));    
  }
  
  @Test public void testPutOn() {
    ChainStringToIntegerMap map = new ChainStringToIntegerMap();
    map.putOn(1, "a", "b", "c");
    azzert.aye(map.containsValue(1));
    azzert.aye(map.containsKey("a"));
    azzert.aye(map.containsKey("b"));
    azzert.aye(map.containsKey("c"));
  }
  
}
