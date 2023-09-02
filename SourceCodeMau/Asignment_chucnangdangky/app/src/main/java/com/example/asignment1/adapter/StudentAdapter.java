package com.example.asignment1.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.asignment1.R;
import com.example.asignment1.model.student;

import java.util.ArrayList;

public class StudentAdapter extends BaseAdapter {
    Context context;
    ArrayList<student> listStudent;

    public StudentAdapter(Context context, ArrayList<student> listStudent) {
        super();
        this.context = context;
        this.listStudent = listStudent;
    }

    @Override
    public int getCount() {
        // trả về tổng số item có trong arraylist<student>
        return listStudent.size();
    }

    @Override
    public Object getItem(int i) {
        // duyệt quá từng vị trí phần tử có mặt trong araylist<stduent>
        return listStudent.get(i);
    }

    @Override
    public long getItemId(int i) {
        // trả về id của một phần t
        return Long.parseLong(listStudent.get(i).getRollno());
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final  View viewStudents;
        /*convertView là View của phần tử ListView, nếu convertView != null nghĩa là View này được sử dụng lại,
        chỉ việc cập nhật nội dung mới. Nếu convertView la null cần tạo mới*/
        if(view == null){
            viewStudents = View.inflate(viewGroup.getContext(), R.layout.list_item, null);
        }else{
            viewStudents = view;
        }

        // bind dữ liệu tg ứng qua mục listview_item
        final student st = (student) getItem(i);
        ((TextView) viewStudents.findViewById(R.id.txt_list_rollno)).setText(st.getRollno());
        ((TextView) viewStudents.findViewById(R.id.txt_list_name)).setText(st.getName());
        ((TextView) viewStudents.findViewById(R.id.txt_list_date)).setText(st.getDate());
        ((TextView) viewStudents.findViewById(R.id.txt_list_radiobutton)).setText(st.getTerm());
        return  viewStudents;
    }
}
