package il.org.parknet;

import org.junit.*;

import fluent.ly.*;
import static fluent.ly.azzert.*;

@SuppressWarnings("static-method") public class UserTest {
  private static final User U2 = new User("123456789", "John Smith", "0522552322", "johns@campus.technion.ac.il");
  private static final User U1 = new User("318211687", "Ameer Amer", "0548088095", "ameeramer@campus.technion.ac.il");

  @Test public void get_id1() {
    azzert.that(U1.getId(), is("318211687"));
  }
  
  @Test public void get_id2() {
    azzert.that(U2.getId(), is("123456789"));
  }
  
  @Test public void get_name1() {
    azzert.that(U1.getName(), is("Ameer Amer"));
  }
  
  @Test public void get_name2() {
    azzert.that(U2.getName(), is("John Smith"));
  }
}
