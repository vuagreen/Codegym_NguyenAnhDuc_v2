package com.codegym.demo.Service;

import com.codegym.demo.model.DichVuDiKem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DichVuDiKemServicce {

    Page<DichVuDiKem> findAll(Pageable pageable);

    Iterable<DichVuDiKem> findAll();

    DichVuDiKem findById(Long id);

    void save(DichVuDiKem dichVuDiKem);

    void remove(Long id);

    Page<DichVuDiKem> findAllByFirstNameContaining(String firstname, Pageable pageable);
}
