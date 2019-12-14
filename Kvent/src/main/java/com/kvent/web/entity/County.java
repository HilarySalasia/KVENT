package com.kvent.web.entity;

import javax.persistence.*;

@Entity
@Table(name="vent_county")
public class County {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="county_id")
    private Long countryId;

    @Column(name="county", length=15, nullable=false, unique=false)
    private String countyName;
}
