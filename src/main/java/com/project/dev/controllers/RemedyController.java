package com.project.dev.controllers;

import com.project.dev.dto.RemedyDTO;
import com.project.dev.dto.RemedyDetailsDTO;
import com.project.dev.services.RemedyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/remedies")
public class RemedyController {

    @Autowired
    private RemedyService remedyService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<RemedyDTO> findById(@PathVariable Long id) {
        RemedyDTO dto = remedyService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<RemedyDetailsDTO>> findAll(@RequestParam(name = "name", defaultValue = "")String name, Pageable pageable) {
        Page<RemedyDetailsDTO> page = remedyService.findAllPaged(name, pageable);
        return ResponseEntity.ok(page);
    }
}
