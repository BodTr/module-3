package com.example.practice_1.Controller;

import com.example.practice_1.Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UserController", urlPatterns = {"/admin/users/*"})
public class UserController extends BaseController {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        this.userService = new UserService(); // tạo mới 1 đối tượng UserService khi Servlet vừa tạo ra trong init() method
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        if (url == null) {
            url = "/";
        }
        try {
            switch (url) {
                case "/":
                    userService.showPageUserList(req, resp);
                    break;
                case "/delete":
                    userService.deleteUser(req, resp);
                    break;
                case "/create":
                    userService.createUser(req, resp);
                    break;
                case "/update":
                    userService.updateUser(req, resp);
                    break;
                default:
                    pageNotFound(req, resp);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new ServletException(e);
        }

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        if (url == null) {
            url = "/";
        }

        try {
            switch (url) {
                case "/create":
                    userService.createUser(req, resp);
                    break;
                case "/update":
                    userService.updateUser(req, resp);
                    break;
                default:
                    pageNotFound(req, resp);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new ServletException(e);
        }

    }
}

