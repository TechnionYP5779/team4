package il.org.spartan.utils;

import org.jetbrains.annotations.*;

import fluent.ly.*;

public abstract class Accumulator {
  protected int value;
  public int weight = 1;
  @NotNull protected final String name;

  public Accumulator() {
    this("");
  }

  public Accumulator(final @NotNull String name) {
    this.name = name;
  }

  public final void add(final boolean ¢) {
    add(as.bit(¢));
  }

  public void add(final int v) {
    value += weight * transform(v);
  }

  public final void add(final @NotNull String ¢) {
    add(as.bit(¢));
  }

  public String name() {
    return name;
  }

  public int value() {
    return value;
  }

  protected abstract int transform(int v);

  final int weight() {
    return weight;
  }

  final Accumulator weight(final int w) {
    weight = w;
    return this;
  }

  /** A simple counter class.
   * @author Itay Maman, The Technion
   * @since Jul 30, 2007 */
  public static class Counter extends Accumulator {
    public Counter() {
    }

    public Counter(final @NotNull String name) {
      super(name);
    }

    public void add() {
      add(1);
    }

    public int next() {
      add();
      return value();
    }

    @Override @NotNull public String toString() {
      return value + "";
    }

    @Override protected int transform(final int v) {
      return v == 0 ? 0 : 1;
    }
  }

  public static class Last extends Accumulator {
    /** Instantiate {@link Last}. */
    public Last() {
    }

    /** Instantiate {@link Last}.
     * @param name JD */
    public Last(final @NotNull String name) {
      super(name);
    }

    @Override public void add(final int v) {
      value = v;
    }

    @Override protected int transform(final int v) {
      return v;
    }
  }

  public static class Squarer extends Accumulator {
    @Override protected int transform(final int v) {
      return v * v;
    }
  }

  public static class Summer extends Accumulator {
    /** Instantiate {@link Summer}. */
    public Summer() {
      // Empty
    }

    /** Instantiate {@link Summer}.
     * @param name name of this instance */
    public Summer(final @NotNull String name) {
      super(name);
    }

    @Override protected int transform(final int v) {
      return v;
    }
  }
}