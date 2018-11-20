package fluent.ly;

import static il.org.spartan.Utils.*;

import java.util.*;

import org.hamcrest.*;
import org.hamcrest.core.*;
import org.hamcrest.number.*;
import org.jetbrains.annotations.*;
import org.junit.*;

import il.org.spartan.utils.*;

/** Extends {@link org.junit.Assert} with more assertion for equality
 * comparisons. If the comparison yields a "not-equal" result, a JUnit assertion
 * failure is issued.
 * @author Itay Maman Jul 9, 2007
 * @author Yossi Gil revised 2015-07-18 */
@SuppressWarnings("null") //
public class azzert extends org.junit.Assert {
  public static <T> Matcher<T> allOf(final java.lang.Iterable<Matcher<? super T>> ¢) {
    return AllOf.allOf(¢);
  }

  @SafeVarargs public static <T> Matcher<T> allOf(final Matcher<? super T>... ¢) {
    return AllOf.allOf(¢);
  }

  public static <T> Matcher<T> allOf(final Matcher<? super T> first, final Matcher<? super T> second) {
    return AllOf.allOf(first, second);
  }

  public static <T> Matcher<T> allOf(final Matcher<? super T> first, final Matcher<? super T> second, final Matcher<? super T> third) {
    return AllOf.allOf(first, second, third);
  }

  public static <T> Matcher<T> allOf(final Matcher<? super T> first, final Matcher<? super T> second, final Matcher<? super T> third,
      final Matcher<? super T> fourth, final Matcher<? super T> fifth) {
    return AllOf.allOf(first, second, third, fourth, fifth);
  }

  public static <T> Matcher<T> allOf(final Matcher<? super T> first, final Matcher<? super T> second, final Matcher<? super T> third,
      final Matcher<? super T> fourth, final Matcher<? super T> fifth, final Matcher<? super T> sixth) {
    return AllOf.allOf(first, second, third, fourth, fifth, sixth);
  }

  public static <T> Matcher<T> any(final java.lang.Class<T> type) {
    return IsInstanceOf.any(type);
  }

  public static <T> @Nullable AnyOf<T> anyOf(final java.lang.Iterable<Matcher<? super T>> ¢) {
    return AnyOf.anyOf(¢);
  }

  @SafeVarargs public static <T> @Nullable AnyOf<T> anyOf(final Matcher<? super T>... ¢) {
    return AnyOf.anyOf(¢);
  }

  public static <T> @Nullable AnyOf<T> anyOf(final Matcher<T> first, final Matcher<? super T> second) {
    return AnyOf.anyOf(first, second);
  }

  public static <T> @Nullable AnyOf<T> anyOf(final Matcher<T> first, final Matcher<? super T> second, final Matcher<? super T> third) {
    return AnyOf.anyOf(first, second, third);
  }

  public static <T> @Nullable AnyOf<T> anyOf(final Matcher<T> first, final Matcher<? super T> second, final Matcher<? super T> third,
      final Matcher<? super T> fourth) {
    return AnyOf.anyOf(first, second, third, fourth);
  }

  public static <T> @Nullable AnyOf<@Nullable T> anyOf(final Matcher<T> first, final Matcher<? super T> second, final Matcher<? super T> third,
      final Matcher<? super T> fourth, final Matcher<? super T> fifth) {
    return AnyOf.anyOf(first, second, third, fourth, fifth);
  }

  public static <T> @Nullable AnyOf<T> anyOf(final Matcher<T> first, final Matcher<? super T> second, final Matcher<? super T> third,
      final Matcher<? super T> fourth, final Matcher<? super T> fifth, final Matcher<? super T> sixth) {
    return AnyOf.anyOf(first, second, third, fourth, fifth, sixth);
  }

  public static Matcher<@Nullable Object> anything() {
    return IsAnything.anything();
  }

  public static Matcher<@Nullable Object> anything(final @Nullable String description) {
    return IsAnything.anything(description);
  }

  public static <T> void assertCollectionsEqual(final @NotNull Collection<T> c1, final @NotNull Collection<T> c2) {
    assertCollectionsEqual("", c1, c2);
  }

  public static <T> void assertCollectionsEqual(final @NotNull Collection<T> ts1, final T[] ts2) {
    assertCollectionsEqual("", ts1, Arrays.asList(ts2));
  }

