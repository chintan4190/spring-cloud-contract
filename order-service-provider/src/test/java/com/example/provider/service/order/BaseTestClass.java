package com.example.provider.service.order;

import com.example.provider.service.order.controller.OrderProviderController;
import com.example.provider.service.order.model.CalculateOrderResponse;
import com.example.provider.service.order.service.OrderServiceImpl;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.when;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@DirtiesContext
@AutoConfigureMessageVerifier
@ExtendWith({SpringExtension.class})
public class BaseTestClass {

    @Autowired
    protected WebApplicationContext context;

    @Autowired
    private OrderProviderController orderProviderController;

    @MockBean
    private OrderServiceImpl orderService;

    @BeforeEach
    public void setup() {
        StandaloneMockMvcBuilder standaloneMockMvcBuilder
                = MockMvcBuilders.standaloneSetup(orderProviderController);
        RestAssuredMockMvc.webAppContextSetup(this.context);

        when(orderService.create(ArgumentMatchers.any())).thenReturn(new CalculateOrderResponse(Double.valueOf(1000),true));
    }
}