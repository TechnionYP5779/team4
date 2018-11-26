package il.org.parknet;

import org.junit.*;

import fluent.ly.*;
import static fluent.ly.azzert.*;

@SuppressWarnings("static-method") public class UserTest {
  private static User U2;
  private static User U1;

  @Before
  public void setup() {
    U1 = new User("318211687", "Ameer Amer", "0548088094", "ameeramer@campus.technion.ac.il");
    U2 = new User("123456789", "John Smith", "0522552322", "johns@campus.technion.ac.il");
  }
  
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
  
  @Test public void get_phone1() {
    azzert.that(U1.getPhone(), is("0548088094"));
  }
  
  @Test public void get_phone2() {
    azzert.that(U2.getPhone(), is("0522552322"));
  }
  
  @Test public void get_email1() {
    azzert.that(U1.getEmail(), is("ameeramer@campus.technion.ac.il"));
  }
  
  @Test public void get_email2() {
    azzert.that(U2.getEmail(), is("johns@campus.technion.ac.il"));
  }
  
  @Test public void update_phone() {
    azzert.that(U1.updatePhone("0548088095").getPhone(), is("0548088095"));
  }
  
  @Test public void update_email() {
    azzert.that(U2.updateEmail("johnny@campus.technion.ac.il").getEmail(), is("johnny@campus.technion.ac.il"));
  }
}
