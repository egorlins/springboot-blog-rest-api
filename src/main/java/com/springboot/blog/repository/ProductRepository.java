package com.springboot.blog.repository;

import com.springboot.blog.entity.Product;
import com.springboot.blog.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE " +
            "p.name LIKE CONCAT('%', :query, '%')" +
            "OR p.description LIKE CONCAT('%', :query, '%')")
    List<Product> searchProducts(String query);

    //can be used both queries
    @Query(value = "SELECT * FROM products p WHERE " +
            "p.name LIKE CONCAT('%', :query, '%')" +
            "OR p.description LIKE CONCAT('%', :query, '%')", nativeQuery = true)
    List<Product> searchProductsSQL(String query);
}
