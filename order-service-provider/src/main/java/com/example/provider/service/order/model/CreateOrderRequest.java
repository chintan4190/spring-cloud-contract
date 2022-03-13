package com.example.provider.service.order.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class CreateOrderRequest {

    @NonNull
    private String itemName;
    private int quantity;
}
