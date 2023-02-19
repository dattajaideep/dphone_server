package com.bajaj.controller;

import com.bajaj.beans.OrderBean;
import com.bajaj.beans.ProductBean;
import com.bajaj.service.OrderService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class OrderController {
    @Autowired
    public OrderService orderService;
    @PostMapping("/order/add")
    public ResponseEntity<String> newOrder(@RequestBody OrderBean orderBean) {
        return orderService.newOrder(orderBean);
    }
    @GetMapping("/displayall")
    public ResponseEntity<Map<OrderBean, ProductBean>> allOrders()
    {
        return orderService.allOrders();
    }

}
