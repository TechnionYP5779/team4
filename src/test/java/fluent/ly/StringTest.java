package fluent.ly;

import static fluent.ly.azzert.*;

import java.io.*;
import java.util.*;

import org.junit.*;

@SuppressWarnings("static-method") public class StringTest {
  @Test public void atod() {
    azzert.that(string.atod("2.4"), is(2.4));
    azzert.that(string.atod("0.0"), is(0.0));
    azzert.that(string.atod("-1.1"), is(-1.1));
  }

  @Test public void atof() {
    azzert.that(string.atof("2.4"), is(2.4F));
    azzert.that(string.atof("2.0"), is(2.0F));
    azzert.that(string.atof("0.0"), is(0.0F));
  }

  @Test public void atoi() {
    azzert.that(string.atoi("24"), is(24));
    azzert.that(string.atoi("0"), is(0));
    azzert.that(string.atoi("-1"), is(-1));
  }

  @Test public void atol() {
    azzert.that(string.atol("222"), is(222L));
    azzert.that(string.atol("0"), is(0L));
    azzert.that(string.atol("-4"), is(-4L));
  }

  @Test public void capitalize0() {
    azzert.that(string.capitalize(""), is(""));
  }

  @Test public void capitalize1() {
    azzert.that(string.capitalize("abc"), is("Abc"));
  }

  @Test public void cat0() {
    azzert.that(string.cat(""), is(""));
  }

  @Test public void cat1() {
    azzert.that(string.cat("abc"), is("abc"));
  }

  @Test public void cat2() {
    azzert.that(string.cat("ab", "cd"), is("abcd"));
  }

  @Test public void delta0() {
    azzert.that(string.delta(1.4, 1.4), is(0.0));
  }

  @Test public void delta1() {
    azzert.that(string.delta(-1.4, 1.4), is(Double.NaN));
  }

  @Test public void delta2() {
    azzert.that(string.delta(1.4, -2.4), is(Double.NaN));
  }

  @Test public void delta3() {
    azzert.that(string.delta(5.0, 3.0), is(0.5));
  }

  @Test public void delta4() {
    azzert.that(string.delta(4.0, 2.0), is(2 / 3.0));
  }

  @Test public void dtoa0() {
    azzert.that(string.dtoa(4.0), is("4.0"));
  }

  @Test public void dtoa1() {
    azzert.that(string.dtoa(0), is("0.0"));
  }

  @Test public void eq0() {
    azzert.aye(string.eq(null, null));
  }

  @Test public void eq1() {
    azzert.nay(string.eq(Integer.valueOf(1), null));
  }

  @Test public void eq2() {
    azzert.nay(string.eq(null, Integer.valueOf(1)));
  }

  @Test public void eq3() {
    azzert.aye(string.eq(Integer.valueOf(1), Integer.valueOf(1)));
  }

  @Test public void eq4() {
    azzert.nay(string.eq(Double.valueOf(1.0), Double.valueOf(4.55)));
  }

  @Test public void escChar0() {
    azzert.that(string.esc('\n'), is("\\n"));
  }

  @Test public void escChar1() {
    azzert.that(string.esc('\r'), is("\\r"));
  }

  @Test public void escChar2() {
    azzert.that(string.esc('\t'), is("\\t"));
  }

  @Test public void escChar3() {
    azzert.that(string.esc('\f'), is("\\f"));
  }

  @Test public void escChar4() {
    azzert.that(string.esc('\b'), is("\\b"));
  }

  @Test public void escChar5() {
    azzert.that(string.esc('\\'), is("\\\\"));
  }

  @Test public void escChar6() {
    azzert.that(string.esc('a'), is("a"));
  }

  @Test public void esc0() {
    azzert.that(string.esc(null), is("(null)"));
  }

  @Test public void esc1() {
    azzert.that(string.esc("abc\n"), is("abc\\n"));
  }

  @Test public void fill0() {
    azzert.that(string.fill(3, 'a'), is("aaa"));
  }

  @Test public void fill1() {
    azzert.that(string.fill(4, "ab"), is("abababab"));
  }

  @Test public void ftoa() {
    azzert.that(string.ftoa(3.14F), is("3.14"));
  }

  @Test public void isDouble0() {
    azzert.aye(string.isDouble("3.14"));
  }

  @Test public void isDouble1() {
    azzert.nay(string.isDouble("abc"));
  }

  @Test public void isInt0() {
    azzert.aye(string.isInt("314"));
  }

  @Test public void isInt1() {
    azzert.nay(string.isInt("abc"));
  }

  @Test public void isFloat0() {
    azzert.aye(string.isFloat("3.14"));
  }

  @Test public void isFloat1() {
    azzert.nay(string.isFloat("abc"));
  }

  @Test public void isLong0() {
    azzert.aye(string.isLong("314"));
  }

  @Test public void isLong1() {
    azzert.nay(string.isLong("abc"));
  }

  @Test public void itoa() {
    azzert.that(string.itoa(314), is("314"));
  }

  @Test public void javaCase0() {
    azzert.that(string.javaCase(""), is(""));
  }

  @Test public void javaCase1() {
    azzert.that(string.javaCase("ABC"), is("aBC"));
  }

  @Test public void last() {
    azzert.that(string.last("abc"), is('c'));
    try {
      string.last("");
      azzert.fail();
    } catch (final Exception ¢) {
      forget.it(¢);
    }
  }

