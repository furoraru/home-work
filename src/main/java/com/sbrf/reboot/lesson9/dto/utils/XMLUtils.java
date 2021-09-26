package com.sbrf.reboot.lesson9.dto.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.sbrf.reboot.lesson9.dto.Request;
import com.sbrf.reboot.lesson9.dto.Response;

public class XMLUtils {
    public static String toXML(Request request) throws JsonProcessingException {
        return new XmlMapper().writeValueAsString(request);
    }

    public static String toXML(Response response) throws JsonProcessingException {
        return new XmlMapper().writeValueAsString(response);
    }

    public static Request XMLtoRequest(String json) throws JsonProcessingException {
        return new XmlMapper().readValue(json, Request.class);
    }

    public static Response XMLtoResponse(String json) throws JsonProcessingException {
        return new XmlMapper().readValue(json, Response.class);
    }
}
