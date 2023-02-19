package com.bajaj.repository;

import com.bajaj.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity,Integer> {
    @Query("Select u from OrdersEntity u where u.userId = :Id")
    public List<OrdersEntity> findByUserId(int Id);
}
