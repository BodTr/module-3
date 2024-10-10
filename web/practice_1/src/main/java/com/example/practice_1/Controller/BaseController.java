package com.example.practice_1.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class BaseController extends HttpServlet {
    protected void pageNotFound(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        out.println("<h1>Page Not Found</h1>");
    }
}
