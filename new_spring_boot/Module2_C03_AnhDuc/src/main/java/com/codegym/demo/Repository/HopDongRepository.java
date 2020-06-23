package com.codegym.demo.Repository;

import com.codegym.demo.model.HopDong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HopDongRepository extends JpaRepository<HopDong,Long> {
}