  public static <T> void assertCollectionsEqual(final @NotNull String s, final @NotNull Collection<T> c1, final @NotNull Collection<T> c2) {
    assertContained(s, c1, c2);
    assertContained(s, c2, c1);
  }

  public static <T> void assertCollectionsEqual(final @NotNull String s, final @NotNull Collection<T> ts1, final T[] ts2) {
    assertCollectionsEqual(s, ts1, Arrays.asList(ts2));
  }

  public static <T> void assertCollectionsEqual(final @NotNull String s, final T[] ts1, final @NotNull Collection<T> ts2) {
    assertCollectionsEqual(s, ts2, ts1);
  }

  public static <T> void assertContained(final @NotNull String s, final @NotNull Collection<T> c1, final @NotNull Collection<T> c2) {
    // assertLE(s, c1.size(), c2.size());
    final @NotNull ArrayList<T> missing = new ArrayList<>();
    for (final T ¢ : c1)
      if (!c2.contains(¢))
        missing.add(¢);
    switch (missing.size()) {
      case 0:
        return;
      case 1:
        fail(s + "Element '" + missing.get(0) + "' not found in " + c2.size() + " sized-\n collection " + c2);
        break;
      default:
        fail(s + "Element '" + missing.get(0) + "' and '" + missing.get(1) + "'  as well as " + (missing.size() - 2)
            + " other \n elements were not found in " + c2.size() + " sized-\n collection " + c2);
        break;
    }
  }

  public static <T> void assertContains(final @NotNull Collection<T> ts, final T t) {
    assertContains("", ts, t);
  }

  public static <T> void assertContains(final @NotNull String s, final @NotNull Collection<T> ts, final T t) {
    assert ts.contains(t) : s + " t = " + t;
  }

  public static void assertEquals(final boolean a, final boolean b) {
    assertEquals(box.it(a), box.it(b));
  }

  public static void assertEquals(final boolean b1, final Boolean b2) {
    assertEquals(box.it(b1), b2);
  }

  public static void assertEquals(final Boolean b1, final boolean b2) {
    assertEquals(b1, box.it(b2));
  }

  public static void assertEquals(final int expected, final int actual) {
    assertEquals(fluent.ly.box.it(expected), fluent.ly.box.it(actual));
  }

  public static void assertEquals(final int a, final Integer b) {
    assertEquals(box.it(a), b);
  }

  public static void assertEquals(final Integer a, final int b) {
    assertEquals(a, box.it(b));
  }

  public static void assertEquals(final @NotNull String message, final boolean b1, final boolean b2) {
    assertEquals(message, box.it(b1), box.it(b2));
  }

  public static void assertEquals(final @NotNull String message, final boolean b1, final Boolean b2) {
    assertEquals(message, box.it(b1), b2);
  }

  public static void assertEquals(final @NotNull String message, final Boolean b1, final boolean b2) {
    assertEquals(message, b1, box.it(b2));
  }

  public static void assertEquals(final @NotNull String reason, final int i1, final int i2) {
    assertThat(reason, fluent.ly.box.it(i1), CoreMatchers.equalTo(fluent.ly.box.it(i2)));
  }

  public static void assertEquals(final @NotNull String message, final int a, final Integer b) {
    assertEquals(message, box.it(a), b);
  }

  public static void assertEquals(final @NotNull String message, final Integer a, final int b) {
    assertEquals(message, a, box.it(b));
  }

  public static void assertFalse(final boolean ¢) {
    that("", box.it(¢), is(Boolean.FALSE));
  }

  public static void assertFalse(final @NotNull String s, final boolean b) {
    that(s, b, is(Boolean.FALSE));
  }

  public static void assertLE(final @NotNull String s, final int i, final int m) {
    assert i <= m : s + " n=" + i + " m=" + m;
  }

  public static <T> void assertNotContains(final @NotNull Collection<T> ts, final T t) {
    assertNotContains("", ts, t);
  }

  public static <T> void assertNotContains(final @NotNull String s, final @NotNull Collection<T> ts, final T t) {
    assert !ts.contains(t) : s + " t = " + t;
  }

