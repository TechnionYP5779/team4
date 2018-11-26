package il.org.parknet;

import fluent.ly.*;

public class User {

  private String id;
  private String name;

  public User(String id, String name, String phone, String email) {
    this.id = id;
    this.name = name;
    forget.it(email);
    forget.it(phone);
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
