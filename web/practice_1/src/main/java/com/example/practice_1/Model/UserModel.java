package com.example.practice_1.Model;

import com.example.practice_1.Entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserModel {
    private List<User> users;

    private final Connection connection;
    public UserModel() {
        this.users = new ArrayList<>();
        connection = Database.getConnection();
    }
    public ResultSet getAllUser(int limit, int offset) throws SQLException {
        String sql = "select * from users limit ? offset ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, limit);
        statement.setInt(2, offset);

        return statement.executeQuery();
    }

    public int getTotalUsers() throws SQLException {
        String sql = "select count(*) as totalUser from users";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        int totalUser = 0;
        while (resultSet.next()) {
            totalUser = resultSet.getInt("totalUser");
        }
        return totalUser;
    }

    public void deleteUser(int id) throws SQLException {
        String sql = "delete from users where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.execute();
    }

    public void addUser(User user) throws SQLException {
        String sql = "insert into users (name, password, role) values (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, user.getUsername());
        statement.setString(2, user.getPassword());
        statement.setString(3, user.getRole());
        statement.execute();
    }

    public void updateUser(User user) throws SQLException {
        String sql = "update users set username=?, password=?, role=? where id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, user.getUsername());
        statement.setString(2, user.getPassword());
        statement.setString(3, user.getRole());
        statement.setInt(4, user.getId());
        statement.execute();
    }

    public ResultSet findUserById(int id) throws SQLException {
        String sql = "select * from users where id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        return statement.executeQuery();
    }

    public ResultSet findUserByUserName(String username, int limit, int offset) throws SQLException {
        String sql = "select * from users where username like ? limit ? offset ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "%" + username + "%");
        statement.setInt(2, limit);
        statement.setInt(3, offset);
        return statement.executeQuery();
    }

}
