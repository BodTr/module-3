package com.books_manager.case_study.Services;

import com.books_manager.case_study.Entities.Author;
import com.books_manager.case_study.Entities.Book;
import com.books_manager.case_study.Models.AuthorModel;
import com.books_manager.case_study.Models.BookModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookService {
    private BookModel bookModel;
    private AuthorModel authorModel;
    public BookService() {
        this.bookModel = new BookModel();
        this.authorModel = new AuthorModel();
    }

    public void showPageBooksList(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String keyword = request.getParameter("keyword");
        ResultSet data = null;
        int itemsEachPage = 4;
        String page = request.getParameter("page");
        int offset = 0;
        if (page != null) {
            offset = itemsEachPage * (Integer.parseInt(page) - 1);
        }
        if (keyword != null) {
            data = bookModel.findBookByTitle(keyword, itemsEachPage, offset);
        } else {
            data = bookModel.getAllBooks(itemsEachPage, offset);
        }
        List<Book> books = new ArrayList<>();
        while (data.next()) {
            int id = data.getInt("id");
            String title = data.getString("title");
            String author = data.getString("name");
            int authorId = data.getInt("authorId");
            String publisher = data.getString("publisher");
            String isbn = data.getString("isbn");
            String genre = data.getString("genre");
            int pages = data.getInt("pages_count");
            double price = data.getDouble("price");
            Book book = new Book(id, title, author, authorId, publisher, isbn, genre, pages, price);
            books.add(book);
        }

        System.out.println("books: " + books);

        int totalBooks = bookModel.getTotalBooks();
        if (keyword != null) {
            totalBooks = books.size();
        }
        int totalPages = totalBooks % itemsEachPage == 0 ? totalBooks / itemsEachPage : totalBooks / itemsEachPage + 1;

        // Lấy danh sách authors
        ResultSet authorsList = authorModel.getAuthorsIdNName();
        List<Author> authors = new ArrayList<>();
        while (authorsList.next()) {
            int authorId = authorsList.getInt("id");
            String authorName = authorsList.getString("name");
            Author author = new Author(authorId, authorName);
            authors.add(author);
        }
        System.out.println("authors: \n" + authors);
        request.setAttribute("authors", authors);

        request.setAttribute("books", books);
        request.setAttribute("totalBooks", totalBooks);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("currentPage", page);
        RequestDispatcher rd = request.getRequestDispatcher("/views/books/books.jsp");
        rd.forward(request, response);
    }

    public void deleteBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        bookModel.deleteBooks(id);
        response.sendRedirect(request.getContextPath() + "/admin/books");
    }

    public void createBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String title = request.getParameter("title");
        String authorIdString = request.getParameter("authorId");
        int authorId = Integer.parseInt(authorIdString);
        String publisher = request.getParameter("publisher");
        String isbn = request.getParameter("isbn");
        String genre = request.getParameter("genre");
        int pages = Integer.parseInt(request.getParameter("pages_count"));
        double price = Double.parseDouble(request.getParameter("price"));
        Book book = new Book(title, authorId, publisher,isbn, genre, pages, price);
        bookModel.addBook(book);
        response.sendRedirect(request.getContextPath() + "/admin/books");
    }

    public void updateBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String authorIdString = request.getParameter("authorId");
        int authorId = Integer.parseInt(authorIdString);
        String publisher = request.getParameter("publisher");
        String isbn = request.getParameter("isbn");
        String genre = request.getParameter("genre");
        int pages = Integer.parseInt(request.getParameter("pages_count"));
        double price = Double.parseDouble(request.getParameter("price"));
        Book book = new Book(id, title, authorId, publisher, isbn, genre, pages, price);
        bookModel.updateBook(book);
        response.sendRedirect(request.getContextPath() + "/admin/books");
    }

    public Book getBookById(int id) throws SQLException {
        ResultSet data = bookModel.findBookById(id);
        Book book = null;
        if (data.next()) {
            String title = data.getString("title");
            String author = data.getString("author");
            String publisher = data.getString("publisher");
            String isbn = data.getString("isbn");
            String genre = data.getString("genre");
            int pages = data.getInt("pages_count");
            double price = data.getDouble("price");
            book = new Book(title, author, publisher, isbn, genre, pages, price);

        }
        return book;
    }

//    public void getAuthorIdNName(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
//        ResultSet data = authorModel.getAuthorsIdNName();
//        List<Author> authors = new ArrayList<>();
//        if (data.next()) {
//            int authorId = data.getInt("id");
//            String authorName = data.getString("name");
//            Author author = new Author(authorId, authorName);
//            authors.add(author);
//        }
//        System.out.println("authors: \n" + authors);
//        request.setAttribute("authors", authors);
//        RequestDispatcher rd = request.getRequestDispatcher("/views/books/books.jsp");
//        rd.forward(request, response);
//    }
}
