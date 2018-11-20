package fluent.ly;

import static fluent.ly.azzert.*;

import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import static il.org.spartan.Utils.*;

@SuppressWarnings("static-method") public class TheTest {
  final List<@Nullable Integer> l = new ArrayList<>();

  @Before public void setUp() {
    l.add(cantBeNull(Integer.valueOf(1)));
    l.add(cantBeNull(Integer.valueOf(2)));
    l.add(cantBeNull(Integer.valueOf(3)));
    l.add(cantBeNull(Integer.valueOf(4)));
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

  @Test public void previousOfFound() {
    azzert.that(the.previous(cantBeNull(Integer.valueOf(4)), l), is(Integer.valueOf(3)));
  }

  @Test public void previousOfNull() {
    isNull(the.previous(null, null));
  }

  @Test public void previousOfFirst() {
    isNull(the.previous(Integer.valueOf(1), l));
  }

  @Test public void previousOfNotFound() {
    isNull(the.previous(Integer.valueOf(0), l));
  }

  @Test public void tailOfList() {
    final List<@NotNull Integer> l2 = new ArrayList<>();
    l2.add(cantBeNull(Integer.valueOf(2)));
    l2.add(cantBeNull(Integer.valueOf(3)));
    l2.add(cantBeNull(Integer.valueOf(4)));
    final List<Integer> res = the.tailOf(l);
    azzert.that(res.size(), is(l2.size()));
    for (int ¢ = 0; ¢ < l2.size(); ++¢)
      azzert.that(res.get(¢), is(l2.get(¢)));
  }

  @Test public void restOfList() {
    final List<@NotNull Integer> l2 = new ArrayList<>();
    l2.add(cantBeNull(Integer.valueOf(2)));
    l2.add(cantBeNull(Integer.valueOf(3)));
    l2.add(cantBeNull(Integer.valueOf(4)));
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

  @Test public void secondOfList2() {
    @Nullable final List<@Nullable Integer> l1 = new ArrayList<>();
    l1.add(Integer.valueOf(4));
    azzert.isNull(the.secondOf(l1));
  }

  @Test public void secondOfnullList() {
    @Nullable List<@Nullable Integer> l1 = new ArrayList<>();
    l1.add(Integer.valueOf(1));
    l1 = null;
    isNull(the.secondOf(l1));
  }

  @Test public void tailOf() {
    azzert.that(the.tailOf(new String[] { "a", "b", "c" }), is(new String[] { "b", "c" }));
  }

  @Test public void sqr1() {
    azzert.that(the.sqr(1), is(1));
  }

  @Test public void sqr2() {
    azzert.that(the.sqr(0), is(0));
  }

  @Test public void sqr3() {
    azzert.that(the.sqr(-1), is(1));
  }

  @Test public void headOfNullList() {
    azzert.isNull(the.headOf(null));
  }

  @Test public void headOfEmptyList() {
    azzert.isNull(the.headOf(new ArrayList<String>()));
  }

  @Test public void last1() {
    @Nullable final List<@Nullable Integer> l1 = new ArrayList<>();
    l1.add(Integer.valueOf(1));
    azzert.that(the.last(l1), is(Integer.valueOf(1)));
  }

  @Test public void last2() {
    azzert.isNull(the.last(null));
  }

  @Test public void last3() {
    azzert.isNull(the.last(new ArrayList<>()));
  }

  @Test @SuppressWarnings("null") public void lastOf() {
    azzert.that(the.lastOf(new String[] { "a", "b", "c" }), is("c"));
  }

  @Test public void onlyOneOf1() {
    azzert.isNull(the.onlyOneOf(null));
  }

  @Test public void onlyOneOf2() {
    @Nullable final List<@Nullable Integer> l1 = new ArrayList<>();
    l1.add(Integer.valueOf(1));
    azzert.that(the.onlyOneOf(l1), is(Integer.valueOf(1)));
  }

  @Test public void onlyOneOf3() {
    @Nullable final List<@Nullable Integer> l1 = new ArrayList<>();
    l1.add(Integer.valueOf(1));
    l1.add(Integer.valueOf(1));
    azzert.isNull(the.onlyOneOf(l1));
  }

  @Test public void lastOfString() {
    azzert.that(the.lastOf("123"), is('3'));
  }

  @Test public void lastOfSet() {
    azzert.notNull(the.lastOf(new HashSet<>()));
  }

  @Test public void lastOfSetIterator() {
    final Set<String> i = new HashSet<>();
    i.add("a");
    i.add("a");
    azzert.nay(the.lastOf(i).iterator().hasNext());
  }
}