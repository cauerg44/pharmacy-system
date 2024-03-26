package com.project.dev.controllers;

import com.project.dev.dto.RemedyDTO;
import com.project.dev.services.RemedyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
