package fluent.ly;

import static fluent.ly.idiomatic.*;

import java.util.*;
import java.util.function.*;

import org.jetbrains.annotations.*;

import il.org.spartan.utils.*;

/** TODO Yossi Gil: document class
 * @author Yossi Gil
 * @since 2017-04-28 */
public interface list {
  interface Operator<T> extends UnaryOperator<List<T>> {
    /**/}

  class Operators<T> extends Outer<List<Operator<T>>> {
    public Operators() {
      super(an.empty.list());
    }

    public Operators(final List<Operator<T>> inner) {
      super(inner);
    }

    public Operators(final Operators<T> other) {
      this(other != null ? other.inner : an.empty.list());
    }
  }

  class PrependOrAppend<T> extends ToCallExpected<T> {
    public PrependOrAppend() {
      this(null);
    }

    public PrependOrAppend(final Operators<T> other) {
      super(other);
    }

    public ToCallExpected<T> append(final T x) {
      inner.add(λ -> {
        λ.add(x);
        return λ;
      });
      return new ToCallExpected<>(this);
    }

    public ToCallExpected<T> prepend(final T t) {
      inner.add(λ -> {
        λ.add(0, t);
        return λ;
      });
      return new ToCallExpected<>(this);
    }
  }

  class ToCallExpected<T> extends Operators<T> {
    public ToCallExpected(final Operators<T> other) {
      super(other);
    }

    public PrependOrAppend<T> to() {
      return new PrependOrAppend<>(this);
    }

    public List<T> to(final List<T> xs) {
      List<T> $ = new ArrayList<>(xs);
      for (final Operator<T> ¢ : inner)
        $ = ¢.apply($);
      return $;
    }
  }

  static <T> ToCallExpected<T> append(final T ¢) {
    return new PrependOrAppend<T>().append(¢);
  }

  static <T> ToCallExpected<T> prepend(final T ¢) {
    return new PrependOrAppend<T>().prepend(¢);
  }

  /** @param <T> JD
   * @param ¢ a list
   * @return last item in a list or <code><b>null</b></code> if the parameter is
   *         <code><b>null</b></code> or empty */
  static <T> @Nullable T penultimate(final List<T> ¢) {
    return eval(() -> ¢.get(¢.size() - 2)).unless(¢ == null || ¢.size() < 2);
  }

  /** Determine whether an {@link Object} is penultimate in its {@link List} .
   * @param    <T> JD
   * @param o  JD
   * @param os JD
   * @return <code><b>true</b></code> <i>iff</i> the an {@link Object} parameter
   *         occurs as the penultimate element of the {@link List} parameter */
  static <@Nullable T> boolean penultimateIn(final T o, final @Nullable List<T> os) {
    assert os != null;
    return penultimate(os) == o;
  }
}
