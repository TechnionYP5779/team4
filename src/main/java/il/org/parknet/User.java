package il.org.parknet;

import java.util.*;

public class User {
  private String id;
  private String name;
  private String phone;
  private String email;
  private List<ParkingLot> available;
  private List<ParkingLot> rented;
  private List<ParkingLot> ordered;

  public User(String id, String name, String phone, String email) {
    this.id = id;
    this.name = name;
    this.phone = phone;
    this.email = email;
    this.available = new ArrayList<>();
    this.rented = new ArrayList<>();
    this.ordered = new ArrayList<>();
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getPhone() {
    return phone;
  }

  public String getEmail() {
    return email;
  }

  public User updatePhone(String newPhone) {
    this.phone = newPhone;
    return this;
  }

  public User updateEmail(String newEmail) {
    this.email = newEmail;
    return this;
  }

  public User newAvailableParkingLot(ParkingLot ¢) {
    this.available.add(¢);
    return this;
  }

  public Iterator<ParkingLot> availableParkingLots() {
    return available.iterator();
  }

  public User rentParkingLot(ParkingLot ¢) {
    this.rented.add(¢);
    return this;
  }

  public Iterator<ParkingLot> rentedParkingLots() {
    return rented.iterator();
  }

  public User orderParkingLot(ParkingLot ¢) {
    this.ordered.add(¢);
    return this;
  }

  public Iterator<ParkingLot> orderedParkingLots() {
    return ordered.iterator();
  }

  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override public int hashCode() {
    return Objects.hash(id);
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override public boolean equals(Object ¢) {
    return ¢ == this || ¢ != null && ¢ instanceof User && Objects.equals(id, ((User) ¢).id);
  }
  
  
}
