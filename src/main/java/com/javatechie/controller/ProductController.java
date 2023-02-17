package com.javatechie.controller;

import com.javatechie.beans.ProductBean;
import com.javatechie.dto.AuthRequest;
import com.javatechie.entity.ProductEntity;
import com.javatechie.entity.UserEntity;
import com.javatechie.service.JwtService;
import com.javatechie.service.ProductService;
import com.javatechie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    public ProductService productService;


    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping("/products/all")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<List<ProductBean>> allProducts() {
        List<ProductBean> products = productService.allProducts();
        return new ResponseEntity<List<ProductBean>>(products,HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public List<ProductBean> getProductById(@PathVariable int id) {
        System.out.println("inside single product"+id);
        return productService.productById(id);
    }
}
