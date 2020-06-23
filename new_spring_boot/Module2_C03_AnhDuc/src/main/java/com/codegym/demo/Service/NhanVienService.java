package com.codegym.demo.Service;

import com.codegym.demo.model.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NhanVienService {

    Page<NhanVien> findAll(Pageable pageable);

    Iterable<NhanVien> findAll();

    NhanVien findById(Long id);

    void save(NhanVien nhanVien);

    void remove(Long id);


    Page<NhanVien> findAllByFirstNameContaining(String firstname, Pageable pageable);
}
