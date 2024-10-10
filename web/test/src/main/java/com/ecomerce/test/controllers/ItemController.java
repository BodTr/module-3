package com.ecomerce.test.controllers;


import com.ecomerce.test.services.ItemService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ItemController", urlPatterns = {"/admin/items/*"})
public class ItemController extends BaseController {
    private ItemService itemService;

    @Override
    public void init() throws ServletException {
        this.itemService = new ItemService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getPathInfo();
        if (url == null) {
            url = "/";
        }

        try {
            if (url.equals("/")) {
                itemService.showItemsList(request, response);
            } else {
                pageNotFound(request, response);
            }

        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        } catch (ServletException e) {
            System.out.println("ServletException: " + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getPathInfo();
        if (url == null) {
            url = "/";
        } else {
            pageNotFound(request, response);
        }
        try {
            if(url.equals("/create")) {
                itemService.createItem(request, response);
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }

}