  public static void assertNotEquals(final Object o1, final @Nullable Object o2) {
    assertThat("", o1, CoreMatchers.not(o2));
  }

  public static void assertNotEquals(final @NotNull String message, final @NotNull Object o1, final Object o2) {
    assert !o1.equals(o2);
  }

  public static void assertNotEquals(final @NotNull String s1, final @NotNull String s2) {
    assertNotEquals("", s1, s2);
  }

  public static void assertNotEquals(final @NotNull String message, final @NotNull String s1, final @NotNull String s2) {
    assert !s1.equals(s2) : message;
  }

  public static void assertNull(final @Nullable Object ¢) {
    assert ¢ == null;
  }

  public static void assertNull(final @NotNull String message, final Object o) {
    assertEquals(message, null, o);
  }

  public static void assertPositive(final int ¢) {
    assert ¢ > 0 : "Expecting a positive value, but got " + ¢;
  }

  public static <T> void assertSubset(final @NotNull Collection<T> c1, final @NotNull Collection<T> c2) {
    assertContained("", c1, c2);
  }

  public static void assertTrue(final boolean ¢) {
    that("", box.it(¢), is(Boolean.TRUE));
  }

  public static void assertTrue(final @NotNull String s, final boolean b) {
    that(s, box.it(b), is(Boolean.TRUE));
  }

  public static void assertZero(final int ¢) {
    assertEquals("Expecting a zero", ¢, 0);
  }

  @NotNull public static Asserter aye(final boolean claim) {
    return aye("", claim);
  }

  @NotNull public static Asserter aye(final @NotNull String reason, final boolean claim) {
    return new Asserter().andAye(reason, claim);
  }

  public static <LHS> CombinableMatcher.@Nullable CombinableBothMatcher<LHS> both(final Matcher<? super LHS> ¢) {
    return CombinableMatcher.both(¢);
  }

  @Factory public static Matcher<@Nullable Boolean> comparesEqualTo(final boolean ¢) {
    return OrderingComparison.comparesEqualTo(box.it(¢));
  }

  @Factory public static Matcher<@Nullable Byte> comparesEqualTo(final byte ¢) {
    return OrderingComparison.comparesEqualTo(box.it(¢));
  }

  @Factory public static Matcher<@Nullable Character> comparesEqualTo(final char ¢) {
    return OrderingComparison.comparesEqualTo(box.it(¢));
  }

  @Factory public static Matcher<@Nullable Double> comparesEqualTo(final double ¢) {
    return OrderingComparison.comparesEqualTo(box.it(¢));
  }

  @Factory public static Matcher<@Nullable Float> comparesEqualTo(final float ¢) {
    return OrderingComparison.comparesEqualTo(box.it(¢));
  }

  @Factory public static Matcher<@Nullable Integer> comparesEqualTo(final int ¢) {
    return OrderingComparison.comparesEqualTo(box.it(¢));
  }

  @Factory public static Matcher<@Nullable Long> comparesEqualTo(final long ¢) {
    return OrderingComparison.comparesEqualTo(box.it(¢));
  }

  @Factory public static Matcher<@Nullable Short> comparesEqualTo(final short ¢) {
    return OrderingComparison.comparesEqualTo(box.it(¢));
  }

  public static Matcher<@Nullable String> containsString(final @NotNull String substring) {
    return StringContains.containsString(substring);
  }

  public static <T> Matcher<T> describedAs(final @NotNull String description, final Matcher<T> m, final Object... values) {
    return DescribedAs.describedAs(description, m, values);
  }

  public static <LHS> CombinableMatcher.@Nullable CombinableEitherMatcher<LHS> either(final Matcher<? super LHS> ¢) {
    return CombinableMatcher.either(¢);
  }

  public static Matcher<String> endsWith(final @NotNull String suffix) {
    return StringEndsWith.endsWith(suffix);
  }

  public static <T> void equals(final @NotNull String prefix, final @NotNull Collection<T> set, final @NotNull Collection<T> ts) {
    @NotNull Set<T> temp = new HashSet<>();
    temp.addAll(set);
    temp.removeAll(ts);
    assert temp.isEmpty() : temp;
    temp = new HashSet<>();
    temp.addAll(ts);
    temp.removeAll(set);
    assert temp.isEmpty() : prefix + " - " + temp;
  }

