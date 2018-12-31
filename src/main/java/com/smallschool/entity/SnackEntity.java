package com.smallschool.entity;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name = "app_scl_snacks")
public class SnackEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int snackId;

    private String snackName;
    private Float snackPrice;
    private int snackCategory;
    private String snackInfo;
    private int snackBalance;

    private byte[] snackPic;

    @Transient
    private String picString;

    public SnackEntity() {
    }

    public SnackEntity(String snackName, Float snackPrice, int snackCategory, String snackInfo, int snackBalance,byte[] snackPic) {
        this.snackName = snackName;
        this.snackPrice = snackPrice;
        this.snackCategory = snackCategory;
        this.snackInfo = snackInfo;
        this.snackBalance = snackBalance;
        this.snackPic = snackPic;
    }

    public int getSnackId() {
        return snackId;
    }

    public void setSnackId(int snackId) {
        this.snackId = snackId;
    }

    public String getSnackName() {
        return snackName;
    }

    public void setSnackName(String snackName) {
        this.snackName = snackName;
    }

    public Float getSnackPrice() {
        return snackPrice;
    }

    public void setSnackPrice(Float snackPrice) {
        this.snackPrice = snackPrice;
    }

    public int getSnackCategory() {
        return snackCategory;
    }

    public void setSnackCategory(int snackCategory) {
        this.snackCategory = snackCategory;
    }

    public String getSnackInfo() {
        return snackInfo;
    }

    public void setSnackInfo(String snackInfo) {
        this.snackInfo = snackInfo;
    }

    public int getSnackBalance() {
        return snackBalance;
    }

    public void setSnackBalance(int snackBalance) {
        this.snackBalance = snackBalance;
    }

    public byte[] getSnackPic() {
        return snackPic;
    }

    public void setSnackPic(byte[] snackPic) {
        this.snackPic = snackPic;
    }

    public String getPicString() {
        return picString;
    }

    public void setPicString(String picString) {
        this.picString = picString;
    }

    @Override
    public String toString() {
        return "SnackEntity{" +
                "snackId=" + snackId +
                ", snackName='" + snackName + '\'' +
                ", snackPrice=" + snackPrice +
                ", snackCategory=" + snackCategory +
                ", snackInfo='" + snackInfo + '\'' +
                ", snackBalance=" + snackBalance +
                ", snackPic=" + snackPic +
                '}';
    }
}
