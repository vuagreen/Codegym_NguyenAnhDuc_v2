package com.codegym.demo.Service;

import com.codegym.demo.model.HopDongChiTiet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface HopDongChiTietService {

    Page<HopDongChiTiet> findAll(Pageable pageable);

    Iterable<HopDongChiTiet> findAll();

    HopDongChiTiet findById(Long id);

    void save(HopDongChiTiet customer);

    void remove(Long id);

    Page<HopDongChiTiet> findAllByFirstNameContaining(String firstname, Pageable pageable);
}
