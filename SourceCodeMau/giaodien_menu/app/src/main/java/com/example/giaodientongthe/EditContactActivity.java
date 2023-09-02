package com.example.giaodientongthe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.giaodientongthe.model.contactModel;

public class EditContactActivity extends AppCompatActivity {
    private contactModel c_model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);

        // lớp hiên thị show dữ liệu ra layout edit
        int id = getIntent().getIntExtra("id",0);
        c_model = MainActivity.contactList.get(id);

        ((EditText) findViewById(R.id.edit_EditContact_name)).setText(c_model.getName());
        ((EditText) findViewById(R.id.edit_EditContact_phone)).setText(c_model.getNumber());
        ((EditText) findViewById(R.id.edit_EditContact_nickname)).setText(c_model.getNickName());
        ((EditText) findViewById(R.id.edit_EditContact_address)).setText(c_model.getAddress());
        ((EditText) findViewById(R.id.edit_EditContact_note)).setText(c_model.getNotes());


        // liên kết id của button
         Button btn_save_Contact = (Button)findViewById(R.id.btn_EditContact_Save);

        // tiến hành xử lý sự kiện saveContact
        btn_save_Contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // liên kết id của các mục EditText bên giao diện và nhậ giá trị gửi qua
                String name = ((EditText) findViewById(R.id.edit_EditContact_name)).getText().toString();
                String phone = ((EditText) findViewById(R.id.edit_EditContact_phone)).getText().toString();
                String nickName = ((EditText)findViewById(R.id.edit_EditContact_nickname)).getText().toString();
                String address = ((EditText) findViewById(R.id.edit_EditContact_address)).getText().toString();
                String note = ((EditText)findViewById(R.id.edit_EditContact_note)).getText().toString();

                //Them Contact vao list
                c_model = new contactModel(id,name,nickName,phone,address, note);
                MainActivity.contactList.set(id,c_model);
                showToats("bạn đã save thành công");


                //Chuyen Activity
                Intent intent = new Intent(EditContactActivity.this, ContactList.class);
                startActivity (intent);
            }
        });
    }


    // method ShowToat
    public void showToats(String msg){
        Toast.makeText(getApplicationContext(),msg, Toast.LENGTH_LONG).show();
    }

}