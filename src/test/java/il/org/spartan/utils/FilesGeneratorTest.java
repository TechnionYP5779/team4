package il.org.spartan.utils;

import java.io.*;
import java.util.*;

import org.junit.*;

import fluent.ly.*;

public class FilesGeneratorTest {
  File resDir;
  File emptyDir;
  List<String> filesNames = as.list(new String[] { "f1", "f2" });

  @Before public void testInit() {
    resDir = new File(getClass().getClassLoader().getResource("dirWithTwoFiles").getPath());
  }

  @Test public void testDirectoryIterator() {
    azzert.isNull(FilesGenerator.directoryIterator(null));
    azzert.isNull(FilesGenerator.directoryIterator(resDir.listFiles()[0]));
    final Iterator<File> it = FilesGenerator.directoryIterator(resDir);
    assert it != null;
    while (it.hasNext())
      filesNames.contains(it.next().getName());
  }
}
