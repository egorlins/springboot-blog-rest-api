package com.springboot.blog.service;

import com.springboot.blog.exception.PaymentException;
import com.springboot.blog.payload.LoginDto;
import com.springboot.blog.payload.OrderRequestDto;
import com.springboot.blog.payload.OrderResponseDto;
import com.springboot.blog.payload.RegisterDto;

public interface OrderService {
    OrderResponseDto placeOrder(OrderRequestDto orderRequestDto) throws PaymentException;

}
