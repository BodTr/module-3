package com.example.practice_1.Service;

import com.example.practice_1.Entity.User;
import com.example.practice_1.Model.UserModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private UserModel userModel;
    public UserService() {
        this.userModel = new UserModel();
    }
    public void showPageUserList(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException, NullPointerException {
        String keyword = req.getParameter("keyword");
        ResultSet data = null;
        int itemsEachPage = 2;
        String page = req.getParameter("page");
        int offset = 0;
        if (page != null) {
            offset = itemsEachPage * (Integer.parseInt(page) - 1);
        }

        if (keyword != null) {
            data = userModel.findUserByUserName(keyword, itemsEachPage, offset);
        } else {
            data = userModel.getAllUser(itemsEachPage,offset);
        }
        List<User> users = new ArrayList<>();
        while (data.next()) {

            int id = data.getInt("id");

            String username = data.getString("username");
            String password = data.getString("password");
            String role = data.getString("role");
            User user = new User(id, username, password, role);
            System.out.println(user);
            users.add(user);
            System.out.println(users + "users");
        }

        // tính số lượng trang
        int totalUsers = userModel.getTotalUsers();
        if (keyword != null) {
            totalUsers = users.size();
        }
        System.out.println("totalUsers: " + totalUsers);
        int totalPages = totalUsers % itemsEachPage == 0 ? totalUsers / itemsEachPage : totalUsers / itemsEachPage + 1;
        System.out.println("totalPages: " + totalPages);
        // set data vào request để chuyển xuống jsp
        req.setAttribute("users", users);
        req.setAttribute("totalPages", totalPages);
        req.setAttribute("currentPage", page);

        // foward req đến user.jsp
        RequestDispatcher rd = req.getRequestDispatcher("/views/users/list.jsp");
        rd.forward(req, res);
    }

    public void deleteUser(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(req.getParameter("id"));
        userModel.deleteUser(id);
        res.sendRedirect(req.getContextPath() + "/admin/users");
    }

    public void showPageAddUser(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException {
        RequestDispatcher rd = req.getRequestDispatcher("/views/user/create.jsp");
        rd.forward(req, res);
    }

    public void showPageUpdateUser(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException {
        // get data từ database
        int id = Integer.parseInt(req.getParameter("id"));
        User updatingUser = this.getUserById(id);
        req.setAttribute("updatingUser", updatingUser);
        RequestDispatcher rd = req.getRequestDispatcher("/views/user/update.jsp");
        rd.forward(req, res);
    }

    public void createUser(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String role = req.getParameter("role");
        User user = new User(username, password, role);
        userModel.addUser(user);
        res.sendRedirect(req.getContextPath() + "/admin/users");
    }

    public void updateUser(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(req.getParameter("id"));
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String role = req.getParameter("role");
        User user = new User(id, username, password, role);
        userModel.updateUser(user);
        res.sendRedirect(req.getContextPath() + "/admin/users");
    }


    public User getUserById(int id) throws SQLException {
        ResultSet data = userModel.findUserById(id);
        User user = null;
        while (data.next()) {
            String username = data.getString("username");
            String password = data.getString("password");
            String role = data.getString("role");
            user = new User(id, username, password, role);

        }
        return user;

    }
}
