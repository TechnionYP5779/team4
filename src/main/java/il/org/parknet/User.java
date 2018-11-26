package il.org.parknet;

import fluent.ly.*;

public class User {

  private String id;

  public User(String id, String name, String phone, String email) {
    this.id = id;
    forget.it(email);
    forget.it(phone);
    forget.it(name);
  }

  public String getId() {
    return id;
  }
}
