package com.codegyme.demo_springboot_mysql.service;

import com.codegyme.demo_springboot_mysql.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    Customer findById(String id);

    void save(Customer customer);



    void delete(String id);

}
