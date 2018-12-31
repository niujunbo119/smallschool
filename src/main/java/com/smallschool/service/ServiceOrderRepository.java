package com.smallschool.service;


import com.smallschool.entity.ServiceOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ServiceOrderRepository extends JpaRepository<ServiceOrderEntity,String> {

}
