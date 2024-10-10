package com.books_manager.case_study.Controllers;

import com.books_manager.case_study.Services.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "BookController", urlPatterns = {"/admin/books/*"})
public class BookController extends BaseController {
    private BookService bookService;

    @Override
    public void init() throws ServletException {
        this.bookService = new BookService();
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
                    bookService.showPageBooksList(request, response);
//                    bookService.getAuthorIdNName(request, response);
                    break;
                case "/create":
                    bookService.createBook(request, response);
                    break;
                case "/update":
                    bookService.updateBook(request, response);
                    break;
                case "/delete":
                    bookService.deleteBook(request, response);
                    break;
                default:
                    pageNotFound(request, response);
            }
        } catch (SQLException e) {
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
                    bookService.createBook(request, response);

                    break;
                case "/update":
                    bookService.updateBook(request, response);
                    break;
                default:
                    pageNotFound(request, response);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new ServletException(e);
        }
    }
}
