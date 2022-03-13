package com.example.provider.service.order.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OrderException extends RuntimeException{
    private final String errorMsg;


}
