package com.example.kienthuctonghopactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InlineAnonymousListenerActivity extends AppCompatActivity {

    private TextView textView;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inline_anonymous_listener);

        // gọi hàm init()
        init();

        /*cachs: xử lý sự kiện với kiểu Inline Anonymous Listener*/
//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                textView.setText("Inline Listener");
//            }
//        });
//
//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                textView.setText("Inline Anonymous Listener");
//            }
//        });
//
//        button3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                textView.setText("Activity Listener");
//            }
//        });
//
//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                textView.setText("Listener Variable");
//            }
//        });
//
//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                textView.setText("Excplicit Listener class");
//            }
//        });


        /* cách 02: viết kiểu lambada*/
        button1.setOnClickListener(v->textView.setText("Inline Listener"));
        button2.setOnClickListener(v->textView.setText("Inline Anonymous Listener"));
        button3.setOnClickListener(v->textView.setText("Activity Listener"));
        button4.setOnClickListener(v->textView.setText("Listener Variable"));
        button5.setOnClickListener(v->textView.setText("Excplicit Listener class"));
    }

    // tạo method init chứa liên kết các id bên layout
    public void init(){
        textView = (TextView) findViewById(R.id.txtview);
        button1=(Button) findViewById(R.id.btn1);
        button2=(Button) findViewById(R.id.btn2);
        button3=(Button) findViewById(R.id.btn3);
        button4=(Button) findViewById(R.id.btn4);
        button5=(Button) findViewById(R.id.btn5);
    }

}