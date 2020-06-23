package com.codegym.demo.Service;

import com.codegym.demo.model.TrinhDo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TrinhDoService {

    Page<TrinhDo> findAll(Pageable pageable);

    Iterable<TrinhDo> findAll();

    TrinhDo findById(Long id);

    void save(TrinhDo trinhDo);

    void remove(Long id);

    Page<TrinhDo> findAllByFirstNameContaining(String firstname, Pageable pageable);
}
