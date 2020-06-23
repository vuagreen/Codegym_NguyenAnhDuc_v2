package com.codegym.demo.Service.Impl;

import com.codegym.demo.Repository.KhachHangRepository;
import com.codegym.demo.Service.KhachHangService;
import com.codegym.demo.model.KhachHang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class KhachHangServiceImpl implements KhachHangService {
    @Autowired
   private KhachHangRepository khachHangRepository;

    @Override
    public Page<KhachHang> findAll(Pageable pageable) {
        return khachHangRepository.findAll(pageable);
    }

    @Override
    public Iterable<KhachHang> findAll() {
        return khachHangRepository.findAll();
    }

    @Override
    public KhachHang findById(Long id) {
        return khachHangRepository.findById(id).orElse(null);
    }

    @Override
    public void save(KhachHang khachHang) {
        khachHangRepository.save(khachHang);
    }

    @Override
    public void remove(Long id) {
        khachHangRepository.deleteById(id);
    }

    @Override
    public Page<KhachHang> findAllByFirstNameContaining(String firstname, Pageable pageable) {
        return null;
    }
}
