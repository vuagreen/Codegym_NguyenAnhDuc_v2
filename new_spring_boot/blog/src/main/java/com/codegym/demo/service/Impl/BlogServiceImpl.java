package com.codegym.demo.service.Impl;

import com.codegym.demo.model.Blog;
import com.codegym.demo.repository.BlogRepository;
import com.codegym.demo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;
    @Override
    public List<Blog> findAll() {
        return (List<Blog>)blogRepository.findAll();
    }

    @Override
    public void saveUser(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void deleteUser(Long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Optional<Blog> findByBlogId(Long id) {
        return blogRepository.findById(id);
    }
}
