package fluent.ly;

import static fluent.ly.azzert.*;

import java.util.*;

import org.junit.*;

import static fluent.ly.range.*;

@SuppressWarnings("static-method") public class RangeTest {
    @Test public void firstTwoNaturals(){
      Iterator<Integer> it = naturals().iterator();
      azzert.that(it.next(), is(0));
      azzert.that(it.next(), is(1));
      
      Iterator<Integer> it2 = to(-1).from(0).step(1).infiniteRange().iterator();
      azzert.that(it2.next(), is(0));
      azzert.that(it2.next(), is(1));
      
      Iterator<Integer> it3 = infinite().iterator();
      azzert.that(it3.next(), is(0));
      azzert.that(it3.next(), is(1));
      
      Iterator<Integer> it4 = to(-1).from(0).infinite().iterator();
      azzert.that(it4.next(), is(0));
      azzert.that(it4.next(), is(1));
      
      Iterator<Integer> it5 = from(0).self().step(1).infinite().iterator();
      azzert.that(it5.next(), is(0));
      azzert.that(it5.next(), is(1));
      
      Iterator<Integer> it6 = from(0).infinite().iterator();
      azzert.that(it6.next(), is(0));
      azzert.that(it6.next(), is(1));
      
      Iterator<Integer> it7 = infiniteFrom(0,4).from(2).iterator();
      azzert.that(it7.next(), is(2));
      azzert.that(it7.next(), is(3));
    }
    
    @Test public void firstTwoNumerlas(){
      Iterator<Integer> it = numerals().iterator();
      azzert.that(it.next(), is(1));
      azzert.that(it.next(), is(2));
    }
    
    @Test public void firstTwoOdds(){
      Iterator<Integer> it = odds().iterator();
      azzert.that(it.next(), is(1));
      azzert.that(it.next(), is(3));
    }
    
    @Test public void rangeOfArray(){
      Iterator<Integer> it = of(new Double[] {Double.valueOf(1.1),Double.valueOf(2.2)
          ,Double.valueOf(3.3)}).iterator();
      azzert.that(it.next(), is(0));
      azzert.that(it.next(), is(1));
      azzert.that(it.next(), is(2));
      try {
        it.next();
        azzert.fail();
      } catch(NoSuchElementException ¢) {
        ¢.getMessage();
        return;
      }
    }
  
    @Test public void infiniteSameValue() {
      Iterator<Integer> it = infinite(2).iterator();
      azzert.that(it.next(), is(2));
      azzert.that(it.next(), is(2));
    }
    
    @Test public void exclusiveRange() {
      Iterator<Integer> it = from(0).to(2).step(1).exclusive().iterator();
      azzert.that(it.next(), is(0));
      azzert.that(it.next(), is(1));
      try {
        it.next();
        azzert.fail();
      } catch(NoSuchElementException ¢) {
        ¢.getMessage();
        return;
      }
    }
  
    @Test public void streamOfAfter() {
      azzert.that(to(10).from(0).step(1).stream().findFirst().get(), is(0));
    }
  }