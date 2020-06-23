package com.codegym.demo.Repository;

import com.codegym.demo.model.HopDongChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HopDongChiTietRepository extends JpaRepository<HopDongChiTiet,Long> {
}
