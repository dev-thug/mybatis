package com.example.mybatis.service;

import com.example.mybatis.dto.User;
import com.example.mybatis.model.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    public List<User> findAll() {
        return userMapper.findAll();
    }

    public User findById(int id) {
        return userMapper.findById(id);
    }

    public boolean save(User user) {
        return userMapper.save(user);
    }

    public boolean update(int id, String name) {
        return userMapper.update(id, name);
    }

}
