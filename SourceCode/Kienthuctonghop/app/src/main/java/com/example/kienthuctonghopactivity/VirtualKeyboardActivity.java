package com.example.kienthuctonghopactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class VirtualKeyboardActivity extends AppCompatActivity {

    private Button btn_Show, btn_hide;
    private EditText edit_one, edit_two;
    private TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_virtual_keyboard);
        // gọi init
        init();

        /* thiết lặp bàn phím ảo trong file Activity.class
         + SOFT_INPUT_STATE_ALWAYS_VISIBLE: cơ chế hiển thị bàn phím ảo
         + WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE: cơ chế tg thích khi bật bàn phím ảo nó tg thích với các view khác không che mất nó đi
        */
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE|WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        // xử lý sự kiện cho hai button víêt kểu lambda

        // ấn btn_show => bàn phím ảo xuất hiện
        btn_Show.setOnClickListener(view->Show_Keyboard());

        // khi ấn btn_hide thì bản phím ảo nó sẽ ẩn đi
        btn_hide.setOnClickListener(view->Hide_Keyboard());
    }


    /* method ẩn đi bàn phím hide_keyboard*/
    public void Hide_Keyboard(){
        // gọi class InpuetMethodManager
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        /* thực thi ẩn di vói thuộc tính hideSoftInputFromWindow
        *+ this.getCurrentFocus().getWindowToken(), 0: nghĩa là liên kết đến các focus cụ thể
        * là các edit text khi ấn vào ấy-> nghĩa là khi nhập nd trong edit text thì ta mún ấn nút ẩn nó sẽ ẩn đi bàn phím ảo
        * chứ kooong để hiện hoài, thì bắt sự kiện focus chính là ở nút edit text */
        inputMethodManager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), 0);
    }

    /*Method hiển thị lên bàn phím ảo*/
    public void Show_Keyboard(){
        // gọi class InpuetMethodManager
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        // dùng showSoftInput để gọi và mở bàn phm ảo
        inputMethodManager.showSoftInput(this.getCurrentFocus(),inputMethodManager.SHOW_IMPLICIT);
    }

    /* ánh xạ các id*/
    public void init(){
        btn_Show = (Button) findViewById(R.id.btn_Show);
        btn_hide = (Button) findViewById(R.id.btn_Hide);
        edit_one = (EditText) findViewById(R.id.edit_One);
        edit_two = (EditText) findViewById(R.id.edit_Two);
        txtView = (TextView) findViewById(R.id.txt_View);
    }

    /* xây dựng hàm showToast*/
    public void showToast(String msg){
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }
}