package com.example.kienthuctonghopactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import EventListener.*;

public class ExplicitListenerClass extends AppCompatActivity {
    private Button btn1, btn2, btn3, btn4, btn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_listener_class);

        init();

        // xử lý sự kiện bằng cách gọi đến class riêng biệt xử lý sự kiện do lập trình viên tự viết
        // lưu ý cách thức này thay vì viets trong cùng 1 Activity thì ta tách class xử lý ra riêng và gọi lại nó
        btn1.setOnClickListener(new event_class());
        btn2.setOnClickListener(new event_class());
        btn3.setOnClickListener(new event_class());
        btn4.setOnClickListener(new event_class());
        btn5.setOnClickListener(new event_class());
    }

    // init() ánh xạ các id button
    public void init(){
        btn1 =(Button) findViewById(R.id.btn1);
        btn2 =(Button) findViewById(R.id.btn2);
        btn3 =(Button) findViewById(R.id.btn3);
        btn4 =(Button) findViewById(R.id.btn4);
        btn5 =(Button) findViewById(R.id.btn5);
    }
}