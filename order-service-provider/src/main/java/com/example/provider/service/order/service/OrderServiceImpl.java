package com.example.provider.service.order.service;

import com.example.provider.service.order.model.CalculateOrderRequest;
import com.example.provider.service.order.model.CalculateOrderResponse;
import java.util.HashMap;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl {
    private static final HashMap<String, Double> ITEM_AMOUNT_MAP = new HashMap<>();
    static {

        ITEM_AMOUNT_MAP.put("mobile", Double.valueOf(1000));
        ITEM_AMOUNT_MAP.put("car", Double.valueOf(50000));
        ITEM_AMOUNT_MAP.put("laptop", Double.valueOf(1200));
    }
    public CalculateOrderResponse create(CalculateOrderRequest calculateOrderRequest) {
        //lots of business logic and call to other services...
        return calculateAmount(calculateOrderRequest);
    }

    private CalculateOrderResponse calculateAmount(CalculateOrderRequest request){
        if(ITEM_AMOUNT_MAP.containsKey(request.getItemName())){
            return new CalculateOrderResponse(ITEM_AMOUNT_MAP.get(request.getItemName()), true);
        }
        return new CalculateOrderResponse(Double.valueOf(0), false);
    }
}
