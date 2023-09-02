package com.example.kienthuctonghopactivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class ToggleButtonActivity extends AppCompatActivity {
        private ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_button);

        // liên kết id layout qua activity
        toggleButton = findViewById(R.id.tgbutton);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isCheck) {
                if(isCheck==true){
                    showToast("Bạn đã tắt");
                }else{
                    showToast("bạn đã bật");
                }
            }
        });

        /*Viết theo kiểu lambda
        *   toggleButton.setOnCheckedChangeListener((buttonView, isCheck) -> {
        *        if(isCheck==true){
                    showToast("Bạn đã tắt");
                }else{
                    showToast("bạn đã bật");
                }
        *   }
        * */
    }

    // xử lý sự kiện cho toggleButton
    public  void showContent(View v){
        // bản chất togglebutton lúc này là đại diện v của View nên có thể thay thể togglebutton bằng v(nhớ p kiểu)
       // boolean check = toggleButton.isChecked();
        boolean check = ((ToggleButton)v).isChecked();
        if(check==true){
            showToast("Bạn đã tắt");
        }else{
                showToast("bạn đã bật");
        }
    }

    // hiện thị thông báo với showToast
    public void showToast(String msg){
        Toast.makeText(getApplicationContext(),msg, Toast.LENGTH_LONG).show();
    }
}