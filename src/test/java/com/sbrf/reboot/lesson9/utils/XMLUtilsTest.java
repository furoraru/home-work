package com.sbrf.reboot.lesson9.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sbrf.reboot.lesson9.dto.Request;
import com.sbrf.reboot.lesson9.dto.Response;
import com.sbrf.reboot.lesson9.dto.utils.XMLUtils;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class XMLUtilsTest {

    @SneakyThrows
    @Test
    void toXMLRequest() {
        Request request = new Request("ATM12345");
        Assertions.assertTrue(XMLUtils.toXML(request).contains("atmNumber"));
    }

    @SneakyThrows
    @Test
    void toXMLResponse() {
        Response response = new Response("SUCCESS");
        Assertions.assertTrue(XMLUtils.toXML(response).contains("statusCode"));
    }

    @Test
    void XMLtoRequest() throws JsonProcessingException {
        Request request = XMLUtils.XMLtoRequest("<Request><atmNumber>ATM12345</atmNumber></Request>");
        Assertions.assertEquals("ATM12345", request.getAtmNumber());
    }

    @Test
    void XMLtoResponse() throws JsonProcessingException {
        Response request = XMLUtils.XMLtoResponse("<Response><statusCode>SUCCESS</statusCode></Response>");
        Assertions.assertEquals("SUCCESS", request.getStatusCode());
    }

}