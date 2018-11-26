package il.org.parknet;

public class User {

  private String id;
  private String name;
  private String phone;
  private String email;

  public User(String id, String name, String phone, String email) {
    this.id = id;
    this.name = name;
    this.phone = phone;
    this.email = email;
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
}
