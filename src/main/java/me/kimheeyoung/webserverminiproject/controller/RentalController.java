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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    // 책 대여 요청 처리
    @PostMapping("/rent")
    public Rental rentBook(@RequestParam(name = "password") Long password,
                           @RequestParam(name = "title") String title) {
        logger.info("RentalController.rentBook");

        logger.info("password: " + password);
        logger.info("title: " + title);

//        Long userId = userRepository.findIdByPassword(password);
//        Long bookId = bookRepository.findIdByTitle(title);
//        logger.info("userId:", userId);
//        logger.info("bookId:", bookId);

        // User와 Book을 데이터베이스에서 조회
//        User user = userRepository.findById(userId)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID: " + userId));
        User user = userRepository.findByPassword(password)
                .orElseThrow(() -> new IllegalArgumentException("등록되지 않은 사용자입니다."));

//        Book book = bookRepository.findById(bookId)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid book ID: " + bookId));
        Book book = bookRepository.findByTitle(title);

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
