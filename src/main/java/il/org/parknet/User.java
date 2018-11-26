package il.org.parknet;

import fluent.ly.*;

public class User {

  private String id;
  private String name;
  private String phone;

  public User(String id, String name, String phone, String email) {
    this.id = id;
    this.name = name;
    this.phone = phone;
    forget.it(email);
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
}
