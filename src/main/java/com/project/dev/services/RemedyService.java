package com.project.dev.services;

import com.project.dev.dto.RemedyDTO;
import com.project.dev.dto.RemedyDetailsDTO;
import com.project.dev.entities.Manufacturer;
import com.project.dev.entities.Remedy;
import com.project.dev.repositories.ManufacturerRepository;
import com.project.dev.repositories.RemedyRepository;
import com.project.dev.services.exceptions.DatabaseException;
import com.project.dev.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class RemedyService {

    @Autowired
    private RemedyRepository remedyRepository;

    @Autowired
    private ManufacturerRepository  manufacturerRepository;

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

    @Transactional
    public RemedyDTO insert(RemedyDTO dto) {
        Remedy remedy = new Remedy();
        copyDtotoEntity(dto, remedy);
        remedy = remedyRepository.save(remedy);
        return new RemedyDTO(remedy);
    }

    @Transactional
    public RemedyDTO update(Long id, RemedyDTO dto) {
        try {
            Remedy obj = remedyRepository.getReferenceById(id);
            copyDtotoEntity(dto, obj);
            obj = remedyRepository.save(obj);
            return new RemedyDTO(obj);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Resource not found.");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!remedyRepository.existsById(id)) {
            throw new ResourceNotFoundException("Resource not found.");
        }
        try {
            remedyRepository.deleteById(id);
        }
        catch(DataIntegrityViolationException e) {
            throw new DatabaseException("Fail in integrity violation.");
        }
    }

    private void copyDtotoEntity(RemedyDTO dto, Remedy entity) {
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        entity.setWarningLabel(dto.getWarningLabel());
        entity.setDescription(dto.getDescription());

        Long manufacturerId = dto.getManufacturer().getId();
        Manufacturer manufacturer = manufacturerRepository.findById(manufacturerId)
                .orElseThrow(() -> new ResourceNotFoundException("Manufacturer not found with ID"));
        entity.setManufacturer(manufacturer);
    }
}
