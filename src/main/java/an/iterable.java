package an;

import java.util.*;

import org.jetbrains.annotations.*;

public interface iterable {
  /** <code>singleton</code>
   * @param   <T> JD
   * @param ¢ JD
   * @return PureIterable.Sized<T> for returned value of method
   *         <code>singleton</code> */
  @NotNull static <T> Iterable<T> singleton(final T ¢) {
    return iterable.over(¢);
  }

  /** Creates an iterable for an array of objects
   * @param ts what to iterate on
   * @return an {@link Iterable} over the parameter */
  @SafeVarargs @NotNull static <T> Iterable<T> over(final T... ts) {
    return new Iterable<T>() {
      @Override @NotNull public Iterator<T> iterator() {
        return new Iterator<T>() {
          int current;

          @Override public boolean hasNext() {
            return current < ts.length;
          }

          @Override public T next() {
            return ts[current++];
          }
        };
      }
    };
  }

  static <T> Iterable<T> alternate(final Iterable<T> itA, final Iterable<T> itB) {
    if (itA == null || itB == null)
      throw new NullPointerException();
    return new Iterable<T>() {
      @Override @NotNull public Iterator<T> iterator() {
        return new Iterator<T>() {
          boolean nextA = true;
          Iterator<T> a = itA.iterator();
          Iterator<T> b = itB.iterator();

          @Override public boolean hasNext() {
            return a.hasNext() || b.hasNext();
          }

          @Override public T next() {
            
            if (!a.hasNext() || !b.hasNext())
              return a.hasNext() ? a.next() : (!b.hasNext() ? null : b.next());
            nextA = !nextA;
            return (nextA ? b : a).next();
          }
        };
      }
    };
  }
}
