package il.org.spartan.utils;

import java.io.*;
import java.util.logging.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class RuleTest {
  static final LogHandler lh = (new RuleTest()).new LogHandler();

  class LogHandler extends Handler {
    String msg;

    public String get() {
      return msg;
    }

    @Override public void publish(LogRecord ¢) {
      msg = ¢.getMessage();
    }

    @Override public void close() {
      /**/}

    @Override public void flush() {
      /**/}
  }

  @Before public void setup() {
    Logger globalLogger = Logger.getLogger("global");
    Handler[] handlers = globalLogger.getHandlers();
    for (Handler ¢ : handlers)
      globalLogger.removeHandler(¢);
    globalLogger.addHandler(lh);
    System.setErr(new PrintStream(new ByteArrayOutputStream()));
  }

  @Test public void description1() {
    assert ((new Rule<@Nullable Integer, Integer>() {
      @Override public Integer apply(@Nullable Integer ¢) {
        // TODO Auto-generated method stub
        return box.boxInteger(unbox.unboxInteger(¢) + 1);
      }

      @Override public boolean check(@Nullable Integer __) {
        // TODO Auto-generated method stub
        return false;
      }

      @Override @Nullable public Integer current() {
        return null;
      }
    }).description().contains("Rule"));
  }
}
