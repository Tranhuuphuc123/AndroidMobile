package com.example.gridviewactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_showBasic, btn_showGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // gọi hàm liên kết các id
        init();

        // xử lý sự kiện chuyển trang sang BassicGridViewActivity
        btn_showBasic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // gọi class Intent để thực thi chuyển trang
                Intent intent = new Intent(MainActivity.this, BasicGridViewActivity.class);
                startActivity(intent);
            }
        });


         // xử lý sự kiện chuyển trang sang CustomGridViewactivity.class
        btn_showGridView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // gọi class Intent để thực thi chuyển trang
                Intent intent = new Intent(MainActivity.this, CustomGridViewActivity.class);
                startActivity(intent);
            }
        });

    }


    //init liên kết id
    public void init(){
        btn_showBasic = (Button) findViewById(R.id.btn_showBasix);
        btn_showGridView =(Button) findViewById(R.id.btn_showGridView);
    }
}