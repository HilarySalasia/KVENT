package com.mixapp.venitar.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
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


}