  public static <T> Matcher<T> equalTo(final T operand) {
    return IsEqual.equalTo(operand);
  }

  public static Matcher<String> equalToIgnoringCase(final @NotNull String expectedString) {
    return org.hamcrest.Matchers.equalToIgnoringCase(expectedString);
  }

  public static Matcher<String> equalToIgnoringWhiteSpace(final @NotNull String expectedString) {
    return org.hamcrest.Matchers.equalToIgnoringWhiteSpace(expectedString);
  }

  public static <U> Matcher<java.lang.Iterable<U>> everyItem(final Matcher<U> itemMatcher) {
    return Every.everyItem(itemMatcher);
  }

  public static void fail() {
    Assert.fail();
  }

  public static void fail(final @NotNull String ¢) {
    Assert.fail(¢);
  }

  public static void falze(final boolean ¢) {
    assert !¢;
  }

  @Factory public static Matcher<@Nullable Boolean> greaterThan(final boolean ¢) {
    return OrderingComparison.greaterThan(box.it(¢));
  }

  @Factory public static Matcher<@Nullable Byte> greaterThan(final byte ¢) {
    return OrderingComparison.greaterThan(box.it(¢));
  }

  @Factory public static Matcher<@Nullable Character> greaterThan(final char ¢) {
    return OrderingComparison.greaterThan(box.it(¢));
  }

  @Factory public static Matcher<@Nullable Double> greaterThan(final double ¢) {
    return OrderingComparison.greaterThan(box.it(¢));
  }

  @Factory @NotNull public static Matcher<@Nullable Float> greaterThan(final float ¢) {
    return OrderingComparison.greaterThan(box.it(¢));
  }

  @Factory @NotNull public static Matcher<@Nullable Integer> greaterThan(final int ¢) {
    return OrderingComparison.greaterThan(box.it(¢));
  }

  @Factory @NotNull public static Matcher<@Nullable Long> greaterThan(final long ¢) {
    return OrderingComparison.greaterThan(box.it(¢));
  }

  @Factory @NotNull public static Matcher<@Nullable Short> greaterThan(final short ¢) {
    return OrderingComparison.greaterThan(box.it(¢));
  }

  @Factory @NotNull public static Matcher<@Nullable Boolean> greaterThanOrEqualTo(final boolean ¢) {
    return OrderingComparison.greaterThanOrEqualTo(box.it(¢));
  }

  @Factory @NotNull public static Matcher<@Nullable Byte> greaterThanOrEqualTo(final byte ¢) {
    return OrderingComparison.greaterThanOrEqualTo(box.it(¢));
  }

  @Factory @NotNull public static Matcher<@Nullable Character> greaterThanOrEqualTo(final char ¢) {
    return OrderingComparison.greaterThanOrEqualTo(box.it(¢));
  }

  @Factory @NotNull public static Matcher<@Nullable Double> greaterThanOrEqualTo(final double ¢) {
    return OrderingComparison.greaterThanOrEqualTo(box.it(¢));
  }

  @Factory @NotNull public static Matcher<@Nullable Float> greaterThanOrEqualTo(final float ¢) {
    return OrderingComparison.greaterThanOrEqualTo(box.it(¢));
  }

  @Factory @NotNull public static Matcher<@Nullable Integer> greaterThanOrEqualTo(final int ¢) {
    return OrderingComparison.greaterThanOrEqualTo(box.it(¢));
  }

  @Factory @NotNull public static Matcher<@Nullable Long> greaterThanOrEqualTo(final long ¢) {
    return OrderingComparison.greaterThanOrEqualTo(box.it(¢));
  }

  @Factory @NotNull public static Matcher<@Nullable Short> greaterThanOrEqualTo(final short ¢) {
    return OrderingComparison.greaterThanOrEqualTo(box.it(¢));
  }

  @NotNull public static <T> Matcher<java.lang.Iterable<? super @Nullable T>> hasItem(final Matcher<? super @Nullable T> itemMatcher) {
    return IsCollectionContaining.hasItem(itemMatcher);
  }

  @NotNull public static <T> Matcher<java.lang.Iterable<? super @Nullable T>> hasItem(final T item) {
    return IsCollectionContaining.hasItem(item);
  }

