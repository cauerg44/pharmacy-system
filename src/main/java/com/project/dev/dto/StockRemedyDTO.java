package com.project.dev.dto;

import com.project.dev.entities.StockRemedy;

public class StockRemedyDTO {

    private Long remedyId;
    private String name;
    private Double price;
    private Integer quantity;
    private String description;

    public StockRemedyDTO(Long remedyId, String name, Double price, Integer quantity, String description) {
        this.remedyId = remedyId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

    public StockRemedyDTO(StockRemedy obj) {
        remedyId = obj.getRemedy().getId();
        name = obj.getRemedy().getName();
        price = obj.getPrice();
        quantity = obj.getQuantity();
        description = obj.getRemedy().getDescription();
    }

    public Long getRemedyId() {
        return remedyId;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }

    public Double getSubTotal() {
        return price * quantity;
    }
}
