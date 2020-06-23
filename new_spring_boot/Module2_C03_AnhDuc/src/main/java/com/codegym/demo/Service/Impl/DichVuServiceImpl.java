package com.codegym.demo.Service.Impl;

import com.codegym.demo.Repository.DichVuRepository;
import com.codegym.demo.Service.DichVuService;
import com.codegym.demo.model.DichVu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DichVuServiceImpl implements DichVuService {

    @Autowired
   private DichVuRepository dichVuRepository;

    @Override
    public Page<DichVu> findAll(Pageable pageable) {
        return dichVuRepository.findAll(pageable);
    }

    @Override
    public Iterable<DichVu> findAll() {
        return dichVuRepository.findAll();
    }

    @Override
    public DichVu findById(Long id) {
        return dichVuRepository.findById(id).orElse(null);
    }

    @Override
    public void save(DichVu dichVu) {
        dichVuRepository.save(dichVu);
    }

    @Override
    public void remove(Long id) {
        dichVuRepository.deleteById(id);
    }

    @Override
    public Page<DichVu> findAllByFirstNameContaining(String firstname, Pageable pageable) {
        return null;
    }
}
