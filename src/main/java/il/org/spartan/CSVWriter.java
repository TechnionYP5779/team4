// <a href=http://ssdl-linux.cs.technion.ac.il/wiki/index.php>SSDLPedia</a>
package il.org.spartan;

// TODO: I commented this import. Had it been renamed?

// import static il.org.spartan.utils.___.*;
import java.io.*;

import org.jetbrains.annotations.*;

import fluent.ly.*;

public final class CSVWriter {
  @Nullable private static FileWriter open(final File $) {
    try {
      return new FileWriter($);
    } catch (final IOException ¢) {
      forget.it(¢);
      return null;
    }
  }

  private File file;
  @Nullable private String header;
  @NotNull private final String fileName;
  @NotNull private final OutputStreamWriter inner;

  public CSVWriter() {
    inner = new OutputStreamWriter(System.out);
    fileName = "";
  }

  @SuppressWarnings("null") public CSVWriter(final @NotNull String fileName) {
    this.fileName = fileName;
    file = new File(fileName);
    @SuppressWarnings("resource") @Nullable FileWriter fw = open(file);
    inner = fw != null ? fw : new OutputStreamWriter(System.out);
  }

  public String close() {
    try {
      inner.close();
    } catch (final IOException ¢) {
      ¢.printStackTrace();
    }
    return fileName;
  }

  public File file() {
    return file;
  }

  public String fileName() {
    return fileName;
  }

  public String header() {
    return header;
  }

  public void write(final AbstractStringProperties ¢) {
    writeln(¢.line());
  }

  public void write(final CSVLine cl) {
    if (header == null)
      writeln(header = cl.header());
    writeln(cl.line());
  }

  public void writeFlush(final CSVLine cl) {
    try {
      write(cl);
      inner.flush();
    } catch (final IOException ¢) {
      ¢.printStackTrace();
    }
  }

  void writeln(final String s) {
    try {
      inner.write(s);
      inner.write("\n");
    } catch (final IOException ¢) {
      ¢.printStackTrace();
    }
  }
}
