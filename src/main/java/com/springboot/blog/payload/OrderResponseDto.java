package com.springboot.blog.payload;

import com.springboot.blog.entity.Order;
import com.springboot.blog.entity.Payment;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderResponseDto {
    private String orderTrackingNumber;
    private String status;
    private String message;

}
