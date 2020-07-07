package com.codegyme.demo_springboot_mysql.service.impl;

import com.codegyme.demo_springboot_mysql.model.Customer;
import com.codegyme.demo_springboot_mysql.repository.CustomerRepository;
import com.codegyme.demo_springboot_mysql.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(String id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) { customerRepository.save(customer); }

    @Override
    public void delete(String id) {
        customerRepository.delete(id);
    }
}
