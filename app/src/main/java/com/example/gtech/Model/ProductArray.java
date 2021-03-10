package com.example.gtech.Model;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ProductArray {

   public ArrayList<FreshGate> getFreshGate() {
      return freshGate;
   }

   public void setFreshGate(ArrayList<FreshGate> freshGate) {
      this.freshGate = freshGate;
   }

   @SerializedName("Fresh2gate")
   ArrayList<FreshGate> freshGate;
}
