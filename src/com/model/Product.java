package com.model;

import java.io.Serializable;

public class Product implements Serializable {
    private int idProduct;
    private String nameProduct;
    private double price;
    private int amount;
    private String manufacturer;
    private String dateOfManufacture;
    private String expiryDate;
    private Category category = new Category();


    public Product() {
    }

    public Product(int idProduct, String nameProduct, double price, int amount, String manufacturer, String dateOfManufacture, String expiryDate, String categoryName, int categoryId) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.price = price;
        this.amount = amount;
        this.manufacturer = manufacturer;
        this.dateOfManufacture = dateOfManufacture;
        this.expiryDate = expiryDate;
        category.setName(categoryName);
        category.setId(categoryId);
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct() {
        this.idProduct = (int) (Math.random() * 10000);
    }


    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(String dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }


    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct +
                ", nameProduct='" + nameProduct + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", manufacturer='" + manufacturer + '\'' +
                ", dateOfManufacture='" + dateOfManufacture + '\'' +
                ", expiryDate='" + expiryDate + '\'' +
                ", category=" + category.getName() +
                '}';
    }
}
