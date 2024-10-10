package com.books_manager.case_study.Controllers;

import com.books_manager.case_study.Services.AuthorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AuthorController", urlPatterns = {"/admin/authors/*"})
public class AuthorController extends BaseController {
    private AuthorService authorService;

    @Override
    public void init() throws ServletException {
        this.authorService = new AuthorService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getPathInfo();
        if (url == null) {
            url = "/";
        }

        try {
            switch (url) {
                case "/":
                    authorService.showPageAuthorsList(request, response);
                    break;
                case "/create":
                    authorService.createAuthor(request, response);
                    break;
                case "/update":
                    authorService.updateAuthor(request, response);
                    break;
                case "/delete":
                    authorService.deleteAuthor(request, response);
                    break;
                default:
                    pageNotFound(request, response);
            }
        } catch ( SQLException e ) {
            System.out.println(e.getMessage());
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getPathInfo();
        if (url == null) {
            url = "/";
        }

        try {
            switch (url) {
                case "/create":
                    authorService.createAuthor(request, response);
                    break;
                case "/update":
                    authorService.updateAuthor(request, response);
                    break;
                default:
                    pageNotFound(request, response);
            }
        } catch (SQLException e ) {
            System.out.println(e.getMessage());
            throw new ServletException(e);
        }
    }
}
