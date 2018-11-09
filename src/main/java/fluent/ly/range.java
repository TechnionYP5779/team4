package fluent.ly;

import static fluent.ly.azzert.*;

import java.util.*;
import java.util.stream.*;

import org.junit.*;

/** A fluent API implementation for range
 * @author Dor Ma'ayan
 * @since 26-11-2016 */
public class range {
  public class AfterTo extends RangeIterator<AfterTo> {
    public AfterTo from(final int ¢) {
      from = ¢;
      return this;
    }

    public Iterable<Integer> infinite() {
      return range.infiniteFrom(from, step);
    }

    public AfterTo step(final int ¢) {
      step = ¢;
      return this;
    }

    public Stream<Integer> stream() {
      return StreamSupport.stream(spliterator(), false);
    }

    @Override AfterTo self() {
      return this;
    }
  }

  public class BeforeTo extends RangeIterator<BeforeTo> {
    public Infinite infinite() {
      return range.infiniteFrom(from, step);
    }

    public AfterTo step(final int ¢) {
      step = ¢;
      return new AfterTo();
    }

    public AfterTo to(final int ¢) {
      to = ¢;
      return new AfterTo();
    }

    @Override BeforeTo self() {
      return this;
    }
  }

  public class Infinite extends RangeIterator<Infinite> {
    public Infinite from(final int ¢) {
      from = ¢;
      step = 1;
      return this;
    }

    public Iterable<Integer> step(final int ¢) {
      step = ¢;
      return this;
    }

    @Override Infinite self() {
      return this;
    }
  }

  abstract class RangeIterator<Self extends RangeIterator<Self>> implements Iterable<Integer> {
    public final Self exclusive() {
      inclusive = false;
      return self();
    }

    public final Self inclusive() {
      inclusive = true;
      return self();
    }

    public final Self infiniteRange() {
      infinite = true;
      return self();
    }

    @Override public Iterator<Integer> iterator() {
      return new Iterator<Integer>() {
        int next = from;

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

    abstract Self self();
  }

  public static BeforeTo from(final int ¢) {
    return makeFrom(¢).new BeforeTo();
  }

  public static Infinite infinite() {
    return infiniteFrom(0, 1);
  }

  public static Iterable<Integer> infinite(final int ¢) {
    return from(¢).to(¢).step(0).inclusive();
  }

  public static RangeIterator<?> naturals() {
    return from(0).to(-1).step(1).infiniteRange();
  }

  public static RangeIterator<?> numerals() {
    return from(1).to(-1).step(1).infiniteRange();
  }

  public static RangeIterator<?> odds() {
    return from(1).to(-1).step(2).infiniteRange();
  }

  public static <T> RangeIterator<?> of(final T[] ¢) {
    return from(0).to(¢.length);
  }

  public static AfterTo to(final int to) {
    return makeTo(to).new AfterTo();
  }

  private static range makeFrom(final int ¢) {
    return new range() {
      {
        from = ¢;
      }
    };
  }

  private static range makeTo(final int ¢) {
    return new range() {
      {
        to = ¢;
      }
    };
  }

  static Infinite infiniteFrom(final int ¢, final int ¢2) {
    final Infinite $ = makeFrom(¢).new Infinite().infiniteRange();
    $.step(¢2);
    return $;
  }

  int from;
  boolean inclusive;
  boolean infinite;
  int step = 1;
  int to = -1;
  
  @SuppressWarnings("static-method") public static class TEST {
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
      } catch(NoSuchElementException e) {
        e.getMessage();
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
      } catch(NoSuchElementException e) {
        e.getMessage();
        return;
      }
    }
  
    @Test public void streamOfAfter() {
      Stream<Integer> s = to(10).from(0).step(1).stream();
      azzert.that(s.findFirst().get(), is(0));
    }
  }
}
