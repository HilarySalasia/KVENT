package com.mixapp.venitar.entity;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
@Table(name="vent_ward")
public class Ward {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "vent-ward-seq")
    @SequenceGenerator(name = "vent-ward-seq", sequenceName = "vent_ward_seq", allocationSize = 1)
    @Column(name="ward_id")
    private Long wardId;

    @Column(name="ward", length=35, nullable=false, unique=false)
    private String wardName;
}
