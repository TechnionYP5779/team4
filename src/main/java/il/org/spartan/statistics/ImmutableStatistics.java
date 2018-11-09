package il.org.spartan.statistics;

import static il.org.spartan.bench.Unit.*;

import java.util.*;

import org.jetbrains.annotations.*;

import il.org.spartan.bench.*;

/** @author Yossi Gil
 * @since 30/04/2011 */
public abstract class ImmutableStatistics extends Statistics implements java.io.Serializable {
  /** A field for identifying a streamed version of objects of this class; we use
   * the values of <code>1L</code> to maintain upward compatibility. */
  private static final long serialVersionUID = 1;

  private static StringBuilder appendValue(final @NotNull StringBuilder b, final @NotNull String name, final double v, final @NotNull Unit u) {
    return b.append(name).append('=').append(u.format(v));
  }

  private static void appendValue(final @NotNull StringBuilder b, final @NotNull String name, final int i) {
    b.append(name).append('=').append(i);
  }

  protected Unit unit;
  protected int flips;
  protected double @NotNull [] values = new double[0];

  /** Generate a copy of the set of all recorded values
   * @return an array containing all recorded values */
  @SuppressWarnings("null") public final double @NotNull [] all() {
    return Arrays.copyOf(values, n);
  }

  public double flipping() {
    return 1. * flips / n;
  }

  public String format() {
    return format(unit != null ? unit : Unit.DOUBLE);
  }

  public String format(final @NotNull Unit ¢) {
    return n() == 1 ? ¢.format(mean()) : format(¢, "A D R N");
  }

  public String format(final @NotNull Unit u, final @Nullable String format) {
    if (format == null)
      return format(u);
    final @NotNull StringBuilder $ = new StringBuilder();
    for (final char ¢ : format.toCharArray())
      switch (¢) {
        case 'A':
          appendValue($, "mean", mean(), u);
          appendError($, relativeError());
          break;
        case 'a':
          appendValue($, "mean", mean(), u);
          break;
        case 'J':
          $.append(u.format(median()));
          appendError($, relativeMedianError());
          break;
        case 'j':
          $.append(u.format(median()));
          break;
        case 'D':
          appendValue($, "median", median(), u);
          appendError($, relativeMedianError());
          break;
        case 'd':
          appendValue($, "median", median(), u);
          break;
        case 'I':
        case 'i':
          appendValue($, "min", min(), u);
          break;
        case 'X':
        case 'x':
          appendValue($, "max", max(), u);
          break;
        case 'N':
        case 'n':
          appendValue($, "n", n());
          break;
        case 'R':
        case 'r':
          $.append("range").append('=');
          $.append(u.format(min()));
          $.append('⋯');
          $.append(u.format(max()));
          $.append("]");
          break;
        default:
          $.append(¢);
          break;
      }
    return $ + "";
  }

  public final double mad() {
    checkEmpty();
    return mad(all());
  }

  public final double median() {
    checkEmpty();
    return median(all());
  }

  /** Prune the set of values to those in the median +- mad value.
   * @return an array representing these values */
  public double @NotNull [] prune() {
    return prune(all());
  }

  public final double relativeMedianError() {
    return mad() / Math.abs(median());
  }

  public double relativeMinError() {
    return (median() - min()) / min();
  }

  /** Provides the {@link Unit} of measurement used by values recorded in this
   * instance
   * @return a non-negative integer, giving the number of elements in the
   *         sequence */
  public final Unit unit() {
    return unit;
  }

  @NotNull @SuppressWarnings("null") private StringBuilder appendError(final @NotNull StringBuilder b, final double d) {
    return n() <= 1 ? b : b.append('±' + RELATIVE.format(d));
  }
}
