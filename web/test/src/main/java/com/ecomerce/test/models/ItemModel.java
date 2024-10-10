package com.ecomerce.test.models;

import com.ecomerce.test.entities.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemModel {
    private List<Item> items;
    private Connection connection;
    public ItemModel() {
        items = new ArrayList<>();
        this.connection = Database.getConnection();
        System.out.println("connection = " + connection);
    }

    public ResultSet getAllItems() throws SQLException {
        String sql = "select * from items";
        PreparedStatement statement = connection.prepareStatement(sql);
        return statement.executeQuery();

    }

    public void addItem(Item item) throws SQLException {
        String sql = "insert into items (name, price, discount, inventory) values (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, item.getName());
        statement.setDouble(2, item.getPrice());
        statement.setDouble(3, item.getDiscount());
        statement.setInt(4, item.getInventory());
        statement.execute();
    }


}
