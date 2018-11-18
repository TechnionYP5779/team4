package fluent.ly;

public interface count {
  static <T> int of(final Iterable<T> ts) {
    int $ = 0;
    for (final T __ : ts) {
      forget.it(__);
      ++$;
    }
    return $;
  }
}
