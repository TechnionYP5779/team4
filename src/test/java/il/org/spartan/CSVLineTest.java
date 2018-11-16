package il.org.spartan;

import java.util.*;

import org.junit.*;

import fluent.ly.*;
import il.org.spartan.tables.*;
import il.org.spartan.utils.*;

import static fluent.ly.azzert.*;

@SuppressWarnings("static-method") public class CSVLineTest {
  @Test public void aggregatingEmpty() {
    Map<String,String> m = new HashMap<>();
    m.put("k1", "v1");
    assert !(new CSVLine(m) {/**/
    }).aggregating();
  }
  
  @Test public void asKeysAndValues() {
    Map<String,String> m = new HashMap<>();
    CSVLine cl = new CSVLine(m) {/**/
    };
    cl.put("k1", "v1");
    azzert.that(cl.asKeyValuePairs(), is("k1=v1"));
  }
  
  @Test public void getString() {
    Map<String,String> m = new HashMap<>();
    CSVLine cl = new CSVLine(m) {/**/
    };
    cl.put("k1", "v1");
    azzert.that(cl.get("k1"), is("v1"));
  }
  
  @Test public void getKeys() {
    Map<String,String> m = new HashMap<>();
    CSVLine cl = new CSVLine(m) {/**/
    };
    cl.put("k1", "v1");
    assert ((Set<String>)(cl.keys())).contains("k1");
  }
  
  @Test public void putAccumulators() {
    Map<String,String> m = new HashMap<>();
    Accumulator.Counter a1 = new Accumulator.Counter("k1"), a2 = new Accumulator.Counter("k2");
    CSVLine cl = new CSVLine(m) {/**/
    };
    a1.add();
    a2.add();
    a2.add();
    cl.put(a1,a2);
    azzert.that(cl.asKeyValuePairs(), is("k1=1, k2=2"));
  }
  
  @Test public void putEnumInt() {
    Map<String,String> m = new HashMap<>();
    CSVLine cl = new CSVLine(m) {/**/
    };
    cl.put(Statistic.mean, 5);
    azzert.that(cl.asKeyValuePairs(), is("mean=5"));
  }
  
  @Test public void putEnumStr() {
    Map<String,String> m = new HashMap<>();
    CSVLine cl = new CSVLine(m) {/**/
    };
    cl.put(Statistic.mean, "hi");
    azzert.that(cl.asKeyValuePairs(), is("mean=hi"));
  }
  
  @Test public void putOnlyKey() {
    Map<String,String> m = new HashMap<>();
    CSVLine cl = new CSVLine(m) {/**/
    };
    cl.put("k");
    azzert.that(cl.asKeyValuePairs(), is("k="));
  }
  
  @Test public void putStrBool() {
    Map<String,String> m = new HashMap<>();
    CSVLine cl = new CSVLine(m) {/**/
    };
    cl.put("k", true);
    azzert.that(cl.asKeyValuePairs(), is("k=true"));
  }
  
  @Test public void putStrChar() {
    Map<String,String> m = new HashMap<>();
    CSVLine cl = new CSVLine(m) {/**/
    };
    cl.put("k", 'v');
    azzert.that(cl.asKeyValuePairs(), is("k=v"));
  }
  
  @Test public void putStrFloat() {
    Map<String,String> m = new HashMap<>();
    CSVLine cl = new CSVLine(m) {/**/
    };
    cl.put("k", 5.2f);
    azzert.that(cl.asKeyValuePairs(), is("k=5.2"));
  }
  
  @Test public void putStrInt() {
    Map<String,String> m = new HashMap<>();
    CSVLine cl = new CSVLine(m) {/**/
    };
    cl.put("k", 5);
    azzert.that(cl.asKeyValuePairs(), is("k=5"));
  }
  
  @Test public void putStrInteger() {
    Map<String,String> m = new HashMap<>();
    CSVLine cl = new CSVLine(m) {/**/
    };
    cl.put("k", Integer.valueOf(5));
    azzert.that(cl.asKeyValuePairs(), is("k=5"));
  }
  
