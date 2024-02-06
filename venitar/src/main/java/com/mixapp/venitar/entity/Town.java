package com.mixapp.venitar.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
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

    @Column(name="town", length=15, nullable=false, unique=false)
    private String townName;
}
