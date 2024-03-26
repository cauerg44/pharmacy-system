package com.project.dev.entities;

import com.project.dev.entities.enums.WarningLabel;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "remedies")
public class Remedy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private WarningLabel warningLabel;
    private Double price;

    @Column(columnDefinition = "TEXT")
    private String description;

    public Remedy() {
    }

    public Remedy(Long id, String name, WarningLabel warningLabel, Double price, String description) {
        this.id = id;
        this.name = name;
        this.warningLabel = warningLabel;
        this.price = price;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WarningLabel getWarningLabel() {
        return warningLabel;
    }

    public void setWarningLabel(WarningLabel warningLabel) {
        this.warningLabel = warningLabel;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Remedy remedy = (Remedy) o;
        return Objects.equals(id, remedy.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
