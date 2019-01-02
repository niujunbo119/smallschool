package com.smallschool.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "app_scl_deliver")
public class DeliverEntity {

    @Id
    private String deliverId;

    private String userPhone;

    private String name;

    private String gender;

    private String phone;

    private String address;

    public DeliverEntity() {
    }

    public DeliverEntity(String deliverId, String userPhone, String name, String gender, String phone, String address) {
        this.deliverId = deliverId;
        this.userPhone = userPhone;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
    }

    public String getDeliverId() {
        return deliverId;
    }

    public void setDeliverId(String deliverId) {
        this.deliverId = deliverId;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
