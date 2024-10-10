package com.books_manager.case_study.Services;

import com.books_manager.case_study.Entities.Author;
import com.books_manager.case_study.Models.AuthorModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AuthorService {
    private AuthorModel authorModel;
    public AuthorService() {
        this.authorModel = new AuthorModel();
    }
    public void showPageAuthorsList(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String keyword = request.getParameter("keyword");
        ResultSet data = null;
        int itemsPerPage = 2;
        String page = request.getParameter("page");
        int offset = 0;
        if (page != null) {
            offset = itemsPerPage * (Integer.parseInt(page) - 1);
        }
        if (keyword != null) {
            data = authorModel.findAuthorByName(keyword, itemsPerPage, offset);

        } else {
            data = authorModel.getAllAuthors(itemsPerPage, offset);
        }

        List<Author> authors = new ArrayList<>();
        while (data.next()) {
            int id = data.getInt("id");
            String name = data.getString("name");
            LocalDate birthDate = data.getDate("birthDate").toLocalDate();
            String bio = data.getString("bio");
            Author author = new Author(id, name, birthDate, bio);
            authors.add(author);
        }
        int totalAuthors = authorModel.getTotalAuthors();
        if (keyword != null) {
            totalAuthors = authors.size();
        }
        int totalPages = totalAuthors % itemsPerPage == 0 ? totalAuthors / itemsPerPage : totalAuthors / itemsPerPage + 1;
        request.setAttribute("totalAuthors", totalAuthors);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("authors", authors);
        request.setAttribute("page", page);
        RequestDispatcher rd = request.getRequestDispatcher("/views/authors/authors.jsp");
        rd.forward(request, response);
    }

    public void deleteAuthor(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        authorModel.deleteAuthor(id);
        response.sendRedirect(request.getContextPath() + "/views/authors/authors.jsp");
    }

    public void createAuthor(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name = request.getParameter("name");
        System.out.println(name + "name");
        String bio = request.getParameter("bio");
        System.out.println(bio + "bio");
        String birthDateString = request.getParameter("birthDate");
        System.out.println(birthDateString + "birthDateString");
        LocalDate birthDate = LocalDate.parse(birthDateString);
        Author author = new Author(name, birthDate, bio);
        authorModel.addAuthor(author);
        response.sendRedirect(request.getContextPath() + "/admin/authors");
    }

    public void updateAuthor(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String bio = request.getParameter("bio");
        LocalDate birthDate = LocalDate.parse(request.getParameter("birthDate"));
        Author author = new Author(id, name, birthDate, bio);
        authorModel.updateAuthor(author);
        response.sendRedirect(request.getContextPath() + "/admin/authors");
    }

    public Author getAuthorById(int id) throws SQLException {
        ResultSet data = authorModel.findAuthorById(id);
        Author author = null;
        if (data.next()) {
            String name = data.getString("name");
            LocalDate birthDate = LocalDate.parse(data.getString("birthDate"));
            String bio = data.getString("bio");

            author = new Author(name, birthDate, bio);

        }
        return author;
    }
}