  @Test public void putStrIntegerNull() {
    Map<String,String> m = new HashMap<>();
    CSVLine cl = new CSVLine(m) {/**/
    };
    Integer a = null;
    forget.it(a);
    cl.put("k", a);
    azzert.that(cl.asKeyValuePairs(), is("k="));
  }
  
  @Test public void putStrLong() {
    Map<String,String> m = new HashMap<>();
    CSVLine cl = new CSVLine(m) {/**/
    };
    cl.put("k", 5L);
    azzert.that(cl.asKeyValuePairs(), is("k=5"));
  }
  
  @Test public void putStrIntegerAsObj() {
    Map<String,String> m = new HashMap<>();
    CSVLine cl = new CSVLine(m) {/**/
    };
    Object o = Integer.valueOf(5);
    forget.it(o);
    cl.put("k", o);
    azzert.that(cl.asKeyValuePairs(), is("k=5"));
  }
  
  @Test public void putStrObjNull() {
    Map<String,String> m = new HashMap<>();
    CSVLine cl = new CSVLine(m) {/**/
    };
    Object a = null;
    forget.it(a);
    cl.put("k", a);
    azzert.that(cl.asKeyValuePairs(), is("k="));
  }
  
  @Test @SuppressWarnings("null") public void putObjArrElem() {
    Map<String, String> m = new HashMap<>();
    CSVLine cl = new CSVLine(m) {/**/
    };
    Object[] a = new Object[] { Integer.valueOf(5) };
    forget.it(a);
    cl.put("k", a, 0);
    azzert.that(cl.asKeyValuePairs(), is("k=5"));
  }
  
  @Test @SuppressWarnings("null") public void putObjArrNull() {
    Map<String, String> m = new HashMap<>();
    CSVLine cl = new CSVLine(m) {/**/
    };
    Object[] a = null;
    forget.it(a);
    cl.put("k", a, 0);
    azzert.that(cl.asKeyValuePairs(), is("k="));
  }
  
  @Test @SuppressWarnings("null") public void putObjArrElemGreaterThanBounds() {
    Map<String, String> m = new HashMap<>();
    CSVLine cl = new CSVLine(m) {/**/
    };
    Object[] a = new Object[] { Integer.valueOf(5) };
    forget.it(a);
    cl.put("k", a, 1);
    azzert.that(cl.asKeyValuePairs(), is("k="));
  }
  
  @Test @SuppressWarnings("null") public void putObjArrElemLowerThanBounds() {
    Map<String, String> m = new HashMap<>();
    CSVLine cl = new CSVLine(m) {/**/
    };
    Object[] a = new Object[] { Integer.valueOf(5) };
    forget.it(a);
    cl.put("k", a, -1);
    azzert.that(cl.asKeyValuePairs(), is("k="));
  }
  
  @Test @SuppressWarnings("null") public void putArr() {
    Map<String, String> m = new HashMap<>();
    CSVLine cl = new CSVLine(m) {/**/
    };
    Object[] a = new Object[] { Integer.valueOf(5), Integer.valueOf(6) };
    forget.it(a);
    cl.put("k", a);
    azzert.that(cl.asKeyValuePairs(), is("k=5;6"));
  }
  
  @Test @SuppressWarnings("null") public void putArrNull() {
    Map<String, String> m = new HashMap<>();
    CSVLine cl = new CSVLine(m) {/**/
    };
    Object[] a = null;
    forget.it(a);
    cl.put("k", a);
    azzert.that(cl.asKeyValuePairs(), is("k=null"));
  }
  
  @Test public void putStrShort() {
    Map<String, String> m = new HashMap<>();
    CSVLine cl = new CSVLine(m) {/**/
    };
    cl.put("k", (short)5);
    azzert.that(cl.asKeyValuePairs(), is("k=5"));
  }
  
  @Test public void csvSize() {
    Map<String, String> m = new HashMap<>();
    CSVLine cl = new CSVLine(m) {/**/
    };
    cl.put("k", (short)5);
    azzert.that(cl.size(), is(1));
  }
  
  @Test public void csvValues() {
    Map<String, String> m = new HashMap<>();
    CSVLine cl = new CSVLine(m) {/**/
    };
    cl.put("k", (short)5);
    assert cl.values().contains("5");
  }
}
