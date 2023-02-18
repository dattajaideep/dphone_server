package com.bajaj.service;

import com.bajaj.beans.OrderBean;
import com.bajaj.entity.OrderEntity;
import com.bajaj.repository.OrderRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    public OrderRepository orderRepository;
    public ResponseEntity<String> newOrder(OrderBean orderBean)
    {
        //   try {
        OrderEntity ordersEntity = new OrderEntity();
        BeanUtils.copyProperties(orderBean, ordersEntity);
        orderRepository.save(ordersEntity);
        return new  ResponseEntity<String>("order executed Successfully", HttpStatus.OK);
        //  }
//        catch (Exception e)
//        {
//            System.out.println(e);
//            return new ResponseEntity<String>("order failed",HttpStatus.CONFLICT);
//
//        }
    }
}
