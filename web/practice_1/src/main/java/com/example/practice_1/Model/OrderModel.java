package com.example.practice_1.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderModel {
    private Connection connection;
    public OrderModel() {
        connection = Database.getConnection();
    }

    public ResultSet getAllOrders() throws SQLException {
        String sql = "select * from Orders join Customers on Orders.customer_id = Customers.customer_id";
        PreparedStatement ps = connection.prepareStatement(sql);
        return ps.executeQuery();
    }
}
