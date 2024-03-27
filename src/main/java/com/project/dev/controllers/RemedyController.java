package com.project.dev.controllers;

import com.project.dev.dto.RemedyDTO;
import com.project.dev.dto.RemedyDetailsDTO;
import com.project.dev.services.RemedyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

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

    @PostMapping
    public ResponseEntity<RemedyDTO> insert(@Valid @RequestBody RemedyDTO dto) {
        dto = remedyService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<RemedyDTO> update(@PathVariable Long id, @Valid @RequestBody RemedyDTO dto) {
        dto = remedyService.update(id, dto);
        return ResponseEntity.ok(dto);
    }
}
