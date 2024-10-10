package com.example.money_converter;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "Converter", value = "/currency-converter")
public class Converter extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
//        String url = request.getPathInfo();
//        if (url == null) {
//            url = "/";
//        }
        request.setCharacterEncoding("UTF-8");
//        request.setAttribute("message", message);
        RequestDispatcher rd = request.getRequestDispatcher("/currency-converter.jsp");
        try {
            rd.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        double rate = Double.parseDouble(request.getParameter("rate"));
        double usd = Double.parseDouble(request.getParameter("usd"));
        RequestDispatcher rd = request.getRequestDispatcher("/currency-converter.jsp");
        try {
            req
        }
    }

    public void destroy() {
    }
}