package com.mixapp.venitar.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name="vent_ward")
public class Ward {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="ward_id")
    private Long wardId;

    @Column(name="ward", length=35, nullable=false, unique=false)
    private String wardName;
}
