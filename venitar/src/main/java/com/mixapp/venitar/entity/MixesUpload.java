package com.mixapp.venitar.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name="mixes_upload")
public class MixesUpload {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="mix_id")
    private Long mixId;

    @Column(name="mix_dj_name")
    private String mixDjName;

    @Column(name="mix_link")
    private String mixLink;

    @Column(name="mix_status")
    private String mixStatus;

    @Column(name="mix_title")
    private String mixTitle;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "mix_companyID", nullable = false)
    private Company company;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "mix_cover_id", nullable = false)
    private Picture picture;

    @Column(name = "mix_user_id", nullable = false)
    private Long userId;

    //Getter and Setters
    public Long getMixId() {
        return mixId;
    }

    public void setMixId(Long mixId) {
        this.mixId = mixId;
    }

    public String getMixDjName() {
        return mixDjName;
    }

    public void setMixDjName(String mixDjName) {
        this.mixDjName = mixDjName;
    }

    public String getMixLink() {
        return mixLink;
    }

    public void setMixLink(String mixLink) {
        this.mixLink = mixLink;
    }

    public String getMixStatus() {
        return mixStatus;
    }

    public void setMixStatus(String mixStatus) {
        this.mixStatus = mixStatus;
    }

    public String getMixTitle() {
        return mixTitle;
    }

    public void setMixTitle(String mixTitle) {
        this.mixTitle = mixTitle;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
