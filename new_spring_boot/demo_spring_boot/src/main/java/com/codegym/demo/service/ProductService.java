package com.codegym.demo.service;

import com.codegym.demo.model.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ProductService {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void remove(int id);
}
