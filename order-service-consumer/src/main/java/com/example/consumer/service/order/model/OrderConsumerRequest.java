package com.example.consumer.service.order.model;

import lombok.Data;

@Data
public class OrderConsumerRequest {

    private String itemName;
    private int quantity;
    private String customerName;
}
