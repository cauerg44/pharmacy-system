package com.project.dev.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "manufactures")
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private Integer shipmentDate;

    @OneToMany(mappedBy = "manufacturer")
    private List<Remedy> remedies = new ArrayList<>();

    public Manufacturer() {
    }

    public Manufacturer(Long id, String name, String address, Integer shipmentDate) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.shipmentDate = shipmentDate;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getShipmentDate() {
        return shipmentDate;
    }

    public void setShipmentDate(Integer shipmentDate) {
        this.shipmentDate = shipmentDate;
    }

    public List<Remedy> getRemedies() {
        return remedies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manufacturer that = (Manufacturer) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}