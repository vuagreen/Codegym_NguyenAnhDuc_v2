package com.codegym.springbootormblog.repository;

import com.codegym.springbootormblog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository <Blog,String>{

}
