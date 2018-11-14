package fluent.ly;

import java.util.logging.*;

import org.junit.*;

@SuppressWarnings("static-method") public class NoteTest {
  @Test public void testLevels() {
    note.set(Level.SEVERE);
    note.unset();
    note.set(Level.WARNING);
    note.set(Level.WARNING);
    note.unset();
    note.unset();
  }
}
