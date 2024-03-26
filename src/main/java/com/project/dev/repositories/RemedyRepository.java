package com.project.dev.repositories;

import com.project.dev.entities.Remedy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RemedyRepository extends JpaRepository<Remedy, Long> {
}
