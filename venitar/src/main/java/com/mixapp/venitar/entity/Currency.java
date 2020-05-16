package com.mixapp.venitar.entity;

import javax.persistence.*;

@Entity
@Table(name ="vent_currency")
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "curr_id")
    private Long currencyId;

    @Column(name = "curr_desc")
    private String currencyDesc;

    @Column(name ="curr_sht_desc")
    private String currencyShtDesc;

    public Long getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }

    public String getCurrencyDesc() {
        return currencyDesc;
    }

    public void setCurrencyDesc(String currencyDesc) {
        this.currencyDesc = currencyDesc;
    }

    public String getCurrencyShtDesc() {
        return currencyShtDesc;
    }

    public void setCurrencyShtDesc(String currencyShtDesc) {
        this.currencyShtDesc = currencyShtDesc;
    }
}
