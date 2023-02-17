package com.javatechie.controller;

import com.javatechie.beans.UserBean;
import com.javatechie.dto.AuthRequest;
import com.javatechie.entity.UserEntity;
import com.javatechie.service.JwtService;
import com.javatechie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {
    @Autowired
    private UserService service;

    @Autowired
    private JwtService jwtService;


    @Autowired
    private AuthenticationManager authenticationManager;
    
    @PostMapping("/new")
    public String addNewUser(@RequestBody UserEntity userInfo) {
        return service.addUser(userInfo);
    }

    @PostMapping("/login")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        try {
            System.out.println("in login route");
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
            System.out.println("---------");
            System.out.println(authRequest.getPassword());
            if (authentication.isAuthenticated()) {
                return jwtService.generateToken(authRequest.getUsername());
            } else {
                throw new UsernameNotFoundException("invalid user request !");
            }
        } catch (Exception e) {
            return e.getLocalizedMessage();
        }

    }
}
