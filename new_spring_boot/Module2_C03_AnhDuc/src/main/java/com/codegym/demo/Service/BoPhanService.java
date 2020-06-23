package com.codegym.demo.Service;

import com.codegym.demo.model.BoPhan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoPhanService {

    Page<BoPhan> findAll(Pageable pageable);

    Iterable<BoPhan> findAll();

    BoPhan findById(Long id);

    void save(BoPhan boPhan);

    void remove(Long id);

    Page<BoPhan> findAllByFirstNameContaining(String firstname, Pageable pageable);
}
