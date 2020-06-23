package com.codegym.demo.Service;

import com.codegym.demo.model.DichVu;
import com.codegym.demo.model.HopDong;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface HopDongService {
    Page<HopDong> findAll(Pageable pageable);

    Iterable<HopDong> findAll();

    HopDong findById(Long id);

    void save(HopDong hopDong);

    void remove(Long id);


    Page<HopDong> findAllByFirstNameContaining(String firstname, Pageable pageable);
}
