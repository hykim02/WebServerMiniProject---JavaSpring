package me.kimheeyoung.webserverminiproject.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDate rentalDate;
    private LocalDate dueDate;
    private boolean returned;

    // constructor
    public Rental() {

    }

    public Rental(Long id, Book book, User user, LocalDate rentalDate, LocalDate dueDate, boolean returned) {
        this.id = id;
        this.book = book;
        this.user = user;
        this.rentalDate = rentalDate;
        this.dueDate = dueDate;
        this.returned = returned;
    }

    // getter
    public Long getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public User getUser() {
        return user;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public boolean isReturned() {
        return returned;
    }

    // setter
    public void setId(Long id) {
        this.id = id;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setRentalDate(LocalDate rentalDate) {
        this.rentalDate = rentalDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }
}
