package il.org.parknet;

import java.util.*;

public class Reservation {
  private User guest;
  private Date time;
  private ParkingLot parking;
  
  public Reservation(User guest, ParkingLot parking, Date time) {
    this.guest = guest;
    this.time = time;
    this.parking = parking;
  }

  public User getGuest() {
    return guest;
  }

  public Date getTime() {
    return time;
  }

  public ParkingLot getParking() {
    return parking;
  }
  
}
