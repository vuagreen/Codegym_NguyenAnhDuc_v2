package com.codegym.demo.Repository;

import com.codegym.demo.model.LoaiDichVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiDichVuRepository extends JpaRepository<LoaiDichVu,Long> {
}
