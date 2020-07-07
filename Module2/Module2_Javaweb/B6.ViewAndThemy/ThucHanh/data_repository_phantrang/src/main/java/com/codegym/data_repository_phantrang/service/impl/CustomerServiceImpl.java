package com.codegym.data_repository_phantrang.service.impl;

import com.codegym.data_repository_phantrang.model.Customer;
import com.codegym.data_repository_phantrang.model.Province;
import com.codegym.data_repository_phantrang.repository.CustomerRepository;
import com.codegym.data_repository_phantrang.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
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
    public Page<Customer> findAllByProvince(Province province) {
        return (Page<Customer>) customerRepository.findAllByProvince(province);
    }

    @Override
    public Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable) {
        return customerRepository.findAllByFirstNameContaining(firstname,pageable);
    }


}
