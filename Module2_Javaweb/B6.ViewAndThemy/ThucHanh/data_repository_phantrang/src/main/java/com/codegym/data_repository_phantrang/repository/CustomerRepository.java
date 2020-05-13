package com.codegym.data_repository_phantrang.repository;

import com.codegym.data_repository_phantrang.model.Customer;
import com.codegym.data_repository_phantrang.model.Province;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    Iterable<Customer> findAllByProvince(Province province);
}
