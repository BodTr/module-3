package com.ecomerce.test.entities;

public class Item {
    private int id;
    private String name;
    private double price;
    private double discount;
    private int inventory;

    public Item(int id, String name, double price, double discount, int inventory) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.inventory = inventory;
    }

    public Item( String name, double price, double discount, int inventory) {
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.inventory = inventory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", inventory=" + inventory +
                '}';
    }
}
