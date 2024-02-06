package com.mixapp.venitar.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
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

    @Column(name="mix_pic_link")
    private String picLink;

    @Column(name = "mix_pic_perm")
    private String picPermission;

}
