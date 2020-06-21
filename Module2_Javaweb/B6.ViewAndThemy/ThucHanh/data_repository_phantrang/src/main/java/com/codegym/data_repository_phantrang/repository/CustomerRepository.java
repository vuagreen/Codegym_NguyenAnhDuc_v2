package com.codegym.data_repository_phantrang.repository;

import com.codegym.data_repository_phantrang.model.Customer;
import com.codegym.data_repository_phantrang.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

    Page<Customer> findAllByFirstNameContaining(String firstName, Pageable pageable);

    Iterable<Customer> findAllByProvince(Province province);
}
