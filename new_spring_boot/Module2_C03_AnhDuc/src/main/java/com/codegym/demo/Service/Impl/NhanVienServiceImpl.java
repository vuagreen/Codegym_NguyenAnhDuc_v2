package com.codegym.demo.Service.Impl;

import com.codegym.demo.Repository.NhanVienRepository;
import com.codegym.demo.Service.NhanVienService;
import com.codegym.demo.model.NhanVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class NhanVienServiceImpl implements NhanVienService {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Override
    public Page<NhanVien> findAll(Pageable pageable) {
        return nhanVienRepository.findAll(pageable);
    }

    @Override
    public Iterable<NhanVien> findAll() {
        return nhanVienRepository.findAll();
    }

    @Override
    public NhanVien findById(Long id) {
        return nhanVienRepository.findById(id).orElse(null);
    }

    @Override
    public void save(NhanVien nhanVien) {
        nhanVienRepository.save(nhanVien);
    }

    @Override
    public void remove(Long id) {
        nhanVienRepository.deleteById(id);
    }

    @Override
    public Page<NhanVien> findAllByFirstNameContaining(String firstname, Pageable pageable) {
        return null;
    }
}
