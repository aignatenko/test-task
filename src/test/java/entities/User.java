package entities;

import entities.enums.GenderTitle;
import utils.DataGenerator;

public final class User {

    private String email;
    private GenderTitle title;
    private String firstName;
    private String lastName;
    private String password;
    private Address address;

    public User(String email, GenderTitle title, String firstName, String lastName, String password, Address address) {
        this.email = email;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.address = address;
    }

    public static User getRandomUser() {
        return new User(DataGenerator.randomEmail(), GenderTitle.MR, DataGenerator.randomString(5),
                DataGenerator.randomString(5), "P@s$w()rd1", Address.DEFAULT);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public GenderTitle getTitle() {
        return title;
    }

    public void setTitle(GenderTitle title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
