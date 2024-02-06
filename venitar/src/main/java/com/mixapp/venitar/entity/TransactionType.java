package com.mixapp.venitar.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "vent_transc_type")
public class TransactionType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="v_tt_id")
    private Long transcType;

    @Column(name="v_tt_name")
    private String transcName;


}
