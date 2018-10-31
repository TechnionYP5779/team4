package il.org.spartan.utils;

import java.io.*;
import java.nio.file.*;

import org.jetbrains.annotations.*;

import fluent.ly.*;

/** File utils
 * @author Ori Marcovitch
 * @since Dec 4, 2016 */
public enum file {
  ;
  private static void delete(final @NotNull String path) {
    if (file.exists(path))
      new File(path).delete();
  }

  private static void rename(final @NotNull String from, final @NotNull String to) {
    file.delete(to);
    final Path source = Paths.get(from);
    try {
      Files.move(source, source.resolveSibling(to));
    } catch (final IOException ¢) {
      note.io(¢);
    }
  }

  private static boolean exists(final @NotNull String path) {
    final File $ = new File(path);
    return $.exists() && !$.isDirectory();
  }

  public static void renameToCSV(final @NotNull String old) {
    file.rename(old, old + ".csv");
  }
}
