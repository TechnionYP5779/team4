package fluent.ly;

import java.io.*;
import java.util.*;

import org.junit.*;

@SuppressWarnings("static-method") public class DumpTest {
  static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  @Before
  public void setup() { 
    System.setOut(new PrintStream(outContent));
  }
  @Test public void goClass() {
    dump.go(Integer.class);
    assert (outContent + "").contains("Integer");
  }
  
  @Test @SuppressWarnings("null") public void goList() {
    dump.go(Arrays.asList("hi"), "Works");
    assert (outContent + "").contains("hi") && (outContent + "").contains("Works");
  }
  
  @Test public void goArray() {
    dump.go(new String[] {"hi"}, "Works");
    assert (outContent + "").contains("hi") && (outContent + "").contains("Works");
  }
  
  @Test public void goObject() {
    dump.go("hi", "Works");
    assert (outContent + "").contains("hi") && (outContent + "").contains("Works");
  }
  
}
