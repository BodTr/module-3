package com.ecomerce.test.services;

import com.ecomerce.test.entities.Item;
import com.ecomerce.test.models.ItemModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemService {
    private ItemModel itemModel;

    public ItemService() {
        this.itemModel = new ItemModel();
    }

    public void showItemsList(HttpServletRequest req, HttpServletResponse res) throws SQLException, ServletException, IOException {
        ResultSet data = itemModel.getAllItems();
        List<Item> items = new ArrayList<>();
        while (data.next()) {
            int id = data.getInt("id");
            String name = data.getString("name");
            Double price = data.getDouble("price");
            Double discount = data.getDouble("discount");
            int inventory = data.getInt("inventory");
            items.add(new Item(id, name, price, discount, inventory));

        }
        System.out.println("items: " + items);
        req.setAttribute("items", items);
        RequestDispatcher rd = req.getRequestDispatcher("/views/items/items.jsp");
        rd.forward(req, res);
    }

    public void createItem(HttpServletRequest req, HttpServletResponse res) throws SQLException, ServletException, IOException {
        String name = req.getParameter("name");
        Double price = Double.parseDouble(req.getParameter("price"));
        Double discount = Double.parseDouble(req.getParameter("discount"));
        int inventory = Integer.parseInt(req.getParameter("inventory"));
        Item item = new Item(name, price, discount, inventory);
        itemModel.addItem(item);
        res.sendRedirect(req.getContextPath() + "/admin/items");
    }
}
