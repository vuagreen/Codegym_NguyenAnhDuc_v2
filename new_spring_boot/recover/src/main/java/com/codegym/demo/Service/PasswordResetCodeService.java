package com.codegym.demo.Service;

import com.codegym.demo.Model.PasswordResetCode;

public interface PasswordResetCodeService {

    PasswordResetCode findById(Long id);

    void save(PasswordResetCode passwordResetCode);

    void remove(Long id);
}
