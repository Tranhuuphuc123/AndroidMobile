package com.example.kienthuctonghopactivity;

import  android.app.Activity;
import  android.widget.*;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class InlineListenerActivity extends AppCompatActivity{
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inline_listener);

        // gọi lại method inlineLListener()
    }


    // xử lý sự kiện với cách thức inline Listener sử dụng android:onClick
    public void inlineListener(View v) {
        // ánh xạ id textview bên layout
        textView = (TextView)findViewById(R.id.txtview);

        // dùng switch case để xử lý từng Button
        switch (v.getId()) {
//            case R.id.btn1:
//                textView.setText("Inline Listener");
//                break;
//            case R.id.btn2:
//                textView.setText("Inline Anonymous Listener");
//                break;
//            case R.id.btn3:
//                textView.setText("Activity Listener");
//                break;
//            case R.id.btn4:
//                textView.setText("Listener Variable");
//                break;
//            case R.id.btn5:
//                textView.setText("Excplicit Listener class");
//                break;
            default:
                textView.setText("*********");
                break;
        }
    }


}