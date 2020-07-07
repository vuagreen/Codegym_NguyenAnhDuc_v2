package com.codegym.springbootormblog.service;

import com.codegym.springbootormblog.model.Blog;

import java.util.List;

public interface BlogService {
    Iterable<Blog> findAll();

    Blog findById(String id);

    void save(Blog blog);

    void remove(String id);
}
