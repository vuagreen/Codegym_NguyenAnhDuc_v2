package com.codegym.demo.Service.Impl;

import com.codegym.demo.Repository.BoPhanRepository;
import com.codegym.demo.Service.BoPhanService;
import com.codegym.demo.model.BoPhan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BoPhanServiceImpl implements BoPhanService {
    @Autowired
    private BoPhanRepository boPhanRepository;

    @Override
    public Page<BoPhan> findAll(Pageable pageable) {
        return boPhanRepository.findAll(pageable);
    }

    @Override
    public Iterable<BoPhan> findAll() {
        return boPhanRepository.findAll();
    }

    @Override
    public BoPhan findById(Long id) {
        return boPhanRepository.findById(id).orElse(null);
    }

    @Override
    public void save(BoPhan boPhan) {
        boPhanRepository.save(boPhan);
    }

    @Override
    public void remove(Long id) {
 boPhanRepository.deleteById(id);
    }

    @Override
    public Page<BoPhan> findAllByFirstNameContaining(String firstname, Pageable pageable) {
        return null;
    }
}
