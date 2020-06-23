package com.codegym.demo.Repository;

import com.codegym.demo.model.BoPhan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoPhanRepository extends JpaRepository<BoPhan,Long> {
}
