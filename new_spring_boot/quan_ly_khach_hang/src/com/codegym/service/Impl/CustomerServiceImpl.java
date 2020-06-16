package com.codegym.service.Impl;

import com.codegym.model.Customer;
import com.codegym.service.CustomerService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements CustomerService {
    public static Map<Integer, Customer> customerMap;

    static {
        customerMap = new HashMap<>();
        customerMap.put(1, new Customer(1, "Minh", "Minh@gmail.com", "VN"));
        customerMap.put(2, new Customer(2, "Hưng", "hung@gmail.com", "VN"));
        customerMap.put(3, new Customer(3, "Phan", "phan@gmail.com", "VN"));
        customerMap.put(4, new Customer(4, "Kim", "kim@gmail.com", "KR"));
        customerMap.put(5, new Customer(5, "Huyền", "huyen@gmail.com", "VN"));
        customerMap.put(6, new Customer(6, "White", "white@gmail.com", "US"));
    }

    @Override

    public List<Customer> findAll() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public void save(Customer customer) {
        customerMap.put(customer.getId(), customer);
    }

    @Override
    public Customer findById(int id) {
        return customerMap.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customerMap.put(id, customer);
    }

    @Override
    public void remove(int id) {
        customerMap.remove(id);
    }
}
