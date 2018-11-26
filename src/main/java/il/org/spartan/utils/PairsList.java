package il.org.spartan.utils;

import java.util.*;

import org.jetbrains.annotations.*;

import fluent.ly.*;

public class PairsList<T extends Number & Comparable<T>> implements Iterable<PairsList<T>.Pair> {
  public class PairComparator implements Comparator<Pair> {
    @Override public int compare(final PairsList<T>.Pair o1, final PairsList<T>.Pair o2) {
      // TODO Auto-generated method stub
      return o1.x.equals(o2.x) ? o1.y.compareTo(o2.y) : o1.x.compareTo(o2.x);
    }
  }

  public class Pair {
    @NotNull T x, y;

    public Pair(@NotNull final T x, @NotNull final T y) {
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
    @Override public boolean equals(final Object o) {
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

  public void record(@NotNull final T x, @NotNull final T y) {
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
    /* In this class we use .doubleValue() functions instead of unboxing it because
     * we are generating a new pair list of type Double from PairList of type T.
     * That is to say, there is no double that is boxed, so nothing to unbox. */
    // TODO Auto-generated method stub
    if (list_of_pairs.isEmpty())
      return null;
    Double sum_x = box.it(0.0), sum_y = box.it(0.0);
    for (final PairsList<T>.Pair ¢ : this) {
      sum_x = box.it(unbox.it(sum_x) + ¢.x.doubleValue());
      sum_y = box.it(sum_y.doubleValue() + ¢.y.doubleValue());
    }
    final Double $ = box.it(unbox.it(sum_x) / list_of_pairs.size()), mean_y = box.it(unbox.it(sum_y) / list_of_pairs.size());
    final PairsList<Double> pd = new PairsList<>();
    pd.count();
    return pd.new Pair($, mean_y);
  }

  public PairsList<Double>.Pair variance() {
    /* In this class we use .doubleValue() functions instead of unboxing it because
     * we are generating a new pair list of type Double from PairList of type T.
     * That is to say, there is no double that is boxed, so nothing to unbox. */
    // TODO Auto-generated method stub
    if (list_of_pairs.isEmpty())
      return null;
    Double $ = box.it(0.0), sum_y = box.it(0.0);
    final PairsList<Double>.Pair mean_ = mean();
    for (final PairsList<T>.Pair ¢ : this) {
      $ = box.it($.doubleValue() + (¢.x.doubleValue() - mean_.getX().doubleValue()) * (¢.x.doubleValue() - mean_.getX().doubleValue()));
      sum_y = box.it(unbox.it(sum_y) + (¢.y.doubleValue() - mean_.getY().doubleValue()) * (¢.y.doubleValue() - mean_.getY().doubleValue()));
    }
    final PairsList<Double> pd = new PairsList<>();
    pd.count();
    return pd.new Pair($, sum_y);
  }

  public double co_variance() {
    /* In this class we use .doubleValue() functions instead of unboxing it because
     * we are generating a new double from PairList of type T. That is to say, there
     * is no double that is boxed, so nothing to unbox. */
    if (list_of_pairs.isEmpty())
      return 0.0;
    double $ = 0.0;
    final PairsList<Double>.Pair mean_ = mean();
    for (final PairsList<T>.Pair ¢ : this)
      $ += (¢.x.doubleValue() - unbox.it(mean_.getX())) * (¢.y.doubleValue() - unbox.it(mean_.getY()));
    return $;
  }

  public PairsList<Double>.Pair linear_regression() {
    // TODO Auto-generated method stub
    if (list_of_pairs.isEmpty())
      return null;
    final PairsList<Double>.Pair mean_ = mean();
    final Double $ = box.it(co_variance() / unbox.it(variance().getX())),
        alpha = box.it(unbox.it(mean_.getY()) - unbox.it($) * unbox.it(mean_.getX()));
    final PairsList<Double> pd = new PairsList<>();
    pd.count();
    return pd.new Pair(alpha, $);
  }
}
