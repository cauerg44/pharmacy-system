package com.project.dev.dto;

import com.project.dev.entities.Payment;
import com.project.dev.entities.Sale;
import com.project.dev.entities.StockRemedy;
import com.project.dev.entities.enums.SaleStatus;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class SaleDTO {

    private Long id;
    private Instant moment;
    private SaleStatus status;

    private UserDTO user;

    private PaymentDTO payment;

    private List<StockRemedyDTO> stock = new ArrayList<>();

    public SaleDTO(Long id, Instant moment, SaleStatus status, UserDTO user, PaymentDTO payment) {
        this.id = id;
        this.moment = moment;
        this.status = status;
        this.user = user;
        this.payment = payment;
    }

    public SaleDTO(Sale obj) {
        id = obj.getId();
        moment = obj.getMoment();
        status = obj.getSaleStatus();
        user = new UserDTO(obj.getUser());
        payment = (obj.getPayment() == null) ? null : new PaymentDTO(obj.getPayment());
        for (StockRemedy sr : obj.getStock()) {
            StockRemedyDTO srDTO = new StockRemedyDTO(sr);
            stock.add(srDTO);
        }
    }

    public Long getId() {
        return id;
    }

    public Instant getMoment() {
        return moment;
    }

    public SaleStatus getStatus() {
        return status;
    }

    public UserDTO getUser() {
        return user;
    }

    public PaymentDTO getPayment() {
        return payment;
    }

    public List<StockRemedyDTO> getStock() {
        return stock;
    }

    public Double getTotalValueInStock() {
        double sum = 0.0;
        for (StockRemedyDTO sr : stock) {
            sum += sr.getSubTotal();
        }
        return sum;
    }
}
