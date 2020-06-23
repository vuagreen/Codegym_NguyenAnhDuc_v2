package com.codegym.demo.Service.Impl;

import com.codegym.demo.Repository.TrinhDoRepository;
import com.codegym.demo.Service.TrinhDoService;
import com.codegym.demo.model.TrinhDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TrinhDoServiceImpl implements TrinhDoService {
    @Autowired
    private TrinhDoRepository trinhDoRepository;

    @Override
    public Page<TrinhDo> findAll(Pageable pageable) {
        return trinhDoRepository.findAll(pageable);
    }

    @Override
    public Iterable<TrinhDo> findAll() {
        return trinhDoRepository.findAll();
    }

    @Override
    public TrinhDo findById(Long id) {
        return trinhDoRepository.findById(id).orElse(null);
    }

    @Override
    public void save(TrinhDo trinhDo) {
        trinhDoRepository.save(trinhDo);
    }

    @Override
    public void remove(Long id) {
        trinhDoRepository.deleteById(id);
    }

    @Override
    public Page<TrinhDo> findAllByFirstNameContaining(String firstname, Pageable pageable) {
        return null;
    }
}
