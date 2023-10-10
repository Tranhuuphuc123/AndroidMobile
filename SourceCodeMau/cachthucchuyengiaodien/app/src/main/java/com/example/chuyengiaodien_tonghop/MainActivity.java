package com.example.chuyengiaodien_tonghop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.chuyengiaodien_tonghop.model.Book;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {
    private Button btn_intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ánh xạ id
        btn_intent = (Button) findViewById(R.id.btn_intent_main);
        btn_intent.setOnClickListener(view->{
            Intent intent = new Intent(MainActivity.this, childActivity.class);

            // tiến hành gửi nhận dữ liệu với thuộc tính putextra
//            intent.putExtra("param1", "Lập trình Android mobile native java");
//            intent.putExtra("param2",100);
//
//            // gọi model Book vào và gửi dữ liệu nó qua cho class child
              Book book = new Book("B01", "Java language", 15.0);
//            intent.putExtra("bookInfo",  book);

            // cách sử dụng bundle để nhóm các value trên thành một gói
           Bundle bundle = new Bundle();
           bundle.putString("param1", "Trung tâm Aptech");
           bundle.putInt("param2", 30);
           bundle.putSerializable("bookInfo", book );
           // tiến hành gửi bundle đi
            intent.putExtra("myBundle",bundle);

            startActivity(intent);
        });
    }
}