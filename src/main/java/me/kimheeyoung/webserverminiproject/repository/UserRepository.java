package me.kimheeyoung.webserverminiproject.repository;

import me.kimheeyoung.webserverminiproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByPassword(Long password);

    // 사용자 ID만 반환하는 쿼리
    @Query("SELECT u.id FROM User u WHERE u.password = :password")
    Long findIdByPassword(@Param("password") Long password);
}
