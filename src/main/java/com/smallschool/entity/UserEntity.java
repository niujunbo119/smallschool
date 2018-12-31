package com.smallschool.entity;

import javax.persistence.*;

@Entity
@Table(name="app_scl_user_info")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @Column(name = "phone",nullable = false)
    private String phone;
    @Column(name = "password",nullable = false)
    private String password;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name="gender",nullable = false)
    private String gender;
    @Column(name = "college",nullable = false)
    private String college;
    @Column(name = "major",nullable = false)
    private String major;
    @Column(name = "location",nullable = false)
    private String location;
    @Column(name = "location2")
    private String location2;
    @Column(name = "location3")
    private String location3;

    public UserEntity() {
    }

    public UserEntity(String phone, String password, String name, String gender, String college, String major, String location, String location2, String location3) {
        this.phone = phone;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.college = college;
        this.major = major;
        this.location = location;
        this.location2 = location2;
        this.location3 = location3;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation2() {
        return location2;
    }

    public void setLocation2(String location2) {
        this.location2 = location2;
    }

    public String getLocation3() {
        return location3;
    }

    public void setLocation3(String location3) {
        this.location3 = location3;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userId=" + userId +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", college='" + college + '\'' +
                ", major='" + major + '\'' +
                ", location='" + location + '\'' +
                ", location2='" + location2 + '\'' +
                ", location3='" + location3 + '\'' +
                '}';
    }
}
