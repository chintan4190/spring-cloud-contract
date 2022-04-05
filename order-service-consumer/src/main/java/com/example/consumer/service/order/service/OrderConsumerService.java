package com.example.consumer.service.order.service;

import com.example.consumer.service.order.model.OrderConsumerRequest;
import com.example.consumer.service.order.model.OrderConsumerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderConsumerService {

    private final ThirdPartyProducerService thirdPartyProducerService;

    public OrderConsumerResponse createOrder(OrderConsumerRequest orderConsumerRequest){
        //some business logic for consumer here

        //calling producer service
        return thirdPartyProducerService.callProducer(orderConsumerRequest);
    }
}
