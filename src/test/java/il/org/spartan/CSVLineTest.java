package il.org.spartan;

import static fluent.ly.azzert.*;

import java.util.*;

import org.junit.*;

import fluent.ly.*;
import il.org.spartan.tables.*;
import il.org.spartan.utils.*;

@SuppressWarnings("static-method") public class CSVLineTest {
  @Test public void aggregatingEmpty() {
    final Map<String, String> m = new HashMap<>();
    m.put("k1", "v1");
    assert !new CSVLine(m) {/**/
    }.aggregating();
  }

  @Test public void asKeysAndValues() {
    final Map<String, String> m = new HashMap<>();
    final CSVLine cl = new CSVLine(m) {/**/
    };
    cl.put("k1", "v1");
    azzert.that(cl.asKeyValuePairs(), is("k1=v1"));
  }

  @Test public void getString() {
    final Map<String, String> m = new HashMap<>();
    final CSVLine cl = new CSVLine(m) {/**/
    };
    cl.put("k1", "v1");
    azzert.that(cl.get("k1"), is("v1"));
  }

  @Test public void getKeys() {
    final Map<String, String> m = new HashMap<>();
    final CSVLine cl = new CSVLine(m) {/**/
    };
    cl.put("k1", "v1");
    assert ((Set<String>) cl.keys()).contains("k1");
  }

  @Test public void putAccumulators() {
    final Map<String, String> m = new HashMap<>();
    final Accumulator.Counter a1 = new Accumulator.Counter("k1"), a2 = new Accumulator.Counter("k2");
    final CSVLine cl = new CSVLine(m) {/**/
    };
    a1.add();
    a2.add();
    a2.add();
    cl.put(a1, a2);
    azzert.that(cl.asKeyValuePairs(), is("k1=1, k2=2"));
  }

  @Test public void putEnumInt() {
    final Map<String, String> m = new HashMap<>();
    final CSVLine cl = new CSVLine(m) {/**/
    };
    cl.put(Statistic.mean, 5);
    azzert.that(cl.asKeyValuePairs(), is("mean=5"));
  }

  @Test public void putEnumStr() {
    final Map<String, String> m = new HashMap<>();
    final CSVLine cl = new CSVLine(m) {/**/
    };
    cl.put(Statistic.mean, "hi");
    azzert.that(cl.asKeyValuePairs(), is("mean=hi"));
  }

  @Test public void putOnlyKey() {
    final Map<String, String> m = new HashMap<>();
    final CSVLine cl = new CSVLine(m) {/**/
    };
    cl.put("k");
    azzert.that(cl.asKeyValuePairs(), is("k="));
  }

  @Test public void putStrBool() {
    final Map<String, String> m = new HashMap<>();
    final CSVLine cl = new CSVLine(m) {/**/
    };
    cl.put("k", true);
    azzert.that(cl.asKeyValuePairs(), is("k=true"));
  }

  @Test public void putStrChar() {
    final Map<String, String> m = new HashMap<>();
    final CSVLine cl = new CSVLine(m) {/**/
    };
    cl.put("k", 'v');
    azzert.that(cl.asKeyValuePairs(), is("k=v"));
  }

  @Test public void putStrFloat() {
    final Map<String, String> m = new HashMap<>();
    final CSVLine cl = new CSVLine(m) {/**/
    };
    cl.put("k", 5.2f);
    azzert.that(cl.asKeyValuePairs(), is("k=5.2"));
  }

  @Test public void putStrInt() {
    final Map<String, String> m = new HashMap<>();
    final CSVLine cl = new CSVLine(m) {/**/
    };
    cl.put("k", 5);
    azzert.that(cl.asKeyValuePairs(), is("k=5"));
  }

  @Test public void putStrInteger() {
    final Map<String, String> m = new HashMap<>();
    final CSVLine cl = new CSVLine(m) {/**/
    };
    cl.put("k", Integer.valueOf(5));
    azzert.that(cl.asKeyValuePairs(), is("k=5"));
  }

  @Test public void putStrIntegerNull() {
    final Map<String, String> m = new HashMap<>();
    final CSVLine cl = new CSVLine(m) {/**/
    };
    final Integer a = null;
    forget.it(a);
    cl.put("k", a);
    azzert.that(cl.asKeyValuePairs(), is("k="));
  }

