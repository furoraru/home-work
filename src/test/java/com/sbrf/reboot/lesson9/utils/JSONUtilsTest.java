package com.sbrf.reboot.lesson9.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sbrf.reboot.lesson9.dto.Request;
import com.sbrf.reboot.lesson9.dto.Response;
import com.sbrf.reboot.lesson9.dto.utils.JSONUtils;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JSONUtilsTest {

    @SneakyThrows
    @Test
    void toJSONRequest() {
        Request request = new Request("ATM12345");
        Assertions.assertTrue(JSONUtils.toJSON(request).contains("atmNumber"));
    }

    @SneakyThrows
    @Test
    void toJSONResponse() {
        Response response = new Response("SUCCESS");
        Assertions.assertTrue(JSONUtils.toJSON(response).contains("statusCode"));
    }

    @Test
    void JSONtoRequest() throws JsonProcessingException {
        Request request = JSONUtils.JSONtoRequest("{\"atmNumber\":\"ATM12345\"}");
        Assertions.assertEquals("ATM12345", request.getAtmNumber());
    }

    @Test
    void JSONtoResponse() throws JsonProcessingException {
        Response request = JSONUtils.JSONtoResponse("{\"statusCode\":\"SUCCESS\"}");
        Assertions.assertEquals("SUCCESS", request.getStatusCode());
    }

}