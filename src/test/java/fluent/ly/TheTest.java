package fluent.ly;
import static fluent.ly.azzert.*;

import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

@SuppressWarnings("static-method") public class TheTest {
    @Test public void indexFound() {
      azzert.that(the.index(4, 1,2,3,4), is(3));
    }
    
    @Test public void indexNotFound() {
      azzert.that(the.index(5, 1,2,3,4), is(-1));
    }
    
    @Test public void nilIsNull() {
      azzert.isNull(the.nil());
    }
    
    @Test public void nthOfCollection() {
      List<Object> l = new ArrayList<>();
      l.add(new Object());
      l.add(new Object());
      l.add(new Object());
      
      azzert.that(the.nth(2, l), is(" #2/3"));
    }
    
    @Test @SuppressWarnings("null") public void previousOfFound() {
      List<@NotNull Integer> l = new ArrayList<>();
      l.add(Integer.valueOf(1));
      l.add(Integer.valueOf(2));
      l.add(Integer.valueOf(3));
      l.add(Integer.valueOf(4));
      azzert.that(the.previous(Integer.valueOf(4), l), is(Integer.valueOf(3)));
    }
    
    @Test @SuppressWarnings("null") public void previousOfFirst() {
      List<@NotNull Integer> l = new ArrayList<>();
      l.add(Integer.valueOf(1));
      l.add(Integer.valueOf(2));
      l.add(Integer.valueOf(3));
      l.add(Integer.valueOf(4));
      azzert.isNull(the.previous(Integer.valueOf(1), l));
    }
    
    @Test @SuppressWarnings("null") public void previousOfNotFound() {
      List<@NotNull Integer> l = new ArrayList<>();
      l.add(Integer.valueOf(1));
      l.add(Integer.valueOf(2));
      l.add(Integer.valueOf(3));
      l.add(Integer.valueOf(4));
      azzert.isNull(the.previous(Integer.valueOf(0), l));
    }
    
    @Test @SuppressWarnings("null") public void tailOfList() {
      List<@NotNull Integer> l = new ArrayList<>();
      l.add(Integer.valueOf(1));
      l.add(Integer.valueOf(2));
      l.add(Integer.valueOf(3));
      l.add(Integer.valueOf(4));
      
      List<@NotNull Integer> l2 = new ArrayList<>();
      l2.add(Integer.valueOf(2));
      l2.add(Integer.valueOf(3));
      l2.add(Integer.valueOf(4));

      List<Integer> res = the.tailOf(l);
      azzert.that(res.size(), is(l2.size()));
      for(int ¢ = 0; ¢ < l2.size(); ++¢)
        azzert.that(res.get(¢), is(l2.get(¢)));
    }
    
    @Test @SuppressWarnings("null") public void restOfList() {
      List<@NotNull Integer> l = new ArrayList<>();
      l.add(Integer.valueOf(1));
      l.add(Integer.valueOf(2));
      l.add(Integer.valueOf(3));
      l.add(Integer.valueOf(4));
      
      List<@NotNull Integer> l2 = new ArrayList<>();
      l2.add(Integer.valueOf(2));
      l2.add(Integer.valueOf(3));
      l2.add(Integer.valueOf(4));

      List<Integer> res = the.rest(Integer.valueOf(1), l);
      azzert.that(res.size(), is(l2.size()));
      for(int ¢ = 0; ¢ < l2.size(); ++¢)
        azzert.that(res.get(¢), is(l2.get(¢)));
    }
    
    @Test public void maxOfList() {
      azzert.that(the.max(1, 4, 3, 2), is(4));
    }
    
    @Test public void minOfList() {
      azzert.that(the.min(1, 4, 3, 2), is(1));
    }
  }