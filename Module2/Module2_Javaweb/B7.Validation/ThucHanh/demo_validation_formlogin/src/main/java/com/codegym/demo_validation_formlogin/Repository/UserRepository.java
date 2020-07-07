package com.codegym.demo_validation_formlogin.Repository;

import com.codegym.demo_validation_formlogin.Model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
