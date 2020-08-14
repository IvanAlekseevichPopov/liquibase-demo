package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    UserRepository userRepository;

    @Autowired
    public UserController(UserRepository repository) {
        this.userRepository = repository;
    }

    @GetMapping("users")
    public Iterable<User> hello() {
        return userRepository.findAll();
    }
}
