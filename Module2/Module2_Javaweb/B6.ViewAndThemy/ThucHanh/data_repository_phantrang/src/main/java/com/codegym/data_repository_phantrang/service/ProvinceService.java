package com.codegym.data_repository_phantrang.service;


import com.codegym.data_repository_phantrang.model.Province;

public interface ProvinceService {
    Iterable<Province> findAll();

    Province findById(Long id);

    void save(Province province);

    void remove(Long id);
}
