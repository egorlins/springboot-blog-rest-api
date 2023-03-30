package com.springboot.blog.controller;

import com.springboot.blog.entity.Product;
import com.springboot.blog.payload.CommentDto;
import com.springboot.blog.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProucts(@RequestParam("query") String query) {
        return ResponseEntity.ok(productService.searchProducts(query));//todo ProductDTO
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product){ //todo ProductDTO
        return productService.createProduct(product);
    }
}
