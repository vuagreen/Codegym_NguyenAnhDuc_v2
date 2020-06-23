package com.codegym.demo.Service.Impl;

import com.codegym.demo.Repository.LoaiDichVuRepository;
import com.codegym.demo.Service.LoaiDichVuService;
import com.codegym.demo.model.LoaiDichVu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LoaiDichVuServiceImpl implements LoaiDichVuService {
    @Autowired
   private LoaiDichVuRepository loaiDichVuRepository;

    @Override
    public Page<LoaiDichVu> findAll(Pageable pageable) {
        return loaiDichVuRepository.findAll(pageable);
    }

    @Override
    public Iterable<LoaiDichVu> findAll() {
        return loaiDichVuRepository.findAll();
    }

    @Override
    public LoaiDichVu findById(Long id) {
        return loaiDichVuRepository.findById(id).orElse(null);
    }

    @Override
    public void save(LoaiDichVu loaiDichVu) {
        loaiDichVuRepository.save(loaiDichVu);
    }

    @Override
    public void remove(Long id) {
        loaiDichVuRepository.deleteById(id);
    }

    @Override
    public Page<LoaiDichVu> findAllByFirstNameContaining(String firstname, Pageable pageable) {
        return null;
    }
}
