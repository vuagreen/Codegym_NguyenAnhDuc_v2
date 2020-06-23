package com.codegym.demo.Service;

import com.codegym.demo.Repository.UserRepository;
import com.codegym.demo.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();

    void saveUser(User user);

    void deleteUser(Long id);

    Optional<User> findByUserId(Long id);
}
