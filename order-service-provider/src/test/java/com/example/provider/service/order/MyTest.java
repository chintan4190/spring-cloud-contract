package com.example.provider.service.order;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import io.restassured.module.mockmvc.specification.MockMvcRequestSpecification;
import io.restassured.response.ResponseOptions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.toomuchcoding.jsonassert.JsonAssertion.assertThatJson;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.assertj.core.api.Assertions.assertThat;

public class MyTest extends BaseTestClass{

    @Test
    @Disabled
    public void validate_orderCreateHappyFlow() throws Exception {
        // given:
        MockMvcRequestSpecification request = given()
                .header("Content-Type", "application/json")
                .body("{\"itemName\":\"mobile\",\"quantity\":\"3\"}");

        // when:
        ResponseOptions response = given().spec(request)
                .post("/orders");

        // then:
        assertThat(response.statusCode()).isEqualTo(200);
        assertThat(response.header("Content-Type")).matches("application/json.*");

        // and:
        DocumentContext parsedJson = JsonPath.parse(response.getBody().asString());
        assertThatJson(parsedJson).field("['totalAmount']").isEqualTo("1000");
        assertThatJson(parsedJson).field("['available']").isEqualTo(true);
    }
}
