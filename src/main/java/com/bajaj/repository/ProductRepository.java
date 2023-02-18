package com.bajaj.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.bajaj.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    List findById(int productId);
}
