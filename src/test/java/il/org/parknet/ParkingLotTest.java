package il.org.parknet;

import org.junit.*;

import fluent.ly.*;
import il.org.parknet.ParkingLot.*;
import il.org.spartan.utils.*;

import static fluent.ly.azzert.*;

@SuppressWarnings("static-method") public class ParkingLotTest {
  
    private static ParkingLot PARKING_LOT;

    @Before public void setup() throws IllegalPriceParameter {
      PARKING_LOT = new ParkingLot("1", new Pair<>(box.it(1), box.it(1)), new User("206", "yogi", "050", "r@walla"), new int[] { 10, 20, 30, 40, 30, 20, 10 });
    }
  @Test
  public void getID0() {
    azzert.that(PARKING_LOT.getId(), is("1"));
    
  }
  
  @Test
  public void getLocation1() {
    azzert.that(PARKING_LOT.getLocation(), is(new Pair<>(box.it(1), box.it(1))));
   
  }
  
  @Test
  public void getOwner1() {
    azzert.that(PARKING_LOT.getOwner(), is(new User("206", "yogi", "050", "r@walla")));
  }
  
  @Test
  public void getPricesArray1() {
    int[] a = { 10, 20, 30, 40, 30, 20, 10 };
    for (int ¢=0; ¢<7;++¢)
      azzert.that(PARKING_LOT.getPricesArray()[¢], is(a[¢]));
    
  }
}
