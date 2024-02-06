package com.mixapp.venitar.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "vent_company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vent-company-seq")
    @SequenceGenerator(name="vent-company-seq", sequenceName = "vent_company_seq", allocationSize = 1)
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
