package il.org.spartan;

import java.util.*;

import org.jetbrains.annotations.*;

import fluent.ly.*;

/** @author Yossi Gil
 * @since Apr 8, 2012 */
@SuppressWarnings("null") public abstract class AbstractStringProperties {
  final Renderer renderer;

  public AbstractStringProperties() {
    this(Renderer.CSV);
  }

  public AbstractStringProperties(final Renderer renderer) {
    this.renderer = renderer;
  }

  @Override @Nullable public AbstractStringProperties clone() {
    try {
      return (AbstractStringProperties) super.clone();
    } catch (final CloneNotSupportedException ¢) {
      ¢.printStackTrace();
      return null;
    }
  }

  @Nullable public abstract String get(String key);

  /** A total inspector
   * @return the header of the CSV line */
  public String header() {
    return renderer.allTop() + makeLine(keys()) + renderer.headerEnd();
  }

  public abstract Iterable<String> keys();

  @NotNull public final String line() {
    return makeLine(values());
  }

  public abstract AbstractStringProperties put(String key, String value);

  public abstract int size();

  public abstract Iterable<String> values();

  protected String makeLine(final Iterable<String> ¢) {
    return renderer.makeLine(¢);
  }

  public static class ListProperties extends AbstractStringProperties {
    @NotNull private final List<String> keys = new ArrayList<>();
    @NotNull private final List<String> values = new ArrayList<>();

    @Override @Nullable public String get(final @NotNull String key) {
      final int $ = keys.lastIndexOf(key);
      return $ < 0 ? null : values.get($);
    }

    @Override @NotNull public Iterable<String> keys() {
      return keys;
    }

    @Override @NotNull public ListProperties put(final @NotNull String key, final @NotNull String value) {
      keys.add(key);
      values.add(value);
      return this;
    }

    /* (non-Javadoc)
     *
     * @see il.org.spartan.csv.AbstractStringProperties#size() */
    @Override public int size() {
      return keys.size();
    }

    @Override @NotNull public Iterable<String> values() {
      return values;
    }
  }

  public enum Renderer {
    CSV {
      @NotNull static final String QUOTE = '"' + "";
      @NotNull static final String DELIMETER = ",";

      @Override @NotNull public String headerEnd() {
        return "";
      }

      @Override @NotNull public String makeField(final @Nullable String ¢) {
        return ¢ == null ? "" : !¢.contains(QUOTE) && !¢.contains(delimiter()) ? ¢ : QUOTE + ¢.replaceAll(QUOTE, QUOTE + QUOTE) + QUOTE;
      }

      @Override @NotNull String allBottom() {
        return "";
      }

      @Override @NotNull String allTop() {
        return "";
      }

      @Override @NotNull String delimiter() {
        return DELIMETER;
      }

      @Override @NotNull String lineBegin() {
        return "";
      }

      @Override @NotNull String lineEnd() {
        return "";
      }
    },
    MATRIX {
      @NotNull static final String DELIMETER = " ";
      static final int WIDTH = 3;

      @Override @NotNull String allBottom() {
        return "";
      }

      @Override @NotNull String allTop() {
        return "";
      }

      @Override @NotNull String delimiter() {
        return DELIMETER;
      }

      @Override @NotNull String headerEnd() {
        return "";
      }

      @Override @NotNull String lineBegin() {
        return "";
      }

      @Override @NotNull String lineEnd() {
        return "";
      }

      @Override String makeField(final @NotNull String ¢) {
        return String.format("%" + WIDTH + "s", ¢);
      }
    },
    LaTeX() {
      @Override @NotNull String allBottom() {
        return "\\bottomrule\n";
      }

      @Override @NotNull String allTop() {
        return "\\toprule\n";
      }

      @Override String delimiter() {
        return " &\t\t";
      }

      @Override @NotNull String headerEnd() {
        return "\n\\midrule";
      }

      @Override @NotNull String lineBegin() {
        return "";
      }

      @Override @NotNull String lineEnd() {
        return "\\\\";
      }

      @Override @NotNull String makeField(final @Nullable String ¢) {
        return ¢ == null ? "" : !¢.contains(delimiter()) ? ¢ : ¢.replaceAll(delimiter(), "\\" + delimiter());
      }
    };
    public String makeLine(final Iterable<String> ¢) {
      return lineBegin() + separate(¢) + lineEnd();
    }

    public String separate(final Iterable<String> ¢) {
      return separate.these(¢).by(delimiter());
    }

    abstract String allBottom();

    abstract String allTop();

    abstract String delimiter();

    abstract String headerEnd();

    abstract String lineBegin();

    abstract String lineEnd();

    abstract String makeField(String s);
  }
}
