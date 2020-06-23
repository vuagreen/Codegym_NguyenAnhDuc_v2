package com.codegym.demo.Service;

import com.codegym.demo.model.LoaiKhach;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LoaiKhachService {

    Page<LoaiKhach> findAll(Pageable pageable);

    Iterable<LoaiKhach> findAll();

    LoaiKhach findById(Long id);

    void save(LoaiKhach loaiKhach);

    void remove(Long id);


    Page<LoaiKhach> findAllByFirstNameContaining(String firstname, Pageable pageable);
}
