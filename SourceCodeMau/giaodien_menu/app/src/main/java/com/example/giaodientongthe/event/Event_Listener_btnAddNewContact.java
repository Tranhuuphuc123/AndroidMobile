package com.example.giaodientongthe.event;

import android.content.Context;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;

import com.example.giaodientongthe.ContactList;
import com.example.giaodientongthe.MainActivity;
import com.example.giaodientongthe.R;
import com.example.giaodientongthe.model.contactModel;


import java.util.List;

public class Event_Listener_btnAddNewContact implements View.OnClickListener {
   private Context mContext;

   // hàm khởi tạo ánh xạ tg tác qua hàm onCreate của NewContatActivity.class
    public Event_Listener_btnAddNewContact(Context context) {
        this.mContext = context;
    }

    @Override
    public void onClick(View view) {
        // ánh xạ các id ở mục editView của giao diện new_contact_activity.xml
        int id = MainActivity.contactList.size();
        // Luu ý nếu muốn gọi findViewById ở class riêng thì cần gọi view.getRootView().findViewByID()
        String name = ((EditText) view.getRootView().findViewById(R.id.edit_name)).getText().toString();
        String nickName = ((EditText) view.getRootView().findViewById(R.id.edit_nickname)).getText().toString();
        String phone = ((EditText) view.getRootView().findViewById(R.id.edit_phone)).getText().toString();
        String address = ((EditText) view.getRootView().findViewById(R.id.edit_address)).getText().toString();
        String note = ((EditText) view.getRootView().findViewById(R.id.edit_note)).getText().toString();

        // Them Contact vao list-> nghĩa là khi nhập giá trị vào thì nó sẽ thêm và hiển thị các thông tin vừa thêm
        contactModel c_model = new contactModel(id, name, nickName, phone, address, note);
        MainActivity.contactList.add(c_model);

        // Chuyển Activity sau khi thêm thành công và nhấn nút addContact
        Intent intent = new Intent(mContext, ContactList.class);
        mContext.startActivity(intent);
    }
}
