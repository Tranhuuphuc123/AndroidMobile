package com.example.kienthuctonghopactivity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView tuongtac;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Lưu ý setContentView chính là phương thức liên kết ánh xạ towis các layout
         *      vd: ta có 2 layout khác nhau vậy thì file mainactivity.java làm sao phần biết
         *    để chạy đc cái layout mình cần chạy -> thông qua setContentView liên kết đến R(res(resource))
         * liên kết đến layout-> liên kết đến file layout activity_....xml cần chạy
         *
         * */
        setContentView(R.layout.activity_main);  // liên kết với R: res(resource)/layout/activity_main.xml)

        /* liên kết activity với layout-> lưu ý nhớ ep kiểu về chung kiểu TextView để tránh bị lỗi*/
        tuongtac = (TextView) findViewById(R.id.key1);
        /* thay đổi nội dung để thể hiện sự tuơng tác*/
        tuongtac.setText("Tương tác Activity với layout");
    }
}