package com.project.dev.entities;

import com.project.dev.entities.enums.WarningLabel;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

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

    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    @OneToMany(mappedBy = "id.remedy")
    private Set<StockRemedy> stock = new HashSet<>();

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

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Set<StockRemedy> getStock() {
        return stock;
    }

    public List<Sale> getSales() {
        return stock.stream().map(obj -> obj.getSale()).toList();
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

