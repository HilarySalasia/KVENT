package com.mixapp.venitar.entity;

import javax.persistence.*;

@Entity
@Table(name = "vent_market")
public class Market {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public Long getMarketId() {
        return marketId;
    }

    public void setMarketId(Long marketId) {
        this.marketId = marketId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public double getItemInventory() {
        return itemInventory;
    }

    public void setItemInventory(double itemInventory) {
        this.itemInventory = itemInventory;
    }

    public MixPicUpload getMixPicUpload() {
        return mixPicUpload;
    }

    public void setMixPicUpload(MixPicUpload mixPicUpload) {
        this.mixPicUpload = mixPicUpload;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
