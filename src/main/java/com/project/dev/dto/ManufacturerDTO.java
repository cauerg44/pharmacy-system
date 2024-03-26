package com.project.dev.dto;

import com.project.dev.entities.Manufacturer;

public class ManufacturerDTO {

    private Long id;
    private String name;
    private String address;
    private Integer shipmentDate;

    public ManufacturerDTO() {
    }

    public ManufacturerDTO(Long id, String name, String address, Integer shipmentDate) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.shipmentDate = shipmentDate;
    }

    public ManufacturerDTO(Manufacturer obj) {
        id = obj.getId();
        name = obj.getName();
        address = obj.getAddress();
        shipmentDate = obj.getShipmentDate();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Integer getShipmentDate() {
        return shipmentDate;
    }
}
