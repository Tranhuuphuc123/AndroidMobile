package com.example.giaodientongthe;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;


import com.example.giaodientongthe.event.Event_Listener_btnAddNewContact;

public class NewContact extends AppCompatActivity {
  private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);
        // gọi class init nơi chưá các liên kết id
        init();
        // khởi tạo toolbar nơi chưa menu khi add vào giao diên
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_newContact);
        setSupportActionBar(toolbar);
        // lxử lý sự kện cho btn buttun Add contact
        button.setOnClickListener(new Event_Listener_btnAddNewContact(this));
    }

    // method lin kết id
    public void init(){
        button = (Button) findViewById(R.id.btn_addContact);
    }


    // khởi tạo menu -> tức là chỗ tạo nút 3 chấm để mà nhấn vào nó sẽ sổ ra các item menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // dùng getInflate.inflate-> để gọi giao diện menu.xml
        getMenuInflater().inflate(R.menu.menu_new, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // xử lý sự kiện khi nhấn vào nút nguồn menu: chọn item menu nào nó sẽ hiện ra layout tương ứng item menu đó
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        int id = item.getItemId();
        if(id == R.id.action_maincontact){
            intent = new Intent(NewContact.this, MainActivity.class);
            startActivity(intent);
            return super.onOptionsItemSelected(item);
        }else if(id == R.id.action_contactlist){
            intent = new Intent(NewContact.this, ContactList.class);
            startActivity(intent);
            return super.onOptionsItemSelected(item);
        }else if(id == R.id.action_setting){
            return  true;
        }
        return true;
    }

}