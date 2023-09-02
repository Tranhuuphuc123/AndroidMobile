package com.example.asignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // gọi init
        init();


        // xử lý chuyển trang
        btn_main.setOnClickListener(view->{
            Intent intent = new Intent(MainActivity.this, StudentManagerActivity.class);
            startActivity(intent);
        });
    }

    // ánh xạ id
    public void init(){
        btn_main = (Button) findViewById(R.id.btn_main);
    }
}