  @SafeVarargs @NotNull public static <T> Matcher<java.lang.Iterable<T>> hasItems(final Matcher<? super T>... itemMatchers) {
    return IsCollectionContaining.hasItems(itemMatchers);
  }

  @SafeVarargs @NotNull public static <T> Matcher<java.lang.Iterable<T>> hasItems(final T... items) {
    return IsCollectionContaining.hasItems(items);
  }

  @NotNull public static <T> Matcher<T> instanceOf(final java.lang.Class<?> type) {
    return IsInstanceOf.instanceOf(type);
  }

  @NotNull public static Matcher<@Nullable Boolean> is(final boolean ¢) {
    return is(box.it(¢));
  }

  @NotNull public static Matcher<@Nullable Byte> is(final byte ¢) {
    return is(box.it(¢));
  }

  @NotNull public static Matcher<@Nullable Character> is(final char ¢) {
    return is(box.it(¢));
  }

  @NotNull public static Matcher<@Nullable Double> is(final double ¢) {
    return is(box.it(¢));
  }

  @NotNull public static Matcher<@Nullable Float> is(final float ¢) {
    return is(box.it(¢));
  }

  @NotNull public static Matcher<@Nullable Integer> is(final int ¢) {
    return is(box.it(¢));
  }

  @NotNull public static Matcher<@Nullable Long> is(final long ¢) {
    return is(box.it(¢));
  }

  @Contract(pure = true) @NotNull public static <T> Matcher<T> is(final @Nullable Matcher<@Nullable T> ¢) {
    return Is.is(¢);
  }

  @NotNull public static Matcher<@Nullable Short> is(final short ¢) {
    return is(box.it(¢));
  }

  @Contract(pure = true) public static <@Nullable T> @NotNull Matcher<T> is(final @Nullable T value) {
    return Is.is(value);
  }

  @NotNull public static <T> Matcher<T> isA(final java.lang.Class<T> type) {
    return Is.isA(type);
  }

  public static void isNull(final @Nullable Object ¢) {
    assertThat("", ¢, nullValue());
  }

  /** @param message what to print
   * @param o       what to examine */
  @Contract("_, !null -> fail") public static void isNull(final @NotNull String message, final @Nullable Object o) {
    azzert.assertNull(message, o);
  }

  @NotNull public static Outer<String> iz(final @NotNull String ¢) {
    return new Outer<>(¢);
  }

  @Factory @NotNull public static Matcher<@Nullable Boolean> lessThan(final boolean ¢) {
    return OrderingComparison.lessThan(box.it(¢));
  }

  @Factory @NotNull public static Matcher<@Nullable Byte> lessThan(final byte ¢) {
    return OrderingComparison.lessThan(box.it(¢));
  }

  @Factory @NotNull public static Matcher<@Nullable Character> lessThan(final char ¢) {
    return OrderingComparison.lessThan(box.it(¢));
  }

  @Factory @NotNull public static Matcher<@Nullable Double> lessThan(final double ¢) {
    return OrderingComparison.lessThan(box.it(¢));
  }

  @Factory @NotNull public static Matcher<@Nullable Float> lessThan(final float ¢) {
    return OrderingComparison.lessThan(box.it(¢));
  }

  @Factory @NotNull public static Matcher<@Nullable Integer> lessThan(final int ¢) {
    return OrderingComparison.lessThan(box.it(¢));
  }

  @Factory @NotNull public static Matcher<@Nullable Long> lessThan(final long ¢) {
    return OrderingComparison.lessThan(box.it(¢));
  }

  @Factory @NotNull public static Matcher<@Nullable Short> lessThan(final short ¢) {
    return OrderingComparison.lessThan(box.it(¢));
  }

  @Factory @NotNull public static Matcher<@Nullable Boolean> lessThanOrEqualTo(final boolean ¢) {
    return OrderingComparison.lessThanOrEqualTo(box.it(¢));
  }

  @Factory @NotNull public static Matcher<@Nullable Byte> lessThanOrEqualTo(final byte ¢) {
    return OrderingComparison.lessThanOrEqualTo(box.it(¢));
  }

  @Factory @NotNull public static Matcher<@Nullable Character> lessThanOrEqualTo(final char ¢) {
    return OrderingComparison.lessThanOrEqualTo(box.it(¢));
  }

