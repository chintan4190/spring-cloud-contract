package com.example.consumer.service.order.util;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class JsonUtil {

    /**
     * The default object mapper for SAM, any customizations should occur here
     */
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * converts the supplied object into a JSON message
     *
     * @param object the object to convert
     * @return a valid json string
     * @throws JsonProcessingException if any internal errors occur
     */
    public static String toJsonString(final Object object) throws JsonProcessingException {
        return OBJECT_MAPPER.writeValueAsString(object);
    }

    /**
     * Utility method using jackson to convert to a specified object type
     *
     * @param json       the json to parse
     * @param objectType the class of the resulting object
     * @param <T>        the generic type argument, determined by return
     * @return a valid generic type
     * @throws IOException if parsing the json to the object fails
     */
    public static <T> T fromJsonString(final String json, final Class<T> objectType) throws IOException {
        return OBJECT_MAPPER.readValue(json, objectType);
    }

}
