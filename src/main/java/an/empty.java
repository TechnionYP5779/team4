package an;

import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import fluent.ly.*;
import il.org.spartan.*;
import il.org.spartan.utils.*;

/** TODO Yossi Gil: document class
 * @author Yossi Gil
 * @since 2017-04-01 */
public enum empty {
  ;
  public static <T> @NotNull List<T> list() {
    return new ArrayList<>();
  }

  public static <@Nullable T> Iterable<T> iterable() {
    return new Iterable<T>() {
      @Override public Iterator<T> iterator() {
        return new Iterator<T>() {
          @Override public boolean hasNext() {
            return false;
          }

          @Override public T next() {
            return null;
          }
        };
      }
    };
  }

  @SuppressWarnings("static-method") public static class TEST {
    @Test public void testList() {
      List<String> list = empty.list();
      azzert.assertEquals(0, list.size());
    }
  }
}
