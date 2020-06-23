package com.codegym.demo.Repository;

import com.codegym.demo.model.LoaiKhach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiKhachRepository extends JpaRepository<LoaiKhach,Long> {
}
