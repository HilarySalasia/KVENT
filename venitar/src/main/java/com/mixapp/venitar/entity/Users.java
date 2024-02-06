package com.mixapp.venitar.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
@Data
@Table(name="vent_user")
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "code")
    private Long userCode;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "surname")
    private String surname;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "phone_num")
    private String phoneNum;

    @Column(name = "phy_addr")
    private String phyAddr;

    @Column(name = "email")
    private String email;

    @Column(name = "user_folder_link")
    private String folderLink;

    @Column(name = "dob")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "YYYY-MM-dd")
    private Date dateOfBirth;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vent_cred_id", nullable = false)
    private Credentials credentials;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vent_country_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Country country;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vent_county_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private County county;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vent_town_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Town town;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vent_ward_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Ward ward;

}
