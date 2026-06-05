package com.gymtracker.controller;

import com.gymtracker.model.User;
import com.gymtracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody User user) {
        Map<String, Object> response = new HashMap<>();
        try {
            User saved = userService.register(user);
            response.put("success", true);
            response.put("userId", saved.getId());
            response.put("username", saved.getUsername());
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "Username already exists!");
        }
        return response;
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> body) {
        Map<String, Object> response = new HashMap<>();
        User user = userService.login(
                body.get("username"),
                body.get("password")
        );
        if (user != null) {
            response.put("success", true);
            response.put("userId", user.getId());
            response.put("username", user.getUsername());
        } else {
            response.put("success", false);
            response.put("message", "Invalid username or password!");
        }
        return response;
    }
}