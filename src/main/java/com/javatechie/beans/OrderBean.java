package com.javatechie.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderBean {
    private int Id;
    private int userId;
    private int productId;
    private Date orderDate;
    private int redeemedPoints;
    private int salePrice;
    private String orderStatus;
}
