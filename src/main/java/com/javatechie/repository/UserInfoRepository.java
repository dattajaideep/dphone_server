package com.javatechie.repository;

import com.javatechie.beans.UserBean;
import com.javatechie.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByName(String username);

}