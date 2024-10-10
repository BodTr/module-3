package com.books_manager.case_study.Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/books_manager?useSSL=false";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "123456";

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println(con + "Connected to database");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage() + "33");
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            throw new RuntimeException(e);
        }
        return con;
    }
}


