package com.example.consumer.service.order.contracttest;

import com.example.consumer.service.order.model.OrderConsumerResponse;
import com.example.consumer.service.order.util.JsonUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith({SpringExtension.class})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@AutoConfigureStubRunner(
        stubsMode = StubRunnerProperties.StubsMode.LOCAL,
        ids = "com.example:order-service-provider:+:stubs:8090")
public class OrderContractTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void given_WhenValidRequest_ThenReturnValidResponse()
            throws Exception {
      String body = "{\"itemName\":\"mobile\",\"quantity\":\"3\",\"customerName\":\"Jon\"}";

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/consume/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andExpect(status().isOk())
                .andReturn();
        final OrderConsumerResponse response = JsonUtil
                .fromJsonString(mvcResult.getResponse().getContentAsString(), OrderConsumerResponse.class);

        assertAll(
                () -> assertEquals(response.getId(), 1),
                () -> assertEquals(response.getName(), "mobile"),
                () -> assertEquals(response.getTotalAmount().toString(), "1000.0")
        );
    }
}
