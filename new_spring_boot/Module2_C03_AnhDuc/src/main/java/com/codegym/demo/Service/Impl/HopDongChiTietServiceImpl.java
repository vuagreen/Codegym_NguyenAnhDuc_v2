package com.codegym.demo.Service.Impl;

import com.codegym.demo.Repository.HopDongChiTietRepository;
import com.codegym.demo.Repository.HopDongRepository;
import com.codegym.demo.Service.HopDongChiTietService;
import com.codegym.demo.model.HopDongChiTiet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class HopDongChiTietServiceImpl implements HopDongChiTietService {
    @Autowired
  private   HopDongChiTietRepository hopDongChiTietRepository;

    @Override
    public Page<HopDongChiTiet> findAll(Pageable pageable) {
        return hopDongChiTietRepository.findAll(pageable);
    }

    @Override
    public Iterable<HopDongChiTiet> findAll() {
        return hopDongChiTietRepository.findAll();
    }

    @Override
    public HopDongChiTiet findById(Long id) {
        return hopDongChiTietRepository.findById(id).orElse(null);
    }

    @Override
    public void save(HopDongChiTiet customer) {
        hopDongChiTietRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        hopDongChiTietRepository.deleteById(id);
    }

    @Override
    public Page<HopDongChiTiet> findAllByFirstNameContaining(String firstname, Pageable pageable) {
        return null;
    }
}
