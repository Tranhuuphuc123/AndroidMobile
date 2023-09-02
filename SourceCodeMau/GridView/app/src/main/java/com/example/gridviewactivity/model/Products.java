package com.example.gridviewactivity.model;

public class Products {
    private int productID;
    private String name;
    private int price;
    private int image;

    public Products(int productID, String name, int price, int image) {
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
