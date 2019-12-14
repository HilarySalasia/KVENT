package com.kvent.web.entity;

import javax.persistence.*;

@Entity
@Table(name="mixes_upload")
public class MixesUpload {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="mix_id")
    private Long mixId;

    @Column(name="mix_company")
    private String mixCompany;

    @Column(name="mix_dj_name")
    private String mixDjName;

    @Column(name="mix_link")
    private String mixLink;

    @Column(name="mix_status")
    private String mixStatus;

    @Column(name="mix_title")
    private String mixTitle;


    //Getter and Setters
    public Long getMixId() {
        return mixId;
    }

    public void setMixId(Long mixId) {
        this.mixId = mixId;
    }

    public String getMixCompany() {
        return mixCompany;
    }

    public void setMixCompany(String mixCompany) {
        this.mixCompany = mixCompany;
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

}
