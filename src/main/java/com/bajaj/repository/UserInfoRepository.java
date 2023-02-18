package com.bajaj.repository;

import com.bajaj.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByName(String username);
    @Query("select q from UserEntity q where q.email=:mail")
    public String findByEmail(String mail);

}
