package com.project.dev.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "stock_remedy")
public class StockRemedy {

    @EmbeddedId
    private StockRemedyPK id = new StockRemedyPK();

    private Integer quantity;
    private Double price;

    public StockRemedy() {
    }

    public StockRemedy(Sale sale, Remedy remedy, Integer quantity, Double price) {
        id.setSale(sale);
        id.setRemedy(remedy);
        this.quantity = quantity;
        this.price = price;
    }

    public Sale getSale() {
        return id.getSale();
    }

    public void setSale(Sale sale) {
        id.setSale(sale);
    }

    public Remedy getRemedy() {
        return id.getRemedy();
    }

    public void setRemedy(Remedy remedy) {
        id.setRemedy(remedy);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
