package com.codegym.demo.Repository;

import com.codegym.demo.model.DichVuDiKem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DichVuDiKemRepository extends JpaRepository<DichVuDiKem,Long> {
}
