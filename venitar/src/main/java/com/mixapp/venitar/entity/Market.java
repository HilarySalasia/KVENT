package com.mixapp.venitar.entity;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
@Table(name = "vent_market")
public class Market {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vent-market-seq")
    @SequenceGenerator(name = "vent-market-seq", sequenceName = "vent_market_seq", allocationSize = 1)
    @Column(name ="markp_id")
    private Long marketId;

    @Column(name = "markp_item_name")
    private String itemName;

    @Column(name ="markp_item_desc")
    private String itemDesc;

    @Column(name = "markp_item_price")
    private double itemPrice;

    @Column(name ="markp_item_invt")
    private double itemInventory;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "markp_item_pic_id", nullable = false)
    private MixPicUpload mixPicUpload;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "markp_comp_id", nullable = false)
    private Company company;

    @Column(name = "markp_item_user_id")
    private Long userId;


}
