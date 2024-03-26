package com.project.dev.dto;

import com.project.dev.entities.Remedy;
import com.project.dev.entities.enums.WarningLabel;
import jakarta.persistence.Column;

public class RemedyDTO {

    private Long id;
    private String name;
    private WarningLabel warningLabel;
    private Double price;
    private String description;

    public RemedyDTO() {
    }

    public RemedyDTO(Long id, String name, WarningLabel warningLabel, Double price, String description) {
        this.id = id;
        this.name = name;
        this.warningLabel = warningLabel;
        this.price = price;
        this.description = description;
    }

    public RemedyDTO(Remedy obj) {
        id = obj.getId();
        name = obj.getName();
        warningLabel = obj.getWarningLabel();
        price = obj.getPrice();
        description = obj.getDescription();
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
}
