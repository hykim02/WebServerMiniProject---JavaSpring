package me.kimheeyoung.webserverminiproject.repository;

import me.kimheeyoung.webserverminiproject.entity.Rental;
import me.kimheeyoung.webserverminiproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Long> {
}
