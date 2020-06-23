package com.codegym.demo.Service.Impl;

import com.codegym.demo.Repository.KieuThueRepository;
import com.codegym.demo.Service.KieuThueService;
import com.codegym.demo.model.KieuThue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class KieuThueServiceImpl implements KieuThueService {
    @Autowired
    private KieuThueRepository kieuThueRepository;

    @Override
    public Page<KieuThue> findAll(Pageable pageable) {
        return kieuThueRepository.findAll(pageable);
    }

    @Override
    public Iterable<KieuThue> findAll() {
        return kieuThueRepository.findAll();
    }

    @Override
    public KieuThue findById(Long id) {
        return kieuThueRepository.findById(id).orElse(null);
    }

    @Override
    public void save(KieuThue kieuThue) {
        kieuThueRepository.save(kieuThue);
    }

    @Override
    public void remove(Long id) {
        kieuThueRepository.deleteById(id);
    }

    @Override
    public Page<KieuThue> findAllByFirstNameContaining(String firstname, Pageable pageable) {
        return null;
    }
}
