package com.smallschool.service;


import com.smallschool.entity.SnackOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SnackOrderRepository extends JpaRepository<SnackOrderEntity,String> {

}
