package com.example.giaodientongthe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.giaodientongthe.model.contactModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static List<contactModel> contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // khởi tạo một mảng danh sách contat
        contactList = new ArrayList<contactModel>();

        // khởi tạo toolbar -> nới chứa menu đc đưa vào
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }


    // khởi tạo menu -> tức là chỗ tạo nút 3 chấm để mà nhấn vào nó sẽ sổ ra các item menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // dùng getInflate.inflate-> để gọi giao diện menu.xml
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // xử lý sự kiện khi nhấn vào nút nguồn menu: chọn item menu nào nó sẽ hiện ra layout tương ứng item menu đó
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        int id = item.getItemId();
        if(id == R.id.action_new_contact){
            intent = new Intent(MainActivity.this, NewContact.class);
            startActivity(intent);
            return super.onOptionsItemSelected(item);
        }else if(id == R.id.action_contact_list){
            intent = new Intent(MainActivity.this, ContactList.class);
            startActivity(intent);
            return super.onOptionsItemSelected(item);
        }else if(id == R.id.action_setting){
           return  true;
        }
        return true;
    }


}