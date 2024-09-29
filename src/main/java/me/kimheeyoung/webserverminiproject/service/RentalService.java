package me.kimheeyoung.webserverminiproject.service;

import me.kimheeyoung.webserverminiproject.entity.Book;
import me.kimheeyoung.webserverminiproject.entity.Rental;
import me.kimheeyoung.webserverminiproject.entity.User;
import me.kimheeyoung.webserverminiproject.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class RentalService {

    @Autowired
    private RentalRepository rentalRepository;

    // 책 대여 로직
    public Rental rentBook(User user, Book book) {
        // 대여 불가능한 경우 (대여한 책이 3권 이상일 경우)
        if (!book.isAvailable() || user.getNumOfBooks() >= 3) {
            throw new IllegalStateException("책 대여 불가능");
        }

        // 대여 가능한 경우
        Rental rental = new Rental();
        rental.setBook(book);
        rental.setUser(user);
        rental.setRentalDate(LocalDate.now());
        rental.setDueDate(LocalDate.now().plusWeeks(2));
        rental.setReturned(false);

        user.setNumOfBooks(user.getNumOfBooks() + 1);
        book.setAvailable(false); // 책 대여 상태 변경
        return rentalRepository.save(rental); // 대여 내역 저장
    }

    // 책 반납 로직
    public void returnBook(Rental rental) {
        rental.setReturned(true); // 책 반납 상태 변경
        rental.getBook().setAvailable(true); // 책 대여 상태 변경
        rentalRepository.save(rental); // 대여 내역 업데이트
    }
}
