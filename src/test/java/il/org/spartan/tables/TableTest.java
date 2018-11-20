package il.org.spartan.tables;

import org.junit.*;

@SuppressWarnings("static-method") public class TableTest {
  @Test public void tableDescription() {
    try (Table t = new Table(Integer.valueOf(5))) {
      assert t.description().contains("5");
    }
  }
}
