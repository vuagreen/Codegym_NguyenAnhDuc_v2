package com.codegym.demo.Service;

import com.codegym.demo.model.LoaiDichVu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LoaiDichVuService {

    Page<LoaiDichVu> findAll(Pageable pageable);

    Iterable<LoaiDichVu> findAll();

    LoaiDichVu findById(Long id);

    void save(LoaiDichVu loaiDichVu);

    void remove(Long id);

    Page<LoaiDichVu> findAllByFirstNameContaining(String firstname, Pageable pageable);
}
