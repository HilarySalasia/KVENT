package com.kvent.web.entity;

import javax.persistence.*;

@Entity
@Table(name="vent_town")
public class Ward {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="ward_id")
    private Long wardId;

    public Long getWardId() {
        return wardId;
    }

    public void setWardId(Long wardId) {
        this.wardId = wardId;
    }

    public String getWardName() {
        return wardName;
    }

    public void setWardName(String wardName) {
        this.wardName = wardName;
    }

    @Column(name="ward", length=15, nullable=false, unique=false)
    private String wardName;
}
