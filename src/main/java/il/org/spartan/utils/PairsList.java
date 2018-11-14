package il.org.spartan.utils;

import java.util.*;

import org.jetbrains.annotations.*;

import fluent.ly.*;

public class PairsList<T extends Number & Comparable<T>> implements Iterable<PairsList<T>.Pair> {
  public class PairComparator implements Comparator<Pair> {
    @Override public int compare(PairsList<T>.Pair o1, PairsList<T>.Pair o2) {
      // TODO Auto-generated method stub
      return o1.x.equals(o2.x) ? o1.y.compareTo(o2.y) : o1.x.compareTo(o2.x);
    }
  }

  public class Pair {
    @NotNull T x, y;

    public Pair(@NotNull T x, @NotNull T y) {
      this.x = x;
      this.y = y;
    }

    /** @return the x */
    public T getX() {
      return x;
    }

    /** @return the y */
    public T getY() {
      return y;
    }

    /* (non-Javadoc)
     *
     * @see java.lang.Object#hashCode() */
    @Override public int hashCode() {
      return Objects.hash(x, y);
    }

    /* (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object) */
    @Override public boolean equals(Object o) {
      if (o == this)
        return true;
      if (o == null || !(o instanceof PairsList.Pair))
        return false;
      @SuppressWarnings("unchecked") final Pair other = (Pair) o;
      return Objects.equals(x, other.x) && Objects.equals(y, other.y);
    }
  }

  protected List<PairsList<T>.Pair> list_of_pairs;

  public PairsList() {
    list_of_pairs = new ArrayList<>();
  }

  public void record(@NotNull T x, @NotNull T y) {
    list_of_pairs.add(new Pair(x, y));
    Collections.sort(list_of_pairs, this.new PairComparator());
  }

  @Override public Iterator<PairsList<T>.Pair> iterator() {
    return list_of_pairs.iterator();
  }

  public int count() {
    // TODO Auto-generated method stub
    return list_of_pairs.size();
  }

  public PairsList<Double>.Pair mean() {
    // TODO Auto-generated method stub
    if (list_of_pairs.isEmpty())
      return null;
    Double sum_x = box.it(0.0), sum_y = box.it(0.0);
    for (final PairsList<T>.Pair ¢ : this) {
      sum_x = box.it(sum_x.doubleValue() + ¢.x.doubleValue());
      sum_y = box.it(sum_y.doubleValue() + ¢.y.doubleValue());
    }
    final Double $ = box.it(sum_x.doubleValue() / list_of_pairs.size()), mean_y = box.it(sum_y.doubleValue() / list_of_pairs.size());
    final PairsList<Double> pd = new PairsList<>();
    pd.count();
    return pd.new Pair($, mean_y);
  }

  public PairsList<Double>.Pair variance() {
    // TODO Auto-generated method stub
    if (list_of_pairs.isEmpty())
      return null;
    Double $ = box.it(0.0), sum_y = box.it(0.0);
    final PairsList<Double>.Pair mean_ = mean();
    for (final PairsList<T>.Pair ¢ : this) {
      $ = box.it($.doubleValue() + (¢.x.doubleValue() - mean_.getX().doubleValue()) * (¢.x.doubleValue() - mean_.getX().doubleValue()));
      sum_y = box
          .it(sum_y.doubleValue() + (¢.y.doubleValue() - mean_.getY().doubleValue()) * (¢.y.doubleValue() - mean_.getY().doubleValue()));
    }
    final PairsList<Double> pd = new PairsList<>();
    pd.count();
    return pd.new Pair($, sum_y);
  }

  public double co_variance() {
    if (list_of_pairs.isEmpty())
      return 0.0;
    double $ = 0.0;
    final PairsList<Double>.Pair mean_ = mean();
    for (final PairsList<T>.Pair ¢ : this)
      $ += (¢.x.doubleValue() - mean_.getX().doubleValue()) * (¢.y.doubleValue() - mean_.getY().doubleValue());
    return $;
  }

  public PairsList<Double>.Pair linear_regression() {
    // TODO Auto-generated method stub
    if (list_of_pairs.isEmpty())
      return null;
    final PairsList<Double>.Pair mean_ = mean();
    final Double $ = box.it(co_variance() / variance().getX().doubleValue()),
        alpha = box.it(mean_.getY().doubleValue() - $.doubleValue() * mean_.getX().doubleValue());
    final PairsList<Double> pd = new PairsList<>();
    pd.count();
    return pd.new Pair(alpha, $);
  }
}
