package me.kimheeyoung.webserverminiproject.repository;

import me.kimheeyoung.webserverminiproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByPassword(Long password);
    Long findIdByPassword(Long password);
}
