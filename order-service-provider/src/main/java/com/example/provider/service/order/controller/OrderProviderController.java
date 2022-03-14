package com.example.provider.service.order.controller;

import com.example.provider.service.order.exception.OrderException;
import com.example.provider.service.order.model.CalculateOrderRequest;
import com.example.provider.service.order.model.CalculateOrderResponse;
import com.example.provider.service.order.service.OrderServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class OrderProviderController {

    private final OrderServiceImpl orderService;


    @PostMapping(value="/providers/calculations", produces="application/json")
    public CalculateOrderResponse createOrder(@RequestBody CalculateOrderRequest calculateOrderRequest){
        if(calculateOrderRequest.getQuantity() <= 0){
            throw new OrderException("invalid request, quantity should be > 0");
        }
        return orderService.create(calculateOrderRequest);
    }

}
