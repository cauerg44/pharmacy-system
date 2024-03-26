package com.project.dev.dto;

import com.project.dev.entities.Remedy;

public class RemedyDetailsDTO {

    private Long id;
    private String name;
    private Double price;
    private String description;

    public RemedyDetailsDTO(Long id, String name, Double price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public RemedyDetailsDTO(Remedy obj) {
        id = obj.getId();
        name = obj.getName();
        price = obj.getPrice();
        description = obj.getDescription();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
