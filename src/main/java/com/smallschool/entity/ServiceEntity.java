package com.smallschool.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "app_scl_services")
public class ServiceEntity {

    @Id
    private Long serviceId;

    private String serviceName;

    private int serviceCategory;

    private String serviceContent;

    private float serviceFee;

    private int serviceStatus;

    private Date serviceStime;

    private Date serviceEtime;


    public ServiceEntity() {
    }

    public ServiceEntity(Long serviceId, String serviceName, int serviceCategory, String serviceContent, float serviceFee, int serviceStatus, Date serviceStime, Date serviceEtime) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceCategory = serviceCategory;
        this.serviceContent = serviceContent;
        this.serviceFee = serviceFee;
        this.serviceStatus = serviceStatus;
        this.serviceStime = serviceStime;
        this.serviceEtime = serviceEtime;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getServiceCategory() {
        return serviceCategory;
    }

    public void setServiceCategory(int serviceCategory) {
        this.serviceCategory = serviceCategory;
    }

    public String getServiceContent() {
        return serviceContent;
    }

    public void setServiceContent(String serviceContent) {
        this.serviceContent = serviceContent;
    }

    public float getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(float serviceFee) {
        this.serviceFee = serviceFee;
    }

    public int getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(int serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    public Date getServiceStime() {
        return serviceStime;
    }

    public void setServiceStime(Date serviceStime) {
        this.serviceStime = serviceStime;
    }

    public Date getServiceEtime() {
        return serviceEtime;
    }

    public void setServiceEtime(Date serviceEtime) {
        this.serviceEtime = serviceEtime;
    }

    @Override
    public String toString() {
        return "ServiceEntity{" +
                "serviceId=" + serviceId +
                ", serviceName='" + serviceName + '\'' +
                ", serviceCategory=" + serviceCategory +
                ", serviceContent='" + serviceContent + '\'' +
                ", serviceFee=" + serviceFee +
                ", serviceStatus=" + serviceStatus +
                ", serviceStime=" + serviceStime +
                ", serviceEtime=" + serviceEtime +
                '}';
    }
}
