package com.example.chuyengiaodien_tonghop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.chuyengiaodien_tonghop.model.Book;

public class childActivity extends AppCompatActivity {
    private Button btn_child;
    private TextView txt_rs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);

        // ánh xạ id
        btn_child= (Button) findViewById(R.id.btn_intent_child);
        txt_rs = (TextView) findViewById(R.id.txt_rs);

        // cách nhận cac values từ bên Intent Mainactivity.class gửi qua Intent bên này
        Intent intent_b = getIntent();

        // thiết lặp nhận dữ liệu bên class khác gửi qua -> và đỗ value cho txt_rs hiển thị ra
   //     String item = getIntent().getStringExtra("param1");
        // lưu ý 300 là tham số default theo mặc định phải có thêm ts default => nếu value ben
        /*hàm khác không chuyển đc thì nó sẽ hiển thị value 300 này*/
   //      int num = getIntent().getIntExtra("param2",300);
        // nhận dl của class model book
    //    Book book = (Book) getIntent().getSerializableExtra("bookInfo");

//        txt_rs.setText(item + "-" + num + "-" + book.getName() + "-"
//                + book.getName() + "-" + book.getPrice());

        // xử lý nhận dữ liệu với bundle
        Bundle bundle = intent_b.getBundleExtra("myBundle");
        String name = bundle.getString("param1");
        int num = bundle.getInt("param2");
        Book bookInfo =(Book) bundle.getSerializable("bookInfo");

        txt_rs.setText(name + "-" + num + "-" + bookInfo.getName() + "-"
                + bookInfo.getName() + "-" + bookInfo.getPrice());


        // xử lý sự kiện chuyển giao diện với intent
        btn_child.setOnClickListener(view->{
            Intent intent = new Intent(childActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }
}