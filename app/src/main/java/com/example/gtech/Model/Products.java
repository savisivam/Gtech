package com.example.gtech.Model;

import com.google.gson.annotations.SerializedName;

public class Products {
    public String product_weight;
    public String product_demo_amount;
    public String product_amount;
    public String getCat_id() {
        return cat_id;
    }

    public void setCat_id(String cat_id) {
        this.cat_id = cat_id;
    }

    @SerializedName("cat_id")
    String cat_id;
    @SerializedName("count")
    String count;
public String getCount(){
    return count;
}
    public void setCount(String count){
    this.count=count;
}

    public String product_name;
    public  String product_image;

    public String getproduct_name() {
        return product_name;
    }

    public void setproduct_name(String product_name) {
        this.product_name = product_name;
    }

}
