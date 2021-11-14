package com.sbrf.reboot.lesson15.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet(
        name = "Servlet",
        description = "Servlet description",
        urlPatterns = "/helloServlet"
)
public class Servlet extends HttpServlet {

    private static final String defaultName = "user";
    private static final AtomicInteger counter = new AtomicInteger(0);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        counter.getAndIncrement();

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        try {
            PrintWriter printWriter = response.getWriter();
            printWriter.write(String.format("Привет, %s\nCounter = %s", name == null ? defaultName : name, counter));
            printWriter.close();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }

    }

}
