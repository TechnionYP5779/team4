package il.org.parknet;

import java.util.*;

import il.org.spartan.utils.*;

public class ParkingLot {

  public class IllegalPriceParameter extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1;
    /**/
  }

  private String id;
  private Pair<Integer, Integer> coordinates;
  private User owner;
  private int[] pricesArr = new int[7];
  private Map<Date, Reservation> reservations;

  public ParkingLot(String id, Pair<Integer, Integer> coordinates, User owner, int[] prices) throws IllegalPriceParameter {
    this.id =id;
    this.coordinates= coordinates;
    this.owner = owner;
    if(prices.length != 7)
      throw new ParkingLot.IllegalPriceParameter();
    for (int ¢=0; ¢<7;++¢)
      pricesArr[¢] = prices[¢];
    
    this.reservations = new HashMap<>();
  }

  public String getId() {
    return this.id;
  }

  public Pair<Integer, Integer> getLocation() {
    return this.coordinates;
  }

  public User getOwner() {
    return this.owner;
  }

  public int[] getPricesArray() {
    return this.pricesArr;
  }
  
  public void reserve(User guest, Date time) {
    if (!reservations.containsKey(time))
      reservations.put(time, new Reservation(guest, this, time));
  }
  
  public void cancelReservation(Date time) {
    if (reservations.containsKey(time))
      reservations.remove(time);
  }
}
