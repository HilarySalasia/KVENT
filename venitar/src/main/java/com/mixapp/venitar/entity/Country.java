package com.mixapp.venitar.entity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="vent_country")
public class Country {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="coun_id")
    private Long countryId;

    @Column(name="country", length=15, nullable=false, unique=false)
    private String name;

}

