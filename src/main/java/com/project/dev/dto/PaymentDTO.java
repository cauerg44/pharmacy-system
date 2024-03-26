package com.project.dev.dto;

import com.project.dev.entities.Payment;

import java.time.Instant;

public class PaymentDTO {

    private Long id;
    private Instant paymentMoment;
    private String paymentMethod;

    public PaymentDTO(Long id, Instant paymentMoment, String paymentMethod) {
        this.id = id;
        this.paymentMoment = paymentMoment;
        this.paymentMethod = paymentMethod;
    }

    public PaymentDTO(Payment obj) {
        id = obj.getId();
        paymentMoment = obj.getPaymentMoment();
        paymentMethod = obj.getPaymentMethod();
    }

    public Long getId() {
        return id;
    }

    public Instant getPaymentMoment() {
        return paymentMoment;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }
}
