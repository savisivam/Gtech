package com.example.gtech.Adapters;

import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.gtech.Fragments.PoultryFragment;
import com.example.gtech.Model.Products;
import com.example.gtech.R;

import java.util.ArrayList;

public class PoultryListAdapter extends RecyclerView.Adapter<PoultryListAdapter.ViewHolder> {
    Context context;
    ArrayList<Products> productslist;

    public PoultryListAdapter(Context context,ArrayList<Products> productslist) {
        this.context=context;
        this.productslist=productslist;
    }

    @NonNull
    @Override
    public PoultryListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.poultrylist, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PoultryListAdapter.ViewHolder holder, int i) {
        holder.prod_name.setText(productslist.get(i).product_name);
        Glide.with(context)
                .load(String.valueOf(productslist.get(i).product_image))
                .into(holder.pictures);
        holder.gram_rate.setText(productslist.get(i).product_weight);
        holder.price_rate.setText("\u20B9"+productslist.get(i).product_amount);
        holder.demo_price_rate.setText("\u20B9"+productslist.get(i).product_demo_amount);
        holder.demo_price_rate.setPaintFlags(holder.demo_price_rate.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

    }

    @Override
    public int getItemCount() {
        return productslist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
           ImageView pictures;
           TextView prod_name,gram_rate,price_rate,demo_price_rate;
        public ViewHolder(@NonNull View itemView) {
                super(itemView);
                pictures=itemView.findViewById(R.id.pictures);
                prod_name=itemView.findViewById(R.id.prod_name);
                gram_rate=itemView.findViewById(R.id.gram_rate);
                price_rate=itemView.findViewById(R.id.price_rate);
              demo_price_rate=itemView.findViewById(R.id.demo_price_rate);

            }
        }
    }

