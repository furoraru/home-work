package com.sbrf.reboot.lesson15.servlet;

import lombok.SneakyThrows;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ServletTest extends Mockito {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private Servlet servlet;
    private StringWriter stringWriter;
    private PrintWriter printWriter;

    @BeforeEach
    void setUp() {
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        servlet = new Servlet();
        stringWriter = new StringWriter();
        printWriter = new PrintWriter(stringWriter);
    }


    @SneakyThrows
    @Test
    @Order(1)
    void testRequestWithParam() {
        when(request.getParameter("name")).thenReturn("Вера");
        when(response.getWriter()).thenReturn(printWriter);

        servlet.doGet(request, response);
        String result = stringWriter.toString();

        assertEquals("Привет, Вера\nCounter = 1", result);
    }

    @SneakyThrows
    @Test
    @Order(2)
    void testRequestWithoutParam() {
        when(request.getParameter("name")).thenReturn(null);
        when(response.getWriter()).thenReturn(printWriter);

        servlet.doGet(request, response);
        String result = stringWriter.toString();

        assertEquals("Привет, user\nCounter = 2", result);
    }

    @SneakyThrows
    @Test
    @Order(3)
    void testWhenThrowIOException() {
        when(request.getParameter("name")).thenReturn(null);
        when(response.getWriter()).thenThrow(IOException.class);

        servlet.doGet(request, response);
        String result = stringWriter.toString();

        assertEquals("", result);
    }
}
