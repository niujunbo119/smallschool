package com.smallschool.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "app_scl_service_category")
public class ServiceCategoryEntity {

    @Id
    @Column(name = "service_category_id")
    private int serviceCategoryId;

    @Column(name = "service_category")
    private String serviceCategory;

    public ServiceCategoryEntity() {
    }

    public ServiceCategoryEntity(int serviceCategoryId, String serviceCategory) {
        this.serviceCategoryId = serviceCategoryId;
        this.serviceCategory = serviceCategory;
    }

    public int getServiceCategoryId() {
        return serviceCategoryId;
    }

    public void setServiceCategoryId(int serviceCategoryId) {
        this.serviceCategoryId = serviceCategoryId;
    }

    public String getServiceCategory() {
        return serviceCategory;
    }

    public void setServiceCategory(String serviceCategory) {
        this.serviceCategory = serviceCategory;
    }
}
