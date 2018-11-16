package il.org.spartan.utils;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class ReduceStringConcatenateTest {
  
  @Test public void testReduce0() {
    azzert.that((new ReduceStringConcatenate()).reduce(), is(""));
  }
  
  @Test public void testReduce1() {
    azzert.that((new ReduceStringConcatenate()).reduce("abc"), is("abc"));
    azzert.that((new ReduceStringConcatenate()).reduce((String[])null), is(""));
  }
  
  @Test public void testReduce2() {
    azzert.that((new ReduceStringConcatenate()).reduce("abc", "def"), is("abcdef"));
  }
  
  @Test public void testReduceN() {
    azzert.that((new ReduceStringConcatenate()).reduce("abc", "def", "ghi"), is("abcdefghi"));
  }
  

}
