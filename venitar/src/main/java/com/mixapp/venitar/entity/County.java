package com.mixapp.venitar.entity;

import javax.persistence.*;

@Entity
@Table(name="vent_county")
public class County {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="county_id")
    private Long countyId;

    @Column(name="county", length=15, nullable=false, unique=false)
    private String countyName;

    public Long getCountyId() {
        return countyId;
    }

    public void setCountyId(Long countyId) {
        this.countyId = countyId;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }
}
