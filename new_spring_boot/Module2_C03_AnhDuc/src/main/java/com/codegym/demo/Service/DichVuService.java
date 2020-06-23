package com.codegym.demo.Service;

import com.codegym.demo.model.DichVu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DichVuService {

    Page<DichVu> findAll(Pageable pageable);

    Iterable<DichVu> findAll();

    DichVu findById(Long id);

    void save(DichVu dichVu);

    void remove(Long id);


    Page<DichVu> findAllByFirstNameContaining(String firstname, Pageable pageable);
}
