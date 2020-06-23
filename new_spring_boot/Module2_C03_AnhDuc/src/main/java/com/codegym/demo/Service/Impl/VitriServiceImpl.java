package com.codegym.demo.Service.Impl;

import com.codegym.demo.Repository.ViTriRepository;
import com.codegym.demo.Service.ViTriService;
import com.codegym.demo.model.ViTri;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class VitriServiceImpl implements ViTriService {
    @Autowired
    private ViTriRepository viTriRepository;

    @Override
    public Page<ViTri> findAll(Pageable pageable) {
        return viTriRepository.findAll(pageable);
    }

    @Override
    public Iterable<ViTri> findAll() {
        return viTriRepository.findAll();
    }

    @Override
    public ViTri findById(Long id) {
        return viTriRepository.findById(id).orElse(null);
    }

    @Override
    public void save(ViTri viTri) {
        viTriRepository.save(viTri);
    }

    @Override
    public void remove(Long id) {
        viTriRepository.deleteById(id);
    }

    @Override
    public Page<ViTri> findAllByFirstNameContaining(String firstname, Pageable pageable) {
        return null;
    }
}
