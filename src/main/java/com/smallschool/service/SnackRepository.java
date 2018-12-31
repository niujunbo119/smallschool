package com.smallschool.service;


import com.smallschool.entity.SnackEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SnackRepository extends JpaRepository<SnackEntity,Integer> {
    List<SnackEntity> findBySnackCategory(int category);
}
