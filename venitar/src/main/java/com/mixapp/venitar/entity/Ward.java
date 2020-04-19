package com.mixapp.venitar.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="vent_ward")
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

    @Column(name="ward", length=35, nullable=false, unique=false)
    private String wardName;
}
