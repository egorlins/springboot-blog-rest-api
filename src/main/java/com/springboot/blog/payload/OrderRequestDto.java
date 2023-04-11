package com.springboot.blog.payload;

import com.springboot.blog.entity.Payment;
import com.springboot.blog.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
public class OrderRequestDto {
    private Order order;
    private Payment payment;
}
