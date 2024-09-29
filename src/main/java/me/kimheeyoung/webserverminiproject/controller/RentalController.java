package me.kimheeyoung.webserverminiproject.controller;


import me.kimheeyoung.webserverminiproject.entity.Rental;
import me.kimheeyoung.webserverminiproject.entity.User;
import me.kimheeyoung.webserverminiproject.entity.Book;
import me.kimheeyoung.webserverminiproject.repository.BookRepository;
import me.kimheeyoung.webserverminiproject.repository.RentalRepository;
import me.kimheeyoung.webserverminiproject.repository.UserRepository;
import me.kimheeyoung.webserverminiproject.service.RentalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rentals")
public class RentalController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private RentalService rentalService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private RentalRepository rentalRepository;

    // 책 대여 요청 api
    @PostMapping("/rent")
    public Rental rentBook(@RequestParam(name = "password") Long password,
                           @RequestParam(name = "title") String title) {
        logger.info("password: " + password);
        logger.info("title: " + title);

        User user = userRepository.findByPassword(password)
                .orElseThrow(() -> new IllegalArgumentException("등록되지 않은 사용자입니다."));

        Book book = bookRepository.findByTitle(title);

        // RentalService를 통해 책 대여
        return rentalService.rentBook(user, book);
    }

    // 대여한 책 조회 api
    @GetMapping("/search")
    public List<Rental> search(@RequestParam(name = "password") Long password) {
        logger.info("search");
        // User 테이블에서 userId 찾기
        Long userId = userRepository.findIdByPassword(password);
        List<Rental> rental = rentalRepository.findByUserId(userId);

        return rental;
    }

    // 책 반납 요청 api
    @PostMapping("/return")
    public User returnBook(@RequestParam(name = "rentalId") Long rentalId) {
        logger.info("returnBook");

        Rental rental = rentalRepository.findById(rentalId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid rental ID: " + rentalId));

        // RentalService를 통해 책 반납
        return rentalService.returnBook(rental);
    }
}
