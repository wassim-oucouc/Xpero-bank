package model;


import java.util.UUID;



public class User {


    private UUID id;
    private String fullName;
    private  String  email;
    private String password;
    private String address;

    public  User(String fullname,String email,String address,String password)
    {
        this.id = UUID.randomUUID();
        this.fullName = fullname;
        this.email = email;
        this.password = password;
        this.address = address;
    }
    public User()
    {

    }

    public String getFullName() {
        return fullName;
    }

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
