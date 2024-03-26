package com.project.dev.services;

import com.project.dev.dto.ManufacturerDTO;
import com.project.dev.entities.Manufacturer;
import com.project.dev.repositories.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ManufacturerService {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Transactional(readOnly = true)
    public List<ManufacturerDTO> findAll() {
        List<Manufacturer> result = manufacturerRepository.findAll();
        return result.stream().map(x -> new ManufacturerDTO(x)).toList();
    }
}
