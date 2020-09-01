package mypersoninterfaceproject;

public class AddressImpl implements AddressInterface {

    private int streetNumber;
    private String streetName;
    private String country;

    public AddressImpl(int streetNumber, String streetName, String country) {
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.country = country;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return this.streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
