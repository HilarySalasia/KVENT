package com.mixapp.venitar.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
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

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "YYYY-MM-dd'T'HH:mm:ss.SSSZ")
    @Column(name="lgn_date")
    private Date loginDate;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "YYYY-MM-dd'T'HH:mm:ss.SSSZ")
    @Column(name="lgn_out_date")
    private Date loginOutDate;

    @Column(name="lgn_OS", length = 50)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String loginOS;

    @Column(name="lgn_Address", length = 70)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String loginAddress;

    @Column(name = "lgn_user_id", nullable = false)
    private Long userId;

    @Column(name="lgn_expired", length = 10)
    private String loginExpire;

    @Column(name="lgn_logout", length = 10)
    private String loginLoggedOut;

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

    public Date getLoginOutDate() {
        return loginOutDate;
    }

    public void setLoginOutDate(Date loginOutDate) {
        this.loginOutDate = loginOutDate;
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

    public Long getLoginUser() {
        return userId;
    }

    public void setLoginUser(Long loginUser) {
        this.userId = loginUser;
    }

    public String getLoginExpire() {
        return loginExpire;
    }

    public void setLoginExpire(String loginExpire) {
        this.loginExpire = loginExpire;
    }

    public String getLoginLoggedOut() {
        return loginLoggedOut;
    }

    public void setLoginLoggedOut(String loginLoggedOut) {
        this.loginLoggedOut = loginLoggedOut;
    }

}
