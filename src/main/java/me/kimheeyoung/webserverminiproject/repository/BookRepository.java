package me.kimheeyoung.webserverminiproject.repository;

import me.kimheeyoung.webserverminiproject.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleContaining(String title);
    List<Book> findByAuthorContaining(String title);
    Book findByTitle(String title);
    Long findIdByTitle(String title);
}
