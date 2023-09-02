package com.example.kienthuctonghopactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/*xử lý theo kiểu sự kiện đặt biến Variable listener*/
public class VariableListenerActivity extends AppCompatActivity  {
   private TextView txtView;
   private Button btn1, btn2, btn3, btn4, btn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_variable_listener);

        init();

        // xủ lý sự kiện theo cách đặt biến cho OnclickListener
        View.OnClickListener clickButton = new View.OnClickListener() {
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
        };

        // đưa clickButton vào các button gán cho nó hiểu
        btn1.setOnClickListener(clickButton);
        btn2.setOnClickListener(clickButton);
        btn3.setOnClickListener(clickButton);
        btn4.setOnClickListener(clickButton);
        btn5.setOnClickListener(clickButton);
    }

    // ánh xạ id thông qua method init
    public void init(){
        txtView =(TextView) findViewById(R.id.txtview);
        btn1=(Button) findViewById(R.id.btn1);
        btn2=(Button) findViewById(R.id.btn2);
        btn3=(Button) findViewById(R.id.btn3);
        btn4=(Button) findViewById(R.id.btn4);
        btn5=(Button) findViewById(R.id.btn5);
    }

}