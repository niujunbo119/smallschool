package com.smallschool.service;

import com.smallschool.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    UserEntity findByName(String name);
    UserEntity findByPhone(String phone);
}
