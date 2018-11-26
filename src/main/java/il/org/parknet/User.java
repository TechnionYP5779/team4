package il.org.parknet;

import java.util.*;

public class User {

  private String id;
  private String name;
  private String phone;
  private String email;
  private List<ParkingLot> available;

  public User(String id, String name, String phone, String email) {
    this.id = id;
    this.name = name;
    this.phone = phone;
    this.email = email;
    this.available = new ArrayList<>();
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
}
