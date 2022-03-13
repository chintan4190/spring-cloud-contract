package com.example.provider.service.order.controller;

import com.example.provider.service.order.exception.OrderException;
import com.example.provider.service.order.model.CreateOrderRequest;
import com.example.provider.service.order.model.CreateOrderResponse;
import com.example.provider.service.order.service.OrderServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class OrderProviderController {

    private final OrderServiceImpl orderService;


    @PostMapping(value="/orders", produces="application/json")
    public CreateOrderResponse createOrder(@RequestBody CreateOrderRequest createOrderRequest){
        if(createOrderRequest.getQuantity() <= 0){
            throw new OrderException("invalid request, quantity should be > 0");
        }
        return orderService.create(createOrderRequest);
    }

}
