package com.mixapp.venitar.entity;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
@Table(name="vent_town")
public class Town {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "vent-town-seq")
    @SequenceGenerator(name = "vent-town-seq", sequenceName = "vent_town_seq", allocationSize = 1)
    @Column(name="town_id")
    private Long townId;

    @Column(name="town", length=15, nullable=false, unique=false)
    private String townName;
}
