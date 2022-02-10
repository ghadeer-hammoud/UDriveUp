package com.example.udriveup.models;

public class Product {

    private int id;
    private String productService;
    private String productTitle;
    private double price;
    private int discount;
    private int distance;
    private float rating;
    private String imageUrl;

    public Product(int id, String productService, String productTitle, double price, int discount, int distance, float rating, String imageUrl) {
        this.id = id;
        this.productService = productService;
        this.productTitle = productTitle;
        this.price = price;
        this.discount = discount;
        this.distance = distance;
        this.rating = rating;
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductService() {
        return productService;
    }

    public void setProductService(String productService) {
        this.productService = productService;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
