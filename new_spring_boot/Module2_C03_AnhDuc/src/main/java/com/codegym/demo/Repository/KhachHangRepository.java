package com.codegym.demo.Repository;

import com.codegym.demo.model.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang,Long> {
}
