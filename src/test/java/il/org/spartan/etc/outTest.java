package il.org.spartan.etc;

import static fluent.ly.azzert.*;

import java.io.*;
import java.util.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class outTest {
  @Test public void out_message() {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    out.out_message("hello");
    azzert.that(outContent + "", is("hello"));
  }
  
  @Test public void out_message23() {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    out.out_message("bye bye");
    azzert.that(outContent + "", is("bye bye"));
  }
  @Test public void out_message24() {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    out.out_message("whatsup");
    azzert.that(outContent + "", is("whatsup"));
  }

  @Test public void out_message2() {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    out.out_message("hello", true);
    azzert.that(outContent + "", is("hello = true\n"));
  }
  
  @Test public void out_message25() {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    out.out_message("noWay", true);
    azzert.that(outContent + "", is("noWay = true\n"));
  }


  @Test public void out_collection() {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    out.out_collection("koko", new ArrayList<>());
    azzert.that(outContent + "", is("No koko\n"));
  }

  @Test public void out_collection2() {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    final Collection<Object> collection = new ArrayList<>();
    collection.add("Hello");
    out.out_collection("koko", collection);
    azzert.that(outContent + "", is("Only 1 koko: Hello\n"));
  }
  @Test public void out_collection22() {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    final Collection<Object> collection = new ArrayList<>();
    collection.add("apple");
    out.out_collection("fruit", collection);
    azzert.that(outContent + "", is("Only 1 fruit: apple\n"));
  }

  @Test public void out_collection3() {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    final Collection<Object> collection = new ArrayList<>();
    collection.add("Hello");
    collection.add("Bye");
    out.out_collection("koko", collection);
    azzert.that(outContent + "", is("Total of 2 koko:\n\t 1) Hello\n\t 2) Bye\n"));
  }
  
  @Test public void out_collection33() {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    final Collection<Object> collection = new ArrayList<>();
    collection.add("banana");
    collection.add("apple");
    out.out_collection("fruits", collection);
    azzert.that(outContent + "", is("Total of 2 fruits:\n\t 1) banana\n\t 2) apple\n"));
  }

  @Test public void out_collection4() {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    final Collection<Object> collection = new ArrayList<>();
    for (int ¢ = 0; ¢ < 40; ++¢)
      collection.add("a" + ¢);
    out.out_collection("koko", collection);
    azzert.that(outContent + "", is(
        "Total of 40 koko:\n\t 1) a0\n\t 2) a1\n\t 3) a2\n\t 4) a3\n\t 5) a4\n\t 6) a5\n\t 7) a6\n\t 8) a7\n\t 9) a8\n\t10) a9\n\t11) a10\n\t12) a11\n\t13) a12\n\t14) a13\n\t15) a14\n\t16) a15\n\t17) a16\n\t18) a17\n\t19) a18\n\t20) a19\n\t...\n"));
  }
  @Test public void out_collection44() {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    final Collection<Object> collection = new ArrayList<>();
    for (int ¢ = 0; ¢ < 40; ++¢)
      collection.add("a" + ¢);
    out.out_collection("fruits", collection);
    azzert.that(outContent + "", is(
        "Total of 40 fruits:\n\t 1) a0\n\t 2) a1\n\t 3) a2\n\t 4) a3\n\t 5) a4\n\t 6) a5\n\t 7) a6\n\t 8) a7\n\t 9) a8\n\t10) a9\n\t11) a10\n\t12) a11\n\t13) a12\n\t14) a13\n\t15) a14\n\t16) a15\n\t17) a16\n\t18) a17\n\t19) a18\n\t20) a19\n\t...\n"));
  }
  @Test public void out_integer() {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    out.out_integer("hi", 8);
    azzert.that(outContent + "", is("hi = 8\n"));
  }

  @Test public void out_object() {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    out.out_object("hi", null);
    azzert.that(outContent + "", is("No hi\n"));
  }
  @Test public void out_object22() {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    out.out_object("fruit", null);
    azzert.that(outContent + "", is("No fruit\n"));
  }
  @Test public void out_object2() {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    out.out_object("hi", Integer.valueOf(2));
    azzert.that(outContent + "", is("hi = 2\n"));
  }

  @Test public void out_object_array() {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    out.out_object_array("hi", null);
    azzert.that(outContent + "", is("No hi\n"));
  }

  @Test public void out_object_array2() {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    out.out_object_array("hi", new Object[0]);
    azzert.that(outContent + "", is("No hi\n"));
  }

  @Test public void out_object_array1() {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    out.out_object_array("hi", new Object[] { Integer.valueOf(1) });
    azzert.that(outContent + "", is("Only one hi: 1\n"));
  }

  @Test public void out_object_array3() {
    new out().getClass();
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    out.out_object_array("hi", new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
    azzert.that(outContent + "", is("Total of 2 hi:\n\t1\n\t2\n"));
  }
  
  @Test public void out_object_array12() {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    out.out_object_array("tea", new Object[] { Integer.valueOf(1) });
    azzert.that(outContent + "", is("Only one tea: 1\n"));
  }

  @Test public void out_object_array33() {
    new out().getClass();
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    out.out_object_array("milk", new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
    azzert.that(outContent + "", is("Total of 2 milk:\n\t1\n\t2\n"));
  }
}
