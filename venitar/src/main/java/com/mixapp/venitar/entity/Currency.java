package com.mixapp.venitar.entity;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
@Table(name ="vent_currency")
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vent-currency-seq")
    @SequenceGenerator(name="vent-currency-seq", sequenceName = "vent_currency_seq", allocationSize = 1)
    @Column(name = "curr_id")
    private Long currencyId;

    @Column(name = "curr_desc")
    private String currencyDesc;

    @Column(name ="curr_sht_desc")
    private String currencyShtDesc;


}
