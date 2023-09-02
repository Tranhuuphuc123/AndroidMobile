package com.example.databaseactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.databaseactivity.Adapter.BookListAdapter;
import com.example.databaseactivity.Model.Book;
import com.example.databaseactivity.SQLLite.DBController;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DBController controller = new DBController(this);
    ListView listView;
    Button button;
    BookListAdapter bookListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Book> bookList = controller.getAllBooks();
        bookListAdapter = new BookListAdapter(MainActivity.this, bookList);
        listView = findViewById(R.id.listView);
        listView.setAdapter(bookListAdapter);

       // xửu lý sự kiện khi nhấn các listview item thì nó sẽ hiện ra bảng eddit để sữa hoặc xóa
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView bookId = (TextView) view.findViewById(R.id.textViewID);
                Intent indent = new Intent(getApplicationContext(), EditBookActivity.class);
                indent.putExtra("bookId", bookId.getText().toString());
                startActivity(indent);
            }
        });


       // xử lý sự kiện nút cộng mở ra giao diện new contact
        button = findViewById(R.id.buttonAdd);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NewBookActivity.class);
                startActivity(intent);
            }
        });
    }
}