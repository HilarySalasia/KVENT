package com.mixapp.venitar.entity;

import lombok.Data;

import jakarta.persistence.*;

@Entity
@Data
@Table(name="vent_county")
public class County {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "vent-county-seq")
    @SequenceGenerator(name="vent-county-seq", sequenceName = "vent_county_seq", allocationSize = 1)
    @Column(name="county_id")
    private Long countyId;

    @Column(name="county", length=15, nullable=false, unique=false)
    private String countyName;


}
