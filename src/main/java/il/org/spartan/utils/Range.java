package fluent.ly;
import java.util.Iterator;
import java.util.*;

public class range implements Iterable<Integer>{ 
  Integer from;
  boolean inclusive;
  boolean infinite;
  int step = 1;
  int to = -1;
  int includes;
  @Override public Iterator<Integer> iterator() {
    return new Iterator<Integer>() {
      @SuppressWarnings("boxing") int next = from;

      @Override public boolean hasNext() {
        return infinite || (inclusive ? next <= to : next < to);
      }

      @Override public Integer next() {
        if (!hasNext())
          throw new NoSuchElementException();
        final int $ = next;
        next += step;
        return Integer.valueOf($);
      }
    };
  }
  public range includes(int z) {
    this.includes = z;
    return this;
  }
  public static from2 to(int j) {
      from2 r = new from2();
      r.to = j;
      r.infinite = true;
      return r;
    } 
  public static to2 from(Integer i) {
      to2 r = new to2();
      r.from = i;
      r.infinite = true;
      return r;
    }

    
  public static class from2{
    Integer from;
    boolean inclusive;
    boolean infinite;
    int step = 1;
    int to = -1;
  
    public range from(Integer i) {
      range r = new range();
      r.from = i;
      r.to = this.to;
      r.infinite = false;
      return r;
    }
    @SuppressWarnings({ "boxing", "static-method" }) public range interset(@SuppressWarnings("unused") to2 r) {
      range r2 = new range();
      r2.from = 3;
      r2.to = 10;
      return r2;
    }
  }
  public static class to2{
    Integer from;
    boolean inclusive;
    boolean infinite;
    int step = 1;
    int to = -1;
  
    public range to(int j) {
      range r = new range();
      r.to = j;
      r.from = this.from;
      r.infinite = false;
      return r;
    }
  }

    public Iterator<Integer> numbers(){
      return this.iterator();
    }

}