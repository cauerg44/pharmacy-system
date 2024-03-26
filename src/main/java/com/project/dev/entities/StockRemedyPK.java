package com.project.dev.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class StockRemedyPK {

    @ManyToOne
    @JoinColumn(name = "sale_id")
    private Sale sale;

    @ManyToOne
    @JoinColumn(name = "remedy_id")
    private Remedy remedy;

    public StockRemedyPK() {
    }

    public StockRemedyPK(Sale sale, Remedy remedy) {
        this.sale = sale;
        this.remedy = remedy;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public Remedy getRemedy() {
        return remedy;
    }

    public void setRemedy(Remedy remedy) {
        this.remedy = remedy;
    }


}
