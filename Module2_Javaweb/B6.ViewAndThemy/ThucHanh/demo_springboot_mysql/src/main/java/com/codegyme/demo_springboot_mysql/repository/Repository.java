package com.codegyme.demo_springboot_mysql.repository;

import java.util.List;

public interface Repository<T> {
    List<T> findAll();

    T findById(String id);

    void save(T model);


    void delete(String id);

}
