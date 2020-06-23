package com.codegym.demo.Service;

import com.codegym.demo.model.ViTri;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ViTriService {

    Page<ViTri> findAll(Pageable pageable);

    Iterable<ViTri> findAll();

    ViTri findById(Long id);

    void save(ViTri viTri);

    void remove(Long id);

    Page<ViTri> findAllByFirstNameContaining(String firstname, Pageable pageable);
}
