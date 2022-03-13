package com.example.consumer.service.order.controller;

import com.example.consumer.service.order.model.OrderConsumerRequest;
import com.example.consumer.service.order.model.OrderConsumerResponse;
import com.example.consumer.service.order.service.OrderConsumerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderConsumerController {
    private final OrderConsumerService orderConsumerService;

    @PostMapping("/consume/orders")
    public OrderConsumerResponse createOrder(@RequestBody OrderConsumerRequest orderConsumerRequest){
        return orderConsumerService.createOrder(orderConsumerRequest);
    }
}
