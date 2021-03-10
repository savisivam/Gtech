package com.example.gtech;

import com.example.gtech.Model.ProductArray;
import com.example.gtech.Model.ProductDetails;
import com.example.gtech.Model.Products;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface MyApi {
    String BASE_URL = "https://veggis.in/";

    @POST("fresh2gate/dashboard/api/get_all_products.php")
    Call<ProductArray> getListdata(@Body Products products);

}
