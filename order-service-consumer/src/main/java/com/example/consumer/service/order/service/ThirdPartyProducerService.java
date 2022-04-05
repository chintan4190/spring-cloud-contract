package com.example.consumer.service.order.service;

import com.example.consumer.service.order.model.CreateOrderRequest;
import com.example.consumer.service.order.model.CreateOrderResponse;
import com.example.consumer.service.order.model.OrderConsumerRequest;
import com.example.consumer.service.order.model.OrderConsumerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class ThirdPartyProducerService {

    private final RestTemplate restTemplate;

    @Value("${orderservice.url}")
    private  String orderServiceUrl;

    public OrderConsumerResponse callProducer(OrderConsumerRequest orderConsumerRequest) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json");

        CreateOrderRequest createOrderRequest = new CreateOrderRequest(orderConsumerRequest.getItemName(), orderConsumerRequest.getQuantity());
        ResponseEntity<CreateOrderResponse> responseEntity = restTemplate
                .exchange(orderServiceUrl, HttpMethod.POST, new HttpEntity<>(createOrderRequest, httpHeaders), CreateOrderResponse.class);
        return new OrderConsumerResponse(1l, orderConsumerRequest.getItemName(), responseEntity.getBody().getTotalAmount());
    }
}
