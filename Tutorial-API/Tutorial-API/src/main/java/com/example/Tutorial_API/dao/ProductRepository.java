package com.example.Tutorial_API.dao;

import com.example.Tutorial_API.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    @Query(value = "SELECT * FROM product where category = :category ", nativeQuery = true)
    List<Product> findByCategory (@Param("category") String category);
}
