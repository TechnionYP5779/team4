package il.org.spartan.utils;
import java.util.Iterator;

import fluent.ly.*;

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
      @SuppressWarnings("null") int next = unbox.unboxInteger(from);

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
      from2 $ = new from2();
      $.to = j;
      $.infinite = true;
      return $;
    } 
  public static to2 from(Integer ¢) {
      to2 $ = new to2();
      $.from = ¢;
      $.infinite = true;
      return $;
    }

    
  public static class from2{
    Integer from;
    boolean inclusive;
    boolean infinite;
    int step = 1;
    int to = -1;
  
    public range from(Integer ¢) {
      range $ = new range();
      $.from = ¢;
      $.to = this.to;
      $.infinite = false;
      return $;
    }
    @SuppressWarnings("static-method") public range interset(@SuppressWarnings("unused") to2 r) {
      range $ = new range();
      $.from = box.boxInteger(3);
      $.to = 10;
      return $;
    }
  }
  public static class to2{
    Integer from;
    boolean inclusive;
    boolean infinite;
    int step = 1;
    int to = -1;
  
    public range to(int j) {
      range $ = new range();
      $.to = j;
      $.from = this.from;
      $.infinite = false;
      return $;
    }
  }

    public Iterator<Integer> numbers(){
      return this.iterator();
    }

}