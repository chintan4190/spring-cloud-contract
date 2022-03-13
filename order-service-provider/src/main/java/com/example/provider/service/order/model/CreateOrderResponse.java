package com.example.provider.service.order.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateOrderResponse {
    private Double totalAmount;
    private boolean isAvailable;

}