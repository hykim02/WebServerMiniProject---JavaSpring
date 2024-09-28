package me.kimheeyoung.webserverminiproject.service;

import me.kimheeyoung.webserverminiproject.entity.User;
import me.kimheeyoung.webserverminiproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean isUserExist(Long password) {
        return userRepository.findByPassword(password).isPresent();
    }

    public void registerUser(User user) {
        userRepository.save(user);
    }
}
