package com.smallschool.service;

import com.smallschool.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<CartEntity,Long> {
     CartEntity findBySnackId(int snackId);
}
