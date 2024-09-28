package me.kimheeyoung.webserverminiproject.service;

import me.kimheeyoung.webserverminiproject.controller.UserController;
import me.kimheeyoung.webserverminiproject.entity.Book;
import me.kimheeyoung.webserverminiproject.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private BookRepository bookRepository;

    // 제목 or 저자로 책 검색
    public List<Book> searchBooks(String title) {
        List<Book> byTitle = bookRepository.findByTitleContaining(title);
        List<Book> byAuthor = bookRepository.findByAuthorContaining(title);

        // 제목으로 찾은 경우
        if (!byTitle.isEmpty()) {
            return byTitle;
        } else {
            return byAuthor;
        }
    }
}
