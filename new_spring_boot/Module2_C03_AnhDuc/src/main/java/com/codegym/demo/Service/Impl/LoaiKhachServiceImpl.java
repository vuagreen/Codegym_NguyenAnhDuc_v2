package com.codegym.demo.Service.Impl;

import com.codegym.demo.Repository.LoaiKhachRepository;
import com.codegym.demo.Service.LoaiKhachService;
import com.codegym.demo.model.LoaiKhach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LoaiKhachServiceImpl implements LoaiKhachService {
    @Autowired
 private  LoaiKhachRepository loaiKhachRepository;

    @Override
    public Page<LoaiKhach> findAll(Pageable pageable) {
        return loaiKhachRepository.findAll(pageable);
    }

    @Override
    public Iterable<LoaiKhach> findAll() {
        return loaiKhachRepository.findAll();
    }

    @Override
    public LoaiKhach findById(Long id) {
        return loaiKhachRepository.findById(id).orElse(null) ;
    }

    @Override
    public void save(LoaiKhach loaiKhach) {
        loaiKhachRepository.save(loaiKhach);

    }

    @Override
    public void remove(Long id) {
        loaiKhachRepository.deleteById(id);
    }

    @Override
    public Page<LoaiKhach> findAllByFirstNameContaining(String firstname, Pageable pageable) {
        return null;
    }
}
