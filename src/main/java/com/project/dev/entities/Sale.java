package com.project.dev.entities;

import com.project.dev.entities.enums.SaleStatus;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "sales")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant moment;
    private SaleStatus saleStatus;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(mappedBy = "sale", cascade = CascadeType.ALL)
    private Payment payment;

    @OneToMany(mappedBy = "id.sale")
    private Set<StockRemedy> stock = new HashSet<>();

    public Sale() {
    }

    public Sale(Long id, Instant moment, SaleStatus saleStatus, User user, Payment payment) {
        this.id = id;
        this.moment = moment;
        this.saleStatus = saleStatus;
        this.user = user;
        this.payment = payment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public SaleStatus getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(SaleStatus saleStatus) {
        this.saleStatus = saleStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Set<StockRemedy> getStock() {
        return stock;
    }

    public List<Remedy> getRemedies() {
        return stock.stream().map(x -> x.getRemedy()).toList();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sale sale = (Sale) o;
        return Objects.equals(id, sale.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
