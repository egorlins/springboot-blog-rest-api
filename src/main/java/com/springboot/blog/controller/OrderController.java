package com.springboot.blog.controller;

import com.springboot.blog.entity.Product;
import com.springboot.blog.exception.PaymentException;
import com.springboot.blog.payload.OrderRequestDto;
import com.springboot.blog.payload.OrderResponseDto;
import com.springboot.blog.service.OrderService;
import com.springboot.blog.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping()
    public ResponseEntity<OrderResponseDto> placeOrder(@RequestBody OrderRequestDto orderRequestDto) throws PaymentException {
        return ResponseEntity.ok(orderService.placeOrder(orderRequestDto));
    }

}
