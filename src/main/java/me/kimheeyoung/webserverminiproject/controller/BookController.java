package me.kimheeyoung.webserverminiproject.controller;


import me.kimheeyoung.webserverminiproject.entity.Book;
import me.kimheeyoung.webserverminiproject.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private BookService bookService;

    // 파라미터 이름 명시(인식 문제로)
    @GetMapping("/search")
    public List<Book> searchBooks(@RequestParam(name = "title") String title) {
        logger.info("title: {}", title);
        List<Book> books = bookService.searchBooks(title);
        return books;
    }
}
