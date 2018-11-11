package fluent.ly;

import java.util.*;

import org.junit.*;

import static fluent.ly.azzert.*;

@SuppressWarnings("static-method") public class LispTest {
  @Test public void next() {
    azzert.that(lisp.next(1, Arrays.asList(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3))), is(3));
  }

  @Test public void get() {
    azzert.that(lisp.get(Arrays.asList(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3)), 0), is(2));
  }

  @Test public void replace() {
    ArrayList<Integer> b = new ArrayList<>();
    b.add(Integer.valueOf(1));
    b.add(Integer.valueOf(2));
    b.add(Integer.valueOf(3));
    ArrayList<Integer> a = (ArrayList<Integer>) lisp.replace(b, Integer.valueOf(6), 1);
    if (a != null)
      azzert.that(a.get(0), is(1));
    if (a != null)
      azzert.that(a.get(1), is(6));
    if (a != null)
      azzert.that(a.get(2), is(3));
    ArrayList<Integer> c = (ArrayList<Integer>) lisp.replaceFirst(b, Integer.valueOf(6));
    if (c != null)
      azzert.that(c.get(0), is(6));
    if (c != null)
      azzert.that(c.get(1), is(6));
    if (c != null)
      azzert.that(c.get(2), is(3));
    ArrayList<Integer> d = (ArrayList<Integer>) lisp.replaceLast(b, Integer.valueOf(6));
    if (d != null)
      azzert.that(d.get(0), is(6));
    if (d != null)
      azzert.that(d.get(1), is(6));
    if (d != null)
      azzert.that(d.get(2), is(6));
  }
}
