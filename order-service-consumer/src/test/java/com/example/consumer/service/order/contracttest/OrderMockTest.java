package com.example.consumer.service.order.contracttest;

import com.example.consumer.service.order.model.OrderConsumerRequest;
import com.example.consumer.service.order.model.OrderConsumerResponse;
import com.example.consumer.service.order.service.ThirdPartyProducerService;
import com.example.consumer.service.order.util.JsonUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith({SpringExtension.class})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc

public class OrderMockTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ThirdPartyProducerService thirdPartyProducerService;

    @Test
    public void given_WhenValidRequest_ThenReturnValidResponseWithMock()
            throws Exception {
      String body = "{\"itemName\":\"mobile\",\"quantity\":\"3\",\"customerName\":\"Jon\"}";

      when(thirdPartyProducerService.callProducer(any(OrderConsumerRequest.class))).thenReturn(new OrderConsumerResponse(1l, "mobile",Double.valueOf("1000.0")));

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
