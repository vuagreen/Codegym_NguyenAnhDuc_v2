package com.codegym.demo_validation_formlogin.Service;

import com.codegym.demo_validation_formlogin.Model.User;

public interface UserService {
    Iterable<User> findAll();

    void save(User user);
}
