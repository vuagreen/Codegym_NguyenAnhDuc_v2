package com.codegym.demo.Repository;

import com.codegym.demo.Model.PasswordResetCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface PasswordResetCodeRepository extends JpaRepository<PasswordResetCode,Long> {
}
