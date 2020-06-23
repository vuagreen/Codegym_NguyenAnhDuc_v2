package com.codegym.demo.Service;

import com.codegym.demo.model.User;
import com.codegym.demo.model.ViTri;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    Page<User> findAll(Pageable pageable);

    Iterable<User> findAll();

    User findById(Long id);

    void save(User user);

    void remove(Long id);

    Page<User> findAllByFirstNameContaining(String firstname, Pageable pageable);
}
