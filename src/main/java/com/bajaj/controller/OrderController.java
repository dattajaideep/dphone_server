package com.bajaj.controller;

import com.bajaj.beans.OrderBean;
import com.bajaj.beans.ProductBean;
import com.bajaj.entity.UserEntity;
import com.bajaj.service.JwtService;
import com.bajaj.service.OrderService;

import java.util.Map;
import java.util.Optional;

import com.bajaj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class OrderController {
    @Autowired
    public OrderService orderService;
    @Autowired
    public JwtService jwtService;
    @Autowired
    public UserService userService;
    @PostMapping("/order/add")
    public ResponseEntity<String> newOrder(@RequestBody OrderBean orderBean,@RequestHeader("Authorization") String token ) {
        String name = jwtService.extractUsername(token.split(" ")[1].toString());
        Optional<UserEntity> userEntityOptional = userService.findByname(name);
        return orderService.newOrder(orderBean,userEntityOptional);
    }
    @GetMapping("/displayall")
    public ResponseEntity<Map<OrderBean, ProductBean>> allOrders(@RequestHeader("Authorization") String token )
    {
        String name = jwtService.extractUsername(token.split(" ")[1].toString());
        Optional<UserEntity> userEntityOptional = userService.findByname(name);
        return orderService.allOrders(userEntityOptional);
    }
}
