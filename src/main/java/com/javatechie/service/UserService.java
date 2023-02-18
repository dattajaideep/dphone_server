package com.javatechie.service;

import com.javatechie.beans.UserBean;
import com.javatechie.entity.UserEntity;
import com.javatechie.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserInfoRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public String addUser(UserEntity userInfo) {
        try {
            System.out.println(userInfo);
            userInfo.setPoints(0);
            userInfo.setRoles("USER");
            userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
            repository.save(userInfo);
            return "user added to system ";
        } catch (Exception e) {
            return e.toString();
        }
    }
}
