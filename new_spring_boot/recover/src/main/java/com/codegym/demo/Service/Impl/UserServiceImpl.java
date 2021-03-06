package com.codegym.demo.Service.Impl;

import com.codegym.demo.Model.User;
import com.codegym.demo.Repository.UserRepository;
import com.codegym.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void remove(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Boolean checkInfo(User user1, User user2) {
        if (user1.getPhoneNumber().equals(user2) && user1.getQuestion().equals(user2.getQuestion()) && user1.getAnswer().equals(user2.getAnswer())) {
            return true;
        }
        return false;
    }
}
