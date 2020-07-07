package com.codegym.demo.Service;

import com.codegym.demo.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);

    Iterable<Customer> findAll();

    Customer findById(Long id);

    void save(Customer customer);

    void remove(Long id);
    Page<Customer> findAllByName(String name, Pageable pageable);
    Page<Customer> findAllByCodeCustomer(String code, Pageable pageable);
}
