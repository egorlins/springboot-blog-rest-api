package com.springboot.blog.repository;

import com.springboot.blog.entity.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // load full context of application, not testing but using unit test for executing real code
//@DataJpaTest //actually testing
class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    void saveMethod() {
        //create
        Product product = new Product();
        product.setName("product 111");
        product.setActive(true);
        product.setDescription("prod descript");
        product.setSku("jshd");
        product.setImageUrl("www.ee");

        //save
        Product savedProduct = productRepository.save(product);

        //display
        System.out.println(savedProduct.getId());
        System.out.println(savedProduct.toString());
    }

    @Test
    void saveAllMethod() {
        //create
        Product product2 = new Product();
        product2.setName("product 2221");
        product2.setActive(true);
        product2.setDescription("prod 2descript");
        product2.setSku("jshd2");
        product2.setImageUrl("www2.ee");

        //create
        Product product3 = new Product();
        product3.setName("product 1311");
        product3.setActive(true);
        product3.setDescription("prod3 descript");
        product3.setSku("jshd3");
        product3.setImageUrl("www3.ee");

        //save
        productRepository.saveAll(List.of(product2,product3));
    }

    @Test
    void findAllMethod() {

        List <Product> products = productRepository.findAll();

        products.forEach((p)->{
            System.out.println(p.getName());
        });

    }

    @Test
    void countMethod() {
        long count = productRepository.count();
        System.out.println(count);
    }

    @Test
    void existsByIdMethod() {
        boolean exists = productRepository.existsById(1L);
        System.out.println(exists);

        exists = productRepository.existsById(19999L);
        System.out.println(exists);
    }

//    @BeforeEach
//    void setUp() {
//    }
//
//    @AfterEach
//    void tearDown() {
//    }
//
//    @Test
//    void deleteInBatch() {
//    }
//
//    @Test
//    void searchProducts() {
//    }
//
//    @Test
//    void searchProductsSQL() {
//    }
}