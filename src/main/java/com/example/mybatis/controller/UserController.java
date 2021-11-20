package com.example.mybatis.controller;

import com.example.mybatis.dto.User;
import com.example.mybatis.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("users")
    public List<User> users() {
        return userService.findAll();
    }

    @GetMapping("user/{id}")
    public User user(@PathVariable int id) {
        return userService.findById(id);
    }

    @PostMapping("user")
    public boolean user(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("user/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public boolean user(@PathVariable int id, @RequestParam String name) {
        return userService.update(id, name);
    }
}
