package com.smallschool.entity;

import javax.persistence.*;

@Entity
@Table(name = "app_scl_shopping_cart")
public class CartEntity {

    @Id
    private Long cartId;


    private int snackId;
    private String snackName;
    private Float snackPrice;
    private int snackNumber;

    public CartEntity() {
    }

    public CartEntity(int snackId, String snackName, Float snackPrice, int snackNumber) {
        this.snackId = snackId;
        this.snackName = snackName;
        this.snackPrice = snackPrice;
        this.snackNumber = snackNumber;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
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

    public int getSnackNumber() {
        return snackNumber;
    }

    public void setSnackNumber(int snackNumber) {
        this.snackNumber = snackNumber;
    }

    @Override
    public String toString() {
        return "CartEntity{" +
                "cartId=" + cartId +
                ", snackId=" + snackId +
                ", snackName='" + snackName + '\'' +
                ", snackPrice=" + snackPrice +
                ", snackNumber=" + snackNumber +
                '}';
    }
}
