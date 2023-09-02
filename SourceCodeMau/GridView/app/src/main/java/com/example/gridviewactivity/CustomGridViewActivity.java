package com.example.gridviewactivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gridviewactivity.Adapter.ProductAdapter;
import com.example.gridviewactivity.model.Products;

import java.util.ArrayList;

public class CustomGridViewActivity extends AppCompatActivity {
    ArrayList<Products> listProduct;
    ProductAdapter productAdapter;
    GridView gridViewProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_grid_view);
        addProduct();

        // khỏi tạo Adapter
        productAdapter = new ProductAdapter(this,listProduct);
        //truyền Adapter vao gridView
        gridViewProduct = findViewById(R.id.gridViewCustom);
        gridViewProduct.setAdapter(productAdapter);

        // xử lý sự kiện khi nhấn card_item nào nó sẽ hiện lên trang details của sp đó chi tiết
        // nhớ nhe nếu mà xử lý sự kiện cho cả list thì dùng setOnItemListener
        gridViewProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Products products = (Products) productAdapter.getItem(position);
                //hiển thị tên sản phẩm đã chọn
                final View formAlert =
                        CustomGridViewActivity.this.getLayoutInflater().inflate(R.layout.card_item_details, null);

                // tạo Alertdialog
                // tiềm hiểu cho kỹ về AlertDialog??? hộp thoại hiển thi một phần không chiếm hết nd của giao diện
                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(CustomGridViewActivity.this);
                ImageView imageView = formAlert.findViewById(R.id.img_details);
                imageView.setImageResource(products.getImage());

                TextView textView = formAlert.findViewById(R.id.txt_name_details);
                textView.setText(products.getName());

                // set View
                alertDialog.setView(formAlert);
                //get Result
                alertDialog.setPositiveButton("Back", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                alertDialog.show();
            }
        });
    }

    public void addProduct(){
        listProduct = new ArrayList<>();
        listProduct.add(new Products(1,"Iphone 65", 500, R.drawable.iphone6s_gray));
        listProduct.add(new Products(2,"Iphone 7 Plus", 700, R.drawable.iphone_7_plus));
        listProduct.add(new Products(3,"Iphone X", 800, R.drawable.iphone_x));
        listProduct.add(new Products(4,"Samsung Galaxy S18", 900, R.drawable.samsunggalaxys10));
        listProduct.add(new Products(5,"Samsung Galaxy A70", 1000, R.drawable.samsung_galaxy_a70_white));
        listProduct.add(new Products(6,"Nokia 5.1", 900, R.drawable.nokia81_xanh));
        listProduct.add(new Products(7,"Samsung Galaxy G20", 500, R.drawable.samsunggalaxys10));
        listProduct.add(new Products(8,"Nokia 5.1S18", 900, R.drawable.nokia81_xanh));
    }
}