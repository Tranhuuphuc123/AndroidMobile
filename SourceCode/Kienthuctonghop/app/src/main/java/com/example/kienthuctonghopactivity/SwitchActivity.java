package com.example.kienthuctonghopactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class SwitchActivity extends AppCompatActivity {

     private Switch swbutton;
     private ToggleButton toggleButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch);

        // liên kết key id ben layout
        swbutton = (Switch) findViewById(R.id.sw);
        toggleButton=(ToggleButton) findViewById(R.id.tgl_btn);


        // xử lý sự kiện-> kiêểu viết lambada
        swbutton.setOnCheckedChangeListener((buttonView, isCheck) ->{
                if(isCheck){
                    toggleButton.setChecked(true);
                    showToast("Bật nha");
                }else{
                    toggleButton.setChecked(false);
                    showToast("tắt rồi đó");
                }
        });
    }

    // taạo Toast
    public void showToast(String msg){
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }
}