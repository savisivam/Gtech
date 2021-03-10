package com.example.gtech.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class FreshGate {


    @SerializedName("id")
    String id;
    @SerializedName("category_id")
    String categoryId;
    @SerializedName("product_name")
    String productName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRecommended() {
        return recommended;
    }

    public void setRecommended(String recommended) {
        this.recommended = recommended;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public ArrayList<ProductDetails> getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(ArrayList<ProductDetails> productDetails) {
        this.productDetails = productDetails;
    }

    @SerializedName("product_image")
    String productImage;
    @SerializedName("type")
    String type;
    @SerializedName("recommended")
    String recommended;
    @SerializedName("available")
    String available;
    @SerializedName("product_details")
    ArrayList<ProductDetails> productDetails;


}