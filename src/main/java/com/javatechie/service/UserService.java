package com.javatechie.service;

import com.javatechie.beans.UserBean;
import com.javatechie.entity.UserEntity;
import com.javatechie.repository.UserInfoRepository;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserInfoRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public static String code(int codeLength) {
        char[] chars = "abcdefghijklmnopqrstuvwxyz1234567890".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new SecureRandom();
        for (int i = 0; i < codeLength; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String output = sb.toString();
        System.out.println(output);
        return output;
    }

    public String addUser(UserEntity userInfo) {
        try {
            System.out.println(userInfo);
            userInfo.setPoints(0);
            userInfo.setRoles("USER");
            userInfo.setReferalCode(code(8));
            userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
            repository.save(userInfo);
            return "user added to system ";
        } catch (Exception e) {
            return e.toString();
        }
    }
}
