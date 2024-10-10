package com.example.demo1;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        if ("trungop".equals(username) && "123456".equals(password)){
            writer.println("<h1>Welcome " + username + "!</h1>");
        } else {
            writer.println("<h1>Login Error!</h1>");
        }
        writer.println("</html>");
//        writer.close();
    }
}