package com.codegym.demo.Service;

import com.codegym.demo.model.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface KhachHangService {

    Page<KhachHang> findAll(Pageable pageable);

    Iterable<KhachHang> findAll();

    KhachHang findById(Long id);

    void save(KhachHang khachHang);

    void remove(Long id);

    Page<KhachHang> findAllByFirstNameContaining(String firstname, Pageable pageable);
}
