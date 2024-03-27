package com.project.dev.dto;

import com.project.dev.entities.Remedy;
import com.project.dev.entities.enums.WarningLabel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class RemedyDTO {

    private Long id;

    @NotBlank
    private String name;
    private WarningLabel warningLabel;

    @Positive(message = "Price must be positive")
    private Double price;
    private String description;
    private ManufacturerDTO manufacturer;

    public RemedyDTO() {
    }

    public RemedyDTO(Long id, String name, WarningLabel warningLabel, Double price, String description, ManufacturerDTO manufacturerDTO) {
        this.id = id;
        this.name = name;
        this.warningLabel = warningLabel;
        this.price = price;
        this.description = description;
        this.manufacturer = manufacturerDTO;
    }

    public RemedyDTO(Remedy obj) {
        id = obj.getId();
        name = obj.getName();
        warningLabel = obj.getWarningLabel();
        price = obj.getPrice();
        description = obj.getDescription();
        if (obj.getManufacturer() != null) {
            manufacturer = new ManufacturerDTO(obj.getManufacturer());
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public WarningLabel getWarningLabel() {
        return warningLabel;
    }

    public Double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public ManufacturerDTO getManufacturer() {
        return manufacturer;
    }
}
