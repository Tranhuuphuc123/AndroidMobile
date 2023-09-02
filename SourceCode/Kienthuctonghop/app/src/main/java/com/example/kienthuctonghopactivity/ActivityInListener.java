package com.example.kienthuctonghopactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import  android.view.View;

/*Tiến hành xử lý sự kiện theo cách: Activity in Listener*/

// đầu tiền tiến hành: implement view.OnclickListener
public class ActivityInListener extends Activity implements View.OnClickListener {

     // caác properties ánh đại diện các button
     private Button btn1, btn2, btn3, btn4, btn5;
    private TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_listener);
        // goij đến lớp init();
        init();

        //bước thứ hai là gọi đến OnlcikListener(this) trong hàm onCreate
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
    }

    // xây dựng lơ init ánh xạ liên ket các id bên layout qua bên Activity
    public void init(){
        btn1 =(Button) findViewById(R.id.btn1);
        btn2 =(Button) findViewById(R.id.btn2);
        btn3 =(Button) findViewById(R.id.btn3);
        btn4 =(Button) findViewById(R.id.btn4);
        btn5 =(Button) findViewById(R.id.btn5);
        txtView=(TextView) findViewById(R.id.txtview);
    }

    // bước thứ 3: Override method Onclick là đại diện của từ khóa this ở trên
    @Override
    public void onClick(View view) {
        // dùng if-else để xử lý
       if((view.getId())== R.id.btn1){
           txtView.setText("Inline Listener");
       }else if (view.getId() == R.id.btn2) {
           txtView.setText("Inline Anonymous Listener");
       } else if (view.getId() == R.id.btn3) {
           txtView.setText("Activity Listener");
       } else if (view.getId() == R.id.btn4) {
           txtView.setText("Listener Variable");
       } else if (view.getId() == R.id.btn5) {
           txtView.setText("Excplicit Listener class");
       }
    }

}