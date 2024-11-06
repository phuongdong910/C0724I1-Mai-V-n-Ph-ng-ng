package com.example.showlistcustomers;

public class Customer {
    private String name;
    private String birthdate;
    private String address;
    private String image;

    public Customer(String name, String birthdate, String address, String image) {
        this.name = name;
        this.birthdate = birthdate;
        this.address = address;
        this.image = image;
    }

    // Getters và setters...
    public String getName() { return name; }
    public String getBirthdate() { return birthdate; }
    public String getAddress() { return address; }
    public String getImage() { return image; }
}
