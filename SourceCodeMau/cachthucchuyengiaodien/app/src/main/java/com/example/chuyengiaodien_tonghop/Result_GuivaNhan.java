package com.example.chuyengiaodien_tonghop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Result_GuivaNhan extends AppCompatActivity implements View.OnClickListener{
    private EditText edit_txt;
    private Button btn_Upper, btn_Lower;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_guiva_nhan);
        init();

        // xử lý sự kiện cho các button
        btn_Upper.setOnClickListener(this);
    }


    // method liên kết id init
    public void init(){
        edit_txt = (EditText) findViewById(R.id.edit);
        btn_Lower = (Button) findViewById(R.id.btn_changeLower);
        btn_Upper = (Button) findViewById(R.id.btn_changeUpper);
    }

    // xửu lý logic  cho sự kiện
    @Override
    public void onClick(View view) {
        // tạo lớp intent chuyển giao diện
        Intent temp = getIntent();
        if(view.getId() == R.id.btn_changeUpper){
            temp.putExtra("yourtitle", edit_txt.getText().toString());
            setResult(GuiVaNhan_Values_Activity.RESULT_CODE_UPPER,temp);
            /* finish có chức năng sau khi nhân nút button
             thc thi thì nó sẽ đóng lại cửa sổ giao diện hiện tại đi*/
            finish();

        }else if(view.getId()==R.id.btn_changeLower){
              temp.putExtra("yourtitle", edit_txt.getText().toString());
              setResult(GuiVaNhan_Values_Activity.RESULT_CODE_LOWER, temp);
              finish();
        }
    }
}