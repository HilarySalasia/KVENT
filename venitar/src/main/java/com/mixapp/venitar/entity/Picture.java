package com.mixapp.venitar.entity;

import javax.persistence.*;

@Entity
@Table(name = "picture_upload")
public class Picture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "mix_pic_id")
    private Long picId;

    @Column(name = "mix_pic_artist")
    private String picArtist;

    @Column(name = "mix_pic_comp")
    private String picComp;

    public Long getPicId() {
        return picId;
    }

    public void setPicId(Long picId) {
        this.picId = picId;
    }

    public String getPicArtist() {
        return picArtist;
    }

    public void setPicArtist(String picArtist) {
        this.picArtist = picArtist;
    }

    public String getPicComp() {
        return picComp;
    }

    public void setPicComp(String picComp) {
        this.picComp = picComp;
    }

    public String getPicLink() {
        return picLink;
    }

    public void setPicLink(String picLink) {
        this.picLink = picLink;
    }

    public String getPicPermission() {
        return picPermission;
    }

    public void setPicPermission(String picPermission) {
        this.picPermission = picPermission;
    }

    @Column(name="mix_pic_link")
    private String picLink;

    @Column(name = "mix_pic_perm")
    private String picPermission;

}
