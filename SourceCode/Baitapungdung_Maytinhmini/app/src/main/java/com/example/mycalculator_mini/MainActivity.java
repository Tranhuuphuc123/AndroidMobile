package com.example.mycalculator_mini;

import android.content.Context;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // khởi tạo các biến
    private TextView txt_result;
    private EditText edit_one, edit_two;
    private Button btn_add, btn_plus, btn_core, btn_divide;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // aánh xạ init()
        init();
        /* khởi tạo bàn phím ảo:
        *  + SOFT_INPUT_STATE_ALWAYS_VISIBLE: khởi chạy baàn phím ảo
        *  + SOFT_INPUT_ADJUST_RESIZE: tương thích khi mở bàn phím ảo không che hay lấn mất
        * nd của view khác
        * */
       getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE|WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        // xử lý sự kiện cho các buttn và txt_result
        btn_add.setOnClickListener(view->{});
        btn_add.setOnClickListener(view->{});
        btn_add.setOnClickListener(view->{});
        btn_add.setOnClickListener(view->{});

        txt_result.setOnClickListener(view->{});
    }

    /* ánh xạ các id*/
    public void init(){
        txt_result = (TextView) findViewById(R.id.txt_result);
        edit_one = (EditText) findViewById(R.id.edit_one);
        edit_two = (EditText) findViewById(R.id.edit_two);
        btn_add = (Button) findViewById(R.id.btn_add);
        btn_plus = (Button) findViewById(R.id.btn_plus);
        btn_core = (Button) findViewById(R.id.btn_core);
        btn_divide = (Button) findViewById(R.id.btn_divide);
    }

    /* method ẩn vitural_keyboard*/
    public void hide_keyboard(){
        //gọi class InputMethodManager và khởi tạo nó
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        // dùng hideSoftInputFromWindown để ẩn đi bàn phim ảo
        inputMethodManager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), 0);
    }

    /* method show vittural keyboard*/
    public void show_keyboard(){
        //gọi class InputMethodManager và khởi tạo nó
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        // dùng showSoftInput để show bàn phím ảo
        inputMethodManager.showSoftInput(this.getCurrentFocus(), inputMethodManager.SHOW_IMPLICIT);
    }


    /* method showToast*/
    public void showToast(String msg){
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }
}
