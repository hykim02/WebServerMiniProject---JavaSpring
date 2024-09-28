package me.kimheeyoung.webserverminiproject.entity;

import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private Boolean rentalCheck;

    // constructor
    public User() {

    }

    public User(Long id, String username, String password, Boolean rentalCheck) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.rentalCheck = rentalCheck;
    }

    // getter
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getRentalCheck() {return rentalCheck;}

    // setter
    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRentalCheck(Boolean rentalCheck) {this.rentalCheck = rentalCheck;}
}
