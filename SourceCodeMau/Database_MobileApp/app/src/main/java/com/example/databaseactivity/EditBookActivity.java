package com.example.databaseactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.databaseactivity.Model.Book;
import com.example.databaseactivity.SQLLite.DBController;

public class EditBookActivity extends AppCompatActivity {

    Button btnUpdate, btnDelete;
    EditText bookName;
    DBController controller = new DBController(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_book);

        bookName = findViewById(R.id.editTextName);
        Intent objIntent = getIntent();
        String bookId = objIntent.getStringExtra("bookId");

        final Book book = controller.getBookInfo(bookId);
        if(book!=null) bookName.setText(book.getName());

        btnUpdate = findViewById(R.id.buttonUpdate);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                book.setName(bookName.getText().toString());
                controller.updateBook(book);
                Intent intent = new Intent(EditBookActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        btnDelete = findViewById(R.id.buttonDelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.deleteBook(book);
                Intent intent = new Intent(EditBookActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}