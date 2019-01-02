package com.smallschool.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "app_scl_snack_order")
public class SnackOrderEntity {

    @Id
    private String orderSnackId;

    private int userId;

    private int snackId;

    private String name;

    private String phone;

    private Date orderTime;

    private String address;

    private String deliverTime;

    private float totalCost;

    private String note;

    public SnackOrderEntity() {
    }

    public SnackOrderEntity(String orderSnackId, int userId, int snackId, String name, String phone, Date orderTime, String address,String deliverTime, float totalCost) {
        this.orderSnackId = orderSnackId;
        this.userId = userId;
        this.snackId = snackId;
        this.name = name;
        this.phone = phone;
        this.orderTime = orderTime;
        this.address = address;
        this.deliverTime = deliverTime;
        this.totalCost = totalCost;
    }

    public String getDeliverTime() {
        return deliverTime;
    }

    public void setDeliverTime(String deliverTime) {
        this.deliverTime = deliverTime;
    }

    public String getOrderSnackId() {
        return orderSnackId;
    }

    public void setOrderSnackId(String orderSnackId) {
        this.orderSnackId = orderSnackId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSnackId() {
        return snackId;
    }

    public void setSnackId(int snackId) {
        this.snackId = snackId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "SnackOrderEntity{" +
                "orderSnackId='" + orderSnackId + '\'' +
                ", userId=" + userId +
                ", snackId=" + snackId +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", orderTime=" + orderTime +
                ", address='" + address + '\'' +
                ", totalCost=" + totalCost +
                '}';
    }
}