  @Factory @NotNull public static Matcher<@Nullable Double> lessThanOrEqualTo(final double ¢) {
    return OrderingComparison.lessThanOrEqualTo(box.it(¢));
  }

  @Factory @NotNull public static Matcher<@Nullable Float> lessThanOrEqualTo(final float ¢) {
    return OrderingComparison.lessThanOrEqualTo(box.it(¢));
  }

  @Factory @NotNull public static Matcher<@Nullable Integer> lessThanOrEqualTo(final int ¢) {
    return OrderingComparison.lessThanOrEqualTo(box.it(¢));
  }

  @Factory @NotNull public static Matcher<@Nullable Long> lessThanOrEqualTo(final long ¢) {
    return OrderingComparison.lessThanOrEqualTo(box.it(¢));
  }

  @Factory @NotNull public static Matcher<@Nullable Short> lessThanOrEqualTo(final short ¢) {
    return OrderingComparison.lessThanOrEqualTo(box.it(¢));
  }

  @NotNull public static Asserter nay(final boolean claim) {
    return nay("", claim);
  }

  @NotNull public static Asserter nay(final @NotNull String reason, final boolean claim) {
    return new Asserter().andNay(reason, claim);
  }

  public static void nonNulls(final @NotNull @Nullable Iterable<@Nullable Object> os) {
    assert os != null;
    assert os != null;
    for (final @Nullable Object ¢ : os)
      assert ¢ != null : os + "";
  }

  @NotNull public static Matcher<Boolean> not(final boolean ¢) {
    return cantBeNull(IsNot.not(box.it(¢)));
  }

  @NotNull public static Matcher<Byte> not(final byte ¢) {
    return cantBeNull(IsNot.not(box.it(¢)));
  }

  @NotNull public static Matcher<Character> not(final char i) {
    return cantBeNull(IsNot.not(box.it(i)));
  }

  @NotNull public static Matcher<Double> not(final double ¢) {
    return cantBeNull(IsNot.not(box.it(¢)));
  }

  @NotNull public static Matcher<Float> not(final float ¢) {
    return cantBeNull(IsNot.not(box.it(¢)));
  }

  @NotNull public static Matcher<Integer> not(final int ¢) {
    return cantBeNull(IsNot.not(box.it(¢)));
  }

  @NotNull public static Matcher<Long> not(final long i) {
    return cantBeNull(IsNot.not(box.it(i)));
  }

  @Contract(pure = true) @NotNull public static <T> Matcher<T> not(final Matcher<T> ¢) {
    return IsNot.not(¢);
  }

  @NotNull public static Matcher<Short> not(final short ¢) {
    return cantBeNull(IsNot.not(box.it(¢)));
  }

  @Contract(pure = true) @NotNull public static <T> Matcher<T> not(final T value) {
    return IsNot.not(value);
  }

  public static void notNull(final @Nullable Object ¢) {
    assertThat("", ¢, notNullValue());
  }

  public static void notNull(final @NotNull String s, final @Nullable Object o) {
    assertThat(s, o, notNullValue());
  }

  @Contract(pure = true) @NotNull public static Matcher<@Nullable Object> notNullValue() {
    return IsNull.notNullValue();
  }

  @Contract(pure = true) @NotNull public static <T> Matcher<T> notNullValue(final java.lang.Class<T> type) {
    return IsNull.notNullValue(type);
  }

  public static void notNullz(final @NotNull @Nullable Object @Nullable... os) {
    assert os != null;
    assert os != null;
    for (final @Nullable Object ¢ : os)
      assert ¢ != null : Arrays.toString(os) + "";
  }

  @Contract(pure = true) @NotNull public static Matcher<@Nullable Object> nullValue() {
    return IsNull.nullValue();
  }

  @Contract(pure = true) @NotNull public static <T> Matcher<T> nullValue(final java.lang.Class<T> type) {
    return IsNull.nullValue(type);
  }

  public static void positive(final int ¢) {
    azzert.that(¢, greaterThan(0));
  }

  @Contract(pure = true) @NotNull public static <T> Matcher<T> sameInstance(final T target) {
    return IsSame.sameInstance(target);
  }

