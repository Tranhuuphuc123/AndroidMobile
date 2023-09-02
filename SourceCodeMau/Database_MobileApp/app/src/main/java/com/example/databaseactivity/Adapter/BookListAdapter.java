package com.example.databaseactivity.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.databaseactivity.Model.Book;
import com.example.databaseactivity.R;

import java.util.ArrayList;

public class BookListAdapter extends BaseAdapter {
    Context context;
    ArrayList<Book> listBook;

    public BookListAdapter(Context context, ArrayList<Book> listBook) {
        super();
        this.context = context;
        this.listBook = listBook;
    }

    @Override
    public int getCount() {
        //Tra ve tong so phan tu cua ListView
        return listBook.size();
    }

    @Override
    public Object getItem(int position) {
        //Tra ve du lieu ở vi tri position của Adapter, tuong ung la phan tu co chi so position trong listBook
        return listBook.get(position);
    }

    @Override
    public long getItemId(int position) {
        //Tra ve mot ID của phan tu
        return listBook.get(position).getId();
    }

    @Override
    public View getView(int position, View view, final ViewGroup viewGroup) {
        /*convertView là View của phần tử ListView, nếu convertView != null nghĩa là View này được sử dụng lại, 
        chỉ việc cập nhật nội dung mới. Nếu convertView la null cần tạo mới*/
        final View viewBook;
        if (view == null) {
            viewBook = View.inflate(viewGroup.getContext(), R.layout.list_book_item, null);
        } else {
            viewBook = view;
        }

        //Bind du lieu phan tu vao View list_view_item
        final Book book = (Book) getItem(position);
        ((TextView) viewBook.findViewById(R.id.textViewID)).setText(book.getId()+"");
        ((TextView) viewBook.findViewById(R.id.textViewName)).setText(book.getName());
        return viewBook;

    }
}
