package com.smallschool.service;

import com.smallschool.entity.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ServiceRepository extends JpaRepository<ServiceEntity,Long> {
    public List<ServiceEntity> findByServiceName(String serviceName);
}
