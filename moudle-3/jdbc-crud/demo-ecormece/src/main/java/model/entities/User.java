package model.entities;

import javax.swing.*;

public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String country;

    public User() {}

    public User(String username, String password, String email, String country) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.country = country;
    }

    public User(int id, String username, String password, String email, String country) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.country = country;
    }

    // Getters và Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
}