package me.kimheeyoung.webserverminiproject.controller;


import me.kimheeyoung.webserverminiproject.entity.Rental;
import me.kimheeyoung.webserverminiproject.entity.User;
import me.kimheeyoung.webserverminiproject.entity.Book;
import me.kimheeyoung.webserverminiproject.repository.BookRepository;
import me.kimheeyoung.webserverminiproject.repository.RentalRepository;
import me.kimheeyoung.webserverminiproject.repository.UserRepository;
import me.kimheeyoung.webserverminiproject.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rentals")
public class RentalController {

    @Autowired
    private RentalService rentalService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private RentalRepository rentalRepository;

    // 책 대여 요청 처리
    @PostMapping("/rent")
    public Rental rentBook(@RequestParam Long userId, @RequestParam Long bookId) {
        // User & Book을 db에서 조회
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID: " + userId));

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book ID: " + bookId));

        // RentalService를 통해 책 대여
        return rentalService.rentBook(user, book);
    }

    // 책 반납 요청 처리
    @PostMapping("/return")
    public void returnBook(@RequestParam Long rentalId) {
        // Rental을 db에서 조회
        Rental rental = rentalRepository.findById(rentalId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid rental ID: " + rentalId));

        // RentalService를 통해 책 반납
        rentalService.returnBook(rental);
    }
}
