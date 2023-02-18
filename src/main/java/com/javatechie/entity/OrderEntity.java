package com.javatechie.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="orders")
public class OrderEntity {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(name = "userId")
    private int userId;
    @Column(name = "productId")
    private int productId;
    @Column(name="orderDate")
    @Temporal(TemporalType.DATE)
    private Date orderDate;
    @Column(name = "redeemedPoints")
    private int redeemedPoints;
    @Column(name = "salePrice")
    private int salePrice;
    @Column(name = "orderStatus")
    private String orderStatus;
}
