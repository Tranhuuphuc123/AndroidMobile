package com.example.mfstore.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.mfstore.R;
import com.example.mfstore.model.AllProductModels;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.List;

public class CartFragment extends Fragment {

  RecyclerView recyclerViewCart;
  List<AllProductModels> cartModel;

  private RoundedImageView productRoundImg;
  private ImageView icon;
  private View view;

  /*method kế thừa Fragment*/
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_cart, container, false);
        recyclerViewCart = view.findViewById(R.id.recycleview_cart_id);

      return view;
    }
}