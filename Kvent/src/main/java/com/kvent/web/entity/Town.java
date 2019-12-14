package com.kvent.web.entity;

import javax.persistence.*;

@Entity
@Table(name="vent_town")
public class Town {
    public Long getTownId() {
        return townId;
    }

    public void setTownId(Long townId) {
        this.townId = townId;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="town_id")
    private Long townId;

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    @Column(name="town", length=15, nullable=false, unique=false)
    private String townName;
}