  @NotNull public static Matcher<String> startsWith(final @NotNull String prefix) {
    return StringStartsWith.startsWith(prefix);
  }

  public static void that(final boolean b, final @NotNull Matcher<? super @Nullable Boolean> m) {
    assertThat("", box.it(b), m);
  }

  public static void that(final byte b, final @NotNull Matcher<? super @Nullable Byte> m) {
    assertThat("", box.it(b), m);
  }

  public static void that(final char c, final @NotNull Matcher<? super @Nullable Character> m) {
    assertThat("", box.it(c), m);
  }

  public static void that(final double d, final @NotNull Matcher<? super @Nullable Double> m) {
    assertThat("", box.it(d), m);
  }

  public static void that(final float f, final @NotNull Matcher<? super @Nullable Float> m) {
    assertThat("", box.it(f), m);
  }

  public static void that(final int i, final @NotNull Matcher<? super @Nullable Integer> m) {
    assertThat("", box.it(i), m);
  }

  public static void that(final long l, final @NotNull Matcher<? super @Nullable Long> m) {
    assertThat("", box.it(l), m);
  }

  public static void that(final Object actual, final @NotNull Outer<@Nullable String> expected) {
    assertThat("", compressSpaces(actual + ""), is(compressSpaces(expected.get())));
  }

  public static void that(final short s, final @NotNull Matcher<? super @Nullable Short> m) {
    assertThat("", box.it(s), m);
  }

  public static void that(final @NotNull String reason, final boolean b, final @NotNull Matcher<? super Boolean> m) {
    assertThat(reason, box.it(b), m);
  }

  public static void that(final @NotNull String reason, final byte b, final @NotNull Matcher<? super @Nullable Byte> m) {
    assertThat(reason, box.it(b), m);
  }

  public static void that(final @NotNull String reason, final char c, final @NotNull Matcher<? super Character> m) {
    assertThat(reason, box.it(c), m);
  }

  public static void that(final @NotNull String reason, final double d, final @NotNull Matcher<? super @Nullable Double> m) {
    assertThat(reason, box.it(d), m);
  }

  public static void that(final @NotNull String reason, final float f, final @NotNull Matcher<? super Float> m) {
    assertThat(reason, box.it(f), m);
  }

  public static void that(final @NotNull String reason, final int i, final @NotNull Matcher<? super Integer> m) {
    assertThat(reason, box.it(i), m);
  }

  public static void that(final @NotNull String reason, final long l, final @NotNull Matcher<? super @Nullable Long> m) {
    assertThat(reason, box.it(l), m);
  }

  public static void that(final @NotNull String reason, final short s, final @NotNull Matcher<? super Short> m) {
    assertThat(reason, box.it(s), m);
  }

  public static <@Nullable T> void that(final @NotNull String reason, final @Nullable T actual, final @NotNull Matcher<? super @Nullable T> t) {
    assertThat(reason, actual, t);
  }

  public static <@Nullable T> void that(final @Nullable T actual, final @NotNull Matcher<? super @Nullable T> t) {
    assertThat("", actual, t);
  }

  @Contract(pure = true) @NotNull public static <T> Matcher<T> theInstance(final T target) {
    return IsSame.theInstance(target);
  }

  public static void xassertEquals(final int a, final int b) {
    assertEquals("", a, b);
  }

  public static void xassertEquals(final @NotNull String s, final int a, final int b) {
    assertEquals(s, box.it(a), box.it(b));
  }

  /** Assert that an integer is zero
   * @param ¢ JD */
  public static void zero(final int ¢) {
    assertEquals(0, ¢);
  }

  /** Assert that long is zero
   * @param ¢ JD */
  public static void zero(final long ¢) {
    assertEquals(0L, ¢);
  }

  public static class ____META {
    //
  }

  public static class Asserter {
    @NotNull public Asserter andAye(final boolean claim) {
      return andAye("", claim);
    }

    @NotNull public Asserter andAye(final @NotNull String reason, final boolean claim) {
      azzert.that(reason, claim, is(true));
      return this;
    }

    @NotNull public Asserter andNay(final boolean claim) {
      return andNay("", claim);
    }

    @NotNull public Asserter andNay(final @NotNull String reason, final boolean claim) {
      azzert.that(reason, claim, is(false));
      return this;
    }
  }
}
