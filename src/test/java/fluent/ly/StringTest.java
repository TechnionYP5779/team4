package fluent.ly;

import org.junit.*;
import static fluent.ly.azzert.*;
import fluent.ly.forget;

@SuppressWarnings("static-method") public class StringTest {
  
  @Test public void atod() {
    azzert.that(string.atod("2.4"), is(2.4));
  }
  
  @Test public void atof() {
    azzert.that(string.atof("2.4"), is(2.4F));
  }
  
  @Test public void atoi() {
    azzert.that(string.atoi("24"), is(24));
  }
  
  @Test public void atol() {
    azzert.that(string.atol("222"), is(222L));
  }
  
  @Test public void capitalize() {
    azzert.that(string.capitalize(""), is(""));
    azzert.that(string.capitalize("abc"), is("Abc"));
  }
  
  @Test public void cat() {
    azzert.that(string.cat(""), is(""));
    azzert.that(string.cat("abc"), is("abc"));
    azzert.that(string.cat("ab", "cd"), is("abcd"));
  }
  
  @Test public void delta() {
    azzert.that(string.delta(1.4, 1.4), is(0.0));
    azzert.that(string.delta(-1.4, 1.4), is(Double.NaN));
    azzert.that(string.delta(1.4, -2.4), is(Double.NaN));
    azzert.that(string.delta(5.0, 3.0), is(0.5));
    azzert.that(string.delta(4.0, 2.0), is(2/3.0));
  }
  
  @Test public void dtoa() {
    azzert.that(string.dtoa(4.0), is("4.0"));
    azzert.that(string.dtoa(0), is("0.0"));
  }
  
  @Test public void eq() {
    azzert.aye(string.eq(null, null));
    azzert.nay(string.eq(Integer.valueOf(1), null));
    azzert.nay(string.eq(null, Integer.valueOf(1)));

    azzert.aye(string.eq(Integer.valueOf(1), Integer.valueOf(1)));
    azzert.nay(string.eq(Double.valueOf(1.0), Double.valueOf(4.55)));
  }
  
  @Test public void escChar() {
    azzert.that(string.esc('\n'), is("\\n"));
    azzert.that(string.esc('\r'), is("\\r"));
    azzert.that(string.esc('\t'), is("\\t"));
    azzert.that(string.esc('\f'), is("\\f"));
    azzert.that(string.esc('\b'), is("\\b"));
    azzert.that(string.esc('\\'), is("\\\\"));
    azzert.that(string.esc('a'), is("a"));
  }
  
  @Test public void esc() {
    azzert.that(string.esc(null), is("(null)"));
    azzert.that(string.esc("abc\n"), is("abc\\n"));
  }
  
  @Test public void fill() {
    azzert.that(string.fill(3, 'a'), is("aaa"));
    azzert.that(string.fill(4, "ab"), is("abababab"));
  }
  
  @Test public void ftoa() {
    azzert.that(string.ftoa(3.14F), is("3.14"));
  }
  
  @Test public void isDouble() {
    azzert.aye(string.isDouble("3.14"));
    azzert.nay(string.isDouble("abc"));
  }
  
  @Test public void isInt() {
    azzert.aye(string.isInt("314"));
    azzert.nay(string.isInt("abc"));
  }
  
  @Test public void isFloat() {
    azzert.aye(string.isFloat("3.14"));
    azzert.nay(string.isFloat("abc"));
  }
  
  @Test public void isLong() {
    azzert.aye(string.isLong("314"));
    azzert.nay(string.isLong("abc"));
  }
  
  @Test public void itoa() {
    azzert.that(string.itoa(314), is("314"));
  }
  
  @Test public void javaCase() {
    azzert.that(string.javaCase(""), is(""));
    azzert.that(string.javaCase("ABC"), is("aBC"));
  }
  
  @Test public void last() {
    azzert.that(string.last("abc"), is('c'));
    
    try {
      string.last("");
      azzert.fail();
    } catch (Exception ¢) {
      forget.it(¢);
    }
  }
  
}
