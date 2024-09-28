package me.kimheeyoung.webserverminiproject.entity;

import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private Long password;
    private int numOfBooks;

    // constructor
    public User() {

    }

    public User(Long id, String username, Long password, int numOfBooks) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.numOfBooks = numOfBooks;
    }

    // getter
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Long getPassword() {
        return password;
    }

    public int getNumOfBooks() {return numOfBooks;}

    // setter
    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(Long password) {
        this.password = password;
    }

    public void setNumOfBooks(int numOfBooks) {this.numOfBooks = numOfBooks;}
}
