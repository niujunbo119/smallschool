package com.smallschool.service;

import com.smallschool.entity.ServiceCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceCategoryRepository extends JpaRepository<ServiceCategoryEntity,Integer> {
    ServiceCategoryEntity findByServiceCategory(String serviceCategory);
}