  @Test public void putStrLong() {
    final Map<String, String> m = new HashMap<>();
    final CSVLine cl = new CSVLine(m) {/**/
    };
    cl.put("k", 5L);
    azzert.that(cl.asKeyValuePairs(), is("k=5"));
  }

  @Test public void putStrIntegerAsObj() {
    final Map<String, String> m = new HashMap<>();
    final CSVLine cl = new CSVLine(m) {/**/
    };
    final Object o = Integer.valueOf(5);
    forget.it(o);
    cl.put("k", o);
    azzert.that(cl.asKeyValuePairs(), is("k=5"));
  }

  @Test public void putStrObjNull() {
    final Map<String, String> m = new HashMap<>();
    final CSVLine cl = new CSVLine(m) {/**/
    };
    final Object a = null;
    forget.it(a);
    cl.put("k", a);
    azzert.that(cl.asKeyValuePairs(), is("k="));
  }

  @Test @SuppressWarnings("null") public void putObjArrElem() {
    final Map<String, String> m = new HashMap<>();
    final CSVLine cl = new CSVLine(m) {/**/
    };
    final Object[] a = new Object[] { Integer.valueOf(5) };
    forget.it(a);
    cl.put("k", a, 0);
    azzert.that(cl.asKeyValuePairs(), is("k=5"));
  }

  @Test @SuppressWarnings("null") public void putObjArrNull() {
    final Map<String, String> m = new HashMap<>();
    final CSVLine cl = new CSVLine(m) {/**/
    };
    final Object[] a = null;
    forget.it(a);
    cl.put("k", a, 0);
    azzert.that(cl.asKeyValuePairs(), is("k="));
  }

  @Test @SuppressWarnings("null") public void putObjArrElemGreaterThanBounds() {
    final Map<String, String> m = new HashMap<>();
    final CSVLine cl = new CSVLine(m) {/**/
    };
    final Object[] a = new Object[] { Integer.valueOf(5) };
    forget.it(a);
    cl.put("k", a, 1);
    azzert.that(cl.asKeyValuePairs(), is("k="));
  }

  @Test @SuppressWarnings("null") public void putObjArrElemLowerThanBounds() {
    final Map<String, String> m = new HashMap<>();
    final CSVLine cl = new CSVLine(m) {/**/
    };
    final Object[] a = new Object[] { Integer.valueOf(5) };
    forget.it(a);
    cl.put("k", a, -1);
    azzert.that(cl.asKeyValuePairs(), is("k="));
  }

  @Test @SuppressWarnings("null") public void putArr() {
    final Map<String, String> m = new HashMap<>();
    final CSVLine cl = new CSVLine(m) {/**/
    };
    final Object[] a = new Object[] { Integer.valueOf(5), Integer.valueOf(6) };
    forget.it(a);
    cl.put("k", a);
    azzert.that(cl.asKeyValuePairs(), is("k=5;6"));
  }

  @Test @SuppressWarnings("null") public void putArrNull() {
    final Map<String, String> m = new HashMap<>();
    final CSVLine cl = new CSVLine(m) {/**/
    };
    final Object[] a = null;
    forget.it(a);
    cl.put("k", a);
    azzert.that(cl.asKeyValuePairs(), is("k=null"));
  }

  @Test public void putStrShort() {
    final Map<String, String> m = new HashMap<>();
    final CSVLine cl = new CSVLine(m) {/**/
    };
    cl.put("k", (short) 5);
    azzert.that(cl.asKeyValuePairs(), is("k=5"));
  }

  @Test public void csvSize() {
    final Map<String, String> m = new HashMap<>();
    final CSVLine cl = new CSVLine(m) {/**/
    };
    cl.put("k", (short) 5);
    azzert.that(cl.size(), is(1));
  }

  @Test public void csvValues() {
    final Map<String, String> m = new HashMap<>();
    final CSVLine cl = new CSVLine(m) {/**/
    };
    cl.put("k", (short) 5);
    assert cl.values().contains("5");
  }
}
