package com.example.capstone2.Repostore;

import com.example.capstone2.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepostory extends JpaRepository<Product,Integer> {
    Product findAllById (Integer Id);
    boolean findAllByProductsPriceLessThanEqual(Double points);
}