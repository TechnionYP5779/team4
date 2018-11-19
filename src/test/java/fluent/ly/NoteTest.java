package fluent.ly;

import java.io.*;
import java.util.logging.*;

import static java.lang.String.*;



import org.junit.*;



@SuppressWarnings("static-method") public class NoteTest {
  
  static final LogHandler lh = (new NoteTest()).new LogHandler();
  
  class LogHandler extends Handler
  {
      String msg;

      public String get() {
          return msg;
      }    

      @Override public void publish(LogRecord ¢) {
          msg = ¢.getMessage();
      }

      @Override public void close(){/**/}
      @Override public void flush(){/**/}
  }
  
  @Test public void testLevels() {
    note.set(Level.SEVERE);
    note.unset();
    note.set(Level.WARNING);
    note.set(Level.WARNING);
    note.unset();
    note.unset();
  }
  
  @Before
  public void setup() {
    Logger globalLogger = Logger.getLogger("global");
    Handler[] handlers = globalLogger.getHandlers();
    for(Handler ¢ : handlers)
      globalLogger.removeHandler(¢);
    globalLogger.addHandler(lh);
    
    System.setErr(new PrintStream(new ByteArrayOutputStream()));
  }
  
  @Test public void bugStrings() {
    note.bug("bug1. ", "hi");
    assert (lh.get() + "").contains("bug1.");
  }
  
  @Test public void bugInstance() {
    note.bug(Integer.valueOf(5));
    assert (lh.get() + "").contains("Integer");
  }
  
  @Test public void bugInstanceThrowable() {
    note.bug(Integer.valueOf(5), new IllegalStateException(//
        format("Works:","","","")));
    assert (lh.get() + "").contains("Works");
  }
  
  @Test public void bugThrowable() {
    note.bug(new IllegalStateException(//
        format("Works:","","","")));
    assert (lh.get() + "").contains("Works");
  }
  
  @Test public void cancelException() {
    note.cancel(new NullPointerException());
    assert (lh.get() + "").contains("NullPointerException");
  }
  
  @Test public void cancelObjectException() {
    note.cancel(Integer.valueOf(5), new NullPointerException());
    String l = lh.get() + "";
    assert l.contains("NullPointerException") && l.contains("Integer");
  }
  
  @Test public void ignoreClassThrowable() {
    note.ignore(Integer.class, new IllegalStateException(//
        format("Works:","","","")));
    String l = lh.get() + "";
    assert l.contains("Works") && l.contains("Integer");
  }
  
  @Test public void ignoreObjectThrowable() {
    note.ignore(Integer.valueOf(5), new IllegalStateException(//
        format("Works:","","","")));
    String l = lh.get() + "";
    assert l.contains("Works") && l.contains("Integer");
  }
  
  @Test public void ioExceptionMessage() {
    note.io(new NullPointerException(), "Works");
    String l = lh.get() + "";
    assert l.contains("Works") && l.contains("NullPointerException");
  }
  
  @Test public void ioExceptionIO() {
    note.io(new IOException());
    assert (lh.get() + "").contains("IOException");
  }
}
