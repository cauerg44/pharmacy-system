package com.project.dev.services;

import com.project.dev.dto.RemedyDTO;
import com.project.dev.dto.RemedyDetailsDTO;
import com.project.dev.entities.Remedy;
import com.project.dev.repositories.RemedyRepository;
import com.project.dev.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RemedyService {

    @Autowired
    private RemedyRepository remedyRepository;

    @Transactional(readOnly = true)
    public RemedyDTO findById(Long id) {
        Remedy obj = remedyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Remedy not found."));
        return new RemedyDTO(obj);
    }

    @Transactional(readOnly = true)
    public Page<RemedyDetailsDTO> findAllPaged(String name, Pageable pageable) {
        Page<Remedy> result = remedyRepository.searchByName(name, pageable);
        return result.map(x -> new RemedyDetailsDTO(x));
    }
}
