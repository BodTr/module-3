package com.books_manager.case_study.Controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class BaseController extends HttpServlet {
    protected void pageNotFound(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setStatus(HttpServletResponse.SC_NOT_FOUND);
        PrintWriter out = res.getWriter();
        res.setContentType("text/html");
        out.println("<h1>Page Not Found</h1>");
    }
}
