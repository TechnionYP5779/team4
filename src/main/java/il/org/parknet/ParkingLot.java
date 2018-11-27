package il.org.parknet;

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

  public ParkingLot(String id, Pair<Integer, Integer> coordinates, User owner, int[] prices) throws IllegalPriceParameter {
    this.id =id;
    this.coordinates= coordinates;
    this.owner = owner;
    if(prices.length != 7)
      throw new ParkingLot.IllegalPriceParameter();
    for (int ¢=0; ¢<7;++¢)
      pricesArr[¢] = prices[¢];
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
}
