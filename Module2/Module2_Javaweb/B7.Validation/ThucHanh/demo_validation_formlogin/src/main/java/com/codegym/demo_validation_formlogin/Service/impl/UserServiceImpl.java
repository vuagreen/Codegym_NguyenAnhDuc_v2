package com.codegym.demo_validation_formlogin.Service.impl;

import com.codegym.demo_validation_formlogin.Model.User;
import com.codegym.demo_validation_formlogin.Repository.UserRepository;
import com.codegym.demo_validation_formlogin.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
