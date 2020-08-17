package com.mixapp.venitar.entity;

import javax.persistence.*;

@Entity
@Table(name = "vent_transc_type")
public class TransactionType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="v_tt_id")
    private Long transcType;

    @Column(name="v_tt_name")
    private String transcName;

    public Long getTranscType() {
        return transcType;
    }

    public void setTranscType(Long transcType) {
        this.transcType = transcType;
    }

    public String getTranscName() {
        return transcName;
    }

    public void setTranscName(String transcName) {
        this.transcName = transcName;
    }
}
