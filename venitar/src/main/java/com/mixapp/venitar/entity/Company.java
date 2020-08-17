package com.mixapp.venitar.entity;

import javax.persistence.*;

@Entity
@Table(name = "vent_company")
public class Company {
    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

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
