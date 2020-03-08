package com.mixapp.venitar.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="vent_cred")
public class Credentials {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="cred_id")
    private Long credId;

    @Column(name="password")
    private String passCode;

    public Long getCredId() {
        return credId;
    }

    public void setCredId(Long credId) {
        this.credId = credId;
    }

    public String getPassCode() {
        return passCode;
    }

    public void setPassCode(String passCode) {
        this.passCode = passCode;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    @Column(name="created_time")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "YYYY-MM-dd")
    private LocalDate createdDate;

}
