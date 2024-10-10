package com.books_manager.case_study.Models;

import com.books_manager.case_study.Entities.Author;
import com.books_manager.case_study.Entities.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class AuthorModel {
    private List<Author> authors;
    private Connection connection;

    public AuthorModel() {
        authors = new ArrayList<>();
        this.connection = Database.getConnection();
    }

    public ResultSet getAllAuthors(int limit, int offset) throws SQLException {
        String sql = "select * from authors limit ? offset ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, limit);
        statement.setInt(2, offset);
        return statement.executeQuery();
    }

    public int getTotalAuthors() throws SQLException {
        String sql = "select count(*) as totalAUthors from authors";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        int totalAuthors = 0;
        while (resultSet.next()) {
            totalAuthors = resultSet.getInt("totalAUthors");
        }
        return totalAuthors;
    }

    public void addAuthor(Author author) throws SQLException {
        String sql = "insert into authors (name, birthDate, bio) values (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, author.getName());
        statement.setObject(2, author.getBirthDate());
        statement.setString(3, author.getBio());
        statement.execute();
    }

    public void deleteAuthor(int id) throws SQLException {
        String sql = "delete from authors where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.execute();
    }

    public void updateAuthor(Author author) throws SQLException {
        String sql = "update authors set name=?, birthDate=?, bio=? where id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, author.getName());
        statement.setObject(2, author.getBirthDate());
        statement.setString(3, author.getBio());
        statement.setInt(4, author.getId());
        statement.execute();
    }

    public ResultSet findAuthorById(int id) throws SQLException {
        String sql = "select * from authors where id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        return statement.executeQuery();
    }

    public ResultSet findAuthorByName(String name, int limit, int offset) throws SQLException {
        String sql = "select * from authors where name like ? limit ? offset ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "%" + name + "%");
        statement.setInt(2, limit);
        statement.setInt(3, offset);
        return statement.executeQuery();
    }

    public ResultSet getAuthorsIdNName() throws SQLException {
        String sql = "select id, name from authors";
        PreparedStatement statement = connection.prepareStatement(sql);
        return statement.executeQuery();
    }
}


