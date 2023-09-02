package com.example.mfstore.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//import com.example.mfstore.ProductActivity;
import com.example.mfstore.ProductActivity;
import com.example.mfstore.R;
import com.example.mfstore.model.ExclusivesModels;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment  extends Fragment {

    private View view;
    private Context context;
    // nhóm chức năng properties của xử lý recycleview_home (mượn tạm ard của Exclusives, và cả model lun)
    RecyclerView recyclerViewHome;
    List<ExclusivesModels> homeModel;
    private RoundedImageView productRoundImg, newsImg, careImg, storesImg;



    /*method kế thừa Fragment*/
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_home, container, false);


        // liên kết id của nút button trên giao diện home+fragment(nút nhấn sẽ gọi đến giao dện activity_product.xml)
        productRoundImg = view.findViewById(R.id.round_img_id1);
        // liên kết id của RecycleView chỗ slider các imgae của trang home_fragment.xml
        recyclerViewHome = view.findViewById(R.id.recyclerview_home_id);


        /* xử lý trực tiếp sự kiện click on Button Product Plants chuyển trang giao diện aticity_products
        * phương thức xử lý kiểu giao diện Activity là một file extend  AppCompatActivity*/
        productRoundImg.setOnClickListener(new View.OnClickListener() {
            // gọi lại method gôTProductActicity
            @Override
            public void onClick(View view) {
                goToProductActivity();
            }
        });

        return view;
    }





    private void goToProductActivity() {
        Intent intentProduct;
        intentProduct = new Intent(requireContext(), ProductActivity.class);
        startActivity(intentProduct);
    }





}
