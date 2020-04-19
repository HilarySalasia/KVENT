package com.mixapp.venitar.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.sql.Date;

@Table(name="vent_login")
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="lgn_id")
    private Long loginId;

    @Column(name = "lgn_token", length = 160)
    private String loginToken;

    @Column(name="lgn_cookie", length= 140)
    private String loginCookie;

    @Column(name="lgn_date")
    private Date loginDate;

    @Column(name="lgn_OS", length = 50)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String loginOS;

    @Column(name="lgn_Address", length = 70)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String loginAddress;

    public Long getLoginId() {
        return loginId;
    }

    public void setLoginId(Long loginId) {
        this.loginId = loginId;
    }

    public String getLoginToken() {
        return loginToken;
    }

    public void setLoginToken(String loginToken) {
        this.loginToken = loginToken;
    }

    public String getLoginCookie() {
        return loginCookie;
    }

    public void setLoginCookie(String loginCookie) {
        this.loginCookie = loginCookie;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public String getLoginOS() {
        return loginOS;
    }

    public void setLoginOS(String loginOS) {
        this.loginOS = loginOS;
    }

    public String getLoginAddress() {
        return loginAddress;
    }

    public void setLoginAddress(String loginAddress) {
        this.loginAddress = loginAddress;
    }

}
