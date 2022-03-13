package com.example.consumer.service.order.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderConsumerResponse {
    private Long id;
    private String name;
    private Double totalAmount;
}
