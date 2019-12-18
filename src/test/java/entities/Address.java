package entities;

import entities.enums.Country;
import entities.enums.State;
import utils.DataGenerator;

public final class Address {
    public static final Address DEFAULT = new Address(DataGenerator.randomString(5), DataGenerator.randomString(5), DataGenerator.randomString(9),
            "Homer", State.ALASKA, "99603", Country.UNITED_STATES, "+234234234", "address alias");
    private String firstName;
    private String lastName;
    private String address1;
    private String city;
    private State state;
    private String zip;
    private Country country;
    private String mobile;
    private String addressAlias;

    public Address(String firstName, String lastName, String address1,
                   String city, State state, String zip,
                   Country country, String mobile, String addressAlias) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address1 = address1;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zip = zip;
        this.mobile = mobile;
        this.addressAlias = addressAlias;
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

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddressAlias() {
        return addressAlias;
    }

    public void setAddressAlias(String address) {
        this.addressAlias = address;
    }
}
