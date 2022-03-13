package com.example.consumer.service.order.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateOrderRequest {

    private String itemName;
    private int quantity;
}
