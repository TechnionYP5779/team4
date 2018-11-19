package il.org.spartan.utils;

import java.util.function.*;

import il.org.spartan.utils.Proposition.*;

/** TODO Yossi Gil: document class
 * @param <R>
 * @author Yossi Gil
 * @since 2017-03-19 */
@SuppressWarnings("unused") public abstract class PropositionReducer<R> extends Reduce<R> {
  public PropositionReducer(final Reduce<R> inner) {
    this.inner = inner;
    assert inner != this;
  }

  @Override public R reduce() {
    return inner.reduce();
  }

  public final R reduce(final BooleanSupplier ¢) {
    return //
    ¢ instanceof Not ? reduce((Not) ¢) //
        : ¢ instanceof Singleton ? reduce((Singleton) ¢) //
            : ¢ instanceof And ? reduce((And) ¢) //
                : ¢ instanceof Or ? reduce((Or) ¢) //
                    : map(¢);
  }

  @Override public R reduce(final R r1, final R r2) {
    return inner.reduce(r1, r2);
  }

  private R reduce(final And a) {
    R $ = ante(a);
    for(int size = a.inner.size(), ¢ = 0; ¢ < size; ++¢) {
      $ = reduce($, reduce(a.inner.get(¢)));
      if (¢ < size - 1)
        $ = reduce($, inter(a));
    }
    return reduce($, post(a));
  }

  private R reduce(final Not ¢) {
    return reduce(ante(¢), reduce(¢.inner), post(¢));
  }

  private R reduce(final Singleton ¢) {
    return reduce(ante(¢), map(¢), post(¢));
  }

  private R reduce(final Or o) {
    R $ = ante(o);
    for (int size = o.inner.size(), ¢ = 0; ¢ < size; ++¢) {
      $ = reduce($, reduce(o.inner.get(¢)));
      if (¢ < size - 1)
        $ = reduce($, inter(o));
    }
    return reduce($, post(o));
  }

  protected R ante( final Proposition.Not __) {
    return reduce();
  }

  protected R ante( final Proposition.Singleton __) {
    return reduce();
  }

  protected R ante( final Some __) {
    return reduce();
  }

  protected R inter( final And __) {
    return reduce();
  }

  protected R inter( final Or __) {
    return reduce();
  }

  protected abstract R map(BooleanSupplier ¢);

  protected R post( final Proposition.Not __) {
    return reduce();
  }

  protected R post( final Proposition.Singleton __) {
    return reduce();
  }

  protected R post( final Some __) {
    return reduce();
  }

  public final Reduce<R> inner;
}