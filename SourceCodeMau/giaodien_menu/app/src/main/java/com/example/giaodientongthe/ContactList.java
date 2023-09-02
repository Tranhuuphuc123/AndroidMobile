package com.example.giaodientongthe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.giaodientongthe.event.EventListener_ContactList;
import com.example.giaodientongthe.model.contactModel;


public class ContactList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);
        // gọi lớp init()

        // gọi và thực thi Toolbar để chứa menu_list
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_ListContact);
        setSupportActionBar(toolbar);


        ListView listView = findViewById(R.id.listViewContact); // tham chiếu đến id của listView bên layout ContactList
        /*Giải nghĩa:
         +  ArrayAdapter<contactModel> adapter = new ArrayAdapter<contactModel: khởi tạo một  mảng Adapter để hiển thị danh sách
         các t/p của lớp ContactModel lên trong chính giao diện contactList
         + this: để truyền vào context của ContactList để biết rằng ListView sẽ được hiển thị trong màn hình này.
         + android.R.layout.simple_list_item_1 và android.R.id.text1
         --> à các resource ID của layout và TextView mặc định do Android cung cấp.*/
       ArrayAdapter<contactModel> adapter = new ArrayAdapter<contactModel>(this,android.R.layout.simple_list_item_1,android.R.id.text1, MainActivity.contactList);
        listView.setAdapter(adapter); // thiết lặp mảng adapder vừa khởi tạo cho listview để hiển thực thi hiển thị

        // xử lý sự kiện cho
        listView.setOnItemClickListener(new EventListener_ContactList(this));
    }



    // khởi tạo menu -> tức là chỗ tạo nút 3 chấm để mà nhấn vào nó sẽ sổ ra các item menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // dùng getInflate.inflate-> để gọi giao diện menu.xml
        getMenuInflater().inflate(R.menu.menu_list, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // xử lý sự kiện khi nhấn vào nút nguồn menu: chọn item menu nào nó sẽ hiện ra layout tương ứng item menu đó
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        int id = item.getItemId();
        if(id == R.id.menulist_maincontact){
            intent = new Intent(ContactList.this, MainActivity.class);
            startActivity(intent);
            return super.onOptionsItemSelected(item);
        }else if(id == R.id.menulist_newcontact){
            intent = new Intent(ContactList.this, NewContact.class);
            startActivity(intent);
            return super.onOptionsItemSelected(item);
        }else if(id == R.id.menulist_setting){
            return  true;
        }
        return true;
    }

}