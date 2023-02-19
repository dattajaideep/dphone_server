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
           try {
        OrderEntity ordersEntity = new OrderEntity();
        BeanUtils.copyProperties(orderBean, ordersEntity);
        orderRepository.save(ordersEntity);
        return new  ResponseEntity<String>("order executed Successfully", HttpStatus.OK);
          }
        catch (Exception e)
        {
            System.out.println(e);
            return new ResponseEntity<String>("order failed",HttpStatus.CONFLICT);

        }
    }
    public ResponseEntity<Map<OrdersBean, ProductBean>> allOrders()
    {
        Map<OrdersBean, ProductBean> orderProduct=new HashMap<>();
        List<OrdersEntity> orders=ordersDao.findByUserId(7); ///here we have to add the id of the user who is logged in
        for (OrdersEntity o: orders)
        {
            ProductEntity product= productDao.findByProductId(o.getProductId());
            OrdersBean ordersBean=new OrdersBean();
            ProductBean productBean=new ProductBean();
            BeanUtils.copyProperties(o,ordersBean);
            BeanUtils.copyProperties(product,productBean);
            orderProduct.put(ordersBean,productBean);
        }
        return  new ResponseEntity<Map<OrdersBean, ProductBean>>(orderProduct,HttpStatus.OK);
    }
}
