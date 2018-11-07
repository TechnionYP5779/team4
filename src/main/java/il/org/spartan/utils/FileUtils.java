package il.org.spartan.utils;

import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.util.*;

import org.jetbrains.annotations.*;

/** A class for utility methods when working with files and directories
 * @author Daniel Mittelman <code><mittelmania [at] gmail.com></code>
 * @since 2015/09/19 */
@SuppressWarnings("null") public class FileUtils {
  @NotNull public static List<String> findAllJavaFiles(final String... paths) {
    final @NotNull List<String> $ = new ArrayList<>();
    if (paths == null || paths.length == 0)
      return $;
    for (final String s : paths) {
      if (s == null)
        continue;
      final @Nullable File f = new File(s);
      if (f.exists() && f.isDirectory())
        iterateFiles(new File(s), $);
    }
    return $;
  }

  /** @param fileName where to write
   * @param text     what to write
   * @throws FileNotFoundException in case the file could not be found */
  public static void writeToFile(final @NotNull String fileName, final @NotNull String text) throws FileNotFoundException {
    try (@NotNull PrintWriter p = new PrintWriter(fileName)) {
      p.write(text);
      p.flush();
    }
  }

  private static void iterateFiles(final @Nullable File dir, final @NotNull List<String> files) {
    if (dir != null)
      for (final @NotNull File ¢ : dir.listFiles()) {
        if (¢.isDirectory())
          iterateFiles(¢, files);
        if (¢.isFile() && ¢.getName().endsWith(".java"))
          files.add(¢.getAbsolutePath());
      }
  }
}
