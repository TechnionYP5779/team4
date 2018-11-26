package il.org.parknet;

import org.junit.*;

import fluent.ly.*;
import il.org.spartan.utils.*;

import static fluent.ly.azzert.*;

@SuppressWarnings("static-method") public class ParkingLotTest {
  
  @Test
  public void getID0() {
    azzert.that(
        (new ParkingLot("1", new Pair<>(box.it(1), box.it(1)), new User("206", "yogi", "050", "r@walla"), new int[] { 10, 20, 30, 40, 30, 20, 10 }))
            .getId(),
        is("1"));
    
  }
}
