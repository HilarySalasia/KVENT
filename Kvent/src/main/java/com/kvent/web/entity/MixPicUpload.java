package com.kvent.web.entity;

import javax.persistence.*;

@Entity
@Table(name="picture_upload")
public class MixPicUpload {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="mix_pic_id")
    private Long mixPicId;

    @Column(name="mix_pic_artist", length=15, nullable=false, unique=false)
    private String mixPicArtist;

    public String getMixPicName() {
        return mixPicName;
    }

    public void setMixPicName(String mixPicName) {
        this.mixPicName = mixPicName;
    }

    @Column(name="mix_pic_comp", length=200, nullable=false, unique=false)
    private String mixPicName;

    public String getMixPicArtist() {
        return mixPicArtist;
    }

    public void setMixPicArtist(String mixPicArtist) {
        this.mixPicArtist = mixPicArtist;
    }



    public String getMixPicLink() {
        return mixPicLink;
    }

    public void setMixPicLink(String mixPicLink) {
        this.mixPicLink = mixPicLink;
    }

    public String getMixPicPermit() {
        return mixPicPermit;
    }

    public void setMixPicPermit(String mixPicPermit) {
        this.mixPicPermit = mixPicPermit;
    }

    @Column(name="mix_pic_link", length=200, nullable=false, unique=false)
    private String mixPicLink;

    public Long getMixPicId() {
        return mixPicId;
    }

    public void setMixPicId(Long mixPicId) {
        this.mixPicId = mixPicId;
    }

    @Column(name="mix_pic_perm", length=15, nullable=false, unique=false)
    private String mixPicPermit;

}
