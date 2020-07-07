package com.codegym.demo.Service.Impl;

import com.codegym.demo.Service.CustomerService;
import com.codegym.demo.model.Customer;
import com.codegym.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Page<Customer> findAll() {
        return (Page<Customer>) customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }
    @Override
    public Page<Customer> findAllByName(String name, Pageable pageable) {
        return customerRepository.findAllByName(name,pageable);
    }

    @Override
    public Page<Customer> findAllByCodeCustomer(String code, Pageable pageable) {
        return customerRepository.findAllByCodeCustomer(code,pageable);
    }

}
