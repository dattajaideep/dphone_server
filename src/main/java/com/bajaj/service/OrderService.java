package com.bajaj.service;

import com.bajaj.beans.OrderBean;
import com.bajaj.beans.ProductBean;
import com.bajaj.entity.OrderEntity;
import com.bajaj.entity.ProductEntity;
import com.bajaj.entity.UserEntity;
import com.bajaj.repository.OrderRepository;
import com.bajaj.repository.ProductRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    public OrderRepository orderRepository;

    @Autowired
    public ProductRepository productRepository;
    public ResponseEntity<String> newOrder(OrderBean orderBean, Optional<UserEntity> userEntityOptional)
    {
        try {
            OrderEntity ordersEntity = new OrderEntity();
            BeanUtils.copyProperties(orderBean, ordersEntity);
            int id=userEntityOptional.get().getId();
            ordersEntity.setId(id);
            orderRepository.save(ordersEntity);
            return new  ResponseEntity<String>("order executed Successfully", HttpStatus.OK);
        }
        catch (Exception e)
        {
            System.out.println(e);
            return new ResponseEntity<String>("order failed",HttpStatus.CONFLICT);

        }
    }
    public ResponseEntity<Map<OrderBean, ProductBean>> allOrders(Optional<UserEntity> userEntityOptional)
    {
        Map<OrderBean, ProductBean> orderProduct=new HashMap<>();
        int id= userEntityOptional.get().getId();
        List<OrderEntity> orders= orderRepository.findByUserId(id); ///here we have to add the id of the user who is logged in
        for (OrderEntity o: orders)
        {
            ProductEntity product= productRepository.findByProductId(o.getProductId());
            OrderBean ordersBean=new OrderBean();
            ProductBean productBean=new ProductBean();
            BeanUtils.copyProperties(o,ordersBean);
            BeanUtils.copyProperties(product,productBean);
            orderProduct.put(ordersBean,productBean);
        }
        return  new ResponseEntity<Map<OrderBean, ProductBean>>(orderProduct,HttpStatus.OK);
    }
}
