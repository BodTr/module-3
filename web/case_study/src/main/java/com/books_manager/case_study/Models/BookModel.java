package com.books_manager.case_study.Models;

import com.books_manager.case_study.Entities.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookModel {
    private List<Book> books;

    private Connection connection;
    public BookModel() {
        books = new ArrayList<>();
        this.connection = Database.getConnection();
        System.out.println("connection = " + connection);
    }
    public ResultSet getAllBooks(int limit, int offset) throws SQLException {
        String sql = "select * from books join authors on authors.id = books.authorId limit ? offset ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, limit);
        statement.setInt(2, offset);
        return statement.executeQuery();

    }

    public int getTotalBooks() throws SQLException {
        String sql = "select count(*) as totalBooks from books";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        int totalBooks = 0;
        while (resultSet.next()) {
            totalBooks = resultSet.getInt("totalBooks");
        }
        return totalBooks;
    }

    public void addBook(Book book) throws SQLException {
        String sql = "insert into books (title, authorId, publisher,isbn, genre, pages_count, price) values (?,?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, book.getTitle());
        statement.setInt(2, book.getAuthorId());
        statement.setString(3, book.getPublisher());
        statement.setString(4, book.getIsbn());
        statement.setString(5, book.getGenre());
        statement.setInt(6, book.getPages_count());
        statement.setDouble(7, book.getPrice());
        statement.execute();
    }

    public void deleteBooks(int id) throws SQLException {
        String sql = "delete from books where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.execute();
    }

    public void updateBook(Book book) throws SQLException {
        String sql = "update books set title=?, authorId=?, publisher=?, isbn=?, genre=?, pages_count=?, price=? where id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, book.getTitle());
        statement.setInt(2, book.getAuthorId());
        statement.setString(3, book.getPublisher());
        statement.setString(4, book.getIsbn());
        statement.setString(5, book.getGenre());
        statement.setInt(6, book.getPages_count());
        statement.setDouble(7, book.getPrice());
        statement.setInt(8, book.getId());
        statement.execute();

    }

    public ResultSet findBookById(int id) throws SQLException {
        String sql = "select * from books where id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        return statement.executeQuery();
    }

    public ResultSet findBookByTitle(String title, int limit, int offset) throws SQLException {
        String sql = "select * from books where title like ? limit ? offset ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "%" + title + "%");
        statement.setInt(2, limit);
        statement.setInt(3, offset);
        return statement.executeQuery();
    }



}
