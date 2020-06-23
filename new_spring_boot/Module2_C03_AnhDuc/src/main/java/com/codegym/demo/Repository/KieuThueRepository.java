package com.codegym.demo.Repository;

import com.codegym.demo.model.KieuThue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KieuThueRepository extends JpaRepository<KieuThue,Long> {
}
