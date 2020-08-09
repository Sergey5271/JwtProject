package com.app.demo.service;

import com.app.demo.model.User;

import java.util.List;

public interface UserService {
    User save(User user);

    List<User> getAll();

    User findByUsername(String email);

    User findById(Long id);

    void delete(Long userId);
}
