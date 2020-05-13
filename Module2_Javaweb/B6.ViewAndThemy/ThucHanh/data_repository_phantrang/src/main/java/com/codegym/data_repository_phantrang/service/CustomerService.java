package com.codegym.data_repository_phantrang.service;

import com.codegym.data_repository_phantrang.model.Customer;
import com.codegym.data_repository_phantrang.model.Province;

import java.util.List;

public interface CustomerService {
    Iterable<Customer> findAll();

    Customer findById(Long id);

    void save(Customer customer);

    void remove(Long id);

    Iterable<Customer> findAllByProvince(Province province);
}