package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // thiết lập mục textview năm ở quy trình 2 khai báo và ánh xạ view
        TextView textView = findViewById(R.id.tv_title);

        // Quy trình 03: xử l logic và sự kiện
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Welcome bạn đến  với thế giới Android mobile",Toast.LENGTH_SHORT).show();
            }
        });



    }
}