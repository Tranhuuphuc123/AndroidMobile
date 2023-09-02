package com.example.giaodientongthe.event;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;

import com.example.giaodientongthe.EditContactActivity;
import com.example.giaodientongthe.model.contactModel;

public class EventListener_ContactList implements AdapterView.OnItemClickListener {

    // context là đại diện class ContactList.class khi tạo class riêng cách này là cách lk contactList qua bên class này
    private Context context;

    public EventListener_ContactList(Context context) {
        this.context = context;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //adapterView.getItemAtPosition(i): lấy ra dữ liệu ở từng vị trí trong ds listview
        contactModel c_model = (contactModel) adapterView.getItemAtPosition(i);
        // Intent quá quen thuộc dùng để chuyển giao diện sáng class Edit
        Intent intent = new Intent(context, EditContactActivity.class);
        /*putExtra là một phương thức trong lớp Intent ->được sử dụng để đính kèm dữ liệu vào intent khi bạn muốn
        truyền dữ liệu từ một màn hình/activity sang một màn hình/activity khác.*/
        intent.putExtra("id", c_model.getId());
        context.startActivity(intent);// tiến hành khởi chạy thực thi chuyển giao diện
    }
    
}


