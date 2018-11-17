package fluent.ly;

import java.util.*;

public class range implements Iterable<Integer> {
  Integer from;
  boolean inclusive;
  boolean infinite;
  int step = 1;
  int to = -1;
  int includes;

  public range includes(final int z) {
    this.includes = z;
    return this;
  }

  public static from2 to(final int j) {
    final from2 $ = new from2();
    $.to = j;
    $.infinite = true;
    return $;
  }

  public static to2 from(final Integer ¢) {
    final to2 $ = new to2();
    $.from = ¢;
    $.infinite = true;
    return $;
  }

  public static class from2 implements Iterable<Integer> {
    Integer from;
    boolean inclusive;
    boolean infinite;
    int step = 1;
    int to = -1;

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

    public Iterator<Integer> numbers() {
      return this.iterator();
    }

    public range from(final Integer ¢) {
      final range $ = new range();
      $.from = ¢;
      $.to = this.to;
      $.infinite = false;
      return $;
    }

    @SuppressWarnings("static-method") public range interset(@SuppressWarnings("unused") final to2 r) {
      final range $ = new range();
      $.from = box.boxInteger(3);
      $.to = 10;
      return $;
    }
  }

  public static class to2 implements Iterable<Integer> {
    Integer from;
    boolean inclusive;
    boolean infinite;
    int step = 1;
    int to = -1;

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

    public Iterator<Integer> numbers() {
      return this.iterator();
    }

    public range to(final int j) {
      final range $ = new range();
      $.to = j;
      $.from = this.from;
      $.infinite = false;
      return $;
    }
  }

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

  public Iterator<Integer> numbers() {
    return this.iterator();
  }
}