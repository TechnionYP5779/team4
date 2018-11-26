package il.org.parknet;

import org.junit.*;

import fluent.ly.*;
import il.org.parknet.ParkingLot.*;
import il.org.spartan.utils.*;

import static fluent.ly.azzert.*;

@SuppressWarnings("static-method") public class UserTest {
  private static User U1;
  private static User U2;
  private static User U3;
  private static ParkingLot P;

  @Before public void setup() throws IllegalPriceParameter {
    U1 = new User("318211687", "Ameer Amer", "0548088094", "ameeramer@campus.technion.ac.il");
    U2 = new User("123456789", "John Smith", "0522552322", "johns@campus.technion.ac.il");
    U3 = new User("123456789", "John Smith", "0522552322", "johns@campus.technion.ac.il");
    P = new ParkingLot("1", new Pair<>(box.it(1), box.it(1)), new User("206", "yogi", "050", "r@walla"), new int[] { 10, 20, 30, 40, 30, 20, 10 });
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

  @Test public void add_new_available() {
    azzert.that(U1.newAvailableParkingLot(P).availableParkingLots().next().getId(), is("1"));
  }

  @Test public void rent_parking_lot() {
    azzert.that(U1.rentParkingLot(P).rentedParkingLots().next().getId(), is("1"));
  }

  @Test public void order_parking_lot() {
    azzert.that(U1.orderParkingLot(P).orderedParkingLots().next().getId(), is("1"));
  }
  
  @Test public void equal() {
    assert U2.equals(U3);
  }
}
