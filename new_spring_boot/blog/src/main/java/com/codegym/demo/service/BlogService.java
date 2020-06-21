package com.codegym.demo.service;

import com.codegym.demo.model.Blog;

import java.util.List;
import java.util.Optional;

public interface BlogService{
    List<Blog> findAll();

    void saveUser(Blog blog);

    void deleteUser(Long id);

    Optional<Blog> findByBlogId(Long id);
}
