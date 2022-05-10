package com.LiZhihui.model;

import java.io.InputStream;

public class Product {
    private int ProductId;
    private String ProductName;
    private String ProductDescription;
    private InputStream picture;
    private double price;
    private int CategoryId;

    public Product(){}

    public Product(int productId, String productName, String productDescription, InputStream picture, double price, int categoryId) {
        ProductId = productId;
        ProductName = productName;
        ProductDescription = productDescription;
        this.picture = picture;
        this.price = price;
        CategoryId = categoryId;
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int productId) {
        ProductId = productId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getProductDescription() {
        return ProductDescription;
    }

    public void setProductDescription(String productDescription) {
        ProductDescription = productDescription;
    }

    public InputStream getPicture() {
        return picture;
    }

    public void setPicture(InputStream picture) {
        this.picture = picture;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int categoryId) {
        this.CategoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "ProductId=" + ProductId +
                ", ProductName='" + ProductName + '\'' +
                ", ProductDescription='" + ProductDescription + '\'' +
                ", picture=" + picture +
                ", price=" + price +
                ", CategoryId=" + CategoryId +
                '}';
    }
}
