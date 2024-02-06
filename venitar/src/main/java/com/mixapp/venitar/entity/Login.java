package com.mixapp.venitar.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
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



}
