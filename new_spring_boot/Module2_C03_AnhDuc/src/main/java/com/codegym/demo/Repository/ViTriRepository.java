package com.codegym.demo.Repository;

import com.codegym.demo.model.ViTri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViTriRepository extends JpaRepository<ViTri,Long> {
}
