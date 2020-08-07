package com.codegym.demo.Repository;

import com.codegym.demo.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    public User findByEmail(String email);
}
