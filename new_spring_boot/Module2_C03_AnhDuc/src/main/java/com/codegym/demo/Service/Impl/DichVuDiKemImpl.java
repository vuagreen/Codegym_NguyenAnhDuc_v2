package com.codegym.demo.Service.Impl;

import com.codegym.demo.Repository.DichVuDiKemRepository;
import com.codegym.demo.Service.DichVuDiKemServicce;
import com.codegym.demo.model.DichVuDiKem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DichVuDiKemImpl implements DichVuDiKemServicce {
    @Autowired
    private DichVuDiKemRepository dichVuDiKemRepository;

    @Override
    public Page<DichVuDiKem> findAll(Pageable pageable) {
        return dichVuDiKemRepository.findAll(pageable);
    }

    @Override
    public Iterable<DichVuDiKem> findAll() {
        return dichVuDiKemRepository.findAll();
    }

    @Override
    public DichVuDiKem findById(Long id) {
        return dichVuDiKemRepository.findById(id).orElse(null);
    }

    @Override
    public void save(DichVuDiKem dichVuDiKem) {
        dichVuDiKemRepository.save(dichVuDiKem);
    }

    @Override
    public void remove(Long id) {
        dichVuDiKemRepository.deleteById(id);
    }

    @Override
    public Page<DichVuDiKem> findAllByFirstNameContaining(String firstname, Pageable pageable) {
        return null;
    }
}
