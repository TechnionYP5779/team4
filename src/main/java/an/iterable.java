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
   * @param    < T > an arbitrary type
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

  static <T> Iterable<T> alternate(Iterable<T> itA, Iterable<T> itB) {
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
            @SuppressWarnings("null") T $ = null;
            if (a.hasNext() && b.hasNext()) {
              $ = (nextA ? a : b).next();
              nextA = !nextA;
            } else {
              if (a.hasNext())
                $ = a.next();
              if (b.hasNext())
                $ = b.next();
            }
            return $;
          }
        };
      }
    };
  }
}
