package com.project.dev.controllers;

import com.project.dev.dto.ManufacturerDTO;
import com.project.dev.services.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/manufacturers")
public class ManufacturerController {

    @Autowired
    private ManufacturerService manufacturerService;

    @GetMapping
    public ResponseEntity<List<ManufacturerDTO>> findAll() {
        List<ManufacturerDTO> list = manufacturerService.findAll();
        return ResponseEntity.ok(list);
    }
}
