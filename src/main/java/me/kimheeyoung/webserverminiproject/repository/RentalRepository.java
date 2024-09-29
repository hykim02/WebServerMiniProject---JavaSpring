package me.kimheeyoung.webserverminiproject.repository;

import me.kimheeyoung.webserverminiproject.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RentalRepository extends JpaRepository<Rental, Long> {

    // user 필드에서 userId를 기반으로 Rental 정보를 모두 조회
    List<Rental> findByUserId(Long userId);
}
