package com.kvent.web.entity;
import javax.persistence.*;

@Entity
@Table(name="vent_country")
public class Country {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="coun_id")
    private Long countryId;

    @Column(name="country", length=15, nullable=false, unique=false)
    private String name;

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

