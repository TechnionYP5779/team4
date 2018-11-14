package fluent.ly;

import static fluent.ly.azzert.*;

import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

@SuppressWarnings("static-method") public class TheTest {
  final List<@NotNull Integer> l = new ArrayList<>();

  @Before @SuppressWarnings("null") public void setUp() {
    l.add(Integer.valueOf(1));
    l.add(Integer.valueOf(2));
    l.add(Integer.valueOf(3));
    l.add(Integer.valueOf(4));
  }

  @Test public void indexFound() {
    azzert.that(the.index(4, 1, 2, 3, 4), is(3));
  }

  @Test public void indexNotFound() {
    azzert.that(the.index(5, 1, 2, 3, 4), is(-1));
  }

  @Test public void nilIsNull() {
    isNull(the.nil());
  }

  @Test public void nthOfCollection() {
    final List<Object> l1 = new ArrayList<>();
    l1.add(new Object());
    l1.add(new Object());
    l1.add(new Object());
    azzert.that(the.nth(2, l1), is(" #2/3"));
  }

  @Test @SuppressWarnings("null") public void previousOfFound() {
    azzert.that(the.previous(Integer.valueOf(4), l), is(Integer.valueOf(3)));
  }

  @Test @SuppressWarnings("null") public void previousOfFirst() {
    isNull(the.previous(Integer.valueOf(1), l));
  }

  @Test @SuppressWarnings("null") public void previousOfNotFound() {
    isNull(the.previous(Integer.valueOf(0), l));
  }

  @Test @SuppressWarnings("null") public void tailOfList() {
    final List<@NotNull Integer> l2 = new ArrayList<>();
    l2.add(Integer.valueOf(2));
    l2.add(Integer.valueOf(3));
    l2.add(Integer.valueOf(4));
    final List<Integer> res = the.tailOf(l);
    azzert.that(res.size(), is(l2.size()));
    for (int ¢ = 0; ¢ < l2.size(); ++¢)
      azzert.that(res.get(¢), is(l2.get(¢)));
  }

  @Test @SuppressWarnings("null") public void restOfList() {
    final List<@NotNull Integer> l2 = new ArrayList<>();
    l2.add(Integer.valueOf(2));
    l2.add(Integer.valueOf(3));
    l2.add(Integer.valueOf(4));
    final List<Integer> res = the.rest(Integer.valueOf(1), l);
    azzert.that(res.size(), is(l2.size()));
    for (int ¢ = 0; ¢ < l2.size(); ++¢)
      azzert.that(res.get(¢), is(l2.get(¢)));
  }

  @Test public void maxOfList() {
    azzert.that(the.max(1, 4, 3, 2), is(4));
  }

  @Test public void minOfList() {
    azzert.that(the.min(1, 4, 3, 2), is(1));
  }

  @Test public void tailOfString() {
    azzert.that(the.tailOf("Hello World"), is("ello World"));
  }

  @Test public void lastCharOfString() {
    azzert.that(the.characterOf("Hello"), is('o'));
  }

  @Test public void secondCharOfString() {
    azzert.that(the.ith("Hello", 1), is('e'));
  }

  @Test public void lastOfNullList() {
    @Nullable List<@Nullable Integer> l1 = new ArrayList<>();
    l1.add(Integer.valueOf(1));
    l1 = null;
    isNull(the.lastOf(l1));
  }

  @Test public void lastOfEmptyList() {
    @Nullable final List<@Nullable Integer> l1 = new ArrayList<>();
    l1.add(Integer.valueOf(1));
    l1.remove(Integer.valueOf(1));
    isNull(the.lastOf(l1));
  }

  @Test public void lastOfNonEmptyList() {
    @Nullable final List<@Nullable Integer> l1 = new ArrayList<>();
    l1.add(Integer.valueOf(4));
    azzert.that(the.lastOf(l1), is(Integer.valueOf(4)));
  }

  @Test public void penultimateOfNullList() {
    @Nullable List<@Nullable Integer> l1 = new ArrayList<>();
    l1.add(Integer.valueOf(1));
    l1 = null;
    isNull(the.penultimateOf(l1));
  }

  @Test public void penultimateOfEmptyList() {
    @Nullable final List<@Nullable Integer> l1 = new ArrayList<>();
    l1.add(Integer.valueOf(1));
    l1.remove(Integer.valueOf(1));
    isNull(the.penultimateOf(l1));
  }

  @Test public void penultimateOfMoreThanTwoList() {
    @Nullable final List<@Nullable Integer> l1 = new ArrayList<>();
    l1.add(Integer.valueOf(4));
    l1.add(Integer.valueOf(3));
    azzert.that(the.penultimateOf(l1), is(Integer.valueOf(4)));
  }

  @Test public void secondOfList() {
    @Nullable final List<@Nullable Integer> l1 = new ArrayList<>();
    l1.add(Integer.valueOf(4));
    l1.add(Integer.valueOf(3));
    azzert.that(the.secondOf(l1), is(Integer.valueOf(3)));
  }

  @Test public void secondOfnullList() {
    @Nullable List<@Nullable Integer> l1 = new ArrayList<>();
    l1.add(Integer.valueOf(1));
    l1 = null;
    isNull(the.secondOf(l1));
  }
}