package com.project.dev.repositories;

import com.project.dev.entities.StockRemedy;
import com.project.dev.entities.StockRemedyPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRemedyRepository extends JpaRepository<StockRemedy, StockRemedyPK> {
}
