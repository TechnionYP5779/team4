package fluent.ly;

import static fluent.ly.azzert.*;

import java.util.*;

import org.junit.*;

import il.org.spartan.*;

@SuppressWarnings("static-method") public class LispTest {
  final ArrayList<Integer> b = new ArrayList<>();
  ArrayList<Integer> a;
  ArrayList<Integer> c;

  @Before public void setup() {
    b.add(Integer.valueOf(1));
    b.add(Integer.valueOf(2));
    b.add(Integer.valueOf(3));
    a = (ArrayList<Integer>) lisp.replace(b, Integer.valueOf(6), 1);
  }

  private void anotherSetup() {
    c = (ArrayList<Integer>) lisp.replaceFirst(b, Integer.valueOf(6));
  }

  @Test public void next() {
    azzert.that(lisp.next(1, Arrays.asList(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3))), is(3));
  }

  @Test public void get() {
    azzert.that(lisp.get(Arrays.asList(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3)), 0), is(2));
  }

  @Test public void replace1() {
    if (a != null)
      azzert.that(a.get(0), is(1));
  }

  @Test public void replace2() {
    if (a != null)
      azzert.that(a.get(1), is(6));
  }

  @Test public void replace3() {
    if (a != null)
      azzert.that(a.get(2), is(3));
  }

  @Test public void replace4() {
    anotherSetup();
    if (c != null)
      azzert.that(c.get(0), is(6));
  }

  @Test public void replace5() {
    anotherSetup();
    if (c != null)
      azzert.that(c.get(1), is(6));
  }

  @Test public void replace6() {
    anotherSetup();
    if (c != null)
      azzert.that(c.get(2), is(3));
  }

  @Test public void replace7() {
    anotherSetup();
    final ArrayList<Integer> d = (ArrayList<Integer>) lisp.replaceLast(Utils.cantBeNull(b), Integer.valueOf(6));
    if (d != null)
      azzert.that(d.get(0), is(6));
  }

  @Test public void replace8() {
    anotherSetup();
    final ArrayList<Integer> d = (ArrayList<Integer>) lisp.replaceLast(Utils.cantBeNull(b), Integer.valueOf(6));
    if (d != null)
      azzert.that(d.get(1), is(6));
  }

  @Test public void replace9() {
    anotherSetup();
    final ArrayList<Integer> d = (ArrayList<Integer>) lisp.replaceLast(Utils.cantBeNull(b), Integer.valueOf(6));
    if (d != null)
      azzert.that(d.get(2), is(6));
  }
}
