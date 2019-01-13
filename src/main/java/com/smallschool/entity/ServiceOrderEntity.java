package com.smallschool.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "app_scl_service_order")
public class ServiceOrderEntity {

    @Id
    @Column(name = "order_service_id")
    private String orderServiceId;

    @Column(name="service_id")
    private Long serviceId;

    @Column(name = "service_content")
    private String serviceContent;

    @Column(name = "order_service_fee")
    private float orderServiceFee;


    @Column(name = "order_platform_fee")
    private String orderPlatformFee;


    @Column(name = "order_service_score")
    private String orderServiceScore;

    @Column(name = "order_service_category")
    private int orderServiceCategory;

    @Column(name = "order_service_status")
    private String orderServiceStatus;


    @Column(name = "order_service_stime")
    private Date orderServiceStime;

    @Column(name = "order_service_etime")
    private Date orderServiceEtime;

    public ServiceOrderEntity() {
    }


    public ServiceOrderEntity(String orderServiceId, Long serviceId, String serviceContent, float orderServiceFee, String orderPlatformFee, String orderServiceScore, String orderServiceStatus, Date orderServiceStime, Date orderServiceEtime) {
        this.orderServiceId = orderServiceId;
        this.serviceId = serviceId;
        this.serviceContent = serviceContent;
        this.orderServiceFee = orderServiceFee;
        this.orderPlatformFee = orderPlatformFee;
        this.orderServiceScore = orderServiceScore;
        this.orderServiceStatus = orderServiceStatus;
        this.orderServiceStime = orderServiceStime;
        this.orderServiceEtime = orderServiceEtime;
    }

    public String getOrderServiceId() {
        return orderServiceId;
    }

    public void setOrderServiceId(String orderServiceId) {
        this.orderServiceId = orderServiceId;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public int getOrderServiceCategory() {
        return orderServiceCategory;
    }

    public void setOrderServiceCategory(int orderServiceCategory) {
        this.orderServiceCategory = orderServiceCategory;
    }

    public String getServiceContent() {
        return serviceContent;
    }

    public void setServiceContent(String serviceContent) {
        this.serviceContent = serviceContent;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public float getOrderServiceFee() {
        return orderServiceFee;
    }

    public void setOrderServiceFee(float orderServiceFee) {
        this.orderServiceFee = orderServiceFee;
    }

    public String getOrderPlatformFee() {
        return orderPlatformFee;
    }

    public void setOrderPlatformFee(String orderPlatformFee) {
        this.orderPlatformFee = orderPlatformFee;
    }

    public String getOrderServiceScore() {
        return orderServiceScore;
    }

    public void setOrderServiceScore(String orderServiceScore) {
        this.orderServiceScore = orderServiceScore;
    }

    public String getOrderServiceStatus() {
        return orderServiceStatus;
    }

    public void setOrderServiceStatus(String orderServiceStatus) {
        this.orderServiceStatus = orderServiceStatus;
    }

    public Date getOrderServiceStime() {
        return orderServiceStime;
    }

    public void setOrderServiceStime(Date orderServiceStime) {
        this.orderServiceStime = orderServiceStime;
    }

    public Date getOrderServiceEtime() {
        return orderServiceEtime;
    }

    public void setOrderServiceEtime(Date orderServiceEtime) {
        this.orderServiceEtime = orderServiceEtime;
    }

    @Override
    public String toString() {
        return "ServiceOrderEntity{" +
                "orderServiceId='" + orderServiceId + '\'' +
                ", serviceId=" + serviceId +
                ", serviceContent='" + serviceContent + '\'' +
                ", orderServiceFee='" + orderServiceFee + '\'' +
                ", orderPlatformFee='" + orderPlatformFee + '\'' +
                ", orderServiceScore='" + orderServiceScore + '\'' +
                ", orderServiceStatus='" + orderServiceStatus + '\'' +
                ", orderServiceStime=" + orderServiceStime +
                ", orderServiceEtime=" + orderServiceEtime +
                '}';
    }
}
