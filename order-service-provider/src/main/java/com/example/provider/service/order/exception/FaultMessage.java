package com.example.provider.service.order.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FaultMessage {
    private final String faultCode;
    private final String faultText;

}
