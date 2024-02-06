package com.mixapp.venitar.entity;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
@Table(name="picture_upload")
public class MixPicUpload {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "picture-upload-seq")
    @SequenceGenerator(name = "picture-upload-seq", sequenceName = "picture_upload_seq",allocationSize = 1)
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

    @Column(name="mix_pic_link", length=200, nullable=false, unique=false)
    private String mixPicLink;

    @Column(name="mix_pic_perm", length=15, nullable=false, unique=false)
    private String mixPicPermit;

}
