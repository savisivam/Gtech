package com.example.gtech.Viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.gtech.Adapters.PoultryListAdapter;
import com.example.gtech.Model.ProductArray;
import com.example.gtech.Model.ProductDetails;
import com.example.gtech.Model.Products;
import com.example.gtech.MyApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataViewModel extends ViewModel {
    public MutableLiveData<ProductArray> products = new MutableLiveData<>();


    public void getProducts() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MyApi request = retrofit.create(MyApi.class);

        Products productsDAta = new Products();
        productsDAta.setCount("");
        productsDAta.setCat_id("17");


        Call<ProductArray> call = request.getListdata(productsDAta);
        call.enqueue(new Callback<ProductArray>() {
            @Override
            public void onResponse(Call<ProductArray> call, Response<ProductArray> response) {
                if (response.isSuccessful() && response.body() != null) {
                    String jsonresponse = null;
                 /*   try {
                        jsonresponse = response.body().string();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }*/

                    products.setValue(response.body());
                } else {
                    Log.i("onEmptyResponse", "Returned empty response");
                }
            }

            @Override
            public void onFailure(Call<ProductArray> call, Throwable t) {
                Log.d("Error", t.getMessage());

            }
        });
    }


}





