package com.smallschool.service;

import com.smallschool.entity.DeliverEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeliverRepository extends JpaRepository<DeliverEntity,String> {
    List<DeliverEntity> findByUserPhone(String userPhone);
    List<DeliverEntity> findByName(String name);
}
