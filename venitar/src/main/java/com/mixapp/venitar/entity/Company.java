package com.mixapp.venitar.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "vent_company")
public class Company {
        @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "comp_id")
    private Long companyId;

    @Column(name = "comp_name")
    private String companyName;

    @Column(name = "comp_address")
    private String companyAddress;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "county_id", nullable = false)
    private Country country;
}
