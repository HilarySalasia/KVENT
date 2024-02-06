package com.mixapp.venitar.entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="vent_country")
public class Country {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "vent-country-seq")
    @SequenceGenerator(name="vent-country-seq", sequenceName = "vent_country_seq", allocationSize = 1)
    @Column(name="coun_id")
    private Long countryId;

    @Column(name="country", length=15, nullable=false, unique=false)
    private String name;

}

