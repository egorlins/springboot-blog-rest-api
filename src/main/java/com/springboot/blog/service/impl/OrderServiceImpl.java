package com.springboot.blog.service.impl;

import com.springboot.blog.entity.Order;
import com.springboot.blog.entity.Payment;
import com.springboot.blog.exception.PaymentException;
import com.springboot.blog.payload.OrderRequestDto;
import com.springboot.blog.payload.OrderResponseDto;
import com.springboot.blog.repository.OrderRepository;
import com.springboot.blog.repository.PaymentRepository;
import com.springboot.blog.service.OrderService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final PaymentRepository paymentRepository;

    public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }


    @Override
    @Transactional(rollbackFor = PaymentException.class)
    public OrderResponseDto placeOrder(OrderRequestDto orderRequestDto) throws PaymentException {

        Order order = orderRequestDto.getOrder();
        order.setStatus("INPROGRESS");
        order.setOrderTrackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);

        Payment payment = orderRequestDto.getPayment();

        if(!payment.getType().equals("DEBIT")){
            throw new PaymentException("Payment card type not supported");
        }

        payment.setOrderId(order.getId());
        paymentRepository.save(payment);

        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setOrderTrackingNumber(order.getOrderTrackingNumber());
        orderResponseDto.setStatus(order.getStatus());
        orderResponseDto.setMessage("SUCCESS");

        return orderResponseDto;
    }
}
