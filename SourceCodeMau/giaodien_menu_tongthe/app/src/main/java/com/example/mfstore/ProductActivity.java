package com.example.mfstore;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.mfstore.model.ProductModels;

import java.util.ArrayList;
import java.util.List;


public class ProductActivity extends AppCompatActivity {
    // properties product
    private List<ProductModels> listProducts;
    private RecyclerView recyclerView_product;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        // gọi class ánh xạ các id
        init();
    }


    /* hàm ánh xạ id của product */
    public void init(){
        recyclerView_product =  findViewById(R.id.recyclerview_product1);

        // xử lý cho recycleView chuyển ảnh theo chiều ngang, chiều dọc
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView_product.setLayoutManager(layoutManager); // xét reclycle layout của banner quảng cáo

        // khởi tạo list của các lớp model
        listProducts = new ArrayList<>();

    }


    // hàm showToast gửi thông báo
    public void showToast(){
        Toast.makeText(ProductActivity.this,"get data Failid!", Toast.LENGTH_LONG).show();
    }

}








/* cách xử lý cho Firebase FireStore
*
*  db = FirebaseFirestore.getInstance();

        recyclerView_product = findViewById(R.id.recyclerview_product_Indoor);

        // item products
        recyclerView_product.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        productModelsList = new ArrayList<>();
        event_products_plants = new Event_Products_Plants(this, productModelsList);
        recyclerView_product.setAdapter(event_products_plants);

        // Đoạn code mẫu load firebase - xử lý kết nối firebase
        db.collection("Plants_Products")
            .get()
            .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            ProductModels productModels = document.toObject(ProductModels.class);
                            productModelsList.add(productModels);
                            event_products_plants.notifyDataSetChanged();
                            Toast.makeText(ProductActivity.this, ""+task.getException(), Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(ProductActivity.this, "Error!" + task.getException(), Toast.LENGTH_LONG).show();
                    }
                }
            });
  */