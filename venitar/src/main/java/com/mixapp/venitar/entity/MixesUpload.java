package com.mixapp.venitar.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
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

}
