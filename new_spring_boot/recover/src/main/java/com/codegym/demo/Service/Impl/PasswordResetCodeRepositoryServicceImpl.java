package com.codegym.demo.Service.Impl;

import com.codegym.demo.Model.PasswordResetCode;

import com.codegym.demo.Repository.PasswordResetCodeRepository;
import com.codegym.demo.Service.PasswordResetCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PasswordResetCodeRepositoryServicceImpl implements PasswordResetCodeService {

    @Autowired
    PasswordResetCodeRepository passwordResetCodeRepository;

    @Override
    public PasswordResetCode findById(Long id) {
        return passwordResetCodeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(PasswordResetCode passwordResetCode) {
        passwordResetCodeRepository.save(passwordResetCode);
    }

    @Override
    public void remove(Long id) {
        passwordResetCodeRepository.deleteById(id);
    }
}
