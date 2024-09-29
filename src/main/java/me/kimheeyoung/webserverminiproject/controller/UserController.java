package me.kimheeyoung.webserverminiproject.controller;

import me.kimheeyoung.webserverminiproject.entity.User;
import me.kimheeyoung.webserverminiproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/api/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    // 사용자 등록 api
    @PostMapping("/register")
    public ResponseEntity<Map<String, Boolean>> registerUser(@RequestBody User user) {
        boolean isExist = userService.isUserExist(user.getPassword());

        Map<String, Boolean> response = new HashMap<>();
        if (isExist) {
            response.put("registered", true);
        } else {
            userService.registerUser(user);
            response.put("registered", false);
        }

        return ResponseEntity.ok(response);
    }

    // 사용자 등록 여부 확인 api
    @PostMapping("/check")
    public Boolean registerUser(@RequestBody Long password) {
        boolean isExist = userService.isUserExist(password);

        if (isExist) {
            return true;
        } else {
            return false;
        }
    }
}
