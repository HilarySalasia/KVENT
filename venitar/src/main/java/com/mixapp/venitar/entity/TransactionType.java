package com.mixapp.venitar.entity;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
@Table(name = "vent_transc_type")
public class TransactionType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vent-transc_type-seq")
    @SequenceGenerator(name = "vent-transc_type-seq", sequenceName = "vent_transc_type_seq")
    @Column(name="v_tt_id")
    private Long transcType;

    @Column(name="v_tt_name")
    private String transcName;


}
