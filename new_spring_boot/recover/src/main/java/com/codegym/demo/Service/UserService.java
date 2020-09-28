package com.codegym.demo.Service;

import com.codegym.demo.Model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(Long id);

    void save(User user);

    void remove(Long id);
    public User findByEmail(String email);

    Boolean checkInfo(User user1, User user2);
}
