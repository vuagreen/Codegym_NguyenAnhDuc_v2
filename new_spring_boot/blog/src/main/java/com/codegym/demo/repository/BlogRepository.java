package com.codegym.demo.repository;

import com.codegym.demo.model.Blog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface BlogRepository extends CrudRepository<Blog,Long> {
}
