package com.project.dev.repositories;

import com.project.dev.entities.Remedy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RemedyRepository extends JpaRepository<Remedy, Long> {

    @Query("SELECT obj FROM Remedy obj " +
            "WHERE UPPER(obj.name) LIKE UPPER(CONCAT('%', :name, '%'))")
    Page<Remedy> searchByName(String name, Pageable pageable);
}
