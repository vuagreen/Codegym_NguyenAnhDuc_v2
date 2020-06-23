package com.codegym.demo.Repository;

import com.codegym.demo.model.TrinhDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrinhDoRepository extends JpaRepository<TrinhDo, Long> {

}
