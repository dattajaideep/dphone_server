package com.bajaj.service;

import com.bajaj.beans.UserBean;
import com.bajaj.entity.UserEntity;
import com.bajaj.repository.UserInfoRepository;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserInfoRepository userInfoRepository;
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
    public ResponseEntity<UserBean> addUser(UserBean userBean) {
    UserEntity userEntity = new UserEntity();
    try {
        System.out.println(userBean);
        userBean.setPoints(0);
        userBean.setRoles("USER");
        userBean.setReferalCode(code(8));
        userBean.setPassword(passwordEncoder.encode(userBean.getPassword()));
        BeanUtils.copyProperties(userBean , userEntity);
        userInfoRepository.save(userEntity);
        System.out.println("You have been added as a user");
        return new ResponseEntity<UserBean>(userBean, HttpStatus.OK);
    }catch(Exception e){
        return new ResponseEntity<UserBean>(userBean,HttpStatus.CONFLICT);
    }
    }
    public List<UserBean> allRecords() {

        //return userDao.findAll()
        List <UserEntity> allUsers=userInfoRepository.findAll();
        List<UserBean> allUserBean=new ArrayList<UserBean>();
        for( UserEntity u: allUsers)
        {
            UserBean bean=new UserBean();
            BeanUtils.copyProperties(u,bean);
            allUserBean.add(bean);
        }
        return allUserBean;
    }
}
