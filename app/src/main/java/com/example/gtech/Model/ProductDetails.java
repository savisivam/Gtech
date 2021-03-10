package com.example.gtech.Model;

import com.google.gson.annotations.SerializedName;

public class ProductDetails {
    @SerializedName("price_id")
    String price_id;
    @SerializedName("product_weight")
    String product_weight;
    @SerializedName("product_demo_amount")
    String product_demo_amount;
    @SerializedName("product_amount")
    String product_amount;
    @SerializedName("after_weight")
    String after_weight;

    public String getPrice_id() {
        return price_id;
    }

    public void setPrice_id(String price_id) {
        this.price_id = price_id;
    }

    public String getProduct_weight() {
        return product_weight;
    }

    public void setProduct_weight(String product_weight) {
        this.product_weight = product_weight;
    }

    public String getProduct_demo_amount() {
        return product_demo_amount;
    }

    public void setProduct_demo_amount(String product_demo_amount) {
        this.product_demo_amount = product_demo_amount;
    }

    public String getProduct_amount() {
        return product_amount;
    }

    public void setProduct_amount(String product_amount) {
        this.product_amount = product_amount;
    }

    public String getAfter_weight() {
        return after_weight;
    }

    public void setAfter_weight(String after_weight) {
        this.after_weight = after_weight;
    }

    public String getCleaning_amount() {
        return cleaning_amount;
    }

    public void setCleaning_amount(String cleaning_amount) {
        this.cleaning_amount = cleaning_amount;
    }

    @SerializedName("cleaning_amount")
    String cleaning_amount;






}
