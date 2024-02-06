package com.mixapp.venitar.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="vent_county")
public class County {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="county_id")
    private Long countyId;

    @Column(name="county", length=15, nullable=false, unique=false)
    private String countyName;


}
