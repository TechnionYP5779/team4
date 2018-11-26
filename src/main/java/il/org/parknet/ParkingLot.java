package il.org.parknet;

import il.org.spartan.utils.*;

public class ParkingLot {

  private String id;

  public ParkingLot(String id, Pair coordinates, User owner, int[] prices) {
    this.id =id;
  }

  public String getId() {
    return this.id;
  }
}
