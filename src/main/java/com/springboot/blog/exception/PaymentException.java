package com.springboot.blog.exception;

public class PaymentException extends Exception {
    public PaymentException(String message){
        super(message);
    }
}
