package il.org.spartan.utils;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class ReduceStringConcatenateTest {
  @Test public void testReduce0() {
    azzert.that(new ReduceStringConcatenate().reduce(), is(""));
  }

  @Test public void testReduce1() {
    azzert.that(new ReduceStringConcatenate().reduce("abc"), is("abc"));
    azzert.that(new ReduceStringConcatenate().reduce("123"), is("123"));
    azzert.that(new ReduceStringConcatenate().reduce(""), is(""));
    azzert.that(new ReduceStringConcatenate().reduce("-1"), is("-1"));
    azzert.that(new ReduceStringConcatenate().reduce((String[]) null), is(""));
  }

  @Test public void testReduce2() {
    azzert.that(new ReduceStringConcatenate().reduce("abc", "def"), is("abcdef"));
    azzert.that(new ReduceStringConcatenate().reduce("123", "def"), is("123def"));
    azzert.that(new ReduceStringConcatenate().reduce("abc", ""), is("abc"));
    azzert.that(new ReduceStringConcatenate().reduce("", "abc"), is("abc"));
    azzert.that(new ReduceStringConcatenate().reduce("", ""), is(""));
  }

  @Test public void testReduceN() {
    azzert.that(new ReduceStringConcatenate().reduce("abc", "def", "ghi"), is("abcdefghi"));
    azzert.that(new ReduceStringConcatenate().reduce("", "def", "ghi"), is("defghi"));
    azzert.that(new ReduceStringConcatenate().reduce("abc", "", "ghi"), is("abcghi"));
    azzert.that(new ReduceStringConcatenate().reduce("abc", "def", ""), is("abcdef"));
    azzert.that(new ReduceStringConcatenate().reduce("", "", "ghi"), is("ghi"));
    azzert.that(new ReduceStringConcatenate().reduce("", "def", ""), is("def"));
    azzert.that(new ReduceStringConcatenate().reduce("abc", "", ""), is("abc"));
    azzert.that(new ReduceStringConcatenate().reduce("", "", ""), is(""));
    azzert.that(new ReduceStringConcatenate().reduce("1", "2", "3", "4", "5", "6"), is("123456"));
  }
}
