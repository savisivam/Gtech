package com.example.gtech.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gtech.Adapters.PoultryListAdapter;
import com.example.gtech.Model.Products;
import com.example.gtech.MyApi;
import com.example.gtech.R;
import com.example.gtech.Viewmodel.DataViewModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MuttonFragment extends Fragment {
    RecyclerView recyclerView;
    ArrayList<Products> product_list;
    PoultryListAdapter poultryListAdapter;
    String cat_id;
    String count="";
    Products products;
    public MuttonFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_poultry, container, false);
        recyclerView = view.findViewById(R.id.poultry_recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),
                DividerItemDecoration.VERTICAL));

        DataViewModel viewModel = new ViewModelProvider(requireActivity()).get(DataViewModel.class);
        viewModel.getProducts();
      /*  viewModel.products.observe(this, productsString -> {
            product_details(productsString);

        });*/


        viewModel.products.observe(getViewLifecycleOwner(), productsString -> {

            //  product_details(productsString);

            product_list = new ArrayList<>();
            for (int i=0;i<productsString.getFreshGate().size();i++){
                products = new Products();
                products.product_name = productsString.getFreshGate().get(i).getProductName();;
                products.product_image = productsString.getFreshGate().get(i).getProductImage();;
                products.product_amount= productsString.getFreshGate().get(i).getProductDetails().get(0).getProduct_amount();;
                products.product_demo_amount= productsString.getFreshGate().get(i).getProductDetails().get(0).getProduct_demo_amount();;
                products.product_weight= productsString.getFreshGate().get(i).getProductDetails().get(0).getProduct_weight();;
                product_list.add(products);
            }

            poultryListAdapter = new PoultryListAdapter(getActivity(),product_list);
            recyclerView.setAdapter(poultryListAdapter);
        });
        return view;

    }

    @Override
    public void onResume() {
        Log.e("onResume", "onResume");
        super.onResume();

    }

/*
    public void fetchData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MyApi request = retrofit.create(MyApi.class);

        Products products = new Products();
        products.setCount("");
        products.setCat_id("17");

        Call<ResponseBody> call = request.getListdata(products);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful() && response.body() != null) {
                    String jsonresponse = null;
                    try {
                        jsonresponse = response.body().string();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("resposeee" + jsonresponse);
                    product_details(jsonresponse);
                } else {
                    Log.i("onEmptyResponse", "Returned empty response");
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("Error", t.getMessage());

            }
        });
    }
*/

    public void product_details(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray freshgate = jsonObject.getJSONArray("Fresh2gate");
            System.out.println("arrayyy" + freshgate);
            product_list = new ArrayList<>();
            if (freshgate != null) {
                for (int i = 0; i < freshgate.length(); i++) {
                    JSONArray obj_brand = freshgate.getJSONObject(1).getJSONArray("product_details");
                    for(int j=0;j<obj_brand.length();j++){
                        products = new Products();
                        products.product_name = freshgate.getJSONObject(i).getString("product_name");
                        products.product_image = freshgate.getJSONObject(i).getString("product_image");
                        products.product_amount= obj_brand.getJSONObject(j).getString("product_amount");
                        products.product_demo_amount= obj_brand.getJSONObject(j).getString("product_demo_amount");
                        products.product_weight= obj_brand.getJSONObject(j).getString("product_weight");
                        product_list.add(products);
                        System.out.println("producttt" + product_list);

                    }

                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        poultryListAdapter = new PoultryListAdapter(getActivity(),product_list);
        recyclerView.setAdapter(poultryListAdapter);

    }
}