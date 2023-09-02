package com.example.kienthuctonghopactivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class Baitapungdung1Activity extends AppCompatActivity {

    /*tiến hành xử lý sự kiện bền Activity java file*/

    // tạo các properties ánh xạ bên layout qua bên Activity .java
    private EditText editInput;
    private Button btnShow;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // liên kết với file layout
        setContentView(R.layout.activity_baitapungdung1);

        //tiến hảnh kết nối các properties trên với các id bên layout để kết nối layout với Activity .java
        editInput = (EditText)findViewById(R.id.edit);
        btnShow=(Button) findViewById(R.id.btn);
        txtResult= (TextView) findViewById(R.id.txt);
    }

    //tạo method showcontext để xử lý sự kiện khi nhấn button
    // showContent này tại sau có: chính là thuộc tính onClick="showContent" bên layout mà ra
    public void showContent (View v){
        // tiến hành tạo content chứa nd nhận đc khi nhâp từ bàn phím vào editText
        String content = editInput.getText().toString();
        // tiến hành gán content cho txtResult để hiển thị ra TextView sau khi nhấn nút button
        txtResult.setText(content);
        showToast(String.valueOf(txtResult));
        //-> có thể viết gọn: txtResult.setText(editInput.getText().toString());
    }

    // tạo method show Toast=> có nhiệm vụ thông báo xuất hiện Toast trên mobile
    public void showToast(String msg){
        Toast.makeText(getApplicationContext(),msg, Toast.LENGTH_LONG).show();
    }
}