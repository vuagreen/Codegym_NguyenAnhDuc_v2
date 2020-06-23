package com.codegym.demo.Service;

import com.codegym.demo.model.KieuThue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface KieuThueService {

    Page<KieuThue> findAll(Pageable pageable);

    Iterable<KieuThue> findAll();

    KieuThue findById(Long id);

    void save(KieuThue kieuThue);

    void remove(Long id);

    Page<KieuThue> findAllByFirstNameContaining(String firstname, Pageable pageable);
}
