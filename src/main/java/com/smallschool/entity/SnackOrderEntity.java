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

    private int snackNumber;

    private Date orderTime;

    private float totalCost;

    public SnackOrderEntity() {
    }

    public SnackOrderEntity(String orderSnackId, int userId, int snackId, int snackNumber, Date orderTime, float totalCost) {
        this.orderSnackId = orderSnackId;
        this.userId = userId;
        this.snackId = snackId;
        this.snackNumber = snackNumber;
        this.orderTime = orderTime;
        this.totalCost = totalCost;
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

    public int getSnackNumber() {
        return snackNumber;
    }

    public void setSnackNumber(int snackNumber) {
        this.snackNumber = snackNumber;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "SnackOrderEntity{" +
                "orderSnackId='" + orderSnackId + '\'' +
                ", userId=" + userId +
                ", snackId=" + snackId +
                ", snackNumber=" + snackNumber +
                ", orderTime=" + orderTime +
                ", totalCost=" + totalCost +
                '}';
    }
}