  @Test public void lowCounter0() {
    azzert.that(string.lowCounter(-1), is(""));
  }

  @Test public void lowCounter1() {
    azzert.that(string.lowCounter(0), is("a"));
  }

  @Test public void lowCounter2() {
    azzert.that(string.lowCounter(1), is("b"));
  }

  @Test public void ltoa() {
    azzert.that(string.ltoa(314L), is("314"));
  }

  @Test public void ordinal0() {
    azzert.that(string.ordinal(0), is("0th"));
  }

  @Test public void ordinal1() {
    azzert.that(string.ordinal(1), is("1st"));
  }

  @Test public void ordinal2() {
    azzert.that(string.ordinal(11), is("11th"));
  }

  @Test public void ordinal3() {
    azzert.that(string.ordinal(2), is("2nd"));
  }

  @Test public void ordinal4() {
    azzert.that(string.ordinal(12), is("12th"));
  }

  @Test public void ordinal5() {
    azzert.that(string.ordinal(3), is("3th"));
  }

  @Test public void paren() {
    azzert.that(string.paren("abc"), is("(abc)"));
  }

  @Test public void pluralize0() {
    azzert.that(string.pluralize(0, "chair"), is("no chairs"));
  }

  @Test public void pluralize1() {
    azzert.that(string.pluralize(1, "chair"), is("chair"));
  }

  @Test public void pluralize2() {
    azzert.that(string.pluralize(2, "chair"), is("two chairs"));
  }

  @Test public void pluralize3() {
    azzert.that(string.pluralize(3, "chair"), is("three chairs"));
  }

  @Test public void pluralize4() {
    azzert.that(string.pluralize(4, "chair"), is("four chairs"));
  }

  @Test public void pluralize5() {
    azzert.that(string.pluralize(5, "chair"), is("five chairs"));
  }

  @Test public void pluralize6() {
    azzert.that(string.pluralize(6, "chair"), is("six chairs"));
  }

  @Test public void pluralize7() {
    azzert.that(string.pluralize(7, "chair"), is("seven chairs"));
  }

  @Test public void pluralize8() {
    azzert.that(string.pluralize(8, "chair"), is("eight chairs"));
  }

  @Test public void pluralize9() {
    azzert.that(string.pluralize(9, "chair"), is("nine chairs"));
  }

  @Test public void pluralize10() {
    azzert.that(string.pluralize(10, "chair"), is("10 chairs"));
  }

  @Test public void quote() {
    azzert.that(string.quote("abc"), is("'abc'"));
  }

  @Test public void repeat() {
    azzert.that(string.repeat(3, 'c'), is("ccc"));
  }

  @Test public void signum0() {
    azzert.that(string.signum(0.0), is(0));
  }

  @Test public void signum1() {
    azzert.that(string.signum(5.0), is(1));
  }

  @Test public void signum2() {
    azzert.that(string.signum(-5.0), is(-1));
  }

  @Test public void strip1() {
    azzert.that(string.strip("abc"), is("b"));
  }

  @Test public void strip2() {
    azzert.that(string.strip("bc"), is(""));
  }

  @Test public void toLines() {
    try {
      final List<String> a = string.toLines("ab\ncd");
      azzert.that(a.get(0), is("ab"));
      azzert.that(a.get(1), is("cd"));
    } catch (final IOException ¢) {
      forget.it(¢);
      azzert.fail();
    }
  }

  @Test public void upCounter0() {
    azzert.that(string.upCounter(-1), is(""));
  }

  @Test public void upCounter1() {
    azzert.that(string.upCounter(0), is("A"));
  }

  @Test public void upCounter2() {
    azzert.that(string.upCounter(1), is("B"));
  }

  @Test public void visualize() {
    azzert.that(string.visualize("ab \ncd"), is("abs\\ncd"));
  }

  @Test public void wrap() {
    azzert.that(string.wrap("*", "abc"), is("*abc*"));
  }

  @Test @SuppressWarnings("null") public void cat() {
    azzert.that(string.cat(new String[] { "abc" }, new String[] { "def" }), is("abcdef"));
  }

  @Test public void expandLeadingTabs1() {
    azzert.that(string.expandLeadingTabs("abc"), is("abc"));
  }

  @Test public void expandLeadingTabs2() {
    azzert.that(string.expandLeadingTabs(""), is(""));
  }

  @Test public void expandLeadingTabs3() {
    azzert.that(string.expandLeadingTabs("  a"), is("  a"));
  }

  @Test public void pretty1() {
    azzert.that(string.pretty("a", new HashSet<>()), is(""));
  }

  @Test public void pretty2() {
    final Collection<String> c = new HashSet<>();
    c.add("a");
    azzert.that(string.pretty("a", c), is("1 a: a\n"));
  }

  @Test public void pretty3() {
    final Collection<String> c = new HashSet<>();
    c.add("a");
    c.add("b");
    azzert.that(string.pretty("a", c), is("2 as:\n\t1) a\n\t2) b\n"));
  }

  @Test @SuppressWarnings("null") public void sprintf1() {
    azzert.that(string.sprintf(new String[] { "a", "b" }), is("a"));
  }

  @Test @SuppressWarnings("null") public void sprintf2() {
    azzert.that(string.sprintf(new String[] { "a" }), is("a"));
  }

  @Test @SuppressWarnings("null") public void sprint3() {
    azzert.that(string.sprintf(new String[] {}), is(""));
  }
}
